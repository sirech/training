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
	
	@Test
	public void testMajorityFind() {
		assertEquals(7, (int) Iterators.findMajority(Arrays.asList(1, 2, 3, 4, 7, 3, 4, 2, 5, 7, 7, 7, 8, 7, 2, 7, 7, 9, 7, 7, 7)));
	}
	
	@Test
	public void testReservoirSamplingDoesNotCrash() {
		assertEquals(3, Iterators.reservoirSampling(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), 3).size());
	}
}
