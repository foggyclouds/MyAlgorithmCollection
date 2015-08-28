package hackerrank.graphs.prims_mst;

import java.util.*;

public class PrimMST {

    Map<Integer,Map<Integer,Integer>> vertices = new HashMap<Integer,Map<Integer,Integer>>();

    public static void main(String[] args) {
        PrimMST prim = new PrimMST();
        Scanner reader = new Scanner(System.in);
        Integer n , m;
        n=reader.nextInt();
        m=reader.nextInt();

        for(int i=1;i<n+1;i++) {
            prim.addVertex(i);
        }

        for(int i=0;i<m;i++) {
            Integer v1 = reader.nextInt();
            Integer v2 = reader.nextInt();
            Integer w = reader.nextInt();

            prim.addWeightedEdge(v1,v2,w);
            prim.addWeightedEdge(v2,v1,w);
        }

        Integer st = reader.nextInt();
        System.out.println(prim.getMSTPath(st));
    }

    public void addVertex(Integer n) {
        if(vertices.get(n)!=null)
            vertices.put(n, new HashMap<>());
    }

    public void addWeightedEdge(Integer v1, Integer v2, Integer w) {
        if(vertices.get(v1) == null)
            vertices.put(v1, new HashMap<>());

        if(vertices.get(v1).get(v2)!=null){
            if(vertices.get(v1).get(v2) < w)
                w=vertices.get(v1).get(v2);
        }
        vertices.get(v1).put(v2,w);
    }

    public Integer getMSTPath(Integer st) {
        PriorityQueue<HashMap.SimpleEntry<Integer,Integer>> pq = new PriorityQueue<>(new PQMapEntryComparator());
        Map<Integer,Integer> keys = new HashMap<>();

        for(Integer v:vertices.keySet()) {
            keys.put(v,100001);
        }
        keys.put(st,0);

        for(Integer v:vertices.keySet())
            pq.offer(new HashMap.SimpleEntry<Integer, Integer>(v, keys.get(v)));

        while(!pq.isEmpty()) {
            HashMap.SimpleEntry<Integer,Integer> u = pq.poll();
            if(vertices.get(u.getKey())!=null) {
                for (Integer v : vertices.get(u.getKey()).keySet()) {
                    if (pq.contains(new HashMap.SimpleEntry<Integer, Integer>(v, keys.get(v)))
                            && vertices.get(u.getKey()).get(v) < keys.get(v)) {
                        pq.remove(new HashMap.SimpleEntry<Integer, Integer>(v, keys.get(v)));
                        keys.put(v, vertices.get(u.getKey()).get(v));
                        pq.add(new HashMap.SimpleEntry<Integer, Integer>(v, keys.get(v)));
                    }
                }
            }
        }

        Integer sum = 0;
        for(Integer v:keys.keySet()) {
            if(keys.get(v)!=100001)
                sum += keys.get(v);
        }

        return sum;
    }
}

class PQMapEntryComparator implements Comparator<HashMap.SimpleEntry<Integer,Integer>> {
    public int compare(HashMap.SimpleEntry<Integer,Integer> v1, HashMap.SimpleEntry<Integer,Integer> v2) {
        return v1.getValue() - v2.getValue();
    }
}
