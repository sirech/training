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
	public void test2SumNoAnswer() throws Exception {
		assertTrue(Arrays.equals(new int[] {}, Math.twoSum(new int[] { 2, 5, 1, 9, 6, 7 }, 17)));
	}
	
	@Test
	public void test2Sum() throws Exception {
		assertTrue(Arrays.equals(new int[] {1, 3}, Math.twoSum(new int[] { 2, 5, 1, 9, 6, 7 }, 14)));
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
	
	@Test
	public void testSubsetSum() throws Exception {
		assertTrue(Arrays.equals(new int[] {1, 2, 3}, Math.subSetSum(new int[] { -7, -3, -2, 5, 8}, 0)));
	}
	
	@Test
	public void testDivide() {
		assertEquals(0, Math.divide(3, 5));
		assertEquals(1, Math.divide(5, 5));
		assertEquals(9, Math.divide(45, 5));
		assertEquals(9, Math.divide(48, 5));
		
	}
	
	@Test
	public void testPow() {
		assertEquals(1024, Math.pow(2, 10));
		assertEquals(1, Math.pow(3, 0));
		assertEquals(3, Math.pow(3, 1));
		assertEquals(1024 * 1024, Math.pow(2, 20));
	}
	
	@Test
	public void testCountZeroesInFactorial() throws Exception {
		assertEquals(3, Math.countZeroesInFactorial(19));
	}
	
	@Test
	public void testGCD() throws Exception {
		assertEquals(6, Math.gcd(54, 24));
	}
}
