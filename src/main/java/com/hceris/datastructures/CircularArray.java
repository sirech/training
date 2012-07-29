package com.hceris.datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.google.common.annotations.VisibleForTesting;

public class CircularArray<T> implements Iterable<T> {
    private final T[] elements;
    
    @VisibleForTesting
    int head;

    @SuppressWarnings("unchecked")
    public CircularArray(int size) {
        elements = (T[]) new Object[size];
    }

    public CircularArray(Collection<? extends T> c) {
        this(c.size());
        int i = 0;
        for(T elem : c) {
            elements[i++] = elem;
        }
    }

    private int convertIndex(int i) {
        if(i < 0 || i >= elements.length) {
            throw new IndexOutOfBoundsException();
        }
        return (i + head) % elements.length;
    }

    public void shift(int offset) {
        if(offset >= 0) {
            head = (head + offset) % elements.length;
        } else {
            head += offset;
            while(head < 0) {
                head += elements.length;
            }
        }
    }

    public T set(int index, T value) {
        index = convertIndex(index);
        T oldValue = elements[index];
        elements[index] = value;
        return oldValue;
    }

    public T get(int index) {
        index = convertIndex(index);
        return elements[index];
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int current = 0;
            
            public boolean hasNext() {
                return current < elements.length;
            }

            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }

                return elements[convertIndex(current++)];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
