package textGame;

import java.util.Iterator;

public abstract class GameStage{
    protected boolean gameOver;

    public boolean isGameOver() {
        return gameOver;
    }

    public abstract String getDescription();

    public abstract void setUserInput(String userInput);

    public abstract String getGameOverText();

    public abstract Iterable<String> getDecisions();
}
