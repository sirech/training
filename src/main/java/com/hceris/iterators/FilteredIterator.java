package com.hceris.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

public class FilteredIterator<T> implements Iterator<T> {

    private final Iterator<T> delegate;
    private final Predicate<T> checker;

    private T current;

    public FilteredIterator(Iterator<T> delegate, Predicate<T> checker) {
        this.delegate = Preconditions.checkNotNull(delegate);
        this.checker = Preconditions.checkNotNull(checker);
    }

    private T computeNext() {
        while(delegate.hasNext()) {
            T candidate = delegate.next();

            if(checker.apply(candidate)) {
                current = candidate;
                return current;
            }
        }
        return null;
    }
    
    public boolean hasNext() {
        return current != null || computeNext() != null;
    }

    public T next() {
        T element = current != null ? current : computeNext();

        if(element == null) {
            throw new NoSuchElementException();
        }

        current = null;
        return element;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
