package ru.geekbrains.lesson7;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(11);
        g.addEdge(1,4);
        g.addEdge(3,4);
        g.addEdge(2,4);
        g.addEdge(3,1);
        g.addEdge(2,5);
        g.addEdge(5,3);
        g.addEdge(6,5);
        g.addEdge(5,9);
        g.addEdge(3,0);
        g.addEdge(6,7);
        g.addEdge(7,9);
        g.addEdge(8,7);
        g.addEdge(0,9);
        DepthFirstPath dfp= new DepthFirstPath(g, 1);
        System.out.println(dfp.hasPathTo(2));
        System.out.println(dfp.hasPathTo(7));
        System.out.println(dfp.hasPathTo(2));
        System.out.println(dfp.hasPathTo(7));
        System.out.println(dfp.pathTo(9));

        BreadthFirstPath bfp = new BreadthFirstPath(g, 1);

        System.out.println("Кратчайший путь от вуршины 1 до 9:" +bfp.pathTo(9));
    }
}
