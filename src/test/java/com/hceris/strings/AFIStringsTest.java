package com.hceris.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class AFIStringsTest {

	@Test
	public void testRotateLeft() {
		assertEquals("cdeab", AFIStrings.rotateLeft("abcde", 2));
	}

	@Test
	public void testIsRotation() {
		assertTrue(AFIStrings.isRotation("abc", "cab"));
		assertFalse(AFIStrings.isRotation("abc", "cba"));
	}
}
