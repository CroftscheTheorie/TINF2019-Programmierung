package Basic.Grid.Helper;

import java.awt.*;

public class ColorHelper {
    public static Color IndexToColor(int index){
        return ColorIndex.values()[index].color;
    }

    public static int ColorToIndex(Color color){
        return ColorIndex.valueOf(color.toString()).ordinal();
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
