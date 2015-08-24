package graph.jung;

import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 048048 on 8/21/2015.
 */
public class JUNGViewer {

    public static void main(String[] args) {
        // Make a graph by a SparseMultigraph instance.
        Graph<Integer, String> g = new SparseMultigraph <Integer, String>();
        g.addVertex((Integer)1); // Add a vertex with an integer 1
        g.addVertex((Integer)2);
        g.addVertex((Integer)3);
        g.addEdge("Edge-A", 1, 3); // Added an edge to connect between 1 and 3 vertices.
        g.addEdge("Edge-B", 2, 3, EdgeType.DIRECTED);
        g.addEdge("Edge-C", 3, 2, EdgeType.DIRECTED);
        g.addEdge("Edge-P", 2,3); // A parallel edge

        // Make some objects for graph layout and visualization.
        Layout<Integer, String> layout = new KKLayout <Integer, String>(g);
        BasicVisualizationServer<Integer, String> vv =
                new BasicVisualizationServer <Integer, String>(layout);
        vv.setPreferredSize(new Dimension(800,800));

        // It determine how each vertex with its value is represented in a diagram.
        ToStringLabeller<Integer> vertexPaint = new ToStringLabeller <Integer>() {
            public String transform(Integer i) {
                return "Node - "+i;
            }
        };

        vv.getRenderContext().setVertexLabelTransformer(vertexPaint);

        JFrame frame = new JFrame("SpanShapeRenderer.Simple Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }

    public static void display(Graph<Integer, String> g) {
        // Make some objects for graph layout and visualization.
        Layout<Integer, String> layout = new KKLayout <Integer, String>(g);
        BasicVisualizationServer<Integer, String> vv =
                new BasicVisualizationServer <Integer, String>(layout);
        vv.setPreferredSize(new Dimension(800,800));

        // It determine how each vertex with its value is represented in a diagram.
        ToStringLabeller<Integer> vertexPaint = new ToStringLabeller <Integer>() {
            public String transform(Integer i) {
                return "Node - "+i;
            }
        };

        vv.getRenderContext().setVertexLabelTransformer(vertexPaint);

        JFrame frame = new JFrame("SpanShapeRenderer.Simple Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }
}
