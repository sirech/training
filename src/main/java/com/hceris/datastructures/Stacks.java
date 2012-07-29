package com.hceris.datastructures;

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
        
}
