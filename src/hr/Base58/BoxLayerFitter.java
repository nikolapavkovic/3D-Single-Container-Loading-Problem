package hr.Base58;
import java.util.List;

public class BoxLayerFitter implements IBoxFitter {

        private final Box root;
        private final double maxHeight;

        public BoxLayerFitter(double width, double depth, double maxHeight) {

            this.maxHeight=maxHeight;

            root = new Box("root",0, 0, width, depth, 0);

        }


        public void fit(List<Box> boxes) {

            Box freeSpaceBox;
            Box boxToPlace;
            Box optimalBox;

            for (Box aBox : boxes) {

                boxToPlace = aBox;

                //optimalBox = BoxRotationManager.getOptimalRotation(this.root, boxToPlace.getWidth(), boxToPlace.getDepth(), maxHeight);
                
                freeSpaceBox = this.findSpace(this.root, boxToPlace.getWidth(), boxToPlace.getDepth());

                if (freeSpaceBox != null) {

                    boxToPlace.placeBox(this.placeAndSplitSearch(freeSpaceBox, boxToPlace.getWidth(), boxToPlace.getDepth()));

                    if (freeSpaceBox.isRoot()){

                        boxToPlace.getPlacedBox().setAsRoot();

                    }

                }
            }
        }


        public Box findSpace(Box root, double width, double depth) {

            if (!root.isFreeSpaceBox()) {

                Box right = findSpace(root.getRight(), width, depth);

                if(right!=null){

                    return right;

                }

                else{

                    return findSpace(root.getDown(), width, depth);

                }

            }
            else if ((depth <= root.getDepth()) && (width <= root.getWidth()) && root.getHeight() < maxHeight){

                return root;

            }


            else{

                return null;

            }

        }

        public Box placeAndSplitSearch(Box box, double width, double depth) {

            box.setAsUsedSpaceBox();

            box.setDown(new Box(box.getId(),box.getOriginX(), box.getOriginZ() + depth, box.getWidth(),
                    box.getDepth() - depth, box.getHeight()));

            box.setRight(new Box(box.getId(), box.getOriginX() + width, box.getOriginZ(),
                    box.getWidth() - width, depth, box.getHeight()));

            return box;
        }

}
