package robert.mines.mainWindow.mineArea;

import robert.mines.GameCompletedListener;

/**
 * Created by snyder on 2015-07-14.
 */
public class MineArea {
    private MineZone[][] zones;
    private int mineCount;
    private GameCompletedListener gameListener;

    public MineArea(int columns, int rows) {
        zones = new MineZone[columns][rows];
        initializeMineZones();
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    public void uncoverMineZone(int column, int row) {
        MineZone zone = zones[column][row];
        zone.uncover();
        if(zone.isMine()){
            gameListener.GameLost();
        }
    }

    public void setGameListener(GameCompletedListener gameListener) {
        this.gameListener = gameListener;
    }

    private void initializeMineZones() {
        for (MineZone[] row : zones){
            for (MineZone cell : row){
                cell = new MineZone();
            }
        }
    }
}
