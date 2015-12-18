package tictactoe;

import java.util.Scanner;

/**
 * Created by snyder on 2015-10-01.
 */
public class Game {
    private final char[] _board;
    private final Scanner keyboard;
    public Game(){
        _board = new char[9];
        keyboard =  new Scanner(System.in);
    }
    public void playGame(){
        char player = 'x';
        char a1 = ' ', a2 = ' ', a3 = ' ';
        char b1 = ' ', b2 = ' ', b3 = ' ';
        char c1 = ' ', c2 = ' ', c3 = ' ';
        player = (char)(player ^ 'x' ^ 'o');
        while (y <= 9) {
            if (turn == 1) {
                System.out.println("player 1 it is your turn. your spot you wou"
                        + "ld like to enter.\n Ex: top,botton,middle left,right,middle");
                String input = keyboard.nextLine();

                if (input.equals("top left")) {
                    if(IsValidMove(a1)){
                        a1 = 'x';
                        turn++;
                        y++;
                    }
                } else if (input.equals("top middle")) {
                    if (IsValidMove(b1)){
                        b1 = 'x';
                        turn++;
                        y++;
                    }
                } else if (input.equals("top right")) {
                    if (IsValidMove(c1)){
                        c1 = 'x';
                        turn++;
                        y++;
                    }
                } else if (input.equals("middle left")) {
                    if (IsValidMove(a2)){
                        a2 = 'x';
                        turn++;
                        y++;
                    }
                } else if (input.equals("middle middle")) {
                    if (IsValidMove(b2)){
                        b2 = 'x';
                        turn++;
                        y++;
                    }
                } else if (input.equals("middle right")) {
                    if (IsValidMove(c2)){
                        c2 = 'x';
                        turn++;
                        y++;
                    }
                } else if (input.equals("bottom left")) {
                    if (IsValidMove(a3)){
                        a3 = 'x';
                        turn++;
                        y++;
                    }
                } else if (input.equals("bottom middle")) {
                    if (IsValidMove(b3)){
                        b3 = 'x';
                        turn++;
                        y++;
                    }
                } else if (input.equals("bottom right")) {
                    if (IsValidMove(c3)){
                        c3 = 'x';
                        turn++;
                        y++;
                    }
                } else {
                    System.out.println("You have entered an invalid sapce"
                            + "please try again.");
                }
                System.out.printf(" %c | %c | %c \n", a1, b1, c1);
                System.out.printf("____________\n");
                System.out.printf(" %c | %c | %c \n", a2, b2, c2);
                System.out.printf("____________\n");
                System.out.printf(" %c | %c | %c \n", a3, b3, c3);
                if (isPlayer1Winner(a1, a2, a3)){
                    System.out.println("Player 1 wins!!!");
                    return;
                }
                else if (isPlayer1Winner(b1, b2, b3)){
                    System.out.println("Player 1 wins!!!");
                    return;
                }
                else if (isPlayer1Winner(c1, c2, c3)){
                    System.out.println("Player 1 wins!!!");
                    return;
                }
                else if (isPlayer1Winner(a1, b2, c3)){
                    System.out.println("Player 1 wins!!!");
                    return;
                }
                else if (isPlayer1Winner(a1, b1, c1)){
                    System.out.println("Player 1 wins!!!");
                    return;
                }
                else if (isPlayer1Winner(a2, b2, c2)){
                    System.out.println("Player 1 wins!!!");
                    return;
                }
                else if (isPlayer1Winner(a3, b3, c3)){
                    System.out.println("Player 1 wins!!!");
                    return;
                }
                else if (isPlayer1Winner(c1, b2, a3)) {
                    System.out.println("Player 1 wins!!!");
                    return;
                }


                if(y == 9)
                {
                    System.out.println("the game ends in a draw.");
                    return;
                }

            }
            if (turn == 2) {
                System.out.println("player 2 it is your turn. your spot you"
                        + " would like to enter.\n Ex: top,botton,middle left,right,middle");
                String input = keyboard.nextLine();

                if (input.equals("top left")) {
                    if (a1 == ' ') {
                        a1 = 'o';
                        turn--;
                        y++;
                    } else {
                        System.out.println("you cant pick that space its"
                                + " already been taken");
                    }
                } else if (input.equals("top middle")) {
                    if (b1 == ' ') {
                        b1 = 'o';
                        turn--;
                        y++;
                    } else {
                        System.out.println("you cant pick that space its"
                                + " already been taken");
                    }
                } else if (input.equals("top right")) {
                    if (c1 == ' ') {
                        c1 = 'o';
                        turn--;
                        y++;
                    } else {
                        System.out.println("you cant pick that space its"
                                + " already been taken");
                    }
                } else if (input.equals("middle left")) {
                    if (a2 == ' ') {
                        a2 = 'o';
                        turn--;
                        y++;
                    } else {
                        System.out.println("you cant pick that space its"
                                + " already been taken");
                    }
                } else if (input.equals("middle middle")) {
                    if (b2 == ' ') {
                        b2 = 'o';
                        turn--;
                        y++;
                    } else {
                        System.out.println("you cant pick that space its"
                                + " already been taken");
                    }
                } else if (input.equals("middle right")) {
                    if (c2 == ' ') {
                        c2 = 'o';
                        turn--;
                        y++;
                    } else {
                        System.out.println("you cant pick that space its"
                                + " already been taken");
                    }
                } else if (input.equals("bottom left")) {
                    if (a3 == ' ') {
                        a3 = 'o';
                        turn--;
                        y++;
                    } else {
                        System.out.println("you cant pick that space its"
                                + " already been taken");
                    }
                } else if (input.equals("bottom middle")) {
                    if (b3 == ' ') {
                        b3 = 'o';
                        turn--;
                        y++;
                    } else {
                        System.out.println("you cant pick that space its"
                                + " already been taken");
                    }
                } else if (input.equals("bottom right")) {
                    if (c3 == ' ') {
                        c3 = 'o';
                        turn--;
                        y++;
                    } else {
                        System.out.println("you cant pick that space its"
                                + " already been taken");
                    }
                } else {
                    System.out.println("You have entered an invalid space"
                            + "please try again.");
                }
                System.out.printf(" %c | %c | %c \n", a1, b1, c1);
                System.out.printf("____________\n");
                System.out.printf(" %c | %c | %c \n", a2, b2, c2);
                System.out.printf("____________\n");
                System.out.printf(" %c | %c | %c \n", a3, b3, c3);
                if (isPlayer2Winner(a1, a2, a3)){
                    System.out.println("Player 2 wins!!!");
                    return;
                }
                else if (isPlayer2Winner(b1, b2, b3)){
                    System.out.println("Player 2 wins!!!");
                    return;
                }
                else if (isPlayer2Winner(c1, c2, c3)){
                    System.out.println("Player 2 wins!!!");
                    return;
                }
                else if (isPlayer2Winner(a1, b2, c3)){
                    System.out.println("Player 2 wins!!!");
                    return;
                }
                else if (isPlayer2Winner(a1, b1, c1)){
                    System.out.println("Player 2 wins!!!");
                    return;
                }
                else if (isPlayer2Winner(a2, b2, c2)){
                    System.out.println("Player 2 wins!!!");
                    return;
                }
                else if (isPlayer2Winner(a3, b3, c3)){
                    System.out.println("Player 2 wins!!!");
                    return;
                }
                else if (isPlayer2Winner(c1, b2, a3)) {
                    System.out.println("Player 2 wins!!!");
                    return;
                }
            }
        }
    }
    private boolean isPlayer1Winner(char space1, char space2, char space3){
        return isPlayerWinner('x', space1, space2, space3);
    }
    private boolean isPlayer2Winner(char space1, char space2, char space3){
        return isPlayerWinner('o', space1, space2, space3);
    }
    private boolean isPlayerWinner(char token, char space1, char space2, char space3){
        return space1 == token && space2 == token && space3 == token;
    }
    private static  boolean IsValidMove(char space){
        boolean valid = space == ' ';
        if (!valid){
            System.out.println("you cant pick that space its"
                    + " already been taken");
        }

        return valid;
    }

    private static int turn = 1;
    private static int y = 0;

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
