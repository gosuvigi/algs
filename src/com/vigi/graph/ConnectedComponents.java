package com.vigi.graph;

/**
 * Created by vigi on 3/29/2015.
 */
public final class ConnectedComponents {

    private final boolean[] marked;
    private final int[] id;
    private int noOfComponents;

    public ConnectedComponents(Graph g) {
        this.marked = new boolean[g.getNoOfVertices()];
        this.id = new int[g.getNoOfVertices()];
        connectComponents(g);
    }

    private void connectComponents(Graph g) {
        for (int vertex = 0; vertex < g.getNoOfVertices(); vertex++) {
            if (!marked[vertex]) {
                dfs(g, vertex);
                noOfComponents++;
            }
        }
    }

    private void dfs(Graph g, int s) {
        marked[s] = true;
        id[s] = noOfComponents;
        for (int v : g.adjacency(s)) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int getNoOfComponents() {
        return noOfComponents;
    }
}
