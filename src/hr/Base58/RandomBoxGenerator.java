package hr.Base58;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static hr.Base58.TestSCLP.*;

public class RandomBoxGenerator implements IBoxGenerator {

    IRandomGenerator randomGenerator;

    double maxWidth;
    double maxDepth;
    double maxHeight;
    double minWidth;
    double minDepth;
    double minHeight;
    int numberOfBoxes;

    public RandomBoxGenerator(IRandomGenerator randomGenerator){

        this.randomGenerator=randomGenerator;

    }

    public void inputUserBoxData(){

        Scanner dataScanner = new Scanner(System.in);

        System.out.println(ANSI_BLUE + "please enter the minimum dimensions of a randomly generated box"  + ANSI_RESET);

        System.out.println(ANSI_CYAN + "Please enter the minimum box width: " + ANSI_RESET);
        minWidth= dataScanner.nextDouble();

        System.out.println(ANSI_CYAN + "Please enter the minimum box depth: " + ANSI_RESET);
        minDepth= dataScanner.nextDouble();

        System.out.println(ANSI_CYAN + "Please enter the minimum box height: " + ANSI_RESET);
        minHeight= dataScanner.nextDouble();

        System.out.println(ANSI_BLUE + "please enter the maximum dimensions of a randomly generated box"  + ANSI_RESET);

        System.out.println(ANSI_CYAN + "Please enter the maximum box width: " + ANSI_RESET);
        maxWidth= dataScanner.nextDouble();

        System.out.println(ANSI_CYAN + "Please enter the maximum box depth: " + ANSI_RESET);
        maxDepth= dataScanner.nextDouble();

        System.out.println(ANSI_CYAN + "Please enter the maximum box height: " + ANSI_RESET);
        maxHeight= dataScanner.nextDouble();

        System.out.println(ANSI_CYAN + "Please enter the number of boxes to generate: " + ANSI_RESET);
        numberOfBoxes= dataScanner.nextInt();

    }

    public List<Box> getBoxes() {

        inputUserBoxData();

        List<Box> boxes= new ArrayList<>(0);

        for(int i=0; i<numberOfBoxes; i++){

            boxes.add(new Box( "box " + i,0,0, randomGenerator.nextDouble(minWidth, maxWidth),
                    randomGenerator.nextDouble(minDepth, maxDepth), randomGenerator.nextDouble(minHeight, maxHeight)) );

        }

        return boxes;

    }
}
