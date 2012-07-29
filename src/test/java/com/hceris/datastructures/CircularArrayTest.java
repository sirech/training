package com.hceris.datastructures;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CircularArrayTest {

	CircularArray<String> a = new CircularArray<String>(Arrays.asList("3", "4", "1", "2"));
	
	@Before
	public void setUp() {
		a.shift(2);
	}
	
	@Test
	public void testShift() {
		assertEquals(2, a.head);
		a.shift(1);
		assertEquals(3, a.head);
		a.shift(-5);
		assertEquals(2, a.head);
	}

	@Test
	public void testSet() {
		assertEquals("1", a.set(0, "abc"));
		assertEquals("abc", a.get(0));
	}

	@Test
	public void testGet() {
		assertEquals("3", a.get(2));
	}

	@Test
	public void testIterator() {
		int i = 0;
		for(String s : a) {
			assertEquals(Integer.toString(i++ + 1), s);
		}
	}

}
