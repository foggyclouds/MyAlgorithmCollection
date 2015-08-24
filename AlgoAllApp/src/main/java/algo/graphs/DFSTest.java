package algo.graphs;

/**
 * Created by 048048 on 8/24/2015.
 */
public class DFSTest {

    public static void main(String[] args) {
        Graph<String,String> g = new Graph<>();
        g.addEdge("1", "2");
        g.addEdge("1","3");
        g.addEdge("1","4");
        g.addEdge("3","4");
        g.addEdge("3","4");
        g.addEdge("4","5");
        g.addEdge("5","6");
        g.addEdge("7", "8");

        DFSTraversal<String, String> dfst = new DFSTraversal<>(g, "1");
        //System.out.println(dfst.getMapDFSNodes());
        for(String node:dfst.getMapDFSNodes().keySet()) {
            System.out.println(node + "," + dfst.getMapDFSNodes().get(node).getDiscoveryTime()
                            + "," + dfst.getMapDFSNodes().get(node).getFinishingTime()
                            + "," + dfst.getMapDFSNodes().get(node).getColor()
                            + "," + dfst.getMapDFSNodes().get(node).getPredecessor()
            );
        }
    }
}
