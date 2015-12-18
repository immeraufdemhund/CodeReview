package tictactoe;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by snyder on 2015-10-05.
 */
public class TTTGameTest {
    private static final String TL = "top left";
    private static final String TM = "top middle";
    private static final String TR = "top right";

    private static final String ML = "middle left";
    private static final String MM = "middle middle";
    private static final String MR = "middle right";

    private static final String BL = "bottom left";
    private static final String BM = "bottom middle";
    private static final String BR = "bottom right";
    private StorePrintStream ps;
    @BeforeMethod
    public void Setup(){
        ps = new StorePrintStream(System.out);
    }
    @AfterMethod
    public void TearDown(){
        System.setIn(System.in);
    }

    @Test
    public void testUpdatingFieldInADifferentClass() throws  Exception {
        Box box = new Box();
        BoxChanger changer = new BoxChanger(box);
        box.X = 1;
        box.Y = 3;

        changer.changeBox();

        assertEquals(box.X, 2, "Box Changer should have added 1 to X");
        assertEquals(box.Y, 3, "Box Changer should Not have Touched Y");
    }
    @Test
    public void testPlayGameTopRowWinsPlayer1() throws Exception {
        playGameWithTheseMoves(TL, ML, TM, MM, TR);
        assertEquals(ps.getLastLine(), "Player 1 wins!!!");
    }

    @Test
    public void testPlayGameTopRowWinsPlayer2() throws Exception {
        playGameWithTheseMoves(BL, TL, ML, TM, MM, TR);
        assertEquals(ps.getLastLine(), "Player 2 wins!!!");
    }

    @Test
    public void testPlayGameMiddleRowWinsPlayer1() throws Exception {
        playGameWithTheseMoves(ML, TL, MM, TM, MR);
        assertEquals(ps.getLastLine(), "Player 1 wins!!!");
    }

    @Test
    public void testPlayGameMiddleRowWinsPlayer2() throws Exception {
        playGameWithTheseMoves(BL, ML, TL, MM, TM, MR);
        assertEquals(ps.getLastLine(), "Player 2 wins!!!");
    }

    @Test
    public void testPlayGameBottomRowWinsPlayer1() throws Exception {
        playGameWithTheseMoves(BL, TL, BM, TM, BR);
        assertEquals(ps.getLastLine(), "Player 1 wins!!!");
    }

    @Test
    public void testPlayGameBottomRowWinsPlayer2() throws Exception {
        playGameWithTheseMoves(ML, BL, TL, BM, TM, BR);
        assertEquals(ps.getLastLine(), "Player 2 wins!!!");
    }


    private void playGameWithTheseMoves(String... input){
        System.setOut(ps);
        setInputForScanner(input);
        Game g = new Game();
        g.playGame();
    }
    private void setInputForScanner(String... input) {
        String lines = join("\n", input);
        System.setIn(new ByteArrayInputStream(lines.getBytes()));

    }

    private String join(String delim, String... col) {
        StringBuilder sb = new StringBuilder();
        for ( String s : col ) {
            if ( sb.length() != 0 ) sb.append(delim);
            sb.append(s);
        }
        return sb.toString();
    }

    class StorePrintStream extends PrintStream {

        public List<String> printList = new LinkedList<>();

        public StorePrintStream(PrintStream org) {
            super(org);
        }

        @Override
        public void println(String line) {
            printList.add(line);
            super.println(line);
        }

        public String getLastLine() {
            return printList.size() < 1 ? "" : printList.get(printList.size() - 1);
        }
    }
}