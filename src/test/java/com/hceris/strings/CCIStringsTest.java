package com.hceris.strings;

import static org.junit.Assert.*;

import java.util.List;

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
	
	@Test
	public void testEstimate() {
		CCIStrings.Frequencies f = CCIStrings.estimate("GGRR", "RGBY");
		assertEquals(1, f.total);
		assertEquals(1, f.partial);
	
	}
	
	@Test
	public void testPermutations() throws Exception {
		List<String> permutations = CCIStrings.permutations("abc");
		assertEquals("[abc, bac, bca, acb, cab, cba]", permutations.toString());
	}
	
	@Test
	public void testPermutations2() throws Exception {
		List<String> permutations = CCIStrings.permutations2("abc");
		assertEquals("[abc, acb, bac, bca, cba, cab]", permutations.toString());
	}
	
	@Test
	public void testPermutations2WithDuplicates() throws Exception {
		List<String> permutations = CCIStrings.permutations2("abbc");
		assertEquals("[abbc, abcb, acbb, babc, bacb, bbac, bbca, bcba, bcab, cbba, cbab, cabb]", permutations.toString());
	}
}
