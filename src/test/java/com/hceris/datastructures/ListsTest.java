package com.hceris.datastructures;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class ListsTest {

	private String toString(CCILinkedList<Integer> l) {
		StringBuilder b = new StringBuilder();
		for(Integer i : l) {
			b.append(i);
		}
		return b.toString();
	}
	
	@Test
	public void testSumLessSignificantFirst() {
		assertEquals("219", toString(Lists.sumLessSignificantFirst(new CCILinkedList<Integer>(Arrays.asList(7, 1, 6)), new CCILinkedList<Integer>(Arrays.asList(5, 9, 2)))));
	}
	
	@Test
	public void testSumMostSignificantFirst() {
		assertEquals("912", toString(Lists.sumMostSignificantFirst(new CCILinkedList<Integer>(Arrays.asList(6, 1, 7)), new CCILinkedList<Integer>(Arrays.asList(2, 9, 5)))));
	}
	
	@Test
	public void testLastNElements() {
		int i = 0;
		for(Integer result : Lists.lastNElements(Arrays.asList(-1, -2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2), 3)) {
			assertEquals(i++, (int)result);
		}
	}
	
	@Test
	public void testShuffleDoesNotCrash() throws Exception {
		Lists.shuffle(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });		
	}
	
	@Test
	public void testChooseDoesNotCrash() throws Exception {
		Lists.choose(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 3);		
	}
}
