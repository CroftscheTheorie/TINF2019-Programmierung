package GUI;

import Grid.Helper.ColorHelper;
import Grid.Logic.GridLogicHexagon;
import Grid.Logic.GridLogicSquares;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class GridGUIController {

    // Static variables
    @FXML
    private final static int heightPixel = 720;

    @FXML
    private final static int widthPixel = 1280;

    private static double drawableLength = 40;

    // Non-static variables
    @FXML
    private TextField RowsTextBox;

    @FXML
    private TextField ColumnsTextBox;

    @FXML
    private ScrollPane PaneCanvas;

    @FXML
    private ToggleButton toggleButton;

    // Logic
    private GridLogicHexagon logicHexagon;
    private GridLogicSquares logicSquares;

    public GridGUIController(){

    }

    private void GenerateAndDrawHexagon(int length, int rows){
        Pane hexMap = new Pane();
        hexMap.setPrefSize(widthPixel, heightPixel);
        PaneCanvas.setContent(hexMap);
        logicHexagon = new GridLogicHexagon(rows, length);
        logicHexagon.ColorGrid(0, 0);
        var nodes = logicHexagon.GetNodeList();;
        double xcoord = drawableLength;
        double ycoord = drawableLength;

        for (int i = 0; i < rows; i++) {
            xcoord = drawableLength;
            ycoord = i * 2 * drawableLength + drawableLength;
            for (int j = i * length; j < length + (i * length); j = j +2) {
                System.out.print(ColorHelper.ColorToName(nodes.get(j).getNodeColor()) + "    ");
                Polygon hex = new Hexagon(xcoord, ycoord, nodes.get(j).getNodeColor());
                hexMap.getChildren().add(hex);
                xcoord = xcoord + 3 * drawableLength;
            }
            xcoord = 2.5 * drawableLength;
            ycoord = i * 2 * drawableLength + 2 * drawableLength;
            System.out.println();
            System.out.print("    ");
            for (int k = (i * length) + 1; k < length + (i * length); k = k + 2){
                System.out.print(ColorHelper.ColorToName(nodes.get(k).getNodeColor()) + "    ");
                Polygon hex = new Hexagon(xcoord, ycoord, nodes.get(k).getNodeColor());
                hexMap.getChildren().addAll(hex);
                xcoord += 3 * this.drawableLength;
            }
            System.out.println();
        }
    }

    private void GenerateAndDrawSquare(int columns, int rows){
        Pane squareMap = new Pane();
        squareMap.setPrefSize(widthPixel, heightPixel);
        PaneCanvas.setContent(squareMap);
        logicSquares = new GridLogicSquares(columns, rows);
        logicSquares.ColorGrid(0,0, 0);

        var nodes = logicSquares.getNodes();

        for (int i = 0; i < rows; i++) {
            int xcoord = 0;
            int ycoord = i * (int) drawableLength;
            for (int j = 0; j < columns; j++) {
                System.out.print(ColorHelper.ColorToName(nodes[j][i].getNodeColor()) + " ");
                Polygon square = new Square(xcoord, ycoord, nodes[j][i].getNodeColor());
                squareMap.getChildren().add(square);
                xcoord += drawableLength;
            }
            System.out.println();
        }
    }

    @FXML
    private void RenderButtonPressed(ActionEvent actionEvent){
        if (Integer.parseInt(RowsTextBox.getText()) <= 0){
            // Wrong value
        }
        if (Integer.parseInt(ColumnsTextBox.getText()) <= 0){
            // Wrong value
        }
        if (toggleButton.isSelected()){
            GenerateAndDrawHexagon(Integer.parseInt(ColumnsTextBox.getText()), Integer.parseInt(RowsTextBox.getText()));
        } else{
            GenerateAndDrawSquare(Integer.parseInt(ColumnsTextBox.getText()), Integer.parseInt(RowsTextBox.getText()));
        }
    }

    @FXML
    private void ToggleButtonPressed(ActionEvent actionEvent){
        if (toggleButton.isSelected()){
            toggleButton.setText("Hexagon");
        } else {
            toggleButton.setText("Square");
        }
    }

    private class Hexagon extends Polygon {
        Hexagon(double x, double y, Color color) {
            /*getPoints().addAll(
                    x - n/2, y-r,
                    x + n/2, y-r,
                    x + n, y,
                    x + n/2, y+r,
                    x - n/2, y+r,
                    x - n, y
            );*/

            getPoints().addAll(
                    x - drawableLength /2, y - drawableLength,
                    x + drawableLength /2 , y - drawableLength,
                    x + drawableLength, y,
                    x + drawableLength /2, y + drawableLength,
                    x - drawableLength /2, y + drawableLength,
                    x - drawableLength, y
            );

            setFill(color);
            setStrokeWidth(1);
            setStroke(Color.BLACK);
        }
    }

    private class Square extends  Polygon{
        Square(double x, double y, Color color){
            getPoints().addAll(
                    x, y,
                    x + drawableLength, y,
                    x + drawableLength, y + drawableLength,
                    x, y + drawableLength
            );

            setFill(color);
        }
    }
}
