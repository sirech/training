package com.hceris.datastructures;

import java.util.Map;

public class SuffixTree {
    private Node root;

    public SuffixTree(String s) {
        root = new Node();
        for(int i = 0; i < s.length(); i++) {
        	root.insert(s, i);
        }
    }

    public boolean contains(String s) {
        return root.contains(s, 0);
    }

    private static class Node {
        Map<Character, Node> nodes = new HashMap<Character,Node>(0);

        public void insert(String s, int current) {
            if(s == null || current >= s.length()) {
                return;
            }

            char first = s.charAt(current);
            Node next = nodes.get(first);

            if(next == null) {
                next = new Node();
                nodes.put(first, next);
            }

            next.insert(s, current + 1);
        }

        public boolean contains(String s, int current) {
            if(s.isEmpty() || current >= s.length()) {
                return true;
            }

            Node next = nodes.get(s.charAt(current));
            if(next == null) {
                return false;
            }

            return next.contains(s, current + 1);
        }
    }
}
