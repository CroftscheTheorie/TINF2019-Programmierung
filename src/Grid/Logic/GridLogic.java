package Basic.Grid.Logic;

public abstract class GridLogic {
    public LogicType logicType;
    protected int rows;
    protected int length;

    public enum LogicType{
        SQUARES, HEXAGON
    }
}
