package com.hceris.math;

import static org.junit.Assert.*;

import java.util.Arrays;

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
	
	@Test
	public void test3SumNoAnswer() {
		assertTrue(Arrays.equals(new int[] {}, Math.threeSum(new int[] { -4, -1, -1, 0 })));
	}
	
	@Test
	public void test3Sum() {
		assertTrue(Arrays.equals(new int[] {1, 2, 5}, Math.threeSum(new int[] { -4, -1, -1, 0, 1, 2 })));
	}
	
	@Test
	public void test3SumClosestExact() {
		assertTrue(Arrays.equals(new int[] {3, 4, 5}, Math.threeSumClosest(new int[] { -4, -1, -1, 0, 1, 2 }, 3)));
	}
	
	@Test
	public void test3SumClosest() {
		assertTrue(Arrays.equals(new int[] {3, 4, 5}, Math.threeSumClosest(new int[] { -4, -1, -1, 0, 1, 2 }, 4)));
	}
}