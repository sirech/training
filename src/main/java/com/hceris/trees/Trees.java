package com.hceris.trees;

import java.util.ArrayList;
import java.util.List;

public class Trees {
    private Trees() {}

    private static int balanced(Node<?> current) {
        if(current == null) {
            return 0;
        }

        int left = balanced(current.left);
        if(left == -1) {
            return -1;
        }

        int right = balanced(current.right);
        if(right == -1) {
            return -1;
        }

        if(Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    public static boolean isBalanced(Node<?> root) {
        return balanced(root) != -1;
    }

    public static <T extends Comparable<? super T>> Node<T> toTree(T[] a, int start, int end) {
        if(end < start) {
            return null;
        }
        if(start == end) {
            return new Node<T>(a[start]);
        }

        int middle = (start + end) >>> 1;
        return new Node<T>(a[middle],
                           toTree(a, start, middle - 1),
                           toTree(a, middle + 1, end));
    }

    public static <T extends Comparable<? super T>> Node<T> toTree(T[] a) {
        return toTree(a, 0, a.length - 1);
    }

    public static <T> List<T> inOrder(Node<T> root) {
        List<T> result = new ArrayList<T>();
        inOrder(root, result);
        return result;
    }

    private static <T> void inOrder(Node<T> current, List<T> result) {
        if(current == null) {
            return;
        }
        
        inOrder(current.left, result);
        result.add(current.value);
        inOrder(current.right, result);
    }

    public static <T extends Comparable<? super T>> boolean isBST(Node<T> root) {
        List<T> elements = inOrder(root);
        for(int i = 0; i < elements.size() - 1; i++) {
            if(elements.get(i).compareTo(elements.get(i+1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<? super T>> boolean isBST2(Node<T> root) {
        return isBST2(root, null, null);
    }

    public static <T extends Comparable<? super T>> boolean isBST2(Node<T> current, T min, T max) {
        if(current == null) {
            return true;
        }

        if((min != null && current.value.compareTo(min) < 0) ||
           (max != null && current.value.compareTo(max) > 0)) {
            return false;
        }

        if(!isBST2(current.left, min, current.value)) {
            return false;
        }
        return isBST2(current.right, current.value, max);
    }
}
