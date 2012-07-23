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

}
