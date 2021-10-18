/**
 * Circulo.
 */
public class Circle extends Ellipse {

    double radius;

    public Circle(Point center, double radius) {
        super(center, radius, radius);
        this.radius = radius;
    }

    @Override
    protected double perimeter() {
        return 2 * Math.PI * radius;
    }
}
