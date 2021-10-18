/**
 * retangulo.
 */
public class Rectangle extends Quadrilateral {
    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    @Override
    protected double width() {
        return distancia(p4, p3);
    }

    @Override
    double height() {
        return distancia(p1, p4);
    }

    boolean isSquare() {
        return width() - height() <= 0.001 && width() - height() >= -0.001;
    }
}
