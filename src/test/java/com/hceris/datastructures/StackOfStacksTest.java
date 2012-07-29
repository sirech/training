package com.hceris.datastructures;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.Test;

public class StackOfStacksTest {

	StackOfStacks<String> full = new StackOfStacks<String>(3, Arrays.asList("1", "2", "3", "4", "5", "6"));
	StackOfStacks<String> empty= new StackOfStacks<String>(3);
	
	@Test
	public void testPop() {
		assertEquals("6", full.pop());
		assertEquals(5, full.size());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testPopEmpty() {
		empty.pop();
	}
	
	@Test
	public void testPopDestroys() {
		assertEquals(2, full.stacks.size());
		full.pop(); full.pop(); full.pop();
		assertEquals(1, full.stacks.size());		
	}
	
	@Test
	public void testPeek() {
		assertEquals("6", full.peek());
		assertEquals(6, full.size());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testPeekEmpty() {
		empty.peek();
	}
	
	@Test
	public void testPush() {
		full.push("7");
		assertEquals("7", full.peek());
		empty.push("7");
		assertEquals("7", empty.peek());
	}
	
	@Test
	public void testPushCreates() {
		full.push("7");
		assertEquals(3, full.stacks.size());
		empty.push("7");
		assertEquals(1, empty.stacks.size());
	}

}
