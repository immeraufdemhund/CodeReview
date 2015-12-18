package gravityguy;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.testng.Assert.*;

/**
 * Created by snyder on 2015-08-10.
 */
public class ggTest {
    @Test
    public void TestGettingAnswer() throws IOException {
        StringReader sr = new StringReader("3\n" +
                "#...#\n" +
                ".###.\n" +
                "#.#.#.\n" +
                ".#.#.#\n" +
                "#...\n" +
                "#...");

        gg hi = new gg();
        hi.FindAnswer(sr);
    }
}