package hr.Base58;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class BoxLayerStacker {


    private final List<List<Box>> layers;
    private final List<Box> boxes;
    private final List<Box> placedBoxes;


    public BoxLayerStacker(List<Box> boxes){

        this.boxes=boxes;
        layers=new ArrayList<>(0);
        placedBoxes= new ArrayList<>(0);

    }


    public List<List<Box>> stackLayers(Container container){

        //defines the maximum height of the current layer in context.
        double maxLayerHeight = container.getHeight();

        int boxHeightSum=0;
        int layerIndex=0;

        //Generate a new "2D" layer (plane with height boundary) every time a layer is filled.
        //The program stacks the "2D" layers on top of each other to form a 3D object, essentially, a filled container.
        while (!boxes.isEmpty()) {

            BoxLayerFitter boxLayerFitter = new BoxLayerFitter(container.getWidth(), container.getDepth(), boxes.get(0).getHeight());

            boxHeightSum+=boxes.get(0).getHeight();

            if(boxHeightSum > maxLayerHeight ) break;

            //Adds each layer (a list of placed boxes) to layer list.
            layers.add(new ArrayList<>());

            boxLayerFitter.fit(boxes);

            ListIterator<Box> boxIterator = boxes.listIterator();

            while (boxIterator.hasNext()) {

                Box box = boxIterator.next();

                if (box.getPlacedBox() != null) {

                    placedBoxes.add((box));

                    //Adds placed boxes to
                    layers.get(layerIndex).add(box);

                    //Remove box from list when placed in a freeSpaceBox space.
                    boxIterator.remove();
                }
            }
            layerIndex++;
        }
        return layers;
    }


    public int getNumberOfPlacedBoxes(){
        return placedBoxes.size();
    }
}
