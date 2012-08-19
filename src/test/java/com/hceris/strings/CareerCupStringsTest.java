package com.hceris.strings;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CareerCupStringsTest {

	String[] numbers = new String[] { "4", "94", "9", "14", "1" };
	
	@Test
	public void testBiggestNumber() {
		CareerCupStrings.biggestNumber(numbers);
		assertTrue(Arrays.equals(new String[] { "9", "94", "4", "14", "1" }, numbers));
	}

}
