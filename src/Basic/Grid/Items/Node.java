package Basic.Grid.Items;

import java.awt.*;
import java.util.ArrayList;

public class Node {
    protected ArrayList<Node> neighborNodes;
    protected int nodeNumber;
    protected int nodeColor;

    public Node(){
        neighborNodes = new ArrayList<Node>();
    }

    public Node(int number, int color){
        neighborNodes = new ArrayList<Node>();
        nodeNumber = number;
        nodeColor = color;
    }

    public void setNeighborNodes(ArrayList<Node> neighborNodes) {
        this.neighborNodes = neighborNodes;
    }

    public ArrayList<Node> getNeighborNodes() {
        return neighborNodes;
    }

    public void setNodeColor(int nodeColor) {
        this.nodeColor = nodeColor;
    }

    public int getNodeColor() {
        return nodeColor;
    }

    public void setNodeNumber(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }
}
