package GUI.Shapes;

import java.awt.*;

public class Hexagon {
    private final int radius;
    private final Point center;
    private final Polygon hexagon;

    private Color color;

    public Hexagon(int radius, Point center, Color color) {
        this.radius = radius;
        this.center = center;
        this.color = color;
        this.hexagon = createHexagon();
    }

    private Polygon createHexagon(){
        Polygon polygon = new Polygon();

        for (int i = 0; i < 6; i++) {
            double v = radius * Math.cos(i * 2 * Math.PI / 6D);
            int x = (int) (center.x + v);
            int y = (int) (center.y + v);
            polygon.addPoint(x, y);
        }

        return polygon;
    }

    public int getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    public Polygon getHexagon() {
        return hexagon;
    }

    public Color getColor() {
        return color;
    }
}
