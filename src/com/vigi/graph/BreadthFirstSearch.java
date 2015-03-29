package com.vigi.graph;

import java.util.*;

/**
 * Created by vigi on 3/29/2015.
 */
public final class BreadthFirstSearch {

    private final boolean[] marked;
    private final int[] edgeTo;
    private final int source;

    private final List<Integer> bfs;

    public BreadthFirstSearch(Graph g, int source) {
        this.marked = new boolean[g.getNoOfVertices()];
        this.edgeTo = new int[g.getNoOfVertices()];
        this.source = source;
        bfs = new ArrayList<Integer>(g.getNoOfVertices());
        bfs(g, source);
    }

    private void bfs(Graph g, int source) {
        Queue<Integer> q = new ArrayDeque<Integer>(g.getNoOfVertices());
        bfs.add(source);
        marked[source] = true;
        q.add(source);
        while (!q.isEmpty()) {
            int head = q.poll();
            for (int vertex : g.adjacency(head)) {
                if (!marked[vertex]) {
                    bfs.add(vertex);
                    edgeTo[vertex] = head;
                    marked[vertex] = true;
                    q.add(vertex);
                }
            }
        }
    }

    public List<Integer> getBfs() {
        return Collections.unmodifiableList(bfs);
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return Collections.emptyList();
        }
        Deque<Integer> path = new ArrayDeque<Integer>(edgeTo.length);
        for (int i = v; i != source; i = edgeTo[i]) {
            path.push(i);
        }
        path.push(source);
        return path;
    }
}
