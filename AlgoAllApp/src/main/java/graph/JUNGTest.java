package graph;

import edu.uci.ics.jung.graph.*;

import java.lang.management.ManagementFactory;
import java.util.*;

/**
 * Created by 048048 on 8/17/2015.
 */
public class JUNGTest {

    public static void main(String[] args) {

        List<String> students = new ArrayList<>();
        Collection<String> collection = new HashSet<>();
        WeakHashMap<Integer,String> map = new WeakHashMap<>();

        JUNGTest jt = new JUNGTest();
        //jt.testDirectedSparseMultigraph();
        System.out.println(System.getProperty("java.version")+"");
        //ManagementFactory.getRuntimeMXBean().getVmVersion();
        System.out.println(ManagementFactory.getRuntimeMXBean().getVmVersion()+"");

        //jt.testSparseGraph();

        //AnimatingAddNodeDemo t = new AnimatingAddNodeDemo();
        //AnimatingAddNodeDemo.main(new String[]{""});
        //AddNodeDemo.main(null);

    }

    public void testDirectedSparseMultigraph() {
        DirectedSparseMultigraph<Integer, String> g
                = new DirectedSparseMultigraph<Integer, String>();

        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(7);
        g.addVertex(8);

        g.addEdge("A", 1, 2);
        //g.addEdge("A", new Pair<Integer>(1,2), EdgeType.DIRECTED);
        g.addEdge("B", 1, 3);
        g.addEdge("C", 2, 4);
        g.addEdge("D", 3, 4);
        g.addEdge("E", 3, 5);
        g.addEdge("F", 4, 6);
        g.addEdge("G",5,6);
        g.addEdge("H",5,8);
        g.addEdge("I",5,7);
        g.addEdge("J",6,7);
        g.addEdge("K",6,4);
        g.addEdge("L",6,8);

        System.out.println(g.toString());
        JUNGViewer.display(g);

    }

    public void testSparseGraph() {
        // Graph<V, E> where V is the type of the vertices
        // and E is the type of the edges
        Graph<Integer, String> g = new SparseGraph<Integer, String>();
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
        g.addEdge("B", 2, 4);
        g.addEdge("C", 2, 3);
        g.addEdge("D", 4, 6);
        g.addEdge("E", 6, 5);
        g.addEdge("F", 5, 8);
        g.addEdge("G", 3, 5);
        g.addEdge("H", 5, 7);
        g.addEdge("I", 9, 10);
        // Let's see what we have. Note the nice output from the
        // SparseMultigraph<V,E> toString() method
        System.out.println("The graph g = " + g.toString());
        // Note that we can use the same nodes and edges in two different graphs.

        /*Graph<Integer, String> g2 = new SparseMultigraph<Integer, String>();
        g2.addVertex((Integer)1);
        g2.addVertex((Integer)2);
        g2.addVertex((Integer)3);
        g2.addEdge("Edge-A", 1,3);
        g2.addEdge("Edge-B", 2,3, EdgeType.DIRECTED);
        g2.addEdge("Edge-C", 3, 2, EdgeType.DIRECTED);
        g2.addEdge("Edge-P", 2,3); // A parallel edge
        System.out.println("The graph g2 = " + g2.toString());*/

        HashMap<Integer, Boolean> mapVisited = new HashMap<Integer, Boolean>();
        for (int i =1; i<g.getVertexCount()+1; i++)
            mapVisited.put(i,false);

        int v = 1;
        mapVisited.put(1,true);
        System.out.println("Visit = "+1);

        Stack<Integer> stack = new Stack<Integer>();
        Iterator<Integer> it = g.getNeighbors(v).iterator();
        while(it.hasNext()) {
            stack.push(it.next());
        }

        System.out.println("stack = "+stack);

        while(!stack.empty()) {
            v = stack.pop();
            it = g.getNeighbors(v).iterator();
            while(it.hasNext()) {
                Integer k = it.next();
                //System.out.println("k = "+k);
                if(mapVisited.get(k)==false) {
                    mapVisited.put(k, true);
                    System.out.println("Visit = " + k);
                    stack.push(k);
                }

                System.out.println("stack = "+stack);
            }
        }

        System.out.println(mapVisited);
    }
}
