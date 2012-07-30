package com.hceris.trees;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreesTest {
	
	Node<Integer> balanced = new Node<Integer>(4, 
				new Node<Integer>(2, new Node<Integer>(1), new Node<Integer>(3)),
				new Node<Integer>(6, new Node<Integer>(5), new Node<Integer>(7))				
				);
	
	Node<Integer> unbalanced = new Node<Integer>(0, 
				new Node<Integer>(2, new Node<Integer>(4), new Node<Integer>(5)),
				new Node<Integer>(3, null, 
						new Node<Integer>(7, new Node<Integer>(8), null))				
				);
	
	@Test
	public void testIsBalancedTrue() {		
		assertTrue(Trees.isBalanced(balanced));
	}
	
	@Test
	public void testIsBalancedFalse() {		
		assertFalse(Trees.isBalanced(unbalanced));
	}
	
	@Test
	public void testToTree() {
		Integer[] a = new Integer[] { 1, 2, 3, 4, 5 };
		Node<Integer> tree = Trees.toTree(a);
		assertEquals(3, (int) tree.value);
		assertEquals(1, (int) tree.left.value);
		assertEquals(2, (int) tree.left.right.value);
		assertEquals(4, (int) tree.right.value);
		assertEquals(5, (int) tree.right.right.value);		
	}
	
	@Test
	public void testIsBSTTrue() {		
		assertTrue(Trees.isBST(balanced));
	}
	
	@Test
	public void testIsBSTFalse() {		
		assertFalse(Trees.isBST(unbalanced));
	}
	
	@Test
	public void testIsBST2True() {		
		assertTrue(Trees.isBST2(balanced));
	}
	
	@Test
	public void testIsBST2False() {		
		assertFalse(Trees.isBST2(unbalanced));
	}

}
