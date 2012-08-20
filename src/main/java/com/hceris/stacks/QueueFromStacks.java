package com.hceris.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class QueueFromStacks<T> {
    private final Deque<T> newer = new ArrayDeque<T>();
    private final Deque<T> older = new ArrayDeque<T>();

    public QueueFromStacks(Iterable<? extends T> elements) {
    	for(T elem : elements) {
    		enqueue(elem);
    	}
    }
    
    public int size() {
    	return newer.size() + older.size();
    }
    
    public void enqueue(T element) {
        newer.push(element);
    }

    public T dequeue() {
    	shiftStacks();

        if(older.isEmpty()) {
            throw new NoSuchElementException();
        }

        return older.pop();
    }

	private void shiftStacks() {
		if(older.isEmpty()){
	        while(!newer.isEmpty()) {
	        	older.push(newer.pop());
	        }
    	}
	}
}
