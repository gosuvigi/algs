package com.vigi.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by vigi on 3/29/2015.
 */
public class DepthFirstSearchTest {

    private Graph g;
    private DepthFirstSearch dfs;

    @Before
    public void setup() {
        g = initGraph();
        dfs = new DepthFirstSearch(g, 0);
    }

    @After
    public void tearDown() {
        dfs = null;
        g = null;
    }

    @Test
    public void path_to() {
        assertThat(dfs.pathTo(7).toString(), is("[0, 1, 6, 7]"));
    }

    @Test
    public void dfs() {
        assertThat(dfs.getDfs(), is(Arrays.asList(0, 1, 6, 7, 2, 3, 5, 4)));
    }

    private Graph initGraph() {
        Graph g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(0, 5);
        g.addEdge(1, 0);
        g.addEdge(1, 6);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 7);
        g.addEdge(3, 7);
        g.addEdge(4, 5);
        g.addEdge(5, 0);
        g.addEdge(5, 4);
        g.addEdge(6, 7);
        g.addEdge(6, 1);
        g.addEdge(6, 2);
        g.addEdge(7, 6);
        g.addEdge(7, 2);
        g.addEdge(7, 3);
        return g;
    }
}
