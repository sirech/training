package com.hceris.datastructures;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MinStack<T extends Comparable<? super T>> {

    private final LinkedList<T> stack;
    private final LinkedList<T> minStack;

    public MinStack() {
        stack = new LinkedList<T>();
        minStack = new LinkedList<T>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    public void push(T element) {
        stack.addFirst(element);
        if(minStack.isEmpty() || element.compareTo(findMinimum()) <= 0) {
            minStack.addFirst(element);
        }
    }

    public T pop() {
        if(stack.isEmpty()) {
            throw new NoSuchElementException();
        }

        T elem = stack.removeFirst();
        if(elem == findMinimum()) {
            minStack.removeFirst();
        }
        return elem;
    }

    public T findMinimum() {
        if(minStack.isEmpty()) {
            throw new NoSuchElementException();
        }

        return minStack.getFirst();
    }
}
