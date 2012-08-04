package com.hceris.datastructures;

import java.util.Map;

public class SuffixTree {
    private Node root;

    public SuffixTree(String s) {
        root = new Node();
        for(int i = 0; i < s.length(); i++) {
        	root.insert(s.substring(i));
        }
    }

    public boolean contains(String s) {
        return root.contains(s);
    }

    private static class Node {
        Map<Character, Node> nodes = new HashMap<Character,Node>(0);

        public void insert(String s) {
            if(s == null || s.isEmpty()) {
                return;
            }

            char first = s.charAt(0);
            Node next = nodes.get(first);

            if(next == null) {
                next = new Node();
                nodes.put(first, next);
            }

            next.insert(s.substring(1));
        }

        public boolean contains(String s) {
            if(s.isEmpty()) {
                return true;
            }

            Node next = nodes.get(s.charAt(0));
            if(next == null) {
                return false;
            }

            return next.contains(s.substring(1));
        }
    }
}
