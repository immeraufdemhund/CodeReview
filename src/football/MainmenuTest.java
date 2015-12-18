package football;

/**
 * Created by snyder on 2015-09-24.
 */

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainmenuTest extends premierLeagueClubs {

    int clubChoice;

    public MainmenuTest() {

//constructor
    }

    public static void main(String args[]) {

        MainmenuTest team = new MainmenuTest();

        team.getInput();


    } // end main method

    public void getInput() {


        boolean exit = false;
        int option = 0;
        while (!exit) {

            try {
                Scanner in = new Scanner(System.in);

                menu();
                System.out.println("\n");
                option = in.nextInt();
            } // end try

            catch (InputMismatchException e) {

            } // end catch
            switch (option) {

                case 1:
                    chooseTeam();
                    exit = true;
                    break;

                case 2:
                    createProfile();
                    exit = true;
                    break;

                case 3:
                    DeserializeDemo load = new DeserializeDemo();
                    load.Deserialize(clubChoice);
                    exit = true;
                    break;

                case 4:
                    credits();
                    exit = true;
                    break;

                case 5:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;

                case 6:
                    SerializeDemo save = new SerializeDemo();
                    save.Serialize(clubChoice);
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option");


            } // end switch

        } // end loop

    } // end getInput

    public int chooseTeam() {


        boolean exit = false;
        while (!exit) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Please enter an option 1-20 to select a team, or 21 to quit : ");
            System.out.println("1. Arsenal");
            System.out.println("2. Aston Villa");
            System.out.println("3. Bournemouth");
            System.out.println("4. Chelsea");
            System.out.println("5. Crystal Palace");
            System.out.println("6. Everton");
            System.out.println("7. Leicester City");
            System.out.println("8. Liverpool");
            System.out.println("9. Manchester United");
            System.out.println("10. Manchester City");
            System.out.println("11. Newcastle United");
            System.out.println("12. Norwich City");
            System.out.println("13. Southampton");
            System.out.println("14. Stoke City");
            System.out.println("15. Sunderland");
            System.out.println("16. Swansea City");
            System.out.println("17. Tottenham Hotspur");
            System.out.println("18. Watford");
            System.out.println("19. West Brom");
            System.out.println("20. West Ham United");
            System.out.println("\n");
            System.out.println("21. Quit");
            System.out.println("22. Mainmenu");
            try {
                Scanner in = new Scanner(System.in);


                System.out.println("\n");
                clubChoice = in.nextInt();
            } // end try

            catch (InputMismatchException e) {

            } // end catch

            switch (clubChoice) {

                case 1:
                    arsenal();
                    exit = true;
                    break;


                case 2:
                    astonVilla();
                    exit = true;
                    break;

                case 3:
                    bournemouth();
                    exit = true;
                    break;

                case 4:
                    chelsea();
                    exit = true;
                    break;

                case 5:
                    crystalPalace();
                    exit = true;
                    break;

                case 6:
                    everton();
                    exit = true;
                    break;

                case 7:
                    leicester();
                    exit = true;
                    break;

                case 8:
                    liverpool();
                    exit = true;
                    break;

                case 9:
                    manchesterUnited();
                    exit = true;
                    break;

                case 10:
                    manchesterCity();
                    exit = true;
                    break;

                case 11:
                    newcastleUnited();
                    exit = true;
                    break;

                case 12:
                    norwichCity();
                    exit = true;
                    break;

                case 13:
                    southampton();
                    exit = true;
                    break;

                case 14:
                    stokeCity();
                    exit = true;
                    break;

                case 15:
                    sunderland();
                    exit = true;
                    break;

                case 16:
                    swanseaCity();
                    exit = true;
                    break;

                case 17:
                    tottenhamHotspur();
                    exit = true;
                    break;

                case 18:
                    watford();
                    exit = true;
                    break;

                case 19:
                    westBrom();
                    exit = true;
                    break;

                case 20:
                    westHamUnited();
                    exit = true;
                    break;

                case 21:
                    System.out.println("Goodbye!");
                    exit = true;
                    break;

                case 22:
                    getInput();
                    exit = true;
                    break;

            } // end switch
        } // end loop

        return clubChoice;
    } // end chooseTeam

    public void createProfile() {


    } // end createProfile

    public void credits() {
    } // end credits

    public void menu() {

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Created by Darren Estcourt");
        System.out.println("\n");
        System.out.println("Please choose an option  between 1 - 6 : ");
        System.out.println("\n");
        System.out.println("1. Choose team");
        System.out.println("\n");
        System.out.println("2. Create profile");
        System.out.println("\n");
        System.out.println("3. Load game");
        System.out.println("\n");
        System.out.println("4. Credits");
        System.out.println("\n");
        System.out.println("5. Quit");
        System.out.println("\n");
        System.out.println("6. Save game");

        System.out.println("\n");
    } // end menu
}