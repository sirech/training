package com.hceris.datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuffixTreeTest {

	SuffixTree t = new SuffixTree("abracadabra");
	
	@Test
	public void testContains() {
		assertTrue(t.contains("racada"));
	}
	
	@Test
	public void testContainsFalse() {
		assertFalse(t.contains("adabrc"));
	}

}
