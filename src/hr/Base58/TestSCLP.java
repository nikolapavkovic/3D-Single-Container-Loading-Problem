package hr.Base58;

import java.util.*;

public class TestSCLP {

    //ANSI Escape codes for color coding the console output (if supported)
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";


    public static  void fitBoxesFromUserInput(){

        List<Box> boxes =new ArrayList<>(0);

        Scanner dataScanner = new Scanner(System.in);

        System.out.println( ANSI_BLUE + "Please enter the container dimensions " + ANSI_RESET);

        System.out.println(ANSI_CYAN + "Please enter the container width: " + ANSI_RESET);
        double containerWidth= dataScanner.nextDouble();

        System.out.println( ANSI_CYAN + "Please enter the container depth: " + ANSI_RESET);
        double containerDepth= dataScanner.nextDouble();

        System.out.println( ANSI_CYAN +"Please enter the container height: " + ANSI_RESET);
        double containerHeight= dataScanner.nextDouble();

        Container container= new Container(containerWidth,containerDepth,containerHeight);

        System.out.println(ANSI_CYAN + "Please enter the number of box types: " + ANSI_RESET);

        int numOfBoxTypes=dataScanner.nextInt();

        double boxWidth, boxDepth, boxHeight;

        int sameBoxTypes;


        for(int i = 0; i<numOfBoxTypes; i++){

            System.out.println(ANSI_BLUE + "please enter the dimensions of the box number " + i + ANSI_RESET);

            System.out.println(ANSI_CYAN + "Please enter the box width: " + ANSI_RESET);
            boxWidth= dataScanner.nextDouble();

            System.out.println(ANSI_CYAN + "Please enter the box depth: " + ANSI_RESET);
            boxDepth= dataScanner.nextDouble();

            System.out.println(ANSI_CYAN + "Please enter the box height: " + ANSI_RESET);
            boxHeight= dataScanner.nextDouble();

            System.out.println("How many boxes with these dimensions do you have? ");

            sameBoxTypes = dataScanner.nextInt();

            for(int j = 0; j< sameBoxTypes; j++){

            boxes.add(new Box("Box type "+ i,0,0 ,boxWidth, boxDepth, boxHeight ));

            }

        }

        BoxLayerStacker boxLayerStacker= new BoxLayerStacker(boxes);

        List<List<Box>> layers =boxLayerStacker.stackLayers(container);

        int layerIndex = 0;

        for (List<Box> layer: layers) {

            System.out.println(ANSI_GREEN + "-----------------------------layer "+ ++layerIndex + "-----------------------------\n" + ANSI_RESET);

            for (Box box: layer) {

                System.out.println(box.toString()+"\n");

            }

        }

        System.out.println(ANSI_GREEN + "Box fitting complete, the total amount of placed boxes is: " + boxLayerStacker.getNumberOfPlacedBoxes() + ANSI_RESET);

        System.out.println();

    }


    public static  void fitRandomBoxes(){

        double maxWidth, maxDepth, maxHeight;

        Scanner dataScanner = new Scanner(System.in);

        System.out.println( ANSI_BLUE + "Please enter the container dimensions " + ANSI_RESET);

        System.out.println(ANSI_CYAN + "Please enter the container width: " + ANSI_RESET);
        double containerWidth= dataScanner.nextDouble();

        System.out.println( ANSI_CYAN + "Please enter the container depth: " + ANSI_RESET);
        double containerDepth= dataScanner.nextDouble();

        System.out.println( ANSI_CYAN +"Please enter the container height: " + ANSI_RESET);
        double containerHeight= dataScanner.nextDouble();

        Container container= new Container(containerWidth,containerDepth,containerHeight);

        System.out.println(ANSI_BLUE + "please enter the maximum dimensions of a randomly generated box"  + ANSI_RESET);

        System.out.println(ANSI_CYAN + "Please enter the maximum box width: " + ANSI_RESET);
        maxWidth= dataScanner.nextDouble();

        System.out.println(ANSI_CYAN + "Please enter the maximum box depth: " + ANSI_RESET);
        maxDepth= dataScanner.nextDouble();

        System.out.println(ANSI_CYAN + "Please enter the maximum box height: " + ANSI_RESET);
        maxHeight= dataScanner.nextDouble();

        System.out.println(ANSI_CYAN + "Please enter the number of boxes to generate: " + ANSI_RESET);
        int numberOfBoxes= dataScanner.nextInt();

        List<Box> boxes =RandomBoxGenerator.generateRandomBoxes(numberOfBoxes, maxWidth, maxDepth, maxHeight, RandomDoubleGenerator.getInstance());

        System.out.println("Generated boxes:\n");
        for (Box box:boxes) {
            System.out.println(box.toString());
        }


        BoxLayerStacker boxLayerStacker= new BoxLayerStacker(boxes);

        List<List<Box>> layers =boxLayerStacker.stackLayers(container);


        int layerIndex = 0;

        for (List<Box> layer: layers) {

            System.out.println(ANSI_GREEN + "-----------------------------layer "+ ++layerIndex + "-----------------------------\n" + ANSI_RESET);

            for (Box box: layer) {

                System.out.println(box.toString()+"\n");

            }

        }

        System.out.println(ANSI_GREEN + "Box fitting complete, the total amount of placed boxes is: " + boxLayerStacker.getNumberOfPlacedBoxes() + ANSI_RESET);

        System.out.println();


    }

    public static  void fitSameSizedBoxes(){

    }




    public static void main(String[] args) {


        fitRandomBoxes();
        //fitBoxesFromUserInput();



        /*Container container= new Container(600.18,600,1000);

        List<Box> boxes =new ArrayList<>(0);
        //RandomBoxGenerator.generateRandomBoxes(51,100,100,500,
        //  RandomDoubleGenerator.getInstance());


        boxes.add(new Box("Figure1", 0,0,600, 600, 500));
        //boxes.add(new Box("Figure2", 0,0,590, 400, 400));
        boxes.add(new Box("Figure3", 0,0, 100, 100, 500));






 /*
        Scanner dataScanner = new Scanner(System.in);
        System.out.println("Please enter the number of box types: ");
        int numOfBoxTypes=dataScanner.nextInt();

        double X,Y,Z;

        int sameBoxTypes;

        int boxID;

        for(int i = 0; i<numOfBoxTypes; i++){
            boxID=i+1;
            System.out.println("please enter the dimensions of the box number " + boxID);
            X= dataScanner.nextDouble();
            Y= dataScanner.nextDouble();
            Z= dataScanner.nextDouble();
            System.out.println("How many boxes with these dimensions do you have? ");
            int numOfBoxType = dataScanner.nextInt();
            boxes.add(new Box("Box "+ i ,X, Y, Z ));

        }





     //   boxes.sort(new WidthComparator());

       // List<Box> boxes1 = new ArrayList<>(boxes);

       // BoxLayerStacker boxLayerStacker= new BoxLayerStacker(boxes1);


        List<List<Box>> layers =boxLayerStacker.stackLayers(container);

        int layerIndex=0;
        for (List<Box> layer: layers) {

            System.out.println(ANSI_GREEN + "-----------------------------layer "+ ++layerIndex + "-----------------------------\n" + ANSI_RESET);

            for (Box box: layer) {
                System.out.println(box.toString()+"\n");
            }
        }
        System.out.println(ANSI_GREEN+"Box fitting complete, the total amount of placed boxes is: " + boxLayerStacker.getNumberOfPlacedBoxes()+ANSI_RESET);
        System.out.println();



*/
    }

}
