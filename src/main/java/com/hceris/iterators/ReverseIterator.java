package com.hceris.iterators;

import java.util.List;
import java.util.NoSuchElementException;


public class ReverseIterator<T> {

    private final List<T> delegate;
    private int position;
    
    public ReverseIterator(List<T> delegate) {
        this.delegate = delegate;
        this.position = delegate.size() - 1;
    }
    
    public boolean hasNext() {
        return position >= 0;
    }

    public T next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }

        T element = delegate.get(position);
        position--;
        return element;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
