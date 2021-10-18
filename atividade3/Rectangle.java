/**
 * Axis-aligned rectangle abstraction.
 */
public class Rectangle {
    private final double xx;
    private final double yy;
    private final double width;
    private final double height;

    /**
     * Constructor.
     * @param xx the center x-coordinate
     * @param yy the center y-coordinate
     * @param width the width
     * @param height the height
     */
    public Rectangle(double xx, double yy, double width, double height) {
        this.xx = xx;
        this.yy = yy;
        this.width = width;
        this.height = height;
    }

    /**
     * Computer the area of the rectangle.
     * @return the area
     */
    public double area() {
        // TODO: Completar
        return this.height * this.width;
    }

    /**
     * Computes the perimeter of the rectangle.
     * @return the perimeter
     */
    public double perimeter() {
        // TODO: Completar
        return 2 * this.height + 2 * this.width;
    }

    /**
     * Checks if the argument intersects with
     * this rectangle.
     * @param b the other rectangle
     * @return true if there is intersection, false otherwise
     */
    public boolean intersects(Rectangle b) {
        // TODO: Completar
        double x1 = this.xx - (this.width / 2);
        double x2 = b.xx - (b.width / 2);
        double y1 = this.yy + (this.height / 2);
        double y2 = b.yy + (b.height / 2);
        if (x1 >= x2 + b.width){
            return false;
        }
        if (x2 >= x1 + this.width) {
            return false;
        }
        if (y1 <= (y2 - b.height)){
            return false;
        }
        return !(y2 <= (y1 - this.height));
    }

    /**
     * Check if the argument is inside this rectangle.
     * @param b the other rectangle
     * @return true if it is contained, false otherwise
     */
    public boolean contains(Rectangle b) {
        // TODO: Completar
        if (b.yy + b.height / 2 <= this.yy + this.height / 2 && b.yy - b.height / 2 >= this.yy - this.height / 2){
            return b.xx - b.width / 2 >= this.xx - this.width / 2
                && b.xx + b.width / 2 <= this.xx + this.width / 2;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Rectangle{"
            + "x=" + xx
            + ", y=" + yy
            + ", width=" + width
            + ", height=" + height
            + '}';
    }
}
