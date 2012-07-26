package com.hceris.graphs;

public final class Edge {

    private final Node src;
    private final Node dst;
    private final int w;

    public Edge(Node src, Node dst, int w) {
        this.src = src;
        this.dst = dst;
        this.w = w;
    }

    public Node source() { return src; }
    public Node destination() { return dst; }
    public int weight() { return w; }
}
