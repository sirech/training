package com.hceris.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Graph implements Iterable<Node> {

    final List<Node> nodes = new ArrayList<Node>();

    public Iterator<Node> iterator() {
        return nodes.iterator();
    }

    public int vertices() { return nodes.size() ; }

    public Node get(int index) { return nodes.get(index); }

    Graph edge(int src, int dst) {
        return edge(src, dst, 1);
    }
    
    Graph edge(int src, int dst, int w) {
        Edge e = new Edge(nodes.get(src), nodes.get(dst), w);
        nodes.get(src).ady.add(e);
        return this;
    }
}
