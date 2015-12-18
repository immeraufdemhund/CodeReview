import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

/**
 * Created by snyder on 2015-05-11.
 */
public class HiddenWordTest {

    @Test(dataProvider = "getHiddenWords")
    public void testGetHint(String hiddenWord, String guessedWord, String expectedHint) throws Exception {
        System.out.printf("HiddenWord(%s).getHint(%s) should equal %s\r\n", hiddenWord, guessedWord, expectedHint);

        HiddenWord puzzle = new HiddenWord(hiddenWord);
        String hint = puzzle.getHint(guessedWord);

        assertEquals(hint, expectedHint);
    }

    @Test
    public void testVeryLargeoutput(){
        int[] testSize = {10000, 20000,40000,80000, 160000};
        for (int size : testSize){
            HiddenWord puzzle = new HiddenWord(getLargeUppercaseString(size));
            String guess = getLargeUppercaseString(size);
            long start_time = System.nanoTime();
            puzzle.getHint(guess);
            long end_time = System.nanoTime();
            double difference = (end_time - start_time)/1e6;
            System.out.printf("String length:%d Time:%f\r\n", size, difference);
        }
    }
    private static String getLargeUppercaseString(int size){
        return getRandomString(new Random(), "QWERTYUIOPASDFGHJKLZXCVBNM", size);
    }

    private static String getRandomString(Random rnd, String letterFilter, int size) {
        StringBuilder sb = new StringBuilder( size );
        for( int i = 0; i < size; i++ )
            sb.append( letterFilter.charAt( rnd.nextInt(letterFilter.length()) ) );
        return sb.toString();
    }

    @DataProvider
    private Object[][] getHiddenWords(){
        return new Object[][]{
                {"A", "A", "A"},
                {"A", "B", "*"},
                {"AA", "AB", "A*"},
                {"HARPS", "AAAAA", "+A+++"},
                {"HARPS", "HELLO", "H****"},
                {"HARPS", "HEART", "H*++*"},
                {"HARPS", "HARMS", "HAR*S"},
                {"HARPS", "HARPS", "HARPS"},
        };
    }


}