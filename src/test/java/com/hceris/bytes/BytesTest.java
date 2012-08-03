package com.hceris.bytes;

import static org.junit.Assert.*;

import org.junit.Test;

public class BytesTest {

	@Test
	public void testIsPowerOfTwo() {
		assertFalse(Bytes.isPowerOfTwo(355));
		assertFalse(Bytes.isPowerOfTwo(354));
		
		assertTrue(Bytes.isPowerOfTwo(256));
		assertTrue(Bytes.isPowerOfTwo(Integer.MIN_VALUE));
	}

	@Test
	public void testCountBitsSparse() {
		assertEquals(5, Bytes.countBitsSparse(0x00A01300));
		assertEquals(0, Bytes.countBitsSparse(0));
		assertEquals(32, Bytes.countBitsSparse(-1));
	}

	@Test
	public void testCountBits() {
		assertEquals(5, Bytes.countBits(0x00A01300));
		assertEquals(0, Bytes.countBits(0));
		assertEquals(32, Bytes.countBits(-1));
	}

	@Test
	public void testReverse() {
		assertEquals(0, Bytes.reverse(0));
		assertEquals(-1, Bytes.reverse(-1));
		assertEquals(0xF350AE55, Bytes.reverse(0xAA750ACF));
		assertEquals(Integer.MIN_VALUE, Bytes.reverse(1));
	}
	
	@Test
	public void testInsert() {
		assertEquals(Integer.parseInt("101001101", 2), Bytes.insert(Integer.parseInt("101111101", 2), Integer.parseInt("10011", 2), 2, 6));
		assertEquals(Integer.parseInt("110001011", 2), Bytes.insert(Integer.parseInt("111101111", 2), Integer.parseInt("00010", 2), 2, 6));
	}
	
	@Test
	public void testNumberOfDifferentBits() {
		assertEquals(2, Bytes.numberOfDifferentBits(31, 14));
		assertEquals(32, Bytes.numberOfDifferentBits(-1, 0));
	}
	
	@Test
	public void testMax() throws Exception {
		assertEquals(335, Bytes.max(335, 32));
		assertEquals(5, Bytes.max(5, 3));
		assertEquals(1, Bytes.max(0, 1));
		assertEquals(-1, Bytes.max(-2, -1));
	}
}
