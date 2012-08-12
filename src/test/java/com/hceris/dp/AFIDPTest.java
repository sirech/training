package com.hceris.dp;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class AFIDPTest {

	Set<String> dict = new HashSet<String>(Arrays.asList("and", "bed", "bat", "bath", "beyond", "hand"));
	
	@Test
	public void testBreakWordsEmpty() {
		assertEquals(0, AFIDP.breakWords("bedbathandbeyon", dict).size());
	}
	
	@Test
	public void testBreakWords() {
		List<String> result = AFIDP.breakWords("bedbathandbeyond", dict);
		assertEquals("bed", result.get(0));
		assertEquals("bath", result.get(1));
		assertEquals("and", result.get(2));
		assertEquals("beyond", result.get(3)); 
	}

	@Test
	public void testKnapsackZeroOne() {
		assertEquals(Arrays.asList(2, 4, 5, 9), AFIDP.knapsackZeroOne(new int[] { 2, 3, 4, 5, 9, 10 }, 20));
	}
}
