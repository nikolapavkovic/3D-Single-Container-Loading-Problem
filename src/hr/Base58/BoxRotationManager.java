package hr.Base58;

import java.util.ArrayList;
import java.util.List;

public class BoxRotationManager {


    public List<String> getTypes(List<Box> boxes){

        List<String> boxesOfType = new ArrayList<>();

        for (Box box:boxes) {
            if(!boxesOfType.contains(box.getId())){
                boxesOfType.add(box.getId());
            }
        }
        return boxesOfType;

    }
    public boolean canFit(Box box, double spaceWidth, double spaceDepth, double maxHeight){

        return !(box.getWidth()>spaceWidth || box.getWidth()> maxHeight || box.getWidth()>spaceDepth
                || box.getHeight()>spaceWidth || box.getHeight()> maxHeight || box.getHeight()>spaceDepth
                  || box.getDepth()>spaceWidth || box.getDepth()> maxHeight|| box.getDepth()>spaceDepth);

    }

    public double getSubSpaceFitabilityIndex(Box box, double spaceWidth, double spaceDepth){
        return 1-(box.getWidth()* box.getDepth())/(spaceDepth*spaceDepth);
    }

    public Box getOptimalRotation(Box box, double spaceWidth, double spaceDepth, double maxHeight ){

        List<Box> boxRotations=getRotations(box);
        List<Box> fittableRotations=new ArrayList<>(0);

        for (Box boxRotation:boxRotations) {
                if(canFit(boxRotation,spaceWidth,spaceDepth,maxHeight)){
                    fittableRotations.add(box);
                }
        }

        Box optimalBoxRotation=null;
        double optimalFitabilityIndex=0;
        double currentFitabilityIndex=0;

        for (Box fittableRotation: fittableRotations) {
            if((currentFitabilityIndex=getSubSpaceFitabilityIndex(fittableRotation, spaceWidth, spaceDepth))>optimalFitabilityIndex){
                optimalFitabilityIndex=currentFitabilityIndex;
                optimalBoxRotation=fittableRotation;
            }
        }


    return optimalBoxRotation;
    }

    public List<Box> getRotations(Box box){

            List<Box> boxRotations = new ArrayList<>();

            boxRotations.add(box);
            boxRotations.add(new Box( box.getId(),box.getWidth(), box.getDepth(), box.getHeight() ));
            boxRotations.add(new Box(box.getId(), box.getHeight(), box.getWidth(), box.getDepth() ));
            boxRotations.add(new Box(box.getId(), box.getHeight(),box.getDepth(), box.getWidth() ));
            boxRotations.add(new Box(box.getId(), box.getDepth(),box.getWidth(), box.getHeight() ));
            boxRotations.add(new Box(box.getId(), box.getDepth(),box.getHeight(), box.getWidth() ));




        return boxRotations;
    }
}
