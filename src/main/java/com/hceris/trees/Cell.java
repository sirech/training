package com.hceris.trees;

import com.google.common.base.Objects;

class Cell {
    final int i;
    final int j;

    Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }

	@Override
	public String toString() {
		return "Cell [i=" + i + ", j=" + j + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(i, j);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		return i == other.i && j == other.j;
	}
}