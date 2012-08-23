package com.hceris.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatchingTest {

	@Test
	public void testSimpleFailure() {
		assertEquals(-1, Matching.simple("The recorded plane", "planegg"));
		assertEquals(-1, Matching.simple("The recorded plane", "this"));
		assertEquals(-1, Matching.simple("The recorded plane", "ordd"));
	}
	
	@Test
	public void testSimple() {
		assertEquals(0, Matching.simple("The recorded plane", "The"));
		assertEquals(13, Matching.simple("The recorded plane and the other plane", "plane"));
		assertEquals(15, Matching.simple("The recorded plane", "ane"));
	}

	@Test
	public void testKmpFailure() {
		assertEquals(-1, Matching.kmp("abracadabra abbbbradacab", "bbbc"));
		assertEquals(-1, Matching.kmp("abracadabra abbbbradacab", "braa"));
		assertEquals(-1, Matching.kmp("abracadabra abbbbradacab", "caba"));		
	}
	
	@Test
	public void testKmp() {
		assertEquals(16, Matching.kmp("abracadabra abbbbradacab", "brada"));
		assertEquals(0, Matching.kmp("abracadabra abbbbradacab", "abra"));
		assertEquals(7, Matching.kmp("abracadabra abbbbradacab", "abra "));
	}

	@Test
	public void testMinimumContainingSubstringNoResult() throws Exception {
		assertNull(Matching.minimumContainingSubstring("bbbbbbbabbbbbbbbaabb", "abc"));		
	}
	
	@Test
	public void testMinimumContainingSubstringLengthOne() throws Exception {
		assertEquals("a", Matching.minimumContainingSubstring("bbbbbbbabbbbbbbbaabb", "a"));		
	}
	
	@Test
	public void testMinimumContainingSubstring() throws Exception {
		assertEquals("BANC", Matching.minimumContainingSubstring("ADOBECODEBANC", "ABC"));		
	}
	
	@Test
	public void testRemove() throws Exception {
		assertEquals("flyingmonster", Matching.remove("theflyingthemonsterthe", "the"));
		assertEquals("abaaaa", Matching.remove("aababaaaabaa", "aba"));
	}
	
	@Test
	public void testRegexpStart() throws Exception {
		assertTrue(Matching.regexp("deliver", "^deliver"));
		assertFalse(Matching.regexp("deliver", "^eliver"));
	}
	
	@Test
	public void testRegexpEnd() throws Exception {
		assertTrue(Matching.regexp("deliver", "ver$"));
		assertFalse(Matching.regexp("deliver", "e$"));
	}
	
	@Test
	public void testRegexpAny() throws Exception {
		assertTrue(Matching.regexp("deliver", "li.er"));
		assertFalse(Matching.regexp("deliver", "er."));
	}
	
	@Test
	public void testRegexpWildcard() throws Exception {
		assertTrue(Matching.regexp("deliiiiiver", "li*v"));
		assertTrue(Matching.regexp("deliiiiiver", "li*iv"));
		assertTrue(Matching.regexp("deliver", "lie*v"));
		assertFalse(Matching.regexp("deliiiiiver", "li*e"));
	}
	
	@Test
	public void testRegexpAll() throws Exception {
		assertTrue(Matching.regexp("deliieeiver", "^de.i*e*i.er$"));
		assertFalse(Matching.regexp("deliieeiver", "^de.i*e*i.ar"));
	}
}
