package com.hceris.trees;

import static com.hceris.util.Utils.swap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.hceris.datastructures.MinHeap;

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

    // assumption: array sorted
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

    // assumption: array comes from preorder traversal
    public static <T extends Comparable<? super T>> Node<T> toTreeFromPreorder(T[] a) {
        LinkedList<Node<T>> stack = new LinkedList<Node<T>>();
        Node<T> root = new Node<T>(a[0]);
        stack.addFirst(root);

        for(int i = 1; i < a.length; i++) {
            Node<T> node = new Node<T>(a[i]);
            if(a[i].compareTo(stack.getFirst().value) <= 0) {
                stack.getFirst().left = node;
            } else {
                Node<T> parent = null;
                while(!stack.isEmpty() && a[i].compareTo(stack.getFirst().value) > 0) {
                    parent = stack.removeFirst();
                }
                parent.right = node;
            }
            stack.addFirst(node);
        }

        return root;
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

    public static <T> List<T> inOrderIterative(Node<T> root) {
        List<T> result = new ArrayList<T>();
        LinkedList<Node<T>> stack = new LinkedList<Node<T>>();

        Node<T> current = root;
        while(true) {
            while(current != null) {
                stack.addFirst(current);
                current = current.left;
            }

            if(stack.isEmpty()){ break; }

            current = stack.removeFirst();
            result.add(current.value);
            current = current.right;

        }
        return result;
    }

    public static <T> List<T> inOrderMorris(Node<T> root) {
        List<T> result = new ArrayList<T>();

        Node<T> current = root;
        Node<T> prev = null;

        while(current != null) {
            if(current.left == null) {
                result.add(current.value);
                current = current.right;
            } else {
                for (prev = current.left; prev.right != null && prev.right != current; prev = prev.right) ;

                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    result.add(current.value);
                    current = current.right;
                }
            }
        }

        return result;
    }

    public static <T extends Comparable<? super T>> List<T> inOrderIterative(Node<T> r1, Node<T> r2) {
        List<T> result = new ArrayList<T>();

        LinkedList<Node<T>> s1 = new LinkedList<Node<T>>();
        LinkedList<Node<T>> s2 = new LinkedList<Node<T>>();

        Node<T> current = r1;
        Node<T> current2 = r2;

        while(true) {
            while(current != null) {
                s1.addFirst(current);
                current = current.left;
            }

            while(current2 != null) {
                s2.addFirst(current2);
                current2 = current2.left;
            }

            if(s1.isEmpty() && s2.isEmpty()) {
                break;
            } else if(!s1.isEmpty() && s2.isEmpty()) {
                current = s1.removeFirst();
                result.add(current.value);
                current = current.right;
            } else if(s1.isEmpty() && !s2.isEmpty()) {
                current2 = s2.removeFirst();
                result.add(current2.value);
                current2 = current2.right;
            } else {
                if(s1.getFirst().value.compareTo(s2.getFirst().value) <= 0) {
                    current = s1.removeFirst();
                    result.add(current.value);
                    current = current.right;
                } else {
                    current2 = s2.removeFirst();
                    result.add(current2.value);
                    current2 = current2.right;
                }
            }
        }
        return result;
    }

    public static <T> List<T> preOrderMorris(Node<T> root) {
        List<T> result = new ArrayList<T>();

        Node<T> current = root;
        Node<T> prev = null;

        while(current != null) {
            if(current.left == null) {
                result.add(current.value);
                current = current.right;
            } else {
                for (prev = current.left; prev.right != null && prev.right != current; prev = prev.right) ;

                if (prev.right == null) {
                    result.add(current.value);
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    current = current.right;
                }
            }
        }

        return result;
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

        return isBST2(current.left, min, current.value) && isBST2(current.right, current.value, max);
    }

    public static Map<Character, String> huffmanTree(List<HuffmanValue> values) {
        Collection<HuffmanNode> nodes = Collections2.transform(values, new Function<HuffmanValue, HuffmanNode>() {
                public HuffmanNode apply(HuffmanValue value) {
                    return new HuffmanNode(value);
                }
            });
        MinHeap<HuffmanNode> heap = new MinHeap<HuffmanNode>(Lists.newArrayList(nodes));

        while(heap.size() > 1) {
            HuffmanNode v1 = heap.poll();
            HuffmanNode v2 = heap.poll();
            heap.offer(new HuffmanNode(v1.value.combine(v2.value), v1, v2));
        }

        Map<Character, String> codes = new HashMap<Character, String>();
        huffmanCode(heap.poll(), "", codes);
        return codes;
    }

    private static void huffmanCode(Node<HuffmanValue> current, String prefix, Map<Character, String> codes) {
        if(current.left == null && current.right == null) {
            codes.put(current.value.getCharacter(), prefix);
        } else {
            huffmanCode(current.left, prefix + "0", codes);
            huffmanCode(current.right, prefix + "1", codes);
        }
    }

    public static <T> List<LinkedList<Node<T>>> levels(Node<T> root) {
        List<LinkedList<Node<T>>> result = new ArrayList<LinkedList<Node<T>>>();
        levels(root, 0, result);
        return result;
    }

    private static <T> void levels(Node<T> root, int currentLevel, List<LinkedList<Node<T>>> result) {
        if(root == null) {
            return;
        }

        addToN(root, currentLevel, result);
        levels(root.left, currentLevel + 1, result);
        levels(root.right, currentLevel + 1, result);
    }

    private static <T> void addToN(Node<T> node, int level, List<LinkedList<Node<T>>> levels) {
        if(levels.size() == level) {
            levels.add(new LinkedList<Node<T>>());
        }
        levels.get(level).addLast(node);
    }

    public static int diameter(Node<?> current) {
        if(current == null) {
            return 0;
        }

        int lheight = height(current.left);
        int rheight = height(current.right);

        int ldiameter = diameter(current.left);
        int rdiameter = diameter(current.right);

        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
    }

    public static int height(Node<?> current) {
        if(current == null) {
            return 0;
        }

        return 1 + Math.max(height(current.left), height(current.right));
    }

    public static <T> boolean equals(Node<T> x, Node<T> y) {
        if(x == null || y == null) {
            return x == y;
        }

        return x.value.equals(y.value) && equals(x.left, y.left) && equals(x.right, y.right);
    }

    public static <T> T kElement(Node<T> root, int k) {
        KElement<T> e = kElement(root, 0, k);
        return e.value;
    }

    private static <T> KElement<T> kElement(Node<T> current, int start, int k) {
        if(current == null) {
            return new KElement<T>(null, start);
        }

        KElement<T> e = kElement(current.left, start, k);

        if(e.value != null) {
            return e;
        }

        if(e.count == k) {
            return new KElement<T>(current.value, k);
        }

        return kElement(current.right, e.count + 1, k);
    }

    private static class KElement<T> {
        T value;
        int count;

        KElement(T value, int count) {
            this.value = value;
            this.count = count;
        }

    }

    public static <T> int numberOfTrees(List<T> inOrder) {
        return numberOfTrees(inOrder, 0, inOrder.size() - 1, new HashMap<List<Integer>,Integer>());
    }

    private static <T> int numberOfTrees(List<T> inOrder, int first, int last, Map<List<Integer>,Integer> cache) {
        if(first >= last) {
            return 1;
        }

        List<Integer> key = Arrays.asList(first, last);
        Integer cached = cache.get(key);

        if(cached != null) {
            return cached;
        }

        int sum = 0;
        for(int i = first; i <= last; i++) {
            sum += numberOfTrees(inOrder, first, i-1, cache) * numberOfTrees(inOrder, i+1, last, cache);
        }

        cache.put(key, sum);
        return sum;
    }

    public static Node<Cell> bstAndHeap(Cell[] a) {
        return bstAndHeap(a, 0, a.length - 1);
    }
    
    private static Node<Cell> bstAndHeap(Cell[] a, int left, int right) {
        if(left > right) {
            return null;
        }
        
        if(left == right) {
        	return new Node<Cell>(a[left]);
        }

        int root = left;
        for(int i = left + 1; i <= right; i++) {
            if(a[i].j > a[root].j) {
                root = i;
            }
        }

        swap(a, left, root);
        int middle = left;

        for(int i = left + 1; i <= right; i++) {
            if(a[i].i <= a[left].i) {
                swap(a, i, ++middle);
            }
        }
        swap(a, left, middle);

        return new Node<Cell>(a[middle], bstAndHeap(a, left, middle - 1), bstAndHeap(a, middle + 1, right));
    }
    
    // does not work if either p or q are not in the tree
    public static <T> Node<T> commonAncestor(Node<T> root, T p, T q) {
    	if(root == null) {
    		return null;
    	}
    	
    	Node<T> x = commonAncestor(root.left, p, q);
    	if(x != null && !x.value.equals(p) && !x.value.equals(q)) {
    		return x;
    	}
    	
    	Node<T> y = commonAncestor(root.right, p, q);
    	if(y != null && !y.value.equals(p) && !y.value.equals(q)) {
    		return y;
    	}
    	
    	if(x != null && y != null) {
    		return root;
    	} else if(root.value.equals(p) || root.value.equals(q)) {
    		return root;
    	} else {
    		return x == null ? y : x;
    	}    		
    }
    
    public static boolean containsTree(Node<?> root, Node<?> subTree) {
    	if(subTree == null) {
    		return true;
    	}
    	
    	if(root == null) {
    		return false;
    	}
    	
    	if(root.value.equals(subTree.value)) {
    		if(match(root, subTree)) {
    			return true;
    		}
    	}
    	
    	return containsTree(root.left, subTree) || containsTree(root.right, subTree);
    }
    
    private static boolean match(Node<?> root, Node<?> subTree) {
    	if(root == null && subTree == null) {
    		return true;
    	}
    	
    	if(root == null || subTree == null) {
    		return false;
    	}
    	
    	return root.value.equals(subTree.value) && match(root.left, subTree.left)
    											&& match(root.right, subTree.right);
    }
    
    private static class Edge<T> {
    	Node<T> left;
    	Node<T> right;
    	
    	Edge(Node<T> left, Node<T> right) {
    		this.left = left;
    		this.right = right;
    	}
    }
    
    public static <T> Node<T> bstToDoublyLinkedList(Node<T> root) {
    	Edge<T> edges = flatten(root);
    	return edges.left;
    }
    
	private static <T> Edge<T> flatten(Node<T> root) {
    	if(root == null) { return null; }
    	
    	Edge<T> left = flatten(root.left);
    	Edge<T> right = flatten(root.right);
    	
    	if(left != null) {
    		left.right.right = root;
    		root.left = left.right;
    	}
    	
    	if(right != null) {
    		right.left.left = root;
    		root.right = right.left;
    	}
    	
    	return new Edge<T>(left != null ? left.left : root , right != null ? right.right : root);
    }
}
