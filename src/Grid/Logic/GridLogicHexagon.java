package Grid.Logic;

import Grid.Helper.ColorHelper;
import Grid.Items.Node;

import java.util.ArrayList;

public class GridLogicHexagon extends GridLogic {

    private ArrayList<Node> nodes = new ArrayList<>();

    public GridLogicHexagon(int rows, int length){
        this.logicType = LogicType.HEXAGON;
        this.rows = rows;
        this.length = length;

        for (int i = 0; i < (rows * length); i++) {
            nodes.add(new Node());
        }
    }

    public boolean ColorGrid(int number, int colorindex){
        if (number >= rows*length){
            return true;
        }

        nodes.get(number).setNodeColor(ColorHelper.IndexToColor(colorindex));

        //Check current row number
        var row = (int) number / length;

        // Oben
        if (number-length >= 0){
            if (nodes.get(number - length).getNodeColor() == nodes.get(number).getNodeColor()){
                return false;
            }
        }
        //Unten
        if ((number + length) < nodes.size()){
            if (nodes.get(number + length).getNodeColor() == nodes.get(number).getNodeColor()){
                return false;
            }
        }

        // Gerade laenge
        if (length % 2 == 0 || row % 2 == 0){

            // Links-Oben & Links-Unten
            // Linke Kante
            if(number % length != 0){
                //Ungerade
                if(number % 2 == 1){
                    if (nodes.get(number-1).getNodeColor() == nodes.get(number).getNodeColor()){
                        return false;
                    }
                    if (number <= nodes.size() - length){
                        if (nodes.get(number + (length - 1)).getNodeColor() == nodes.get(number).getNodeColor()){
                            return false;
                        }
                    }
                }
                //Gerade
                else {
                    if (nodes.get(number-1).getNodeColor() == nodes.get(number).getNodeColor()){
                        return false;
                    }
                    if (number > length){
                        if (nodes.get(number - (length + 1)).getNodeColor() == nodes.get(number).getNodeColor()){
                            return false;
                        }
                    }
                }
            }
            // Rechts-Oben & Rechts-Unten
            if (number % length != length - 1){
                // Ungerade
                if (number % 2 == 1){
                    // Rechts-Oben
                    if (nodes.get(number + 1).getNodeColor() == nodes.get(number).getNodeColor()){
                        return false;
                    }
                    if (number < nodes.size() - length){
                        if (nodes.get(number + (length + 1)).getNodeColor() == nodes.get(number).getNodeColor()){
                            return false;
                        }
                    }
                }
                // Gerade
                else {
                    // Rechts-Oben
                    if (number > length-1){
                        if (nodes.get(number - (length-1)).getNodeColor() == nodes.get(number).getNodeColor()){
                            return false;
                        }
                    }
                    // Rechts-Unten
                    if (nodes.get(number + 1).getNodeColor() == nodes.get(number).getNodeColor()){
                        return false;
                    }
                }
            }
        } else {
            // Gerade
            if (number % 2 == 0){
                // Nicht Linker Rand
                if (number % length != 0){
                    //Links Oben
                    if (nodes.get((number - 1)).getNodeColor() == nodes.get(number).getNodeColor()){
                        return false;
                    }
                    //Links Unten
                    if (number < nodes.size() - length){
                        if (nodes.get(number + (length - 1)).getNodeColor() == nodes.get(number).getNodeColor()){
                            return false;
                        }
                    }
                }
                //Nicht rechter Rand
                if (number % length == length - 1){
                    // Rechts Oben
                    if (nodes.get(number + 1).getNodeColor() == nodes.get(number).getNodeColor()){
                        return false;
                    }
                    //Rechts unten
                    if (number < nodes.size() - length){
                        if (nodes.get(number + length + 1).getNodeColor() == nodes.get(number).getNodeColor()){
                            return false;
                        }
                    }
                }
            } else { //Ungeraden
                // Nicht linker Rand
                if (number % length != 0){
                    // Links-Oben
                    if (nodes.get(number - length - 1).getNodeColor() == nodes.get(number).getNodeColor()){
                        return false;
                    }
                    // Links-Unten
                    if (nodes.get(number - 1).getNodeColor() == nodes.get(number).getNodeColor()){
                        return false;
                    }
                }
                // Nicht rechter Rand
                if (number % length != length - 1){
                    // Rechts-Oben
                    if (nodes.get(number - (length - 1)).getNodeColor() == nodes.get(number).getNodeColor()){
                        return false;
                    }
                    // Rechts-Unten
                    if (nodes.get(number + 1).getNodeColor() == nodes.get(number).getNodeColor()){
                        return false;
                    }
                }
            }
        }

        var fnumber = number + 1;
        for (int i = 0; i < 4; i++) {
            if (ColorGrid(fnumber, i)){
                return true;
            }
        }
        return false;
    }

    public void PrintGrid(){
        for (int i = 0; i < rows; i++) {
            for (int j = i * length; j < length + (i * length); j = j +2) {
                System.out.print(ColorHelper.ColorToName(nodes.get(j).getNodeColor()) + "    ");
            }
            System.out.println();
            System.out.print("    ");
            for (int k = (i * length) + 1; k < length + (i * length); k = k + 2){
                System.out.print(ColorHelper.ColorToName(nodes.get(k).getNodeColor()) + "    ");
            }
            System.out.println();
        }
    }

    public ArrayList<Node> GetNodeList(){
        return nodes;
    }
}
