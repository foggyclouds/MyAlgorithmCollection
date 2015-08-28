package graph.jung;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import org.apache.commons.collections15.Transformer;

import java.util.List;
import java.util.Scanner;

/**
 * Created by 048048 on 8/25/2015.
 */
public class JungShortestPath {

    JungShortestPath() {
        Transformer<MyLink, Double> wtTransformer = new Transformer<MyLink,Double>() {
            public Double transform(MyLink link) {
                return link.weight;
            }
        };

        Scanner reader = new Scanner(System.in);
        reader.nextLine();
        String nm = reader.nextLine();
        Integer n = Integer.parseInt(nm.split(" ")[0]);
        Integer m = Integer.parseInt(nm.split(" ")[1]);

        DirectedSparseMultigraph<MyNode, MyLink> g = new DirectedSparseMultigraph<MyNode, MyLink>();

        MyNode[] nodes = new MyNode[n];
        for(int i=0;i<n;i++) {
            nodes[i]=new MyNode(i+1);
        }

        for(int i=0;i<m;i++) {
            String edgeWt = reader.nextLine();
            String[] ew = edgeWt.split(" ");
            //System.out.println("--->"+ew[0]+" "+ew[1]+" "+ew[2]);
            g.addEdge(new MyLink(Integer.parseInt(ew[2]), 0.0)
                    , nodes[Integer.parseInt(ew[0]) - 1]
                    , nodes[Integer.parseInt(ew[1]) - 1]);
        }
        // g.addEdge(new MyLink(2.0, 48),n1, n2); // This method

        reader.nextLine();

        DijkstraShortestPath<MyNode,MyLink> alg
                = new DijkstraShortestPath(g, wtTransformer);

        List<MyLink> l = alg.getPath(nodes[11], nodes[4]);
        Number dist = alg.getDistance(nodes[11], nodes[4]);

        System.out.println("SP = " + dist.toString());
        System.out.println("L="+l);
    }

    public static void main(String[] args) {
        new JungShortestPath();
    }
}


class MyNode {
    int id; // good coding practice would have this as private
    public MyNode(int id) {
        this.id = id;
    }
    public String toString() { // Always a good idea for debuging
        return "V"+id; // JUNG2 makes good use of these.
    }
}

class MyLink {
    double capacity; // should be private
    double weight; // should be private for good practice
    int id;

    public MyLink(double weight, double capacity) {
        //this.id = edgeCount++; // This is defined in the outer class.
        this.weight = weight;
        this.capacity = capacity;
    }
    public String toString() { // Always good for debugging
        return "E"+id;
    }

}