package graph.jung;

import java.util.*;

/**
 * Created by 048048 on 8/18/2015.
 */
public class SHDepthFirstIterator<V,E> implements Iterator<V> {

    private Map<V,String> mapVisited = new HashMap<V, String>();
    private Stack<V> stack = new Stack<V>();
    SHSparseGraph g = new SHSparseGraph();

    public SHDepthFirstIterator(SHSparseGraph g, V start) {
        this.g = g;
        Iterator<V> it = g.getVertex_maps().keySet().iterator();
        while(it.hasNext())
            mapVisited.put(it.next(),"NOT_VISITED");
        stack.push(start);
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public boolean hasNext() {
        boolean ret = false;

        if (!this.stack.isEmpty())
            ret = true;

        if(this.stack.isEmpty()) {
            Iterator<V> it = mapVisited.keySet().iterator();
            while (it.hasNext()) {
                V next = it.next();
                if (mapVisited.get(next).equals("NOT_VISITED")) {
                    stack.push(next);
                    return true;
                }
            }
        }

        return ret;
    }

    public V next() {
        System.out.println("stack - " + stack);
        V next = stack.pop();
        mapVisited.put(next, "VISITED");
        Iterator<V> it = g.getNeighbors(next).iterator();
        while(it.hasNext()) {
            V v = it.next();
            if(mapVisited.get(v).equals("NOT_VISITED")) {
                mapVisited.put(v, "DISCOVERED");
                stack.push(v);
            }
        }

        return next;
    }
}
