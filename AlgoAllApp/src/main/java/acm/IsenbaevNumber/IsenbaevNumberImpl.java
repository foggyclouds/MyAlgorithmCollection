package acm.IsenbaevNumber;

import java.util.*;

/* Problem - http://acm.timus.ru/problem.aspx?space=1&num=1837 */

public class IsenbaevNumberImpl {
    Map<Integer, String> inputMap = new HashMap<>();
    Map<String,Integer> distanceMap = new HashMap<>();
    Map<String,String> vertexColorMap = new HashMap<>();
    Graph g = new Graph();

    public IsenbaevNumberImpl() {
        /*inputMap.put(1,"7");
        inputMap.put(2,"Isenbaev Oparin Toropov");
        inputMap.put(3,"Ayzenshteyn Oparin Samsonov");
        inputMap.put(4,"Ayzenshteyn Chevdar Samsonov");
        inputMap.put(5,"Fominykh Isenbaev Oparin");
        inputMap.put(6,"Dublennykh Fominykh Ivankov");
        inputMap.put(7,"Burmistrov Dublennykh Kurpilyanskiy");
        inputMap.put(8,"Cormen Leiserson Rivest");*/

        Scanner reader = new Scanner(System.in);
        int count = Integer.parseInt(reader.nextLine());
        inputMap.put(1,count+"");
        for(int i=0;i<count;i++) {
            inputMap.put(i + 2, reader.nextLine());
        }
        //System.out.println("-- Done --");
    }

    public void init(){
        int count = Integer.parseInt(inputMap.get(1));
        for(int i=2;i<(count+2);i++) {
            String[] str = inputMap.get(i).toString().split(" ");
            g.addVertex(str[0]);
            g.addVertex(str[1]);
            g.addVertex(str[2]);
            g.addEdge(str[0], str[1]);
            g.addEdge(str[0], str[2]);
            g.addEdge(str[1], str[2]);
        }
    }

    public void findDistance() {
        LinkedList<String> q = new LinkedList<>();

        Iterator<String> it = g.getEdge().keySet().iterator();
        while(it.hasNext()) {
            String n = it.next();
            distanceMap.put(n, -1);
            vertexColorMap.put(n,"WHITE");
        }

        distanceMap.put("Isenbaev", 0);
        vertexColorMap.put("Isenbaev","GRAY");
        q.addFirst("Isenbaev");

        while(!q.isEmpty()) {
            String name = q.removeLast();
            Set<String> neighbors = g.getNeighbors(name);
            if(neighbors!= null) {
                Iterator<String> it2 = neighbors.iterator();
                while (it2.hasNext()) {
                    String n2 = it2.next();
                    if (vertexColorMap.get(n2).equals("WHITE")) {
                        vertexColorMap.put(n2, "GRAY");
                        distanceMap.put(n2, distanceMap.get(name) + 1);
                        q.addFirst(n2);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        IsenbaevNumberImpl impl = new IsenbaevNumberImpl();
        impl.init();
        impl.findDistance();

        Map<String,Set<String>> edge = impl.g.getEdge();
        //int total = edge.keySet().size();
        int i = 1;
        Iterator<String> it = edge.keySet().iterator();
        while(it.hasNext()) {
            String name = it.next();
            String dis = impl.distanceMap.get(name).toString();
            if (dis.equals("-1"))
                dis = "undefined";
            if(i!=1)
                System.out.print(System.lineSeparator() + name+" "+dis);
            else
                System.out.print(name+" "+dis);

            i++;
            //if(i<total)
            //    System.out.println("");
            //i++;
        }

    }
}

class Graph {
    Map<String,Set<String>> edge = new TreeMap<>();

    public Map<String, Set<String>> getEdge() {
        return edge;
    }

    public void addVertex(String name) {
        if(edge.get(name)==null)
            edge.put(name,new HashSet<String>());
    }

    public void addEdge(String n1, String n2) {
        edge.get(n1).add(n2);
        edge.get(n2).add(n1);
    }

    public Set<String> getNeighbors(String node) {
        return edge.get(node);
    }

}

