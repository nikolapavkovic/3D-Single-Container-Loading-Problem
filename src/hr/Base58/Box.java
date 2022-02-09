package hr.Base58;

public class Box {

    private final double depth;
    private final double width;
    private final double height;

    //defines the origin coordinates of a box
    private final double originX;
    private final double originZ;

    //denotes the root box of the box tree
    private boolean isRoot = false;

    private final String id;

    //by default the box is a "freeSpaceBox" which denotes a free space that can be occupied by a non-freeSpaceBox
    private boolean freeSpaceBox = true;

    //free space boxes to the right and down in a 2d plane
    private Box right = null;
    private Box down = null;

    //defines the box placed in the freeSpaceBox space
    private Box placedBox = null;


    public Box(String id, double originX, double originZ, double width, double depth, double height) {

        this.id=id;
        this.originX=originX;
        this.originZ=originZ;
        this.depth=depth;
        this.width=width;
        this.height=height;

    }




    @Override
    public String toString() {
        return  id + " details:" +
                ", width=" + width +
                ", height=" + height +
                "  depth=" + depth +
                ", box placed at " + "("+placedBox.originX +", "+ placedBox.originZ + ")"
                 + " in current layer" + ',' ;
    }


    //accessors and setters
    public boolean isRoot() {

        return isRoot;

    }

    public void setAsRoot() {

        isRoot = true;

    }

    public String getId() {

        return id;

    }

    public double getOriginX() {

        return originX;

    }

    public double getOriginZ() {

        return originZ;

    }

    public double getDepth() {

        return depth;

    }

    public double getWidth() {

        return width;

    }

    public double getHeight() {

        return height;

    }

    public boolean isFreeSpaceBox() {

        return freeSpaceBox;

    }

    public void setAsUsedSpaceBox(){

        freeSpaceBox=false;

    }

    public Box getRight() {

        return right;

    }

    public void setRight(Box right) {

        this.right = right;

    }

    public Box getDown() {

        return down;

    }

    public void setDown(Box down) {

        this.down = down;

    }

    public Box getPlacedBox() {

        return placedBox;

    }

    public void placeBox(Box box) {

        this.placedBox = box;

    }

}
