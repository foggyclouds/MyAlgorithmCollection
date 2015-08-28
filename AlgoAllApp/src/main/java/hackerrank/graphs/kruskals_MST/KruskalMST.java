package hackerrank.graphs.kruskals_MST;

import java.util.*;

/**
 * Created by 048048 on 8/26/2015.
 */
public class KruskalMST {

    Map<Integer,Map<Integer,Integer>> vertices = new HashMap<Integer,Map<Integer,Integer>>();
    Edge[] edges;

    public Map<Integer, Map<Integer, Integer>> getVertices() {
        return vertices;
    }

    public void setVertices(Map<Integer, Map<Integer, Integer>> vertices) {
        this.vertices = vertices;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
        Arrays.sort(this.edges,new EdgeComparator() );
    }

    public static void main(String[] args) {
        KruskalMST kruskal = new KruskalMST();
        Scanner reader = new Scanner(System.in);
        Integer n=reader.nextInt();
        Integer m=reader.nextInt();

        for(int i=1;i<n+1;i++) {
            kruskal.addVertex(i);
        }

        Edge[] edges = new Edge[m];

        for(int i=0;i<m;i++) {
            Integer v1 = reader.nextInt();
            Integer v2 = reader.nextInt();
            Integer w = reader.nextInt();
            edges[i] = new KruskalMST.Edge(v1, v2, w);

            kruskal.addWeightedEdge(v1,v2,w);
            kruskal.addWeightedEdge(v2,v1,w);
        }

        kruskal.setEdges(edges);
        Integer st = reader.nextInt();
        System.out.println(kruskal.getMSTPath(st));
    }

    public void addWeightedEdge(Integer v1, Integer v2, Integer w) {
        if(vertices.get(v1) == null)
            vertices.put(v1, new HashMap<>());

        if(vertices.get(v1).get(v2)!=null){
            if(vertices.get(v1).get(v2) < w)
                w=vertices.get(v1).get(v2);
        }
        vertices.get(v1).put(v2, w);
    }

    public void addVertex(Integer n) {
        if(vertices.get(n)!=null)
            vertices.put(n, new HashMap<>());
    }

    public Integer getMSTPath(Integer st) {
        List<Map<Integer, Set<Integer>>> ds = new ArrayList<>();

        for(Integer node:vertices.keySet()) {
            Map<Integer, Set<Integer>> hm = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            set.add(node);
            hm.put(node, set);
            ds.add(hm);
        }

        Integer sum = 0;

        for(int i=0;i<edges.length;i++) {
            if(findSet(ds,edges[i].getN1()) != findSet(ds,edges[i].getN2())) {
                unionSet(ds, edges[i].getN1(), edges[i].getN2());
                sum += edges[i].getW();
            }
        }

        return sum;

    }

    public Integer findSet(List<Map<Integer, Set<Integer>>> ds, Integer v) {
        for (int i = 0; i < ds.size(); i++) {
            Map<Integer,Set<Integer>> map = ds.get(i);
            for(Integer key:map.keySet()) {
                if(map.get(key).contains(v))
                    return key;
            }
        }

        return -1;
    }

    public void unionSet(List<Map<Integer, Set<Integer>>> ds, Integer v1, Integer v2) {
        Integer k1=findSet(ds,v1);
        Integer k2=findSet(ds,v2);

        Set<Integer> set1 = null;
        Set<Integer> set2 = null;

        for (int i = 0; i < ds.size(); i++) {
            Map<Integer,Set<Integer>> map = ds.get(i);
            if(map.containsKey(k1))
                set1 = map.get(k1);
            else if(map.containsKey(k2))
                set2 = map.get(k2);
        }

        if(set1!=null && set2!=null)
            set1.addAll(set2);

        for (int i = 0; i < ds.size(); i++) {
            Map<Integer,Set<Integer>> map = ds.get(i);
            if(map.containsKey(k1))
                map.put(k1, set1);
            else if(map.containsKey(k2))
                map.remove(k2);
        }
    }

    static class Edge {
        Integer n1,n2,w;

        public Edge(Integer n1, Integer n2, Integer w) {
            this.n1 = n1;
            this.n2 = n2;
            this.w = w;
        }

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

    static class EdgeComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.getW() - o2.getW();
        }
    }
}





