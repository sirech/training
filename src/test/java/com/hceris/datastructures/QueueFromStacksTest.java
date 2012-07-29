package com.hceris.datastructures;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class QueueFromStacksTest {

	QueueFromStacks<String> q = new QueueFromStacks<String>(Arrays.asList("1", "2", "3", "4", "5"));
	
	@Test
	public void testEnqueue() {
		q.enqueue("6");
		assertEquals(6, q.size());
	}

	@Test
	public void testDequeue() {
		assertEquals("1", q.dequeue());
	}
	
	@Test
	public void testComposedOperations() {
		q.enqueue("6");
		assertEquals("1", q.dequeue());
		q.enqueue("7");
		assertEquals(6, q.size());
	}

}
