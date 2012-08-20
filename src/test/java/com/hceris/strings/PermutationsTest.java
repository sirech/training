package com.hceris.strings;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class PermutationsTest {
	@Test
	public void testPermutations() throws Exception {
		List<String> permutations = Permutations.permutations("abc");
		assertEquals("[abc, bac, bca, acb, cab, cba]", permutations.toString());
	}

	@Test
	public void testPermutations2() throws Exception {
		List<String> permutations = Permutations.permutations2("abc");
		assertEquals("[abc, acb, bac, bca, cba, cab]", permutations.toString());
	}

	@Test
	public void testPermutations2WithDuplicates() throws Exception {
		List<String> permutations = Permutations.permutations2("abbc");
		assertEquals(
				"[abbc, abcb, acbb, babc, bacb, bbac, bbca, bcba, bcab, cbba, cbab, cabb]",
				permutations.toString());
	}

	@Test
	public void testInterleave() throws Exception {
		assertEquals("[ABCD, ACBD, ACDB, CABD, CADB, CDAB]", Permutations
				.interleave("AB", "CD").toString());
	}
}
