package GUI.Panel;

import GUI.Shapes.Hexagon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {
    private ArrayList<Hexagon> hexagonList;

    public DrawingPanel(ArrayList<Hexagon> hexagonList){
        this.hexagonList = hexagonList;
        this.setPreferredSize(new Dimension(1280,720));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        for (var hexagon : hexagonList) {
            g.setColor(hexagon.getColor());
            g.drawPolygon(hexagon.getHexagon());
        }
    }
}
