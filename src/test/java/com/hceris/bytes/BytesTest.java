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

}
