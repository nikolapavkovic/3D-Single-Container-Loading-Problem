package hr.Base58;

import java.util.ArrayList;
import java.util.List;

public class RandomBoxGenerator {


    public static List<Box> generateRandomBoxes(int boxNumber, double maxWidth, double maxDepth, double maxHeight, RandomDoubleGenerator randomGenerator) {

        List<Box> boxes= new ArrayList<>(0);

        for(int i=0; i<boxNumber; i++){

            boxes.add(new Box( "box " + i,0,0, randomGenerator.nextDouble(maxWidth) ,randomGenerator.nextDouble(maxDepth),
                    randomGenerator.nextDouble(maxHeight)) );

        }

        return boxes;

    }
}
