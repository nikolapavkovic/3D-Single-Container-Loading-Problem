package hr.Base58;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static hr.Base58.TestSCLP.*;

public class UserInputBoxGenerator implements IBoxGenerator{

    @Override
    public List<Box> getBoxes() {

        List<Box> boxes = new ArrayList<>(0);


        Scanner dataScanner = new Scanner(System.in);


        System.out.println(ANSI_CYAN + "Please enter the number of box types: " + ANSI_RESET);

        int numOfBoxTypes=dataScanner.nextInt();

        double boxWidth, boxDepth, boxHeight;

        int sameBoxTypes;


        for(int i = 0; i<numOfBoxTypes; i++){

            System.out.println(ANSI_BLUE + "please enter the dimensions of the box type " + i + ANSI_RESET);

            System.out.println(ANSI_CYAN + "Please enter the box width: " + ANSI_RESET);
            boxWidth= dataScanner.nextDouble();

            System.out.println(ANSI_CYAN + "Please enter the box depth: " + ANSI_RESET);
            boxDepth= dataScanner.nextDouble();

            System.out.println(ANSI_CYAN + "Please enter the box height: " + ANSI_RESET);
            boxHeight= dataScanner.nextDouble();

            System.out.println("How many boxes with these dimensions do you have? ");

            sameBoxTypes = dataScanner.nextInt();

            for(int j = 0; j< sameBoxTypes; j++){

                boxes.add(new Box("Box type " + i,0,0 ,boxWidth, boxDepth, boxHeight ));

            }

        }
        return  boxes;
    }
}
