package Basic.Grid.Model;

import Basic.Grid.Items.Node;

import java.util.ArrayList;

public class GridModel {
    public int Columns;
    public int Rows;

    public ArrayList<Node> Nodes = new ArrayList<Node>();

    public GridModel(int columns, int rows){
        Columns = columns;
        Rows = rows;
    }
}
