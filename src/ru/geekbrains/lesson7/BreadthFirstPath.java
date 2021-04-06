package ru.geekbrains.lesson7;

import java.util.LinkedList;

public class BreadthFirstPath extends FirstPath{

    public BreadthFirstPath(Graph g, int begin) {
        super(g, begin);
        bfs(g, begin);
    }

    private void bfs(Graph g, int begin) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(begin);
        marked[begin]=true;
        while(!queue.isEmpty()){
            int vertex = queue.removeFirst();
            for (int w: g.getEdgeList(vertex)) {
                if (!marked[w]){
                    marked[w]=true;
                    parent[w]=vertex;
                    queue.addLast(w);
                }
            }
        }
    }

}
