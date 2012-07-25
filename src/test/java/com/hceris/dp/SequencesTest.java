package com.hceris.dp;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class SequencesTest {

	@Test
	public void testLongestIncreasingRunSimple() {
		assertTrue(Arrays.equals(new int[] { 4 }, Sequences.longestIncreasingRun(new int[] { 4 })));		
	}
	
	@Test
	public void testLongestIncreasingRunTie() {
		assertTrue(Arrays.equals(new int[] { 3, 5, 6 }, Sequences.longestIncreasingRun(new int[] { 1, 9, 3, 5, 6, 2, 7, 8 })));
	}
	
	@Test
	public void testLongestIncreasingRunStart() {
		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4 }, Sequences.longestIncreasingRun(new int[] { 1, 2, 3, 4, 0, 5, 6, 7})));
	}
	
	@Test
	public void testLongestIncreasingRunEnd() {
		assertTrue(Arrays.equals(new int[] { 7, 9, 10, 11 }, Sequences.longestIncreasingRun(new int[] { 1, 2, 3, 0, 5, 8, 7, 9, 10, 11})));
	}
	
	@Test
	public void testLongestIncreasingSequenceSimple() {
		assertTrue(Arrays.equals(new int[] { 4 }, Sequences.longestIncreasingSequence(new int[] { 4 })));
	}
	
	@Test
	public void testLongestIncreasingSequence() {
		assertTrue(Arrays.equals(new int[] { 2, 3, 6 }, Sequences.longestIncreasingSequence(new int[] { 9, 5, 2, 8, 7, 3, 1, 6, 4 })));
	}
	
	@Test
	public void testMaximumSubArrayNegative() {
		assertTrue(Arrays.equals(new int[0], Sequences.maximumSubArray(new int[] { -1, -5, -3})));
	}
	
	@Test
	public void testMaximumSubArrayPositive() {
		assertTrue(Arrays.equals(new int[] { 1, 2, 3}, Sequences.maximumSubArray(new int[] { 1, 2, 3})));
	}
	
	@Test
	public void testMaximumSubArray() {
		assertTrue(Arrays.equals(new int[] { 4, -1, 2, 1 }, Sequences.maximumSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4})));
	}
	
	@Test
	public void testCutRod() {
		int[] p = new int[] {0, 1, 5, 8, 9, 10, 17, 17, 20};
		int[] results = new int[] { 0, 1,  5, 8, 10, 13, 17, 18, 22 };
		for(int i = 0; i < results.length; i++) {
			assertEquals(results[i], Sequences.cutRod(p, i));
		}
	}

}
