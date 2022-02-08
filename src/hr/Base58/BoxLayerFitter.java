package hr.Base58;
import java.util.List;

public class BoxLayerFitter implements IBoxFitter {

        private final Box root;
        private final double maxHeight;

        public BoxLayerFitter(double width, double depth, double maxHeight) {

            this.maxHeight=maxHeight;
            root = new Box(0, 0, width, depth);

        }


        public void fit(List<Box> boxes) {
            Box box;
            Box freeSpaceBox;

            for (Box value : boxes) {

                freeSpaceBox = value;

                box= this.findNode(this.root, freeSpaceBox.getWidth(), freeSpaceBox.getDepth());

                if (box != null && freeSpaceBox.getHeight() <= getMaxHeight()) {

                    freeSpaceBox.placeBox(this.splitNode(box, freeSpaceBox.getWidth(), freeSpaceBox.getDepth()));

                    if (box.isRoot()) {
                        freeSpaceBox.getPlacedBox().setAsRoot();
                    }
                }
            }
        }


        public Box findNode(Box root, double width, double depth) {

            if (!root.isFreeSpaceBox()) {

                Box right = findNode(root.getRight(), width, depth);
                return (right != null ? right : findNode(root.getDown(), width, depth));

            } else if ((depth <= root.getDepth()) && (width <= root.getWidth())) {
                return root;
            } else {
                return null;
            }
        }

        public Box splitNode(Box box, double width, double depth) {

            box.setAsUsedSpaceBox();

            box.setDown(new Box(box.getOriginX(), box.getOriginZ() + depth, box.getWidth(),
                    box.getDepth() - depth));

            box.setRight(new Box(box.getOriginX() + width, box.getOriginZ(),
                    box.getWidth() - width, depth));
            return box;
        }


    public double getMaxHeight() {
        return maxHeight;
    }

}
