package unitedStates;

/**
 * Created by snyder on 2015-09-29.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StateBirdAndFlowerProgram {
    static List<U_S_State> usStates;
    static {
        usStates = new ArrayList<U_S_State>();
        usStates.add(new U_S_State("Alabama", "Flower: Camelia", "Bird: Northern flicker"));
    }
    //pre java 8, comparable needed on U_S_State
    public void GetInfo1(String stateName){
        int index = usStates.indexOf(new U_S_State(stateName));
        if (index == -1){//not found
            return;
        }

        U_S_State state = usStates.get(index);
        System.out.println("Bird: " + state.getStateBird());
        System.out.println("Flower: " + state.getStateFlower() + "\n");
    }
    //Using java8 stream comparable not needed on U_S_State
    public void GetInfo2(String stateName){
        if(!usStates.stream().anyMatch(s->s.getStateName()==stateName))
            return;

        U_S_State state = usStates.stream()
                .filter(s->s.getStateName() == stateName)
                .findFirst().get();

        System.out.println("Bird: " + state.getStateBird());
        System.out.println("Flower: " + state.getStateFlower() + "\n");
    }
    public static void main(String args[]) {

        // Begin Scanner for user input later on
        Scanner input = new Scanner(System.in);
        //Begin array of information
        String[][] states = {
                {"Alabama", "Flower: Camelia", "Bird: Northern flicker"},
                {"Alaska", "Flower: Forget-me-not", "Bird: Willow ptarmigan "},
                {"Arizona", "Flower: Saguaro cactus blossom", "Bird: Cactus wren "},
                {"Arkansas", "Flower: Apple blossom", "Bird: Northern mockingbird "},
                {"Califorina", "Flower: Califorina poppy", "Bird: California quail"},
                {"Colorado", "Flower: Rocky Mountian columbine", "Bird: Lark bunting"},
                {"Connecticut", "Flower: Mountain laurel ", "Bird: American robin"},
                {"Delaware", "Flower: Peach blossom", "Bird: Delaware Blue Hen "},
                {"Florida", "Flower: Orange blossom ", "Bird: Northern mockingbird "},
                {"Georgia", "Flower: Cherokee rose ", "Bird: Brown thrasher ",},
                {"Hawaii", "Flower: Hawaiian hibiscus ", "Bird: NÄ“nÄ“ or Hawaiian goose"},
                {"Idaho", "Flower: Syringa, mock orange ", "Bird: Mountain bluebird  "},
                {"Illinois", "Flower: Violet ", "Bird: Northern cardinal "},
                {"Indiana", "Flower: Peony ", "Bird: Northern cardinal "},
                {"Iowa ", "Flower: Wild prairie rose ", "Bird: Eastern goldfinch "},
                {"Kansas", "Flower: Sunflower", "Bird: Western meadowlark"},
                {"Kentucky", "Flower: Goldenrod ", "Bird: Northern cardinal"},
                {"Louisiana", "Flower: Magnolia ", "Bird: Brown pelican "},
                {"Maine", "Flower: White pine cone and tassel ", "Bird: Black-capped chickadee "},
                {"Maryland", "Flower: Black-eyed susan ", "Bird: Baltimore oriole"},
                {"Massachusetts", "Flower: Mayflower ", "Bird: Black-capped chickadee "},
                {"Michigan", "Flower: Apple blossom", "Bird: American robin "},
                {"Minnesota", "Flower:Pink and white lady's slipper ", "Bird: Common loon"},
                {"Mississippi", "Flower: Magnolia", "Bird: Northern mockingbird "},
                {"Missouri", "Flower: Hawthorn", "Bird: Eastern bluebird "},
                {"Montana", "Flower: Bitterroot ", "Bird: Western meadowlark "},
                {"Nebraska", "Flower: Goldenrod", "Bird: Western meadowlark"},
                {"Nevada", "Flower: Sagebrush ", "Bird: Mountain bluebird "},
                {"New Hampshire ", "Flower: Purple lilac ", "Bird: Purple finch "},
                {"New Jersey", "Flower: Violet ", "Bird: Eastern goldfinch "},
                {"New Mexico", "Flower: Yucca flower", "Bird: Roadrunner  "},
                {"New York", "Flower: Rose", "Bird: Eastern bluebird "},
                {"North Carolina", "Flower: Flowering dogwood", "Bird: Northern cardinal "},
                {"North Dakota", "Flower: Wild prairie rose ", "Bird: Western meadowlark "},
                {"Ohio", "Flower: carlet carnation ", "Bird Northern cardinal: "},
                {"Oklahoma", "Flower: Oklahoma rose ", "Bird: Scissor-tailed flycatcher "},
                {"Oregon", "Flower: Oregon grape ", "Bird: Western meadowlark "},
                {"Pennsylvania", "Flower: Mountain laurel", "Bird: Ruffed grouse"},
                {"Rhode Island", "Flower: Violet", "Bird: Rhode Island Red "},
                {"South Carolina", "Flower: Yellow jessamine ", "Bird: Carolina wren",},
                {"South Dakota ", "Flower: Pasque flower ", "Bird: Ring-necked pheasant"},
                {"Tennessee", "Flower: Iris", "Bird: Northern mockingbird ",},
                {"Texas", "Flower: Bluebonnet sp. ", "Bird: Northern mockingbird "},
                {"Utah", "Flower: Sego lily", "Bird: California gull "},
                {"Vermont", "Flower: Red clover ", "Bird: Hermit thrush"},
                {"Virginia", "Flower: American dogwood", "Bird: Northern cardinal"},
                {"Washington", "Flower: Coast rhododendron", "Bird: Willow goldfinch "},
                {"West Virginia", "Flower:Rhododendron", "Bird: Northern cardinal "},
                {"Wisconsin", "Flower: Wood violet ", "Bird: American robin "},
                {"Wyoming", "Flower: Indian paintbrush ", "Bird: Western meadowlark "}};
        // While loop to search through array
        while (true) {

            // Request user input
            System.out.println("Enter a state: ");
            // Capture user input
            String stateName = input.nextLine();
            // exit statement
            if (stateName.equalsIgnoreCase("None"))
                // Exit program
                System.exit(0);

            else {
                // For loop to search through array
                for (int row = 0, column = 0; row < states.length; row++) {
                    // If statement for matching input string to array data
                    if (states[row][0].equalsIgnoreCase(stateName)) {
                        // Print bird information
                        System.out.println("Bird: " + states[row][column + 1]);
                        // Print Flower information
                        System.out.println("Flower: " + states[row][column + 2] + "\n");

                    } // end if

                } // end for

            } // end else

        } // end while

    } // end main
} // end class
