package com.hceris.stacks;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

public class StacksTest {

	LinkedList<Integer> s = new LinkedList<Integer>(Arrays.asList(3, 4, 7, 1, 9, 8, 2, 6, 5));
	
	@Test
	public void testSort() {
		Stacks.sort(s);
		
		for(int i = 9; i > 0; i--) {
			assertEquals(i, (int) s.pop());
		}
	}

	@Test
	public void testSlidingWindowMax() throws Exception {
		assertTrue(Arrays.equals(new Integer[] { 3, 3, 4, 5, 5, 5, 6 } , Stacks.slidingWindowMax(new Integer[] { 1, 2, 3, 1, 4, 5, 2, 3, 6 }, 3)));
	}
	
	@Test
	public void testMedian() throws Exception {
		assertEquals(10, (int) Stacks.median(Arrays.asList(4, 5, 6, 2, 9, 8, 1, 11, 13, 15, 17, 3, 0, 7, 10, 16, 14, 12, 18, 19, 20)));
	}
}
