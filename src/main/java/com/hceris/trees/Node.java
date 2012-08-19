package com.hceris.trees;

class Node<T> {
    
	T value;
    Node<T> left;
    Node<T> right;

    Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    Node(T value) {
        this(value, null, null);
    }
    
    @Override
	public String toString() {
		return "Node [value=" + value + ", left=" + left + ", right=" + right
				+ "]";
	}
}
