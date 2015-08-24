package acm.TwoTeams;

import java.util.*;

/**
 * Created by 048048 on 8/23/2015.
 */
public class TwoTeams {

    Graph g = new Graph();

    public TwoTeams() {
        Scanner reader = new Scanner(System.in);
        int count = Integer.parseInt(reader.nextLine());
        for(int i=0;i<count;i++) {
            String v = (i + 1) + "";
            g.addVertex(v);
            String str = reader.nextLine();
            if(str.equals("0")) {
                System.out.print("0");
                return;
            }
            //inputMap.put(i + 1, reader.nextLine());
            String[] adj = str.split(" ");
            for (int j = 0; j < adj.length - 1; j++) {
                g.addVertex(adj[j]);
                g.addEdge(v, adj[j]);
            }
        }

        Set<String> set1 = new TreeSet<>();
        Set<String> set2 = new HashSet<>();

        int num = 0;
        String output = "";

        Map<String,Set<String>> edges = g.getEdges();
        if(edges.get("1")!=null) {
            set1.add("1");
            set2.addAll(edges.get("1"));

            Iterator<String> it = edges.keySet().iterator();
            it.next();
            while(it.hasNext()) {
                String next = it.next();
                if(edges.get(next) == null) {
                    output = "";
                    break;
                }
                if(!set1.contains(next) && !set2.contains(next)) {
                    set1.add(next);
                    Set<String> neigh = edges.get(next);
                    Iterator<String> it2 = neigh.iterator();
                    while(it2.hasNext()) {
                        String n = it2.next();
                        if(!set1.contains(n))
                            set2.add(n);
                    }
                }
            }
            output = set1.toString();
        } else {
            output = "";
        }

        if(output.equals("")) {
            System.out.println("0");
        } else {
            System.out.println(set1.size());
            for(Iterator<String> it = set1.iterator(); it.hasNext(); ) {
                System.out.print(it.next() + " ");
            }
        }

    }

    public static void main(String[] args) {
        TwoTeams tt = new TwoTeams();
    }
}



class Graph {
    Map<String,Set<String>> edges = new TreeMap<>();

    public Map<String, Set<String>> getEdges() {
        return edges;
    }

    public void addVertex(String name) {
        if(edges.get(name)==null)
            edges.put(name,new HashSet<String>());
    }

    public void addEdge(String n1, String n2) {
        edges.get(n1).add(n2);
        edges.get(n2).add(n1);
    }

    public Set<String> getNeighbors(String node) {
        return edges.get(node);
    }

}

