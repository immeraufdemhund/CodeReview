package textGame;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by snyder on 2015-09-17.
 */
    public class AgeVerificationGameStage extends GameStage {
        @Override
        public String getDescription() {
            return "Please enter your age.";
        }

        @Override
        public void setUserInput(String userInput) {
            int age = Integer.parseInt(userInput);
            gameOver = age < 13;
        }

        @Override
        public String getGameOverText() {
            return "You are not old enough.";
        }

        @Override
        public Iterable<String> getDecisions() {
            return Collections.EMPTY_LIST ;
        }
    }
