package com.hceris.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class QueueFromStacks<T> {
    private final Deque<T> desc = new ArrayDeque<T>();
    private final Deque<T> asc = new ArrayDeque<T>();

    public QueueFromStacks(Iterable<? extends T> elements) {
    	for(T elem : elements) {
    		enqueue(elem);
    	}
    }
    
    public int size() {
    	return desc.size() + asc.size();
    }
    
    public void enqueue(T element) {
        while(!asc.isEmpty()) {
            desc.push(asc.pop());
        }
        desc.push(element);
    }

    public T dequeue() {
        while(!desc.isEmpty()) {
            asc.push(desc.pop());
        }

        if(asc.isEmpty()) {
            throw new NoSuchElementException();
        }

        return asc.pop();
    }
}
