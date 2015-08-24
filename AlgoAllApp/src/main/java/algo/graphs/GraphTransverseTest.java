package algo.graphs;

/**
 * Created by 048048 on 8/24/2015.
 */
public class GraphTransverseTest {
    public static void main(String[] args) {
        Graph<String,String> g = new Graph<>();
        Graph<String,String> gt = new Graph<>();
        g.addDirectedEdge("1", "2");
        g.addDirectedEdge("2", "3");
        g.addDirectedEdge("2", "4");
        g.addDirectedEdge("4","5");
        g.addDirectedEdge("6", "5");
        g.addDirectedEdge("6", "7");

        gt = g.getGraphTransverse();

        for(String node:gt.getVertices().keySet()) {
            System.out.println(node+"->"+gt.getVertices().get(node));
        }
    }
}
