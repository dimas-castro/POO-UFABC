/**
 * Linha.
 */
public class Line extends GeometricObject {
    private Point point1;
    private Point point2;

    public Line(Point point1, Point point2) {
        setPoint1(point1);
        setPoint2(point2);
    }

    protected double length() {
        return Math.sqrt(Math.pow(point1.getXcoord() - point2.getXcoord(), 2)
            + Math.pow(point1.getYcoord() - point2.getYcoord(), 2));
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }
}
