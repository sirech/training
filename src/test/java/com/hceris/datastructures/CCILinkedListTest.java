package com.hceris.datastructures;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CCILinkedListTest {

	CCILinkedList<String> l = new CCILinkedList<String>(Arrays.asList("1", "2", "3", "2", "4", "5", "1"));
	
	@Test
	public void testSize() {
		assertEquals(7, l.size());
	}

	@Test
	public void testAddLast() {
		l.addLast("328");
		assertEquals("328", l.get(7));
		assertEquals(8, l.size());
	}

	@Test
	public void testAddFirst() {
		l.addFirst("328");
		assertEquals("328", l.get(0));
		assertEquals(8, l.size());
	}

	@Test
	public void testGet() {
		assertEquals("3", l.get(2));
	}

	@Test
	public void testRemoveDuplicates() {
		l.removeDuplicates();
		assertEquals(5, l.size());
	}

	@Test
	public void testRemoveDuplicatesInPlace() {
		l.removeDuplicatesInPlace();
		assertEquals(5, l.size());
	}

}
