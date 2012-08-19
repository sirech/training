package com.hceris.dp;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CareerCupDPTest {

	@Test
	public void testMaxDistance() {
		assertTrue(Arrays.equals(new int[]{ 1, 6 }, CareerCupDP.maxDistance(new int[] { 3, 1, 4, 5, 2, 1, 2 })));
	}

}
