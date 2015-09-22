package hackerrank.graphs.even_tree;

import java.util.*;

public class EvenTree {

    public static Map<String, Set> hm = new HashMap<>();
    //public static Map<String,String> edges = new HashMap<>();

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Integer n = reader.nextInt();
        Integer m = reader.nextInt();

        Map<String, Integer> anc = new HashMap<>();

        for(Integer i=1;i<n+1;i++) {
            hm.put(i.toString(),new HashSet<>());
            anc.put(i.toString(),0);
        }

        for (int i = 0; i < m; i++) {
            Integer x = reader.nextInt();
            Integer y = reader.nextInt();
            if (x > y) {
                Integer t = x;
                x = y;
                y = t;
            }

            hm.get(x.toString()).add(y.toString());
        }

        //System.out.println(hm);
        /*for(String node:hm.keySet()) {
            System.out.println(node + "-" + getChildren(hm, node));
        }*/

        // Find number of ancestors

        // IMPROVEMENT - use DFS to find children
        Integer count = 0;
        //System.out.println("---------------------");
        for(String node:hm.keySet()) {
            for(Iterator it = hm.get(node).iterator();it.hasNext();) {
                String nxt = it.next().toString();
                if(getChildren(hm,node)%2==1 && getChildren(hm,nxt)%2==1) {
                    //System.out.println(node+"-"+nxt);
                    count++;
                } else if(getChildren(hm,node)%2==0 && getChildren(hm,nxt)%2==1) {
                    count++;
                }
            }
        }

        System.out.println(count.toString());
    }

    public static Integer getChildren(Map<String, Set> g, String node) {
        Set set = g.get(node);
        if(set == null) {
            return 0;
        } else {
            Integer num = set.size();
            Iterator it = set.iterator();
            while(it.hasNext()) {
                num+=getChildren(g, it.next().toString());
            }
            return num;
        }
    }
}
