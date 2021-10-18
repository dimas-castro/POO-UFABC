import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Dna class.
 */
public class DnaTest {
    static final String watsonCrickInput = "src/test/resources/wc-complement.txt";

    @Test
    void testWatsonCrickComplement() {
        try (var scanner = new Scanner(new File(watsonCrickInput))) {
            while (scanner.hasNext()) {
                var input = scanner.next();
                var output = scanner.next();
                var result = DnaUtils.watsonCrick(input);
                var message = String.format("Watson-Crick complement of "
                        + "\"%s\" is \"%s\" not \"%s\"\n", input, output, result);

                Assertions.assertEquals(output, result, message);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open Watson Crick complement input file");
            e.printStackTrace();
        }
    }
}
