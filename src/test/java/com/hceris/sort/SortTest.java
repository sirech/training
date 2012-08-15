package com.hceris.sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SortTest {

	Integer[] a = new Integer[] { 7, 4, 1, 2, 5, 3, 9, 8, 0, 6 };
	Integer[] sorted = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
	@Test
	public void testQuickSort() {
		Sort.quickSort(a);
		assertTrue(Arrays.equals(sorted, a));
	}
	
	@Test
	public void testMergeSort() {
		Sort.mergeSort(a);
		assertTrue(Arrays.equals(sorted, a));
	}
	
	@Test
	public void testDutchFlagSort() throws Exception {
		int[] a = new int[] { 2, 1, 0, 1, 1, 0, 2, 2, 0 };
		Sort.dutchFlagSort(a, 1, 2);
		assertTrue(Arrays.equals(new int[] { 0, 0, 0, 1, 1, 1, 2, 2, 2 }, a));
	}

}
