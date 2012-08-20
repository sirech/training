package com.hceris.datastructures;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CCILinkedListTest {

	CCILinkedList<String> l = new CCILinkedList<String>(Arrays.asList("1", "2", "3", "2", "4", "5", "1"));
	CCILinkedList<String> empty = new CCILinkedList<String>();
	CCILinkedList<String> single = new CCILinkedList<String>(Arrays.asList("1"));
	CCILinkedList<String> palindrome = new CCILinkedList<String>(Arrays.asList("1", "2", "3", "4", "3", "2", "1"));	

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

	@Test
	public void testNthToLast() {
		assertEquals("1", l.nthToLast(0));
		assertEquals("1", l.nthToLast(6));
		assertEquals("2", l.nthToLast(3));
	}
	
	@Test
	public void testReverseEmpty() {
		empty.reverse();
		assertEquals(new CCILinkedList<String>(), empty);
	}
	
	@Test
	public void testReverseOne() {
		single.reverse();
		assertEquals(new CCILinkedList<String>(Arrays.asList("1")), single);
	}
	
	@Test
	public void testReverse() {
		l.reverse();
		assertEquals(new CCILinkedList<String>(Arrays.asList("1", "5", "4", "2", "3", "2", "1")), l);
	}
	
	@Test
	public void testReverseIndexFull() {
		l.reverse(0, l.size() - 1);
		assertEquals(new CCILinkedList<String>(Arrays.asList("1", "5", "4", "2", "3", "2", "1")), l);
	}
	
	@Test
	public void testReverseIndexOne() {
		l.reverse(2, 4);
		assertEquals(new CCILinkedList<String>(Arrays.asList("1", "2", "4", "2", "3", "5", "1")), l);
	}
	
	@Test
	public void testReverseCycle() {
		l.reverseCycle(3);
		assertEquals(new CCILinkedList<String>(Arrays.asList("3", "2", "1", "5", "4", "2", "1")), l);
	}
	
	@Test
	public void testRotateRight() throws Exception {
		l.rotateRight(2);
		assertEquals(new CCILinkedList<String>(Arrays.asList("5", "1", "1", "2", "3", "2", "4")), l);		
	}
	
	@Test
	public void testIsPalindromeFalse() throws Exception {
		assertFalse(l.isPalindrome());
	}
	
	@Test
	public void testIsPalindrome() throws Exception {
		assertTrue(palindrome.isPalindrome());
	}
}
