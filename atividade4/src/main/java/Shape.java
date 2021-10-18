/**
 * forma.
 */
public abstract class Shape extends GeometricObject {
    abstract double width();

    abstract double height();

    abstract double area();

    abstract double perimeter();

    protected double distancia(Point p3, Point p2) {
        return Math.sqrt(Math.pow(p3.getXcoord() - p2.getXcoord(), 2) + Math.pow(p3.getYcoord()
            - p2.getYcoord(), 2));
    }
}
