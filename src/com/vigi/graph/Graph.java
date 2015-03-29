package com.vigi.graph;

import java.util.*;

/**
 * Unidirected graph
 * Created by vigi on 3/22/2015.
 */
public final class Graph {

    private final int noOfVertices;
    private int noOfEdges;
    private final Set<Integer>[] adjacency;

    public Graph(int v) {
        this.noOfVertices = v;
        adjacency = new Set[v];
        for (int i = 0; i < v; i++) {
            adjacency[i] = new LinkedHashSet<Integer>();
        }
    }

    public void addEdge(int from, int to) {
        adjacency[from].add(to);
        adjacency[to].add(from);
        noOfEdges++;
    }

    public Iterable<Integer> adjacency(int vertex) {
        return Collections.unmodifiableCollection(adjacency[vertex]);
    }

    public int getNoOfVertices() {
        return noOfVertices;
    }

    public int getNoOfEdges() {
        return noOfEdges;
    }

}
