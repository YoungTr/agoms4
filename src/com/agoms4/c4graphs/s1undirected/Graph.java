package com.agoms4.c4graphs.s1undirected;

import com.agoms4.c1.s3.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {

    private final int V;            // 顶点数目
    private int E;                  // 边的数目
    private Bag<Integer>[] adj;     // 邻接表

    public Graph(int v) {
        V = v;
        E = 0;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());     // 读取V并将图初始化
        this.E = in.readInt();
        for (int i = 0; i < E; i++) {
            // 添加一条边
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    /**
     * Return a string representation of the graph.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V).append(" vertices, ").append(E).append(" edges ").append(NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (int w : adj[v]) {
                s.append(w).append(" ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
