package hr.Base58;

import java.util.*;

public class TestSCLP {

    //ANSI Escape codes for color coding the console output (if supported)
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";


    public static void main(String[] args) {


        Scanner dataScanner = new Scanner(System.in);

        System.out.println( ANSI_BLUE + "Please enter the container dimensions " + ANSI_RESET);

        System.out.println(ANSI_CYAN + "Please enter the container width: " + ANSI_RESET);
        double containerWidth = dataScanner.nextDouble();

        System.out.println( ANSI_CYAN + "Please enter the container depth: " + ANSI_RESET);
        double containerDepth = dataScanner.nextDouble();

        System.out.println( ANSI_CYAN +"Please enter the container height: " + ANSI_RESET);
        double containerHeight = dataScanner.nextDouble();

        if(containerDepth<=0 || containerHeight<=0 || containerWidth<=0){
            System.out.println("Non-positive container dimensions values inputted. Closing Program.");
            return;
        }

        Container container = new Container(containerWidth, containerDepth, containerHeight);



        System.out.println( ANSI_BLUE +"Please enter the type of box generation.\n0 => random box generation\n1 =>" +
                                       " box generation from user input\n" +
                                       "2 => generate certain number of same-sized boxes" + ANSI_RESET);


        int boxGenerationIndex;

        do{
            boxGenerationIndex= dataScanner.nextInt();

            if(!(boxGenerationIndex>=0 && boxGenerationIndex<=2)){

                System.out.println("Please enter a valid box generation type (0 - 2) ");

            }
        }
        while(!(boxGenerationIndex >= 0 && boxGenerationIndex <= 2));

        IBoxGenerator boxGenerator;

        if(boxGenerationIndex == 0){

            boxGenerator = new RandomBoxGenerator(RandomDoubleGenerator.getInstance());

        }
        else if(boxGenerationIndex == 1){

            boxGenerator = new UserInputBoxGenerator();

        }
        else{

            boxGenerator= new SameSizedBoxGenerator();

        }

        List<Box> boxes= boxGenerator.getBoxes();

        for (Box box: boxes) {
            if(box.getWidth()<=0 || box.getHeight()<=0 || box.getDepth()<=0){
                System.out.println("Non-positive box dimensions values inputted. Closing Program.");
                return;
            }
        }




        BoxLayerStacker boxLayerStacker= new BoxLayerStacker(boxes);

        List<List<Box>> layers =boxLayerStacker.stackLayers(container);

        int layerIndex = 0;

        for (List<Box> layer: layers) {

            System.out.println(ANSI_GREEN + "-----------------------------layer "+ ++layerIndex + "-----------------------------\n" + ANSI_RESET);

            for (Box box: layer) {

                System.out.println(box.toString()+ box.getPlacementCoordinateDetails() + "\n");

            }

        }

        System.out.println(ANSI_GREEN + "Box fitting complete, the total amount of placed boxes is: " + boxLayerStacker.getNumberOfPlacedBoxes() + ANSI_RESET);

        System.out.println();
    }

}
