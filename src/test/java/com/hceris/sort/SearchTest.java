package com.hceris.sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class SearchTest {
	
	Integer[] sorted = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	Integer[] rotated = new Integer[] { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
	Integer[] rotatedDupl = new Integer[] { 7, 8, 9, 0, 1, 1, 1, 2, 3, 4 };
	Integer[] sorted2 = new Integer[] { 1, 2, 3, 4, 5, 8, 11, 13, 15, 17 };
	Integer[] without = new Integer[] { 1, 3, 5, 6 };

	Integer[][] m = new Integer[][] {
			{1, 3, 5, 7},
			{10, 11, 16, 20},
			{23, 30, 34, 50}
	};
	
	@Test
	public void testBinarySearchLeftOverflow() {
		assertEquals(-1, Search.binarySearch(sorted, -1));
	}
	
	@Test
	public void testBinarySearchRightOverflow() {
		assertEquals(-11, Search.binarySearch(sorted, 10));
	}
	
	@Test
	public void testBinarySearch() {
		assertEquals(3, Search.binarySearch(sorted, 3));
	}
	
	@Test
	public void testBinarySearchLimit() {
		assertEquals(9, Search.binarySearch(sorted, 9));
	}
	
	@Test
	public void testRotatedSearch() throws Exception {
		assertEquals(8, Search.rotatedSearch(rotated, 5));
	}
	
	@Test
	public void testRotatedSearchNotThere() throws Exception {
		assertEquals(-1, Search.rotatedSearch(rotated, 6));
	}
	
	@Test
	public void testRotatedSearchDupl() throws Exception {
		assertEquals(8, Search.rotatedSearch(rotatedDupl, 3));
	}
	
	@Test
	public void testRotatedSearchDuplNotThere() throws Exception {
		assertEquals(-1, Search.rotatedSearch(rotatedDupl, 6));
	}
	
	@Test
	public void testRotatedMin() throws Exception {
		assertEquals(4, Search.rotatedMin(new Integer[] { 38, 40, 55, 89, 6, 13, 20, 23, 36 }));
	}
	
	@Test
	public void testBinarySearchWithEmpty() throws Exception {
		assertEquals(4, Search.binarySearchWithEmpty(new String[] { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ball"));		
	}
	
	@Test
	public void testSquareRoot() throws Exception {
		assertEquals(4, Search.squareRoot(16));
		assertEquals(13, Search.squareRoot(169));
		assertEquals(25, Search.squareRoot(625));
		assertEquals(-1, Search.squareRoot(626));
	}
	
	@Test
	public void testMaxLessThan() throws Exception {
		assertEquals(8, Search.maxLessThan(sorted2, 15));
		assertEquals(8, Search.maxLessThan(sorted2, 16));
		assertEquals(-1, Search.maxLessThan(sorted2, 0));
	}
	
	@Test
	public void testMaxmin() throws Exception {
		assertTrue(Arrays.equals(new Integer[] { 3, 9 }, Search.maxmin(new Integer[] { 4, 5, 6, 6, 7, 8, 9, 9, 3, 4 })));
	}
	
	@Test
	public void testMinTriplet() {
		assertTrue(Arrays.equals(new int[] {2, 2, 2}, Search.minTriplet(new int[] {1,3,78}, new int[] {15,19,79}, new int[] {27, 29, 80})));
	}
	
	@Test
	public void testSearchSortedMatrixFalse() throws Exception {
		assertTrue(Arrays.equals(new int[] {-1, -1}, Search.searchSortedMatrix(m, 13)));
	}
	
	@Test
	public void testSearchSortedMatrixTrue() throws Exception {
		assertTrue(Arrays.equals(new int[] {1, 1}, Search.searchSortedMatrix(m, 11)));
	}
	
	@Test
	public void testInsertionPoint() throws Exception {
		assertEquals(0, Search.insertionPoint(without, 0));
		assertEquals(1, Search.insertionPoint(without, 2));
		assertEquals(4, Search.insertionPoint(without, 7));
	}
}
