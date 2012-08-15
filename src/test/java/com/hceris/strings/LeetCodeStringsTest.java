package com.hceris.strings;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LeetCodeStringsTest {

	@Test
	public void testMultiply() {
		assertEquals("3", LeetCodeStrings.multiply("1", "3"));
		assertEquals("3", LeetCodeStrings.multiply("3", "1"));
		assertEquals("1050", LeetCodeStrings.multiply("25", "42"));
		assertEquals("10500", LeetCodeStrings.multiply("420", "25"));
	}

	@Test
	public void testSum() {
		assertEquals("3", LeetCodeStrings.sum("0", "3"));
		assertEquals("3", LeetCodeStrings.sum("3", "0"));
		assertEquals("1053", LeetCodeStrings.sum("356", "697"));
	}
	
	List<String> permutations = Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba");
	
	@Test
	public void testNextPermutation() {
		String base = "abc";
		for(int i = 1; i < permutations.size(); i++) {
			String next = LeetCodeStrings.nextPermutation(base);
			assertEquals(permutations.get(i), next);
			base = next;
		}
		assertEquals("abc", LeetCodeStrings.nextPermutation(base));
	}

	@Test
	public void testIsScramble() throws Exception {
		assertTrue(LeetCodeStrings.isScramble("great", "rgtae"));
	}
}
