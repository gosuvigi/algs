package com.vigi.graph;

import java.util.*;

/**
 * Created by vigi on 3/22/2015.
 */
public final class DepthFirstSearch {

    private final boolean[] marked;
    private final int[] edgeTo;
    private final int source;
    private final List<Integer> dfs;
    private int count;

    public DepthFirstSearch(Graph g, int source) {
        marked = new boolean[g.getNoOfVertices()];
        edgeTo = new int[g.getNoOfVertices()];
        this.source = source;
        dfs = new ArrayList<Integer>(g.getNoOfVertices());
        dfs(g, source);
    }

    private void dfs(Graph g, int source) {
        if (!marked[source]) {
            dfs.add(source);
        }
        marked[source] = true;
        count++;
        for (int i : g.adjacency(source)) {
            if (!marked[i]) {
                edgeTo[i] = source;
                dfs(g, i);
            }
        }
    }

    public List<Integer> getDfs() {
        return Collections.unmodifiableList(dfs);
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
