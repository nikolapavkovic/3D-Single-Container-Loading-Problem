package hr.Base58;

public class Container {

    private final double width;
    private final double height;
    private final double depth;

    public Container(double width, double depth,  double height) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }


    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }

}
