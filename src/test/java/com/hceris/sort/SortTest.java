package com.hceris.sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SortTest {

	Integer[] a = new Integer[] { 7, 4, 1, 2, 5, 3, 9, 8, 0, 6 };
	Integer[] sorted = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	Integer[] reversed = new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	
	@Test
	public void testInsertSort() {
		Sort.insertSort(a);
		assertTrue(Arrays.equals(sorted, a));
	}
	
	@Test
	public void testQuickSort() {
		Sort.quickSort(a);
		assertTrue(Arrays.equals(sorted, a));
	}
	
	@Test
	public void testQuickSortHoare() {
		Sort.quickSortHoare(a);
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

	@Test
	public void testCountInversions() throws Exception {
		assertEquals(0, Sort.countInversions(sorted));
		assertEquals(3, Sort.countInversions(new Integer[] { 3, 2, 1 }));
		assertEquals(21, Sort.countInversions(a));
	}
	
	@Test
	public void findMinUnsorted() throws Exception {
		assertTrue(Arrays.equals(new int[] {-1, -1}, Sort.findMinUnsorted(sorted)));
		assertTrue(Arrays.equals(new int[] {0, reversed.length - 1}, Sort.findMinUnsorted(reversed)));
		assertTrue(Arrays.equals(new int[] {3, 9}, Sort.findMinUnsorted(new Integer[] { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 })));
	}
}
