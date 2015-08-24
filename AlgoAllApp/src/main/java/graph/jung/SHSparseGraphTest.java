package graph.jung;

/**
 * Created by 048048 on 8/17/2015.
 */
public class SHSparseGraphTest {

    public static void main(String[] args) {
        SHSparseGraph g = new SHSparseGraph();
        // Add some vertices. From above we defined these to be type Integer.
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(7);
        g.addVertex(8);
        g.addVertex(9);
        g.addVertex(10);

        // Add some edges. From above we defined these to be of type String
        // Note that the default is for undirected edges.
        g.addEdge("A", 1, 2);
        g.addEdge("A1", 1, 3);
        g.addEdge("B", 2, 4);
        g.addEdge("C", 2, 3);
        g.addEdge("D", 4, 6);
        g.addEdge("E", 6, 5);
        g.addEdge("F", 5, 8);
        g.addEdge("G", 3, 5);
        g.addEdge("H", 5, 7);
        g.addEdge("I", 9, 10);

        System.out.println(g);

        System.out.println(g.dfsTraversalRecursive(1));

        System.out.println("DFS");
        SHDepthFirstIterator<Integer, String> dfsIt = new SHDepthFirstIterator(g, 1);
        while(dfsIt.hasNext()) {
            System.out.println(dfsIt.next());
        }
    }
}
