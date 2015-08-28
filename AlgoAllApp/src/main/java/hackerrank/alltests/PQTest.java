package hackerrank.alltests;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by 048048 on 8/25/2015.
 */
public class PQTest {

    PQTest () {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(10);
        pq.offer(34);
        pq.offer(8);
        pq.offer(122);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(" ");

        PriorityQueue<Node> pqn = new PriorityQueue<>(new PQNodeComparator());
        pqn.offer(new Node(1, 30));
        pqn.offer(new Node(2, 3));
        pqn.offer(new Node(3, 300));
        pqn.offer(new Node(4, 50));
        pqn.offer(new Node(5, 90));
        pqn.offer(new Node(6, 20));
        pqn.offer(new Node(7, 10));

        System.out.println(pqn.poll().getW());
        System.out.println(pqn.poll().getW());
        System.out.println(pqn.poll().getW());
        System.out.println(pqn.poll().getW());
        System.out.println(pqn.poll().getW());

    }

    public static void main(String[] args) {
        new PQTest();
    }
}

class PQComparator implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
        return i1 - i2;
    }
}

class Node {
    Integer v;
    Integer w;

    public Node(Integer v, Integer w) {
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

class PQNodeComparator implements Comparator<Node> {
    public int compare(Node i1, Node i2) {
        return i1.getW() - i2.getW();
    }
}


