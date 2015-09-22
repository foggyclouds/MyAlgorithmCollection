package algo.graphs.graph1;

import java.util.*;

public class DFSTest {

    //static Map<Integer, HashSet> g = new HashMap<Integer, HashSet>();
    static Map<Integer, String> state = new HashMap<>();
    static Integer time = 0;
    static Map<Integer, Integer> entryTime = new HashMap<>();
    static Map<Integer, Integer> exitTime = new HashMap<>();
    static Map<Integer, Integer> parent = new HashMap<>();

    public static void main(String[] args) {

        Map<Integer, HashSet> g = new HashMap<>();

        g.put(1, new HashSet<>());
        g.put(2, new HashSet<>());
        g.put(3, new HashSet<>());
        g.put(4, new HashSet<>());
        g.put(5, new HashSet<>());
        g.put(6, new HashSet<>());

        g.get(1).add(2); g.get(1).add(5); g.get(1).add(6);
        g.get(2).add(1); g.get(2).add(3);
        g.get(3).add(2); g.get(3).add(4);
        g.get(4).add(3); g.get(4).add(5);
        g.get(5).add(1); g.get(5).add(2); g.get(5).add(4);
        g.get(6).add(1);

        for(int i=0;i<g.keySet().size();i++) {
            state.put(i+1, "UNDISCOVERED");
        }

        parent.put(1,null);
        DFS(g, 1);
        System.out.println(parent);
        System.out.println(entryTime);
        System.out.println(exitTime);

    }

    static void processVertexEarly(Integer v) {
        System.out.println("Processing Vertex  Early - "+v);
    }

    static void processVertexLate(Integer v) {
        System.out.println("Processing Vertex  Late -  "+v);
    }

    static void processEdge(Integer u, Integer v) {
        System.out.println("Processing Edge - "+u+"--->"+v);
    }

    static void DFS(Map<Integer, HashSet> g, Integer u) {
        state.put(u,"DISCOVERED");
        //parent.put(u,null);
        time++;
        entryTime.put(u, time);

        processVertexEarly(u);

        Iterator<Integer> it = g.get(u).iterator();
        while(it.hasNext()) {
            Integer v = it.next();
            if(state.get(v).equals("UNDISCOVERED")) {
                parent.put(v, u);
                processEdge(u, v);
                DFS(g, v);
            } else if(!state.get(v).equals("PROCESSED")) {
                //processEdge(u, v);
                System.out.println("Back Edge - " + u + "--->" + v);
            } else if(state.get(v).equals("DISCOVERED")) {
                System.out.println("Back Edge - "+u+"--->"+v);
            }
        }

        processVertexLate(u);

        time++;
        exitTime.put(u, time);
        state.put(u,"PROCESSED");

    }
}
