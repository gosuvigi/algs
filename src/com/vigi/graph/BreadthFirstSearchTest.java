package com.vigi.graph;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BreadthFirstSearchTest {

    @Test
    public void testPathTo() throws Exception {
        Graph g = initGraph();
        BreadthFirstSearch bfs = new BreadthFirstSearch(g, 0);

        assertThat(bfs.getBfs(), is(Arrays.asList(0, 4, 1, 5, 2, 6, 3, 7)));
    }

    private Graph initGraph() {
        Graph g = new Graph(8);
        g.addEdge(0, 4);
        g.addEdge(5, 1);
        g.addEdge(1, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 6);
        g.addEdge(2, 1);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        g.addEdge(4, 5);
        g.addEdge(4, 1);
        g.addEdge(4, 0);
        g.addEdge(5, 1);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 2);
        g.addEdge(6, 7);
        g.addEdge(6, 3);
        g.addEdge(6, 5);
        g.addEdge(7, 6);
        g.addEdge(7, 3);
        return g;
    }
}