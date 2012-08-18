package com.hceris.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CCIDPTest {

	@Test
	public void testCountSteps() throws Exception {
		assertEquals(13, CCIDP.countSteps(5));
	}
	
	@Test
	public void testMagicIndexFalse() throws Exception {
		assertEquals(-1, CCIDP.magicIndex(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));		
	}
	
	@Test
	public void testMagicIndexTrue() throws Exception {
		assertEquals(0, CCIDP.magicIndex(new int[] { 0, 2, 3, 4, 5, 6, 7, 8 }));		
	}
	
	@Test
	public void testMagicIndexDuplFalse() throws Exception {
		assertEquals(-1, CCIDP.magicIndexDupl(new int[] { 1, 2, 4, 4, 5, 6, 7, 8 }));		
	}
	
	@Test
	public void testMagicIndexDuplTrue() throws Exception {
		assertEquals(7, CCIDP.magicIndexDupl(new int[] { 1, 2, 3, 4, 5, 6, 7, 7 }));		
	}
}
