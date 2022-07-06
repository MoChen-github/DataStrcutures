package com.chen.graph;

import org.junit.Test;

public class GraphTest {
    @Test
    public void testCreateGraph() {
        int n = 5;
        String[] Vertexes = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for(String vertex: Vertexes) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(0, 4, 1);

        //graph.showGraph();
        /*
        System.out.println("dfs");
        graph.dfs();
        */
        System.out.println("bfs");
        graph.bfs();
    }

    @Test
    public void testDfsVsDfs() {
        int n = 8;
        String[] Vertexes = {"1", "2", "3", "4", "5","6", "7", "8"};
        Graph graph = new Graph(n);
        for(String vertex: Vertexes) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0, 1, 5);
        graph.insertEdge(0, 2, 3);
        graph.insertEdge(1, 3, 7);
        graph.insertEdge(1, 4, 5);
        graph.insertEdge(3, 7, 3);
        graph.insertEdge(4, 7, 4);
        graph.insertEdge(2, 5, 6);
        graph.insertEdge(2, 6, 2);
        graph.insertEdge(5, 6, 1);

        graph.showGraph();
        System.out.println("==============");
        System.out.println("dfs");
        graph.dfs();
        System.out.println();
        System.out.println("==============");
        System.out.println("bfs");
        graph.bfs();
    }
}
