package com.hceris.sort;

import static org.junit.Assert.*;

import org.junit.Test;


public class SearchTest {
	
	Integer[] sorted = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	
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
}
