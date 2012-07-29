package com.hceris.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import com.google.common.annotations.VisibleForTesting;

public class StackOfStacks<T> {
    private final int stackSize;
    
    @VisibleForTesting
    final Deque<Deque<T>> stacks;

    public StackOfStacks(int stackSize) {
        this.stackSize = stackSize;
        this.stacks = new LinkedList<Deque<T>>();
    }

    public StackOfStacks(int stackSize, Iterable<? extends T> elements) {
        this(stackSize);
        for(T elem : elements) {
            push(elem);
        }
    }

    public int size() {
    	int sum = 0;
    	for(Deque<T> stack : stacks) {
    		sum += stack.size();
    	}
    	return sum;
    }
    
    public T pop() {
        Deque<T> stack = firstNonEmpty();

        if(stack == null) {
            throw new NoSuchElementException();
        }

        T value = stack.removeFirst();

        if(stack.isEmpty()) {
            stacks.removeFirst();
        }
        
        return value;
    }

    public T peek() {
        Deque<T> stack = firstNonEmpty();

        if(stack == null) {
            throw new NoSuchElementException();
        }

        return stack.getFirst();
    }

    private Deque<T> firstNonEmpty() {
        for(Deque<T> stack : stacks) {
            if(!stack.isEmpty()) {
                return stack;
            }
        }
        return null;
    }

    public void push(T elem) {
        Deque<T> stack = firstWithSpace();
        stack.addFirst(elem);        
    }

    private Deque<T> firstWithSpace() {
        if(stacks.isEmpty() || stacks.getFirst().size() == stackSize) {
            Deque<T> stack = new ArrayDeque<T>(stackSize);
            stacks.addFirst(stack);
            return stack;
        } else {
            return stacks.getFirst();
        }
    }
}
