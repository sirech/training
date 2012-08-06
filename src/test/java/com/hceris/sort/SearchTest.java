package com.hceris.sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class SearchTest {
	
	Integer[] sorted = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	Integer[] rotated = new Integer[] { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
	Integer[] sorted2 = new Integer[] { 1, 2, 3, 4, 5, 8, 11, 13, 15, 17 };
	
	@Test
	public void testBinarySearchLeftOverflow() {
		assertEquals(-1, Search.binarySearch(sorted, -1));
	}
	
	@Test
	public void testBinarySearchRightOverflow() {
		assertEquals(-1, Search.binarySearch(sorted, 10));
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
	public void assertMaxmin() throws Exception {
		assertTrue(Arrays.equals(new Integer[] { 3, 9 }, Search.maxmin(new Integer[] { 4, 5, 6, 6, 7, 8, 9, 9, 3, 4 })));
	}
}
