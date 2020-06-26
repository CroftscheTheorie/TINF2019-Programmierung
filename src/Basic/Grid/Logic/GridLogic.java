package Basic.Grid.Logic;

import Basic.Grid.Items.Node;
import Basic.Grid.Model.GridModel;

import java.util.ArrayList;

public class GridLogic {

    protected GridModel model;

    public GridLogic(int columns, int rows){
        model = new GridModel(columns, rows);
    }

    public void GenerateGrid(){
        ArrayList<Node> nodes = new ArrayList<>();

        for (int i = 0; i < model.Rows; i++) {
            for (int j = 1; j <= model.Columns; j++) {
                Node node = new Node();
                node.setNodeNumber(j + (i * model.Columns));
                nodes.add(node);
            }
        }

        model.Nodes = nodes;
    }

    public void PrintNodeGrid(){
        for (Node node : model.Nodes) {
            System.out.println(node.getNodeNumber());
        }
    }
}
