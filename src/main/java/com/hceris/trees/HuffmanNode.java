package com.hceris.trees;

class HuffmanNode extends Node<HuffmanValue> implements Comparable<HuffmanNode> {

    HuffmanNode(HuffmanValue value, HuffmanNode left, HuffmanNode right) {
        super(value, left, right);
    }
        
    HuffmanNode(HuffmanValue value) {
        this(value, null, null);
    }

    public int compareTo(HuffmanNode n) {
        return value.compareTo(n.value);
    }
}
