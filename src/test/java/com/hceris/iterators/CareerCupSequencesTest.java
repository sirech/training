package com.hceris.iterators;

import static org.junit.Assert.*;

import org.junit.Test;

public class CareerCupSequencesTest {

	@Test
	public void testIsSequence() {
		assertTrue(CareerCupSequences.isSequence(new int[] { 45, 50, 47, 46, 49, 48 }));
	}
	
	@Test
	public void testIsSequenceDuplicates() {
		assertTrue(CareerCupSequences.isSequence(new int[] { 45, 47, 50, 47, 48, 46, 49, 48, 50}));
	}
	
	
	@Test
	public void testIsSequenceFalse() {
		assertFalse(CareerCupSequences.isSequence(new int[] { 45, 51, 47, 46, 49, 48 }));
	}
	
	@Test
	public void testIsSequenceFalseDupl() {
		assertFalse(CareerCupSequences.isSequence(new int[] { 45, 46, 47, 46, 50, 48 }));
	}

}
