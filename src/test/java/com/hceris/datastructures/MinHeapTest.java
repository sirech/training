package com.hceris.datastructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MinHeapTest {

	MinHeap<Integer> h;
	
	@Before
	public void setUp() {
		h = new MinHeap<Integer>(8);
		h.offer(4);
		h.offer(3);
		h.offer(2);
		h.offer(5);
		h.offer(0);
		h.offer(1);
		h.offer(6);
	}
	
	@Test
	public void testSize() {
		assertEquals(7, h.size());
	}

	@Test
	public void testPeek() {
		assertEquals(0, (int) h.peek());
	}

	@Test
	public void testPoll() {
		assertEquals(0, (int) h.poll());
		assertEquals(6, h.size());
		assertEquals(1, (int) h.peek());
	}

	@Test
	public void testOffer() {
		h.offer(-1);
		assertEquals(8, h.size());
		assertEquals(-1, (int) h.poll());
		h.offer(8);
		assertEquals(8, h.size());
		assertEquals(0, (int) h.poll());
	}

}
