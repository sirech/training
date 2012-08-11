package com.hceris.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathTest {

	@Test
	public void testBinomialCoefficient() {
		assertEquals(1, Math.binomialCoefficient(25, 25));
		assertEquals(3, Math.binomialCoefficient(3, 2));
		assertEquals((25 * 24 * 23 * 22 * 21 * 20) / (6 * 5 * 4 * 3 * 2), Math.binomialCoefficient(25, 6));
		assertEquals((125 * 124) / 2, Math.binomialCoefficient(125, 123));
	}
	
	@Test
	public void testFibonacci() {
		assertEquals(1, Math.fibonacci(1));
		assertEquals(2, Math.fibonacci(3));
		assertEquals(3, Math.fibonacci(4));
		assertEquals(13, Math.fibonacci(7));
	}
	
	@Test
	public void testRandomDoesNotCrash() {
		assertTrue(Math.random(10) < 10);
	}

}
