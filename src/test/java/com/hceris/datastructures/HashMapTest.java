package com.hceris.datastructures;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class HashMapTest {

	Map<String,Integer> basic = new HashMap<String,Integer>(ImmutableMap.of("one", 1, "two", 2, "three", 3, "four", 4));
	
	@Test
	public void testContainsKey() {
		assertTrue(basic.containsKey("one"));
		assertFalse(basic.containsKey("ten"));
	}
	
	@Test
	public void testContainsValue() {
		assertTrue(basic.containsValue(3));
		assertFalse(basic.containsValue(10));
	}
	
	@Test
	public void testClear() {
		assertNotSame(0, basic.size());
		basic.clear();
		assertEquals(0, basic.size());
	}
	
	@Test
	public void testGet() {
		assertEquals(3, (int) basic.get("three"));
		assertNull(basic.get("eight"));
	}
	
	@Test
	public void testPutOverride() {
		assertEquals(3, (int) basic.get("three"));
		assertEquals(3, (int) basic.put("three", 42));
		assertEquals(42, (int) basic.get("three"));
	}
	
	@Test
	public void testPutNew() {
		assertNull(basic.get("eight"));
		assertNull(basic.put("eight", 8));
		assertEquals(8, (int) basic.get("eight"));
	}
	
	@Test
	public void testRemove() {
		assertEquals(3, (int) basic.get("three"));
		basic.remove("three");
		assertNull(basic.get("three"));
	}
}
