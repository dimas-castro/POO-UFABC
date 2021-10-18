import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for ImageUtils.
 */
public class ImageTest {

    private static final String imagesDir = "src/test/resources/images";
    private static final String histTestCases = "src/test/resources/histogram.txt";

    @Test
    void testHistogram() {
        try (var scanner = new Scanner(new File(histTestCases))) {
            while (scanner.hasNext()) {
                var fileName = scanner.next();
                var picture = new Picture(String.format("%s/%s", imagesDir, fileName));
                var output = new int[256];
                var message = "The histogram differs from expected. Check the error details";

                for (int i = 0; i < output.length; i++) {
                    output[i] = scanner.nextInt();
                }

                var result = ImageUtils.histogram(picture);

                Assertions.assertArrayEquals(output, result, message);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open histogram test cases");
            e.printStackTrace();
        }
    }
}
