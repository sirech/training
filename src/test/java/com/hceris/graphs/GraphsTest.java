package com.hceris.graphs;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class GraphsTest {

	private Graph g;
	
	@Before
	public void setUp() {
		g = new Graph();
		
		for(int i = 0; i < 8; i++) {
			Node s = new Node(i); 
			g.nodes.add(s);
		}
		
		g.edge(0, 4);
		g.edge(1, 0).edge(1, 5);
		g.edge(2, 3).edge(2, 6);
		g.edge(3,2).edge(3,6).edge(3, 7);
		g.edge(5, 2).edge(5, 6);
		g.edge(6, 3).edge(6, 7);		
	}
	
	@Test
	public void testBfs() {
		assertTrue(Arrays.equals(new int[] { 1, 0, 2, 3, 2, 1, 2, 3 }, Graphs.bfs(g, 1)));
	}

	@Test
	public void testDfs() {
		assertTrue(Arrays.equals(new int[] { 1, 0, 2, 3, 2, 1, 2, 3 }, Graphs.dfs(g, 1)));
	}

}
