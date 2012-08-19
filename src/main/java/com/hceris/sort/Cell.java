package com.hceris.sort;

import com.google.common.base.Objects;

class Cell<T extends Comparable <? super T>> implements Comparable<Cell<T>> {

	final int x;
	final int y;
	final T value;
	
	Cell(int x, int y, T value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	public int compareTo(Cell<T> o) {
		return value.compareTo(o.value);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(value, x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		Cell<T> other = (Cell<T>) obj;
		if (!value.equals(other.value))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}    
}