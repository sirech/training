package com.hceris.datastructures;

import static com.hceris.util.Utils.swap;

import java.util.Iterator;
import java.util.Random;

public class Lists {
    private Lists() {}

    private static final Random rnd = new Random();

    public static CCILinkedList<Integer> sumLessSignificantFirst(CCILinkedList<Integer> l1, CCILinkedList<Integer> l2) {
        Iterator<Integer> it1 = l1.iterator();
        Iterator<Integer> it2 = l2.iterator();
        int carryOn = 0;

        CCILinkedList<Integer> result = new CCILinkedList<Integer>();
        while(it1.hasNext() || it2.hasNext() || carryOn != 0) {
            int sum = (it1.hasNext() ? it1.next() : 0) +
                      (it2.hasNext() ? it2.next() : 0) +
                      carryOn;
            result.addLast(sum % 10);
            carryOn = sum / 10;
        }
        return result;
    }

    public static CCILinkedList<Integer> sumMostSignificantFirst(CCILinkedList<Integer> l1, CCILinkedList<Integer> l2) {
        int sum = mostSignificantFirstListToInt(l1) + mostSignificantFirstListToInt(l2);
        CCILinkedList<Integer> result = new CCILinkedList<Integer>();
        
        while(sum != 0) {
            result.addFirst(sum % 10);
            sum /= 10;
        }
        return result;
    }

    private static int mostSignificantFirstListToInt(CCILinkedList<Integer> l) {
        int n = 0;
        for(Integer digit : l) {
            n = (n * 10) + digit;
        }
        return n;
    }

    // Crappier version of the original problem: As we can't use nodes, we don't keep the pointer to the last, 
    // which makes the performance depend on whether addLast is O(1) or not. Also, the merge is O(n) instead of O(1)
    public static <T extends Comparable<? super T>> CCILinkedList<T> partition(CCILinkedList<T> l, T value) {
    	CCILinkedList<T> less = new CCILinkedList<T>();
    	CCILinkedList<T> more = new CCILinkedList<T>();
    	
    	for(T elem : l) {
    		if(elem.compareTo(value) <= 0) {
    			less.addLast(elem);
    		} else {
    			more.addLast(elem);
    		}
    	}
    	
    	for(T elem: more) {
    		less.addLast(elem);
    	}
    	return less;
    }
    
    public static <T> Iterable<T> lastNElements(Iterable<T> it, int n) {
    	return lastNElements(it.iterator(), n);
    }
    
    public static <T> Iterable<T> lastNElements(Iterator<T> it, int n) {
        CircularArray<T> a = new CircularArray<T>(n);

        for(int i = 0; i < n; i++) {
            if(!it.hasNext()) {
                throw new IllegalArgumentException();
            }

            a.set(i, it.next());
        }

        while(it.hasNext()) {
            a.shift(1);
            a.set(n - 1, it.next());
        }
        
        return a;
    }

    public static <T> void shuffle(T[] a) {
        for(int i = a.length -1; i > 0; i--) {
            swap(a, i, rnd.nextInt(i + 1));
        }
    }

    public static <T> T[] choose(T[] a, int m) {
        @SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[m];
        for(int i = 0; i < m; i++) {
            swap(a, i, rnd.nextInt(a.length - i) + i);
            result[i] = a[i];
        }
        return result;
    }    
}
