package Basic.Grid;

import Basic.Grid.Logic.GridLogic;

import java.util.Scanner;

public class GridMain {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Columns?");
        int columns = s.nextInt();
        System.out.println("Rows?");
        int rows = s.nextInt();

        GridLogic logic = new GridLogic(columns, rows);
        logic.GenerateGrid();
        logic.PrintNodeGrid();
    }
}
