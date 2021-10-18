/**
 * paralelogramo.
 */
public class Paralelogram extends Quadrilateral {
    public Paralelogram(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    @Override
    protected double width() {
        return distancia(p4, p3);
    }

    @Override
    double height() {
        Point teste = new Point(p2.getXcoord(), p3.getYcoord());
        return distancia(teste, p2);
    }
}
