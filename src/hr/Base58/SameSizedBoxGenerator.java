package hr.Base58;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static hr.Base58.TestSCLP.*;

public class SameSizedBoxGenerator implements IBoxGenerator{

    double width;
    double depth;
    double height;
    int numberOfBoxes;

    public void inputUserBoxData(){
        Scanner dataScanner = new Scanner(System.in);

        System.out.println(ANSI_BLUE + "please enter the dimensions of boxes to be generated"  + ANSI_RESET);

        System.out.println(ANSI_CYAN + "Please enter the box width: " + ANSI_RESET);
        width= dataScanner.nextDouble();

        System.out.println(ANSI_CYAN + "Please enter the box depth: " + ANSI_RESET);
        depth= dataScanner.nextDouble();

        System.out.println(ANSI_CYAN + "Please enter the box height: " + ANSI_RESET);
        height= dataScanner.nextDouble();

        System.out.println(ANSI_CYAN + "Please enter the number of boxes to generate: " + ANSI_RESET);
        numberOfBoxes= dataScanner.nextInt();

    }
    @Override
    public List<Box> getBoxes() {

        inputUserBoxData();

        List<Box> boxes = new ArrayList<>(0);

        for (int i = 0; i < numberOfBoxes; i++) {

            boxes.add(new Box("Box type 0" , 0, 0, width, depth, height));

        }

        return boxes;

    }

}
