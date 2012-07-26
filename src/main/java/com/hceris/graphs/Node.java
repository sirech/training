package com.hceris.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class Node implements Iterable<Edge> {

	private final int id;
	final List<Edge> ady = new LinkedList<Edge>();

	public Node(int id) {
		this.id = id;
	}

	public int index() {
		return this.id;
	}

	public Iterator<Edge> iterator() {
		return ady.iterator();
	}

	@Override
	public String toString() {
		return "Node [id=" + id + "]";
	}
}
