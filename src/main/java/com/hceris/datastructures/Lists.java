package com.hceris.datastructures;

import java.util.Iterator;

public class Lists {
    private Lists() {}

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
}
