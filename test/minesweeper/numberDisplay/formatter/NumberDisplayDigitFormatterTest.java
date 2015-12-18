package minesweeper.numberDisplay.formatter;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by snyder on 2015-07-14.
 */
public class NumberDisplayDigitFormatterTest {

    @Test
    public void testFormat() throws Exception {
        NumberDisplayDigitFormatter formatter = new NumberDisplayDigitFormatter();

        assertEquals(formatter.format(1), "001");
        assertEquals(formatter.format(1234), "234");
        assertEquals(formatter.format(-1), "-01");
        assertEquals(formatter.format(-123), "-23");
    }
}