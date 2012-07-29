package com.hceris.datastructures;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

public class StacksTest {

	LinkedList<Integer> s = new LinkedList<Integer>(Arrays.asList(3, 4, 7, 1, 9, 8, 2, 6, 5));
	
	@Test
	public void testSort() {
		Stacks.sort(s);
		
		for(int i = 9; i > 0; i--) {
			assertEquals(i, (int) s.pop());
		}
	}

}
