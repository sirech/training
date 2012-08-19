package com.hceris.trees;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.hceris.trees.Trees.Cell;

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
	public void testToTreeFromPreorder() {
		Integer[] a = new Integer[] { 3, 1, 2, 4, 5 };
		Node<Integer> tree = Trees.toTreeFromPreorder(a);
		assertEquals(3, (int) tree.value);
		assertEquals(1, (int) tree.left.value);
		assertEquals(2, (int) tree.left.right.value);
		assertEquals(4, (int) tree.right.value);
		assertEquals(5, (int) tree.right.right.value);		
	}
	
	@Test
	public void testInOrder() throws Exception {
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), Trees.inOrder(balanced));
	}
	
	@Test
	public void testInOrderIterative() throws Exception {
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), Trees.inOrderIterative(balanced));
	}
	
	@Test
	public void testInOrderMorris() throws Exception {
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), Trees.inOrderMorris(balanced));
	}
	
	@Test
	public void testInOrderIterativeMultiple() throws Exception {
		assertEquals(Arrays.asList(1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7, 8, 9), Trees.inOrderIterative(balanced, new Node<Integer>(5,
				new Node<Integer>(3, new Node<Integer>(1), new Node<Integer>(4)),
				new Node<Integer>(8, new Node<Integer>(7), new Node<Integer>(9))				
				)));
	}
	
	@Test
	public void testPreOrderMorris() throws Exception {
		assertEquals(Arrays.asList(4, 2, 1, 3, 6, 5, 7	), Trees.preOrderMorris(balanced));
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
	
	@Test
	public void testHuffmanTree() {
		Map<Character, String> codes = Trees.huffmanTree(Arrays.asList(new HuffmanValue('c', 0.5), new HuffmanValue('a', 0.125), new HuffmanValue('b', 0.125), new HuffmanValue('e', 0.2), new HuffmanValue('d', 0.05)));
		assertEquals("0", codes.get('c'));
		assertEquals("110", codes.get('b'));
		assertEquals("1110", codes.get('d'));
		assertEquals("1111", codes.get('a'));
	}
	
	@Test
	public void testLevels() {
		List<LinkedList<Node<Integer>>> result = Trees.levels(balanced);
		assertEquals(1, result.get(0).size());
		
		assertEquals(2, result.get(1).size());
		assertEquals(2, (int) result.get(1).get(0).value);
		assertEquals(6, (int) result.get(1).get(1).value);
		
		assertEquals(4, result.get(2).size());
	}
	
	@Test
	public void testHeight() {
		assertEquals(3, Trees.height(balanced));
		assertEquals(2, Trees.height(balanced.left));
	}
	
	@Test
	public void testDiameter() {
		assertEquals(5, Trees.diameter(balanced));
		assertEquals(6, Trees.diameter(unbalanced));
	}
	
	@Test
	public void testEquals() {
		assertFalse(Trees.equals(balanced, unbalanced));
		assertTrue(Trees.equals(unbalanced, unbalanced));
	}
	
	@Test
	public void testKElement() {
		assertEquals(1, (int) Trees.kElement(balanced, 0));
		assertEquals(4, (int) Trees.kElement(balanced, 3));
		assertEquals(7, (int) Trees.kElement(balanced, 6));
		assertEquals(null, Trees.kElement(balanced, 7));
	}
	
	@Test
	public void testNumberOfTrees() throws Exception {
		assertEquals(1, Trees.numberOfTrees(Arrays.asList(1)));
		assertEquals(5, Trees.numberOfTrees(Arrays.asList(1, 2, 3)));
		assertEquals(132, Trees.numberOfTrees(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}
	
	public void testtestBstAndHeap() throws Exception {
		Cell[] a = new Cell[] { new Cell(3,7), new Cell(2,6), new Cell(5,5), new Cell(1,4), new Cell(4,3) };
		Node<Cell> root = Trees.bstAndHeap(a);
		assertEquals(root, a[0]);
		assertEquals(root.left, a[1]);
		assertEquals(root.left.left, a[3]);
		assertEquals(root.right, a[2]);
		assertEquals(root.left, a[4]);		
	}
}
