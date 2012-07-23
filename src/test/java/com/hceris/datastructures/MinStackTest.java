package com.hceris.datastructures;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.Test;

public class MinStackTest {

	private MinStack<Integer> stack = new MinStack<Integer>();
	
	@Test
	public void testPush() {
		assertTrue(stack.isEmpty());
		stack.push(3);
		assertFalse(stack.isEmpty());
	}

	@Test(expected=NoSuchElementException.class)
	public void testPopEmpty() {
		stack.pop();
	}
	
	@Test
	public void testPop() {
		stack.push(3);
		assertEquals(3, (int) stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testFindMinimum() {
		for(Integer i : Arrays.asList(4, 5, 1)) {
			stack.push(i);
		}
		
		assertEquals(1, (int) stack.findMinimum());
		stack.pop();
		assertEquals(4, (int) stack.findMinimum());
		stack.pop();
		assertEquals(4, (int) stack.findMinimum());
	}

}
