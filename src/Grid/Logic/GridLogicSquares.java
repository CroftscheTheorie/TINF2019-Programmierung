package Grid.Logic;

import Grid.Helper.ColorHelper;
import Grid.Items.Node;

public class GridLogicSquares extends GridLogic {
    private int counter = 1;

    private Node[][] nodes;

    public GridLogicSquares(int length, int rows){
        this.logicType = LogicType.SQUARES;
        this.length = length;
        this.rows = rows;
        this.nodes = new Node[length][rows];

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                nodes[i][j] = new Node();
            }
        }
    }

    public boolean ColorGrid(int column, int row, int colorindex){
        if (row >= rows){
            return true;
        }
        nodes[column][row].setNodeColor(ColorHelper.IndexToColor(colorindex));
        if (row != 0) {
            if (nodes[column][row-1].getNodeColor() == nodes[column][row].getNodeColor()){
                return false;
            }
        }
        if ((row+1) < nodes[column].length){
            if (nodes[column][row+1].getNodeColor() == nodes[column][row].getNodeColor()){
                return false;
            }
        }
        if (column != 0){
            if(nodes[column-1][row].getNodeColor() == nodes[column][row].getNodeColor()){
                return false;
            }
        }
        if ((column+1) < length){
            if(nodes[column+1][row].getNodeColor() == nodes[column][row].getNodeColor()){
                return false;
            }
        }
        if ((row-1 >= 0) && (column-1 >= 0)){
            if (nodes[column-1][row-1].getNodeColor() == nodes[column][row].getNodeColor()){
                return false;
            }
        }
        if ((row-1 >= 0) && (column+1 < length )){
            if (nodes[column+1][row-1].getNodeColor() == nodes[column][row].getNodeColor()){
                return false;
            }
        }
        if ((row + 1 < rows) && (column-1 >= 0)){
            if (nodes[column-1][row+1].getNodeColor() == nodes[column][row].getNodeColor()){
                return false;
            }
        }
        if ((row+1 <= rows) && (column+1 > length)){
            if (nodes[column+1][row+1].getNodeColor() == nodes[column][row].getNodeColor()){
                return false;
            }
        }
        var frow = row;
        var fcol = column+1;
        if (fcol >= length){
            frow = row + 1;
            fcol = 0;
        }
        for (int i = 0; i < 4; i++) {
            if (ColorGrid(fcol, frow, i)){
                return true;
            }
        }
        return false;
    }

    public void PrintGrid(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(ColorHelper.ColorToName(nodes[j][i].getNodeColor()) + " ");
            }
            System.out.println();
        }
    }
}
