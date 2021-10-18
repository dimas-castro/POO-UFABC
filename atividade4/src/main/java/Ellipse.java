/**
 * Elipse.
 */
public class Ellipse extends Shape {
    protected Point center;
    protected double semiMinorAxis;
    protected double semiMajorAxis;

    /**
     * Construtor Elipse.
     * @param center centro da elipse
     * @param semiMinorAxis menor semieixo
     * @param semiMajorAxis maior semieixo
     */
    public Ellipse(Point center, double semiMinorAxis, double semiMajorAxis) {
        setCenter(center);
        setSemiMinorAxis(semiMinorAxis);
        setSemiMajorAxis(semiMajorAxis);
    }

    @Override
    protected double perimeter() {
        return 2 * Math.PI * Math.sqrt((Math.pow(semiMajorAxis, 2)
            + Math.pow(semiMinorAxis, 2)) / 2);
    }

    @Override
    protected double area() {
        return Math.PI * semiMajorAxis * semiMinorAxis;
    }

    @Override
    protected double width() {
        return 2 * semiMajorAxis;
    }

    @Override
    protected double height() {
        return 2 * semiMinorAxis;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }

    public void setSemiMinorAxis(double semiMinorAxis) {
        this.semiMinorAxis = semiMinorAxis;
    }

    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }
}
