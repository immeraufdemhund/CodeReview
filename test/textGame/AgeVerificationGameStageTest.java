package textGame;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by snyder on 2015-09-17.
 */
public class AgeVerificationGameStageTest {

    @Test
    public void whenUserToYoungGameIsOver() throws Exception {
        AgeVerificationGameStage stage = new AgeVerificationGameStage();

        stage.setUserInput("12");

        assertTrue(stage.isGameOver());

        stage.setUserInput("13");

        assertFalse(stage.isGameOver());
    }

    @Test
    public void userSaidTheyPut9AndTheGameWorked() throws Exception {
        AgeVerificationGameStage stage = new AgeVerificationGameStage();

        stage.setUserInput("9");

        assertFalse(stage.isGameOver());
    }
}