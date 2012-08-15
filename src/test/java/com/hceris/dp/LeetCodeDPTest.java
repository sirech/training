package com.hceris.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeetCodeDPTest {

	int[][] a = new int[][] {
			{ 0, 1, 1, 0, 1},
			{ 1, 1, 0, 1, 0},
			{ 0, 1, 1, 1, 0},
			{ 1, 1, 1, 1, 0},
			{ 1, 1, 1, 1, 1},
			{ 0, 0, 0, 0, 0}
	};
	
	@Test
	public void testMaximumSquareSubarray() {
		assertEquals(3, LeetCodeDP.maximumSquareSubarray(a));
	}

}
