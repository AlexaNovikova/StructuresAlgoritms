package ru.geekbrains.lesson7;

import java.util.LinkedList;

public class FirstPath {
    protected boolean[] marked;
    protected int[] parent;
    protected int begin;

    protected FirstPath(Graph g, int begin) {
        // проверка существует ли вершина
        this.begin = begin;
        marked= new boolean[g.getVertexCount()];
        parent= new int[g.getVertexCount()];
      //  bfs(g, begin);
    }
    protected boolean hasPathTo(int w){
        return marked[w];
    }


    protected LinkedList<Integer> pathTo(int w){
        if (!hasPathTo(w)){
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = w;
        while (vertex!=begin){
            stack.push(vertex);
            vertex = parent[vertex];
        }
        return stack;
    }
}
