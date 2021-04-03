package ru.geekbrains.lesson7;

public class DepthFirstPath extends FirstPath {

    public DepthFirstPath(Graph g, int begin) {
       super(g, begin);
        dfs(g, begin);
    }

    private void dfs(Graph g, int v) {
        marked[v]=true;
        for (int w : g.getEdgeList(v)) {
            if(!marked[w]){
                parent[w]=v;
                dfs(g,w);
            }
        }
    }
}
