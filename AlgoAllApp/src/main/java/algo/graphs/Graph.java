package algo.graphs;

import java.util.*;

/**
 * Created by 048048 on 8/24/2015.
 */
public class Graph<V,E> {
    Map<V, Set<V>> vertices = new HashMap<>();

    public Map<V, Set<V>> getVertices() {
        return vertices;
    }

    public void addVertex(V v) {
        if(!vertices.keySet().contains(v))
            vertices.put(v, new HashSet<V>());
    }

    public void addEdge(V v1, V v2) {
        addVertex(v1);
        addVertex(v2);
        vertices.get(v1).add(v2);
        vertices.get(v2).add(v1);
    }

    public void addDirectedEdge(V v1, V v2) {
        addVertex(v1);
        addVertex(v2);
        vertices.get(v1).add(v2);
    }

    public Set<V> getNeighbors(V v) {
        return vertices.get(v);
    }

    public Graph<V,E> getGraphTransverse() {
        Graph<V,E> gt = new Graph<>();
        for(V v:vertices.keySet()) {
            gt.addVertex(v);
        }
        for(V v:vertices.keySet()) {
            if(vertices.get(v)!=null) {
                Iterator<V> it = vertices.get(v).iterator();
                while (it.hasNext()) {
                    gt.addDirectedEdge(it.next(),v);
                }
            }
        }

        return gt;
    }
}
