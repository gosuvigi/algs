package com.vigi.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConnectedComponentsTest {

    private Graph g;
    private ConnectedComponents cc;

    @Before
    public void setup() {
        g = initGraph();
        cc = new ConnectedComponents(g);
    }

    @After
    public void tearDown() {
        cc = null;
        g = null;
    }

    @Test
    public void are_components_connected() {
        assertThat(cc.connected(0, 0), is(true));
        assertThat(cc.connected(0, 5), is(true));
        assertThat(cc.connected(0, 7), is(false));

        assertThat(cc.connected(6, 7), is(true));
        assertThat(cc.connected(3, 9), is(true));

        assertThat(cc.id(0), is(0));
    }

    @Test
    public void id_of_the_connected_component() {
        assertThat(cc.id(0), is(0));
        assertThat(cc.id(1), is(0));
        assertThat(cc.id(5), is(0));

        assertThat(cc.id(2), is(1));
        assertThat(cc.id(3), is(1));
        assertThat(cc.id(4), is(1));
        assertThat(cc.id(8), is(1));
        assertThat(cc.id(9), is(1));

        assertThat(cc.id(6), is(2));
        assertThat(cc.id(7), is(2));
    }

    @Test
    public void number_of_components() {
        assertThat(cc.getNoOfComponents(), is(3));
    }

    private Graph initGraph() {
        Graph g = new Graph(10);
        g.addEdge(0, 1);
        g.addEdge(0, 5);

        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 8);
        g.addEdge(3, 8);
        g.addEdge(3, 9);
        g.addEdge(4, 9);
        g.addEdge(8, 9);

        g.addEdge(6, 7);
        return g;
    }

}