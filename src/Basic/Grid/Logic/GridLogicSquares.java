package Basic.Grid.Logic;

import Basic.Grid.Helper.ColorHelper;
import Basic.Grid.Items.Node;

import java.awt.*;
import java.util.ArrayList;

public class GridLogicSquares {
    private int columns;
    private int rows;
    private int counter = 1;

    private Node[][] nodes;

    public GridLogicSquares(int columns, int rows){
        this.columns = columns;
        this.rows = rows;
        this.nodes = new Node[columns][rows];

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
        if ((column+1) < columns){
            if(nodes[column+1][row].getNodeColor() == nodes[column][row].getNodeColor()){
                return false;
            }
        }
        if ((row-1 >= 0) && (column-1 >= 0)){
            if (nodes[column-1][row-1].getNodeColor() == nodes[column][row].getNodeColor()){
                return false;
            }
        }
        if ((row-1 >= 0) && (column+1 < columns )){
            if (nodes[column+1][row-1].getNodeColor() == nodes[column][row].getNodeColor()){
                return false;
            }
        }
        if ((row + 1 < rows) && (column-1 >= 0)){
            if (nodes[column-1][row+1].getNodeColor() == nodes[column][row].getNodeColor()){
                return false;
            }
        }
        if ((row+1 <= rows) && (column+1 > columns)){
            if (nodes[column+1][row+1].getNodeColor() == nodes[column][row].getNodeColor()){
                return false;
            }
        }
        var frow = row;
        var fcol = column+1;
        if (fcol >= columns){
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
            for (int j = 0; j < columns; j++) {
                System.out.print(ColorHelper.ColorToName(nodes[j][i].getNodeColor()) + " ");
            }
            System.out.println();
        }
    }
}
