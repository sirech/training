package com.hceris.math;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MatricesTest {

	Integer[][] m = new Integer[][] {
			{ 1, 2, 3, 4},
			{ 5, 6, 7, 8},
			{ 9, 10, 11, 12},
			{ 13, 14, 15, 16}					
	};
	
	Integer[][] rotated = new Integer[][] {
			{ 13, 9, 5, 1},
			{ 14, 10, 6, 2},
			{ 15, 11, 7, 3},
			{ 16, 12, 8, 4}
	};
	
	int[][] m2 = new int[][] {
			{ 1, 2, 0, 4},
			{ 5, 6, 7, 8},
			{ 9, 0, 11, 12},
			{ 13, 14, 15, 16}					
	};
	
	int[][] zeroed = new int[][] {
			{ 0, 0, 0, 0},
			{ 5, 0, 0, 8},
			{ 0, 0, 0, 0},
			{ 13, 0, 0, 16}
	};
	
	@Test
	public void testRotateNinetyDegreesRight() {
		Matrices.rotateNinetyDegreesRight(m);
		assertTrue(Arrays.deepEquals(m, rotated));
	}
	
	@Test
	public void testExpandZeroes() {
		Matrices.expandZeroes(m2);
		assertTrue(Arrays.deepEquals(m2, zeroed));
	}

}
