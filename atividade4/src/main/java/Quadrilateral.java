/**
 * quadrilatero.
 */
public abstract class Quadrilateral extends Shape {
    protected Point p1;
    protected Point p2;
    protected Point p3;
    protected Point p4;

    /**
     * Construtor quadrilatero.
     * @param p1 ponto 1
     * @param p2 ponto 2
     * @param p3 ponto 3
     * @param p4 ponto 4
     */
    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        setP1(p1);
        setP2(p2);
        setP3(p3);
        setP4(p4);
    }

    @Override
    protected double area() {
        return distancia(p4, p3) * height();
    }

    @Override
    protected double perimeter() {
        return distancia(p1, p2) + distancia(p2, p3) + distancia(p3, p4) + distancia(p4, p1);
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public Point getP4() {
        return p4;
    }

    public void setP4(Point p4) {
        this.p4 = p4;
    }
}
