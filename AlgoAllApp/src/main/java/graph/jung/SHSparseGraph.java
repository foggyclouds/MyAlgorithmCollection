package graph.jung;

import java.util.*;

/**
 * Created by 048048 on 8/17/2015.
 */
public class SHSparseGraph<V,E> {

    protected Map<V, Map<V,E>>    vertex_maps;

    public Map<V, Map<V, E>> getVertex_maps() {
        return vertex_maps;
    }

    public Map<E, V> getUndirected_edges() {
        return undirected_edges;
    }

    protected Map<E, V>           undirected_edges;

    public SHSparseGraph () {
        vertex_maps = new HashMap<V, Map<V,E>> ();
        undirected_edges = new HashMap<E, V> ();
    };

    public boolean addVertex(V v) {
        if(v==null)
            throw new IllegalArgumentException("vertex may not be null");

        if(!this.containsVertex(v)) {
            vertex_maps.put(v, new HashMap<V, E>());
            return true;
        }
        else
            return false;
    }

    public boolean addEdge(E e, V v1, V v2) {
        if(v1==null || v2==null || e==null)
            throw new IllegalArgumentException("No parameters can be null");

        if(!this.containsVertex(v1))
            this.addVertex(v1);

        if(!this.containsVertex(v2))
            this.addVertex(v2);

        vertex_maps.get(v1).put(v2,e);
        vertex_maps.get(v2).put(v1,e);
        undirected_edges.put(e, v1);
        undirected_edges.put(e, v2);

        return true;
    }

    public Collection<V> getNeighbors(V vertex) {
        Collection<V> neighbors = new HashSet<V>(vertex_maps.get(vertex).keySet());
        return Collections.unmodifiableCollection(neighbors);
    }

    public boolean containsVertex(V vertex) {
        return vertex_maps.containsKey(vertex);
    }

    public String toString() {
        return "vertex_maps = " + vertex_maps;
    }

    private StringBuilder dfsPath = new StringBuilder("");
    private Map<V,String> visitedMap = new HashMap<V, String>();

    public String dfsTraversalRecursive(V start) {
        //Map<V,String> visitedMap = new HashMap<V, String>();
        dfsPath = new StringBuilder("");
        Iterator<V> it = vertex_maps.keySet().iterator();
        while(it.hasNext()) {
            visitedMap.put(it.next(),"WHITE");
        }

        dfsVisitRecursive(start);

        it = vertex_maps.keySet().iterator();
        while(it.hasNext()) {
            V n = it.next();
            if(visitedMap.get(n).equals("WHITE")) {
                dfsVisitRecursive(n);
            }
        }

        return this.dfsPath.toString();
    }

    private void dfsVisitRecursive(V v) {
        dfsPath.append(v);
        dfsPath.append("->");
        visitedMap.put(v, "GRAY");
        Iterator<V> neighbors = this.getNeighbors(v).iterator();
        while(neighbors.hasNext()) {
            V next = neighbors.next();
            if(visitedMap.get(next).equals("WHITE")) {
                dfsVisitRecursive(next);
            } else {
                visitedMap.put(v, "BLACK");
            }
        }
    }

}
