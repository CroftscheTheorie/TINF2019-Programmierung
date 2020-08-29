package Grid.Helper;

import java.awt.*;

public class ColorHelper {
    public static Color IndexToColor(int index){
        return ColorIndex.values()[index].color;
    }

    public static int ColorToIndex(Color color){
        return ColorIndex.valueOf(color.toString()).ordinal();
    }

    public static String ColorToName(Color color){
        if (Color.YELLOW.equals(color)){
            return "YEL";
        }
        if (Color.RED.equals(color)){
            return "RED";
        }
        if (Color.GREEN.equals(color)){
            return "GRE";
        }
        if (Color.BLUE.equals(color)){
            return "BLU";
        }
        else {
            return "ERR";
        }

    }

    private enum ColorIndex{
        GREEN(Color.GREEN),
        RED(Color.RED),
        BLUE(Color.BLUE),
        YELLOW(Color.YELLOW);

        private final Color color;

        ColorIndex(Color color) {
            this.color = color;
        }
    }
}
