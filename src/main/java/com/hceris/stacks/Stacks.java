package com.hceris.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stacks {
    private Stacks() {}

    public static <T extends Comparable<? super T>> void sort(Deque<T> stack) {
        Deque<T> tmp = new ArrayDeque<T>(stack.size());

        while(!stack.isEmpty()) {
            T next = stack.pop();
            while(!tmp.isEmpty() && next.compareTo(tmp.peek()) > 0) {
                stack.push(tmp.pop());
            }
            tmp.push(next);            
        }

        while(!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }
    
    public static <T extends Comparable<? super T>> T[] slidingWindowMax(T[] a, int k) {
    	@SuppressWarnings("unchecked")
		T[] max = (T[]) new Comparable[a.length - k + 1];
    	Deque<Integer> q = new ArrayDeque<Integer>();
    	
    	for (int i = 0; i < k; i++) {
			while(!q.isEmpty() && a[i].compareTo(a[q.getLast()]) >= 0) {
				q.removeLast();
			}
			q.addLast(i);			
		}
    	
    	for(int i = k; i < a.length; i++) {
    		max[i - k] = a[q.getFirst()];
    		while(!q.isEmpty() && a[i].compareTo(a[q.getLast()]) >= 0) {
				q.removeLast();
			}
    		while(!q.isEmpty() && q.getFirst() <= i - k) {
    			q.removeFirst();
    		}
    		q.addLast(i);    		
    	}
    	max[a.length - k] = a[q.getFirst()];    	
    	return max;
    }
        
}
