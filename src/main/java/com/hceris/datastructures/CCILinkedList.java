package com.hceris.datastructures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Set;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;

public class CCILinkedList<T> implements Iterable<T> {

    private Node<T> head;

    public CCILinkedList(Iterable<? extends T> elements) {
    	for(T elem : elements) {
    		addLast(elem);
    	}
    }

    public CCILinkedList() {
    }

    @Override
    public boolean equals(Object o) {
    	if(!(o instanceof CCILinkedList)) {
    		return false;
    	}
    	
    	CCILinkedList<?> l = (CCILinkedList<?>) o;
    	if(size() != l.size()) {
    		return false;
    	}
    	
    	Node<?> current = head;
    	Node<?> other = l.head;
    	
    	while(current != null) {
    		if(!current.data.equals(other.data)) {
    			return false;
    		}
    		current = current.next;
    		other = other.next;
    	}
    	return true;
    }
    
    public int size() { 
    	int n = 0;
    	for(@SuppressWarnings("unused") T data : this) {
    		n++;
    	}
    	return n;
    }

    public void addLast(T data) {
        if(head == null) {
            head = new Node<T>(data, null);
            return;
        }

        Node<T> last = head;
        while(last.next != null) {
            last = last.next;
        }

        last.next = new Node<T>(data, null);
    }

    public void addFirst(T data) {
    	head = new Node<T>(data, head);
    }

    public T get(int index) {
        if(index < 0 || index >= size()) {
            throw new IllegalArgumentException();
        }

        int i = 0;
        Node<T> current = head;

        while(i != index) {
            i++;
            current = current.next;
        }

        return current.data;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = head;
            
            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }

                T value = current.data;
                current = current.next;
                return value;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    @Override public String toString() {
    	return "[" + Joiner.on(',').join(iterator()) + "]";
    };

    public void removeDuplicates() {
        Set<T> seen = new HashSet<T>();

        if(size() < 2) { return; }

        Node<T> prev = head;
        Node<T> current = head.next;

        seen.add(prev.data);
        while(current != null) {
            if(!seen.add(current.data)) {
                prev.next = current.next;
            } else {
                prev = current;
            }

            current = current.next;
        }
    }

    public void removeDuplicatesInPlace() {
        if(size() < 2) { return; }

        Node<T> mark = head;
        while(mark != null) {
            Node<T> prev = mark;
            while(prev.next != null) {
                if(prev.next.data.equals(mark.data)) {
                    prev.next = prev.next.next;
                } else {
                    prev = prev.next;
                }
            }
            mark = mark.next;
        }
    }

    public T nthToLast(int n) {
        return nthToLastNode(n).data;
    }

    private Node<T> nthToLastNode(int n) {
        Node<T> p2 = head;
        Node<T> p1 = head;
        for(int i = 0; i <= n; i++) {
            p2 = p2.next;
        }

        while(p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;

        while(current != null) {
            Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void reverse(int m, int n) {
        Node<T> prev = null;
        Node<T> current = head;

        int i = 0;
        while(i < m && current != null) {
            prev = current;
            current = current.next;
            i++;
        }

        Preconditions.checkState(i == m);
        Node<T> begin = prev;
        prev = null;
        
        while(i <= n && current != null) {
            Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }

        Preconditions.checkState(i == n + 1);
        
        if(begin == null) {
            head.next = current;
            head = prev;
        } else {
            begin.next.next = current;
            begin.next = prev;
        }
    }

    public void reverseCycle(int k) {
        head = reverseCycle(head, k);
    }

    private Node<T> reverseCycle(Node<T> start, int k) {
        if(start == null) {
            return null;
        }
        
        Node<T> current = start;
        Node<T> prev = null;
        int count = 0;

        while(current != null && count < k) {
            Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        start.next = reverseCycle(current, k);
        return prev;        
    }

    public void rotateRight(int k) {
        Node<T> newTail = nthToLastNode(k);
        Node<T> newHead = newTail.next;
        
        Node<T> prev = null;
        Node<T> current = newHead;
        while(current != null) {
            prev = current;
            current = current.next;
        }

        prev.next = head;
        head = newHead;
        newTail.next = null;
    }

    public boolean isPalindrome() {
        Node<T> slow = head;
        Node<T> fast = head;
        LinkedList<T> stack = new LinkedList<T>();

        if(fast == null) {
            return false;            
        }
        
        while(fast != null && fast.next != null) {
            stack.addFirst(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) {
            slow = slow.next;
        }

        while(slow != null) {
            if(!stack.removeFirst().equals(slow.data)) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
    
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

}
