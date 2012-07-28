package com.hceris.strings;

import static org.junit.Assert.*;

import org.junit.Test;


public class CCIStringsTest {

	@Test
	public void testUniqueCharsTrue() {
		assertTrue(CCIStrings.uniqueASCIIChars("cjgrtuapqwilmnzxsdfk"));
	}
	
	@Test
	public void testUniqueCharsFalse() {
		assertFalse(CCIStrings.uniqueASCIIChars("abcdefghahgksaiwerodfamweri"));
	}
	
	@Test
	public void testIsPermutationFalse() {
		assertFalse(CCIStrings.isPermutation("god is dead", "dog sid too"));
	}
	
	@Test
	public void testIsPermutationTrue() {
		assertFalse(CCIStrings.isPermutation("god is dead", "dog sid dea"));
	}
	
	@Test
	public void testReplaceWhitespace() {
		assertEquals("Mr%20John%20Smith", CCIStrings.replaceWhitespace("Mr John Smith    ", 13));
	}
	
	@Test
	public void testCompress() {
		assertEquals("a3b2c2", CCIStrings.compress("aaabbcc"));
	}
	
	@Test
	public void testCompressEdge() {
		assertEquals("a3b2c", CCIStrings.compress("aaabbc"));
	}
}
