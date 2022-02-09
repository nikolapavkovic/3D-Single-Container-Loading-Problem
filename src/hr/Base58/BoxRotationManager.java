package hr.Base58;

import java.util.ArrayList;
import java.util.List;

public  class  BoxRotationManager {


    //if any dimensions of a box cannot fit in (spaceWidth,spaceDepth, maxHeight) defined space return false
    public static boolean canFit(Box box, double spaceWidth, double spaceDepth, double maxHeight){

        return !(box.getWidth()>spaceWidth || box.getWidth()> maxHeight || box.getWidth()>spaceDepth
                || box.getHeight()>spaceWidth || box.getHeight()> maxHeight || box.getHeight()>spaceDepth
                  || box.getDepth()>spaceWidth || box.getDepth()> maxHeight|| box.getDepth()>spaceDepth);

    }

    //The subSpaceFitabilityIndex is defined as the percentage of the subspace area a box occupies.
    //Since we want to define the subSpaceFitabilityIndex as a higher-is-better term, we substract it from 1.
    public static double getSubSpaceFitabilityIndex(Box box, double spaceWidth, double spaceDepth){

        return 1-(box.getWidth()* box.getDepth()/(spaceWidth*spaceDepth));

    }

    public static Box getOptimalRotation(Box box, double spaceWidth, double spaceDepth, double maxHeight ){

        List<Box> boxRotations=getRotations(box);

        List<Box> fittableRotations=new ArrayList<>(0);

        for (Box boxRotation:boxRotations) {
                //Add only boxes which can fit in the subspace
                if(canFit(boxRotation, spaceWidth, spaceDepth, maxHeight)){

                    fittableRotations.add(boxRotation);

                }

        }

        Box optimalBoxRotation=box;
        double optimalFitabilityIndex=0;
        double currentFitabilityIndex;

        //Finds the best fitting box for a subspace (see getSubSpaceFitability method).
        for (Box fittableRotation: fittableRotations) {

            currentFitabilityIndex=getSubSpaceFitabilityIndex(fittableRotation, spaceWidth, spaceDepth);

            if(currentFitabilityIndex>=optimalFitabilityIndex){

                optimalFitabilityIndex=currentFitabilityIndex;
                optimalBoxRotation=fittableRotation;

            }
        }

    return optimalBoxRotation;

    }

    //Returns all possible basic rotations of a box
    public static List<Box> getRotations(Box box){

            List<Box> boxRotations = new ArrayList<>();

            //Since every box has 6 basic rotations (rotations resulting from 90° shifts at a time ), we add every rotation to the list
            //by permuting the dimensions
            boxRotations.add(box);
            boxRotations.add(new Box( box.getId(), box.getOriginX(), box.getOriginZ(),box.getWidth(), box.getDepth(), box.getHeight() ));
            boxRotations.add(new Box(box.getId(),box.getOriginX(), box.getOriginZ(), box.getHeight(), box.getWidth(), box.getDepth() ));
            boxRotations.add(new Box(box.getId(), box.getOriginX(), box.getOriginZ(),box.getHeight(),box.getDepth(), box.getWidth() ));
            boxRotations.add(new Box(box.getId(),box.getOriginX(), box.getOriginZ(), box.getDepth(),box.getWidth(), box.getHeight() ));
            boxRotations.add(new Box(box.getId(),box.getOriginX(), box.getOriginZ(), box.getDepth(),box.getHeight(), box.getWidth() ));


        return boxRotations;
    }
}
