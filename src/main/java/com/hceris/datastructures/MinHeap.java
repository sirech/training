package com.hceris.datastructures;

import static com.hceris.util.Utils.swap;

import java.util.List;
import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable<? super T>> {
    private T[] a;
    private int size;

    @SuppressWarnings("unchecked")
	public MinHeap(int maxSize) {
        a = (T[]) new Comparable[maxSize];
    }

    public MinHeap(List<? extends T> elements) {
        this(elements.size());

        for(int i = 0; i < a.length; i++) {
            a[i] = elements.get(i);
        }

        size = a.length;
        for(int i = parent(a.length-1); i >= 0; i--) {
            heapify(i);
        }
    }

    public int size() { return size; }
    
    public boolean isEmpty() { return size() == 0; }

    public T peek() {
        checkEmpty();
        return a[0];
    }

    public T poll() {
        checkEmpty();
        T value = a[0];
        swap(a, 0, size - 1);
        size--;
        heapify(0);        
        return value;            
    }

    public void offer(T e) {
        checkSize();
        a[size++] = e;
        int i = size - 1;

        while(parent(i) >= 0 && a[parent(i)].compareTo(a[i]) > 0) {
            swap(a, i, parent(i));
            i = parent(i);
        }
    }

    private void checkSize() {
		if(size == a.length) {
			throw new IllegalStateException("heap is full");
		}		
	}

	private void checkEmpty() {
        if(size == 0) {
            throw new NoSuchElementException();
        }
    }

    private int parent(int i) { return (i - 1) / 2; }

    private int left(int i) { return (i *  2) + 1; }

    private int right(int i) { return (i *  2) + 2; }

    private void heapify(int i) {
        if(left(i) >= size) { return; }

        int min = i;
        if(a[i].compareTo(a[left(i)]) > 0) {
            min = left(i);
        }

        if(right(i) < size && a[min].compareTo(a[right(i)]) > 0) {
            min = right(i);
        }

        if(i != min) {
            swap(a, i, min);
            heapify(min);
        }
    }    
}
