/**
 * triangulo.
 */
public class Triangle extends Shape {
    private Point p1;
    private Point p2;
    private Point p3;

    /**
     * construtor triangulo.
     * @param p1 ponto 1
     * @param p2 ponto 2
     * @param p3 ponto 3
     */
    public Triangle(Point p1, Point p2, Point p3) {
        setP1(p1);
        setP2(p2);
        setP3(p3);
    }

    @Override
    protected double perimeter() {
        return distancia(p1, p2) + distancia(p2, p3) + distancia(p3, p1);
    }

    @Override
    protected double width() {
        return distancia(p2, p3);
    }

    @Override
    protected double area() {
        return width() * height() / 2;
    }

    @Override
    protected double height() {
        Point teste = new Point(p1.getXcoord(), p2.getYcoord());
        double cateto1 = distancia(p3, teste);
        double hipotenusa = distancia(p1, p3);
        double arg = Math.pow(hipotenusa, 2) - Math.pow(cateto1, 2);
        return Math.sqrt(arg);
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
}
