package com.hceris.iterators;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.google.common.collect.Lists;

public class IteratorsTest {

	@Test
	public void testSubSetsCount() {
		assertEquals(256, Lists.newArrayList(Iterators.subSets(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"))).size());		
	}
}
