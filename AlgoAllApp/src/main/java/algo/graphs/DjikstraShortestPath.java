package algo.graphs;

import java.util.*;

/**
 * Created by 048048 on 8/25/2015.
 */
public class DjikstraShortestPath {

    /*Map<Integer,Set<Integer>> vertices = new HashMap<>();
    Set<Edge> edges = new HashSet<>();
    PriorityQueue<Edge> pq = new PriorityQueue<>();*/

    Map<Integer,Map<Integer,Integer>> vertices = new HashMap<>();

    public void addWeightedEdge(Integer v1, Integer v2, Integer w) {
        if(vertices.get(v1) == null)
            vertices.put(v1, new HashMap<>());

        vertices.get(v1).put(v2,w);
    }

    public Integer getWeight(Integer v1, Integer v2) {
        Map<Integer,Integer> map = vertices.get(v1);
        return map.get(v2);

    }

    public static void main(String[] args) {

        DjikstraShortestPath dsp = new DjikstraShortestPath();
        dsp.addWeightedEdge(0,1,2);
        dsp.addWeightedEdge(0,4,4);
        dsp.addWeightedEdge(1,2,3);
        dsp.addWeightedEdge(2,4,1);
        dsp.addWeightedEdge(2,3,5);
        dsp.addWeightedEdge(3,0,8);
        dsp.addWeightedEdge(4, 3, 7);

        dsp.getShortestPath(0);

        /*Map<Integer,Set<Pair<Integer,Integer>>> vertices = new HashMap<>();
        //Set<Edge> edges = new HashSet<>();
        Set<Pair<Integer,Integer>> set = new HashSet<>();

        vertices.put(0, new HashSet<>());
        vertices.get(0).add(new Pair<>(1, 2));
        vertices.get(0).add(new Pair<>(4, 4));

        vertices.put(1, new HashSet<>());
        vertices.get(1).add(new Pair<>(2, 3));

        vertices.put(2, new HashSet<>());
        vertices.get(2).add(new Pair<>(1, 2));
        vertices.get(2).add(new Pair<>(1,2));

        vertices.put(3, new HashSet<>());
        vertices.get(3).add(new Pair<>(1,2));

        vertices.put(4, new HashSet<>());
        vertices.get(4).add(new Pair<>(1,2));

        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0,4,4));
        edges.add(new Edge(1,2,3));
        edges.add(new Edge(2,3,5));
        edges.add(new Edge(2,4,1));
        edges.add(new Edge(3,0,8));
        edges.add(new Edge(4, 3, 7));*/

        /*PQWeightedGraphComparator pqs = new PQWeightedGraphComparator();
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges.size(),pqs);
        pq.addAll(edges);

        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            System.out.println(e.getN1() + "," + e.getN2() + "," + e.getW());
        }*/


    }

    public Map<Integer,Integer> getShortestPath(Integer start) {
        VertexDistanceComparator pqc = new VertexDistanceComparator();
        PriorityQueue<VertexDistance> pq = new PriorityQueue<>(pqc);

        Map<Integer,Integer> dist = new HashMap<>();
        Map<Integer,Integer> pred = new HashMap<>();

        for(Integer v:vertices.keySet()) {
            dist.put(v,Integer.MAX_VALUE);
            pred.put(v,null);
        }

        dist.put(start,0);

        for(Integer v:vertices.keySet()) {
            pq.offer(new VertexDistance(v,dist.get(v)));
        }

        while(!pq.isEmpty()) {
            VertexDistance ud = pq.poll();
            for(Integer v: vertices.get(ud.getV()).keySet()) {
                Integer newLen = dist.get(ud.getV()) + this.getWeight(ud.getV(),v);
                if(dist.get(v) > newLen) {
                    Iterator<VertexDistance> it = pq.iterator();
                    while(it.hasNext()) {
                        VertexDistance vd = it.next();
                        if(vd.getV()==v) {
                            vd.setW(newLen);
                            break;
                        }
                    }
                    pred.put(v,ud.getV());
                    dist.put(v, newLen);
                }
            }

        }

        System.out.println(dist.toString());
        System.out.println(pred.toString());

        /*Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for(Integer v: vertices.keySet()) {
            map.put()
        }*/
        return dist;
    }

}

class Pair<V,W> {
    V v;
    W w;

    public Pair(V v, W w) {
        this.v = v;
        this.w = w;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public W getW() {
        return w;
    }

    public void setW(W w) {
        this.w = w;
    }
}

class VertexDistanceComparator implements Comparator<VertexDistance> {
    public int compare(VertexDistance v1, VertexDistance v2) {
        return v1.getW().compareTo(v2.getW());
    }
}

class VertexDistance {
    Integer v;
    Integer w;

    public VertexDistance(Integer v, Integer w) {
        this.v = v;
        this.w = w;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

}

class PQWeightedGraphComparator implements Comparator<Edge>{
    public int compare(Edge o1, Edge o2) {
        return o1.getW().compareTo(o2.getW());
    }
}

class Edge{
    Integer n1;
    Integer n2;

    public Edge(Integer n1, Integer n2, Integer w) {
        this.n1 = n1;
        this.n2 = n2;
        this.w = w;
    }

    Integer w;

    public Integer getN1() {
        return n1;
    }

    public void setN1(Integer n1) {
        this.n1 = n1;
    }

    public Integer getN2() {
        return n2;
    }

    public void setN2(Integer n2) {
        this.n2 = n2;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

}
