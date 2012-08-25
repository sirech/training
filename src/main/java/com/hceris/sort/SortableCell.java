package com.hceris.sort;

import com.hceris.math.Cell;

class SortableCell<T extends Comparable <? super T>> extends Cell<T> implements Comparable<SortableCell<T>>{

	SortableCell(int x, int y, T value) {
		super(x, y, value);
	}

	public int compareTo(SortableCell<T> o) {
		return value.compareTo(o.value);
	}	    
}