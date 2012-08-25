package com.hceris.math;

import javax.annotation.Nullable;

import com.google.common.base.Objects;

/**
 * Class that represents a cell in a matrix.
 * 
 * @author sirech
 *
 * @param <T>
 */
public class Cell<T> {

	final protected int x;
	final protected int y;
	@Nullable
	final protected T value;
	
	public Cell(int x, int y) {
		this(x, y, null);
	}
	
	public Cell(int x, int y, @Nullable T value) {
		this.x = x;
		this.y = y;
		this.value = value;
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
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public T getValue() {
		return value;
	}
}
