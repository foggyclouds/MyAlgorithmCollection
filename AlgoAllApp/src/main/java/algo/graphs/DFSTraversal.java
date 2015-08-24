package algo.graphs;

import edu.uci.ics.jung.graph.*;

import java.util.*;

/**
 * Created by 048048 on 8/24/2015.
 */
public class DFSTraversal<V,E> {

    Map<V,DFSNode> mapDFSNodes = new HashMap<>();

    public Map<V, DFSNode> getMapDFSNodes() {
        return mapDFSNodes;
    }

    LinkedList<V> ll = new LinkedList<>();

    DFSTraversal (Graph<V,E> graph, V start) {
        // Setting all nodes as "WHITE"
        for(V v:graph.getVertices().keySet()) {
            DFSNode node = new DFSNode(-1, -1, "WHITE", null);
            mapDFSNodes.put(v, node);
        }

        // Init start node as "GRAY"
        mapDFSNodes.get(start).setColor("GRAY");
        mapDFSNodes.get(start).setDiscoveryTime(1);
        ll.addFirst(start);
        int time = 1;

        while(!ll.isEmpty()) {
            //time++;
            //V u = ll.getFirst();
            V u = ll.removeFirst();
            for(V v:graph.getNeighbors(u)){
                if(mapDFSNodes.get(v).getColor().equals("WHITE")) {
                    mapDFSNodes.get(v).setColor("GRAY");
                    mapDFSNodes.get(v).setPredecessor(u);
                    mapDFSNodes.get(v).setDiscoveryTime(time);
                    time++;
                    ll.addFirst(v);
                }
            }
            mapDFSNodes.get(u).setFinishingTime(time);
            time++;
            mapDFSNodes.get(u).setColor("BLACK");
            System.out.print(u + "->");

            if(ll.isEmpty()) {
                for(V node:mapDFSNodes.keySet()) {
                    if(mapDFSNodes.get(node).getColor().equals("WHITE")) {
                        ll.addFirst(node);
                        mapDFSNodes.get(node).setDiscoveryTime(time);
                        time++;
                        break;
                    }
                }
            }
        }

        System.out.println("");
    }

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
