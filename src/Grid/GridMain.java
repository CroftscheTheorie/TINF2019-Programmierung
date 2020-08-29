package Basic.Grid;

import Basic.Grid.Logic.GridLogicHexagon;
import Basic.Grid.Logic.GridLogicSquares;

import java.util.Scanner;

public class GridMain {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Length?");
        int length = s.nextInt();
        System.out.println("Rows?");
        int rows = s.nextInt();

        /*
        GridLogicSquares logic = new GridLogicSquares(columns, rows);
        logic.ColorGrid(0,0,0);
        logic.PrintGrid();*/

        GridLogicHexagon logicHexagon = new GridLogicHexagon(rows, length);
        logicHexagon.ColorGrid(0, 0);
        logicHexagon.PrintGrid();
    }
}
