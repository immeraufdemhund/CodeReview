package textGame;

/**
 * Created by snyder on 2015-09-17.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMain {
    private final List<GameStage> gameStages;

    public GameMain(){
        gameStages = new ArrayList<GameStage>();
        gameStages.add(new AgeVerificationGameStage());
    }
    public void playGame(){
        for (GameStage stage : gameStages){
            System.out.print(stage.getDescription());
            for(String decision : stage.getDecisions()){
                System.out.print("    " + decision.toString());
            }
            String userInput = rep.next();
            stage.setUserInput(userInput);
            if(stage.isGameOver()) {
                System.out.print(stage.getGameOverText());
                return;
            }
        }
        System.out.println("Y0U R T3H W1NN3R!!");
    }
    static Scanner rep = new Scanner(System.in);  //Scanner variable
    public static void main(String[] args) {

        String nm;                             //Stores the name of the player.
        String d1, d2, d3;                       //Store the decisions of player.
        int age;                               //Stores the age of player.
        String line2, line3, line4;            //Text for the lines.

        //The next few lines contain text for the dialogues and lines.
        line2 = "What in the.......!!! *He shoots you in the head.* GAMEOVER";
        line3 = "Good. Lets GO! *As you both proceed, suddenly a masked man enters the \ncell with a gun and holds the man at gunpoint. You start to shit your pants*";
        line4 = "You slowly raise your arms in surrender. As you are getting down on your knees, another man shouts from\n15"
                + " outside'HEY! VIKTOR! MAKE IT QUICK!'. The man gets distracted. You see this as an opportunity";

        //Next few lines enforce Age Limit.

        System.out.println("Please enter your age.");
        age = rep.nextInt();

        if (age > 13) {

            //This stores the name of the player to the variable nm.
            System.out.println("Hello. Please Enter your Name :");
        } else {
            System.out.println("You are not old enough.");
            System.exit(0);
        }

        nm = rep.next(); /*allows the user to enter a name, if he/she is older than 13*/


        //Next lines print out the first dialogues and decision.
        System.out.print("[note-type exit at any time to exit] Wake UP!      Goddamnit!\n Looks like they overdosed you a bit. You are ");
        System.out.print(nm);
        System.out.println(" right? Cmon, lets get the hell out of here.");
        System.out.println("What do you do? A. Punch the guy in the nuts.");
        System.out.println("B. Follow him.");
        d1 = rep.next();

        switch (d1) {

            case "exit":
                System.exit(0); /*I decided to let the user terminate the program if            he wants by this command.*/
                break;

            case "A":
                System.out.println(line2);
                System.exit(0);
                break;
            case "B":
                System.out.println(line3);
                break;

        }

        System.out.println("What do you do? ");
        System.out.println("A. You try to take the gun from the man.");
        System.out.println("B. You slowly raise your arms to display that you pose no danger.");

        d2 = rep.next();

        switch (d2) {

            case "exit":
                System.exit(0);
                break;
            case "A":
                System.out.println(" He shoots you in the head when you attempt to take his gun. *GAME OVER*");
                System.exit(0);
                break;
            case "B":
                System.out.println(line4);
                break;
        }

        System.out.println(" What do you do?\n A.Punch the man in the nuts and take his gun.\n B.Make a run for it through the door.\n C.Do nothing and remain in the surrender position.");

        d3 = rep.next();

        switch (d3) {

            case "exit":
                System.exit(0);
                break;

            case "A":
                System.out.println(" You succesfully punch him in the nuts. He shouts in agony and you easily grab the gun that slipped form his hands.\n You now have the gun, What do you do?");
                break;

            case "B":
                System.out.println(" You try to make a run for it through the door, but the man notices your escape attempt.\n He immediately shoots at you, but misses. He shoots at you again. It hits you right in the bottoms and you fall on the ground,\n shouting in agony. The man then shoots your buddy in the head and proceeds to do the same to you.*GAME OVER*");
                System.exit(0);
                break;

            case "C":
                System.out.println("You decide its better to comply. You and your buddy are down on your knees. The man then turns to you buddy\nand says\"Hope you had a fun little life. HA! just kidding! Hope you DIDNT\"\n*BOOM* Your friends severed head lies next to you. The man now shifts his gaze onto you.\n What do you do? ");

//The game is not complete but I only made this to learn. I would love if you guys told me my mistakes and things i could've done differently and better. I would appreciate it . }

        }

    }
}