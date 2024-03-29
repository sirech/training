package com.hceris.iterators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public class Iterators {
    private Iterators() {}

    public static <T> Iterable<Set<T>> subSets(final List<T> elements) {
        return new Iterable<Set<T>>() {
            public Iterator<Set<T>> iterator() {
                return new Iterator<Set<T>>() {
                    int current = 0;

                    public boolean hasNext() {
                        return current < (1 << elements.size());
                    }

                    public Set<T> next() {
                        if(!hasNext()) {
                            throw new NoSuchElementException();
                        }

                        return setFromNumber(current++);                        
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    private Set<T> setFromNumber(int n) {
                        Set<T> result = new HashSet<T>();
                        for(int i = 0; i < elements.size(); i++) {
                            if((n & (1 << i)) != 0) {
                                result.add(elements.get(i));
                            }
                        }
                        return result;
                    }
                };
            }
        };
    }

    public static <T> T findMajority(Iterable<T> elements) {
        T selected = null;
        int count = 0;

        for(T element : elements) {
            if(count == 0) {
                selected = element;
                count = 1;
            } else if(element.equals(selected)) {
                count++;
            } else {
                count--;
            }
        }

        return selected;
    }

    public static <T> List<T> reservoirSampling(Iterable<T> elements, int k) {
        return reservoirSampling(elements.iterator(), k);
    }
    
    public static <T> List<T> reservoirSampling(Iterator<T> elements, int k) {
        Random rnd = new Random();
        List<T> result = new ArrayList<T>();

        for(int i = 0; i < k; i++) {
            if(!elements.hasNext()) {
                throw new IllegalArgumentException();
            }
            result.add(elements.next());
        }

        int round = k;
        while(elements.hasNext()) {
            round++;
            T element = elements.next();

            if(Double.compare(rnd.nextDouble(), k / (double) round) > 0) {
                result.set(rnd.nextInt(k), element);
            }
        }

        return result;
    }
}
