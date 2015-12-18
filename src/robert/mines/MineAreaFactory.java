package robert.mines;

import robert.mines.mainWindow.mineArea.MineArea;

/**
 * Created by snyder on 2015-07-14.
 */
public class MineAreaFactory {
    public static MineAreaFactory Instance(){
        return new MineAreaFactory();
    }

    private MineArea mineArea=new MineArea(0,0);

    protected MineAreaFactory(){
    }

    public MineAreaFactory With_X_Columns_and_Y_Rows(int columns, int rows){
        mineArea = new MineArea(columns, rows);
        return this;
    }

    public MineArea Create(){
        return mineArea;
    }
}
