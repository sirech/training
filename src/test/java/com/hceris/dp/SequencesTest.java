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
}
