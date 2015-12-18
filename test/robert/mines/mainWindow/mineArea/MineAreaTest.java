package robert.mines.mainWindow.mineArea;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import robert.mines.GameCompletedListener;

import static org.testng.Assert.*;

/**
 * Created by snyder on 2015-07-14.
 */
public class MineAreaTest {

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testWhenMineCellIsClicked_BoardNotifiesUserLost(){
        GameCompletedListenerSpy spy = new GameCompletedListenerSpy();

        MineArea area = new MineArea(1,1);
        area.setMineCount(1);
        area.setGameListener(spy);
        area.uncoverMineZone(0, 0);

        assertEquals(spy.gameWonCalled, false, "GameComplated.GameWon event called");
        assertEquals(spy.gameLostCalled, true, "GameComplated.GameLost event was NOT called");
    }

    private class GameCompletedListenerSpy implements  GameCompletedListener{

        public boolean gameWonCalled;
        public boolean gameLostCalled;

        @Override
        public void GameLost() {
            gameLostCalled = true;
        }

        @Override
        public void GameWon() {
            gameWonCalled = true;
        }
    }
}