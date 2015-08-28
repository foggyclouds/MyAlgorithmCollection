package hackerrank.graphs.dijstra_shortest_path.clean;

import java.util.*;

// https://www.hackerrank.com/challenges/dijkstrashortreach

public class DijkstraShortestPathPQ {
    Map<Integer,Map<Integer,Integer>> vertices = new HashMap<>();

    public void addWeightedEdge(Integer v1, Integer v2, Integer w) {
        if(vertices.get(v1) == null)
            vertices.put(v1, new HashMap<>());

        if(vertices.get(v1).get(v2)!=null){
            if(vertices.get(v1).get(v2) < w)
                w=vertices.get(v1).get(v2);
        }
        vertices.get(v1).put(v2,w);
    }

    public Integer getWeight(Integer v1, Integer v2) {
        Map<Integer,Integer> map = vertices.get(v1);
        return map.get(v2);
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int testCases = Integer.parseInt(reader.nextLine());
        StringBuilder[] output = new StringBuilder[testCases];

        for(int i=0;i<testCases;i++) {
            output[i] = new StringBuilder("");
            DijkstraShortestPathPQ dsp = new DijkstraShortestPathPQ();

            String nm = reader.nextLine();
            Integer n = Integer.parseInt(nm.split(" ")[0]);
            Integer m = Integer.parseInt(nm.split(" ")[1]);

            for(int j=0;j<n;j++)
                dsp.vertices.put(j+1, new HashMap<>());

            for(int j=0;j<m;j++) {
                String edgeWtLine = reader.nextLine();
                dsp.addWeightedEdge(Integer.parseInt(edgeWtLine.split(" ")[0])
                        , Integer.parseInt(edgeWtLine.split(" ")[1])
                        , Integer.parseInt(edgeWtLine.split(" ")[2]));
                dsp.addWeightedEdge(Integer.parseInt(edgeWtLine.split(" ")[1])
                        , Integer.parseInt(edgeWtLine.split(" ")[0])
                        , Integer.parseInt(edgeWtLine.split(" ")[2]));
            }

            Map<Integer,Integer> dist = dsp.getShortestPath(Integer.parseInt(reader.nextLine()));
            for(Integer d:dist.keySet()) {
                if(dist.get(d)==999)
                    output[i].append("-1 ");
                else if(dist.get(d)!=0) {
                    output[i].append(dist.get(d));
                    output[i].append(" ");
                }
            }
        }

        for(int i=0;i<testCases;i++)
            System.out.println(output[i]);

    }

    public Map<Integer,Integer> getShortestPath(Integer start) {
        PriorityQueue<HashMap.SimpleEntry<Integer,Integer>> pqme = new PriorityQueue<>(new PQMapEntryComparator());
        Map<Integer,Integer> dist = new HashMap<>();
        for(Integer v:vertices.keySet())
            dist.put(v,999);

        dist.put(start, 0);

        for(Integer v:vertices.keySet())
            pqme.offer(new HashMap.SimpleEntry(v,dist.get(v)));

        while(!pqme.isEmpty()) {
            HashMap.SimpleEntry<Integer,Integer> u = pqme.poll();
            if(vertices.get(u.getKey())!=null) {
                for (Integer v : vertices.get(u.getKey()).keySet()) {
                    Integer newLen = dist.get(u.getKey()) + this.getWeight(u.getKey(), v);
                    if (dist.get(v) > newLen) {
                        pqme.remove(new HashMap.SimpleEntry<Integer,Integer>(v,dist.get(v)));
                        pqme.add(new HashMap.SimpleEntry<Integer,Integer>(v, newLen));
                        dist.put(v, newLen);
                    }
                }
            }
        }

        return dist;
    }
}

class PQMapEntryComparator implements Comparator<HashMap.SimpleEntry<Integer,Integer>> {
    public int compare(HashMap.SimpleEntry<Integer,Integer> v1, HashMap.SimpleEntry<Integer,Integer> v2) {
        return v1.getValue() - v2.getValue();
    }
}