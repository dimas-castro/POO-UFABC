/**
 * Point class.
 */
public class Point extends GeometricObject {
    private double xcoord;
    private double ycoord;

    public Point(double xcoord, double ycoord) {
        setXcoord(xcoord);
        setYcoord(ycoord);
    }

    @Override
    public String toString() {
        return "Point{"
            + "xcoord=" + xcoord
            + ", ycoord=" + ycoord
            + "} " + super.toString();
    }

    public Point(Point point) {
        this.xcoord = point.getXcoord();
        this.ycoord = point.getYcoord();
    }

    public double getXcoord() {
        return xcoord;
    }

    /**
     * Set the x coordinate to a valid value.
     * @param xcoord the x coordinate
     */
    public void setXcoord(double xcoord) {
        if (xcoord < 0 || xcoord > 1.0) {
            throw  new IllegalArgumentException("Coordinate must be in [0,1]");
        }
        this.xcoord = xcoord;
    }

    public double getYcoord() {
        return ycoord;
    }

    /**
     * Set the y coordinate to a valid value.
     * @param ycoord the y coordinate
     */
    public void setYcoord(double ycoord) {
        if (ycoord < 0 || ycoord > 1.0) {
            throw  new IllegalArgumentException("Coordinate must be in [0,1]");
        }
        this.ycoord = ycoord;
    }
}
