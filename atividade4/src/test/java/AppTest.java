import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * All autograding tests.
 */
public class AppTest {
    private static final String baseDir = "src/test/resources/";
    private static final String circlesFile = baseDir + "circles.txt";
    private static final String ellipsesFile = baseDir + "ellipses.txt";
    private static final String linesFile = baseDir + "lines.txt";
    private static final String parallelogramsFile = baseDir + "parallelograms.txt";
    private static final String rectanglesFile = baseDir + "rectangles.txt";
    private static final String squaresFile = baseDir + "squares.txt";
    private static final String trianglesFile = baseDir + "triangles.txt";

    private static final double delta = 0.001;

    @Test
    public void testCircles() {
        try (var scanner = new Scanner(new File(circlesFile))) {
            while (scanner.hasNext()) {
                var center = new Point(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                var radius = Double.parseDouble(scanner.next());
                var circle = new Circle(center, radius);
                var width = Double.parseDouble(scanner.next());
                var height = Double.parseDouble(scanner.next());
                var area = Double.parseDouble(scanner.next());
                var perimeter = Double.parseDouble(scanner.next());

                Assertions.assertEquals(width, circle.width(), delta,
                    "Circle width doesn't match. " + circle);
                Assertions.assertEquals(height, circle.height(), delta,
                    "Circle height doesn't match. " +  circle);
                Assertions.assertEquals(area, circle.area(), delta,
                    "Circle area doesn't match. " + circle);
                Assertions.assertEquals(perimeter, circle.perimeter(), delta,
                    "Circle perimeter doesn't match. " + circle);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open circles case file");
            e.printStackTrace();
        }
    }

    @Test
    public void testEllipses() {
        try (var scanner = new Scanner(new File(ellipsesFile))) {
            while (scanner.hasNext()) {
                var center = new Point(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                var semiMajorAxis = Double.parseDouble(scanner.next());
                var semiMinorAxis = Double.parseDouble(scanner.next());
                var ellipse = new Ellipse(center, semiMinorAxis, semiMajorAxis);
                var width = Double.parseDouble(scanner.next());
                var height = Double.parseDouble(scanner.next());
                var area = Double.parseDouble(scanner.next());
                var perimeter = Double.parseDouble(scanner.next());

                Assertions.assertEquals(width, ellipse.width(), delta,
                    "Ellipse width doesn't match. " + ellipse);
                Assertions.assertEquals(height, ellipse.height(), delta,
                    "Circle height doesn't match. " + ellipse);
                Assertions.assertEquals(area, ellipse.area(), delta,
                    "Circle area doesn't match. " + ellipse);
                Assertions.assertEquals(perimeter, ellipse.perimeter(), delta,
                    "Ellipse perimeter doesn't match. " + ellipse);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open ellipses case file");
            e.printStackTrace();
        }
    }

    @Test
    public void testLines() {
        try (var scanner = new Scanner(new File(linesFile))) {
            while (scanner.hasNext()) {
                var point1 = new Point(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                var point2 = new Point(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                var line = new Line(point1, point2);
                var length = Double.parseDouble(scanner.next());


                Assertions.assertEquals(length, line.length(), delta,
                    "Line length doesn't match. " + line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open lines case file");
            e.printStackTrace();
        }
    }

    @Test
    public void testParallelograms() {
        try (var scanner = new Scanner(new File(parallelogramsFile))) {
            while (scanner.hasNext()) {
                var point1 = new Point(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                var point2 = new Point(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                var point3 = new Point(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                var point4 = new Point(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                var parallelogram = new Paralelogram(point1, point2, point3, point4);
                var width = Double.parseDouble(scanner.next());
                var height = Double.parseDouble(scanner.next());
                var area = Double.parseDouble(scanner.next());
                var perimeter = Double.parseDouble(scanner.next());


                Assertions.assertEquals(width, parallelogram.width(), delta,
                    "Parallelogram width doesn't match. " + parallelogram);
                Assertions.assertEquals(height, parallelogram.height(), delta,
                    "Parallelogram height doesn't match. " + parallelogram);
                Assertions.assertEquals(area, parallelogram.area(), delta,
                    "Parallelogram area doesn't match. " + parallelogram);
                Assertions.assertEquals(perimeter, parallelogram.perimeter(), delta,
                    "Parallelogram perimeter doesn't match. " + parallelogram);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open parallelogram case file");
            e.printStackTrace();
        }
    }

    @Test
    public void testRectangles() {
        String[] files = new String[]{rectanglesFile, squaresFile};

        for (var file : files) {
            try (var scanner = new Scanner(new File(file))) {
                while (scanner.hasNext()) {
                    var point1 = new Point(Double.parseDouble(scanner.next()),
                        Double.parseDouble(scanner.next()));
                    var point2 = new Point(Double.parseDouble(scanner.next()),
                        Double.parseDouble(scanner.next()));
                    var point3 = new Point(Double.parseDouble(scanner.next()),
                        Double.parseDouble(scanner.next()));
                    var point4 = new Point(Double.parseDouble(scanner.next()),
                        Double.parseDouble(scanner.next()));
                    var rectangle = new Rectangle(point1, point2, point3, point4);
                    var width = Double.parseDouble(scanner.next());
                    var height = Double.parseDouble(scanner.next());
                    var area = Double.parseDouble(scanner.next());
                    var perimeter = Double.parseDouble(scanner.next());
                    var isSquare = Boolean.parseBoolean(scanner.next());


                    Assertions.assertEquals(width, rectangle.width(), delta,
                        "Rectangle width doesn't match. " + rectangle);
                    Assertions.assertEquals(height, rectangle.height(), delta,
                        "Rectangle height doesn't match. " + rectangle);
                    Assertions.assertEquals(area, rectangle.area(), delta,
                        "Rectangle area doesn't match."  + rectangle);
                    Assertions.assertEquals(perimeter, rectangle.perimeter(), delta,
                        "Rectangle perimeter doesn't match." + rectangle);
                    Assertions.assertEquals(isSquare, rectangle.isSquare(),
                        "Rectangle square test failed. " + rectangle);

                }
            } catch (FileNotFoundException e) {
                System.err.println("Failed to open rectangle case file");
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testTriangles() {
        try (var scanner = new Scanner(new File(trianglesFile))) {
            while (scanner.hasNext()) {
                var point1 = new Point(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                var point2 = new Point(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                var point3 = new Point(Double.parseDouble(scanner.next()),
                    Double.parseDouble(scanner.next()));
                var triangle = new Triangle(point1, point2, point3);
                var width = Double.parseDouble(scanner.next());
                var height = Double.parseDouble(scanner.next());
                var area = Double.parseDouble(scanner.next());
                var perimeter = Double.parseDouble(scanner.next());


                Assertions.assertEquals(width, triangle.width(), delta,
                    "Triangle width doesn't match. " + triangle);
                Assertions.assertEquals(height, triangle.height(), delta,
                    "Triangle height doesn't match. " + triangle);
                Assertions.assertEquals(area, triangle.area(), delta,
                    "Triangle area doesn't match." + triangle);
                Assertions.assertEquals(perimeter, triangle.perimeter(), delta,
                    "Triangle perimeter doesn't match." + triangle);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open triangle case file");
            e.printStackTrace();
        }
    }

}
