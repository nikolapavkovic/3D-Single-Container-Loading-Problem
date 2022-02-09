package hr.Base58;

import java.util.Comparator;


public class WidthComparator implements Comparator<Box> {
    @Override
    public int compare(Box lhs, Box rhs) {

        return (Double.compare(lhs.getDepth(), rhs.getDepth()));

    }
}
