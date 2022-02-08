package hr.Base58;

import java.util.*;

public class TestSCLP {

    //ANSI Escape codes for color coding the console output (if supported)
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        Container container= new Container(600.18,600,1000);

        List<Box> boxes =RandomBoxGenerator.generateRandomBoxes(51,100,100,500,
               RandomDoubleGenerator.getInstance());
        System.out.println(boxes.get(0).getWidth());
/*
        boxes.add(new Box("Figure1", 1, 1, 1));
        boxes.add(new Box("Figure3", 1, 1, 1));
        boxes.add(new Box("Figure1", 1, 1, 1));
        boxes.add(new Box("Figure1", 1, 1, 1));
        boxes.add(new Box("Figure1", 1, 1, 1));
        boxes.add(new Box("Figure1", 1, 1, 1));

 */



        boxes.sort(new WidthComparator());

        List<Box> boxes1 = new ArrayList<>(boxes);

        BoxLayerStacker boxLayerStacker= new BoxLayerStacker(boxes1);


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



    }


}
