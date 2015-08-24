package algo.graphs;

/**
 * Created by 048048 on 8/24/2015.
 */
public class DFSNode<V> {
    int discoveryTime;
    int finishingTime;
    String color;
    V predecessor;

    public DFSNode(){};

    public DFSNode(int discoveryTime, int finishingTime, String color, V predecessor) {
        this.discoveryTime = discoveryTime;
        this.finishingTime = finishingTime;
        this.color = color;
        this.predecessor = predecessor;
    }

    public int getDiscoveryTime() {
        return discoveryTime;
    }

    public int getFinishingTime() {
        return finishingTime;
    }

    public String getColor() {
        return color;
    }

    public V getPredecessor() {
        return predecessor;
    }

    public void setDiscoveryTime(int discoveryTime) {
        this.discoveryTime = discoveryTime;
    }

    public void setFinishingTime(int finishingTime) {
        this.finishingTime = finishingTime;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPredecessor(V predecessor) {
        this.predecessor = predecessor;
    }
}
