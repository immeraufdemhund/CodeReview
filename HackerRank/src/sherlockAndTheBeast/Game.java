package sherlockAndTheBeast;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by snyder on 2015-08-26.
 */
public class Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] testCases = new int[in.nextInt()];

        for (int i = 0; i < testCases.length; i++) {
            testCases[i] = in.nextInt();
        }

        for (int testCase : testCases) {
            System.out.println(getOutput(testCase));
        }
    }

    private static String getOutput(int testCase) {
        int testX = testCase / 3;
        int testY = testCase / 5;
        for (int x = testX; x > 0; x--) {
            for (int y = testY; y >= 0; y--) {
                if (testCase % (3 * x + 5 * y) == 0) {
                    return getLargestDecentNumber(x, y);
                }
            }
        }
        return "-1";
    }

    // function to generate decentString
    static String getLargestDecentNumber(int threes, int fives) {
        threes = 3 * threes;
        fives = 5 * fives;

        String decentString = buildString('5', threes) + buildString('3', fives);
        return decentString;
    }

    private static String buildString(char s, int n) {
        char[] c = new char[n];
        Arrays.fill(c, s);
        return new String(c);
    }

}
