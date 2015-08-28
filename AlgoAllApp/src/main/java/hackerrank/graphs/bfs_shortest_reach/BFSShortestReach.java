package hackerrank.graphs.bfs_shortest_reach;

import java.util.*;

// https://www.hackerrank.com/challenges/bfsshortreach

public class BFSShortestReach {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int testCases = Integer.parseInt(reader.nextLine());
        StringBuilder[] output = new StringBuilder[testCases];
        for(int i=0;i<testCases;i++) {
            output[i] = new StringBuilder("");
            String str1 = reader.nextLine();
            String[] nm = str1.split(" ");
            int n=Integer.parseInt(nm[0]);
            int m=Integer.parseInt(nm[1]);

            Graph<Integer,String> g = new Graph<>();
            for(int k=1;k<n+1;k++) {
                g.addVertex(k);
            }

            for(int j=0;j<m;j++) {
                String edges = reader.nextLine();
                String edgeStr[] = edges.split(" ");
                g.addEdge(Integer.parseInt(edgeStr[0]),Integer.parseInt(edgeStr[1]));
            }
            Integer start = Integer.parseInt(reader.nextLine());

            // BFS
            LinkedList<Integer> q = new LinkedList<>();
            Map<Integer,Integer> mapDistance = new TreeMap<>();
            Map<Integer,String> mapColor = new TreeMap<>();

            for(Integer s:g.getVertices().keySet()) {
                mapDistance.put(s, -1);
                mapColor.put(s,"WHITE");
            }

            mapDistance.put(start, 0);
            mapColor.put(start,"GRAY");
            q.addFirst(start);

            while(!q.isEmpty()) {
                Integer u = q.removeLast();
                Set<Integer> adj = g.getNeighbors(u);
                for(Integer v:adj) {
                    if(mapColor.get(v).equals("WHITE")) {
                        mapColor.put(v,"GRAY");
                        mapDistance.put(v, mapDistance.get(u)+6);
                        //output[i].append(mapDistance.get(v));
                        //output[i].append(" ");
                        q.addFirst(v);
                    }
                }
                mapColor.put(u,"BLACK");
            }

            for(Integer s:mapDistance.keySet()) {
                /*if(mapDistance.get(s)==-1) {
                    output[i].append("-1");
                    output[i].append(" ");
                }*/
                /*output[i].append(s);
                output[i].append(",");*/
                if(mapDistance.get(s)!=0) {
                    output[i].append(mapDistance.get(s));
                    output[i].append(" ");
                }
            }

            output[i].deleteCharAt(output[i].length()-1);
            System.out.println(output[i]);
        }
    }
}


class Graph<V,E> {
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