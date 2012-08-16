package com.hceris.dp;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class SequencesTest {

	@Test
	public void testLongestIncreasingRunSimple() {
		assertTrue(Arrays.equals(new int[] { 4 }, Sequences.longestIncreasingRun(new int[] { 4 })));		
	}
	
	@Test
	public void testLongestIncreasingRunTie() {
		assertTrue(Arrays.equals(new int[] { 3, 5, 6 }, Sequences.longestIncreasingRun(new int[] { 1, 9, 3, 5, 6, 2, 7, 8 })));
	}
	
	@Test
	public void testLongestIncreasingRunStart() {
		assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4 }, Sequences.longestIncreasingRun(new int[] { 1, 2, 3, 4, 0, 5, 6, 7})));
	}
	
	@Test
	public void testLongestIncreasingRunEnd() {
		assertTrue(Arrays.equals(new int[] { 7, 9, 10, 11 }, Sequences.longestIncreasingRun(new int[] { 1, 2, 3, 0, 5, 8, 7, 9, 10, 11})));
	}
	
	@Test
	public void testLongestIncreasingSequenceSimple() {
		assertTrue(Arrays.equals(new int[] { 4 }, Sequences.longestIncreasingSequence(new int[] { 4 })));
	}
	
	@Test
	public void testLongestIncreasingSequence() {
		assertTrue(Arrays.equals(new int[] { 2, 3, 6 }, Sequences.longestIncreasingSequence(new int[] { 9, 5, 2, 8, 7, 3, 1, 6, 4 })));
	}
	
	@Test
	public void testMaximumSubArrayNegative() {
		assertTrue(Arrays.equals(new int[0], Sequences.maximumSubArray(new int[] { -1, -5, -3})));
	}
	
	@Test
	public void testMaximumSubArrayPositive() {
		assertTrue(Arrays.equals(new int[] { 1, 2, 3}, Sequences.maximumSubArray(new int[] { 1, 2, 3})));
	}
	
	@Test
	public void testMaximumSubArray() {
		assertTrue(Arrays.equals(new int[] { 4, -1, 2, 1 }, Sequences.maximumSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4})));
	}
	
	@Test
	public void testCutRod() {
		int[] p = new int[] {0, 1, 5, 8, 9, 10, 17, 17, 20};
		int[] results = new int[] { 0, 1,  5, 8, 10, 13, 17, 18, 22 };
		for(int i = 0; i < results.length; i++) {
			assertEquals(results[i], Sequences.cutRod(p, i));
		}
	}
	
	@Test
	public void testLongestCommonSubsequence() {
		assertEquals("MJAU", Sequences.longestCommonSubsequence("XMJYAUZ", "MZJAWXU"));
	}
	
	@Test
	public void testMinDistance() throws Exception {
		assertEquals(Integer.MAX_VALUE, Sequences.minDistance(Arrays.asList("the", "flying", "monster", "is", "green"), "the", "blue"));
		assertEquals(0, Sequences.minDistance(Arrays.asList("the", "flying", "monster", "is", "green", "and", "is", "the", "thing", "called", "the", "monster"), "the", "monster"));
		
	}
	
	@Test
	public void testLongestPalindrome() {
		assertEquals("atttgggttta", Sequences.longestPalindrome("cacaattcccatgggttgtggag"));
	}
	
	@Test
	public void testLongestContiguousPalindrome() {
		assertEquals("tgggt", Sequences.longestContiguousPalindrome("cacaattcccatgggttgtggag"));
		assertEquals("aba", Sequences.longestContiguousPalindrome("abacdfgdcaba"));
	}
	
	@Test
	public void testLongestStringWithoutRepetition() {
		assertEquals("b", Sequences.longestSubstringWithoutRepetition("bbbb"));
		assertEquals("abc", Sequences.longestSubstringWithoutRepetition("abcabb"));
	}
	
	@Test
	public void testEditDistance() {
		assertEquals(3, Sequences.editDistance("sitting", "kitten"));
	}
	
	@Test
	public void testProductsExceptSelf() {
		assertTrue(Arrays.equals(new int[] { 3, 5 }, Sequences.productsExceptSelf(new int[] { 5, 3 })));
		assertTrue(Arrays.equals(new int[] { 945, 315, 189, 135, 105 }, Sequences.productsExceptSelf(new int[] { 1, 3, 5, 7, 9 })));
	}
	
	@Test
	public void testMinJumps() {
		assertEquals(2, Sequences.minJumps(new int[] { 2, 3, 1, 1, 4 }));
		assertEquals(-1, Sequences.minJumps(new int[] { 2, 2, 1, 0, 4 }));
		
	}
	
	@Test
	public void testSubarrayWithSumNoAnswer() throws Exception {
		assertTrue(Arrays.equals(new int[] {}, Sequences.subarrayWithSum(new int[] { 3, 1, 5, 4, 6, 7, 2 }, 18)));
	}
	
	@Test
	public void testSubarrayWithSum() throws Exception {
		assertTrue(Arrays.equals(new int[] {3, 5}, Sequences.subarrayWithSum(new int[] { 3, 1, 5, 4, 6, 7, 2 }, 17)));
	}
}
