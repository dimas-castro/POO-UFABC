import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for UrlUtils.
 */
public class UrlTest {
    @Test
    void testReverseDomains() {
        final var reverseDomainsFile = "src/test/resources/reverse-domains.txt";

        try (var scanner = new Scanner(new File(reverseDomainsFile))) {
            while (scanner.hasNext()) {
                String input = scanner.next();
                String output = scanner.next();
                String result = UrlUtils.reverseDomainName(input);
                String message = String.format("Reverse domain of \"%s\" is \"%s\" "
                        + "and not \"%s\"\n", input, output, result);

                Assertions.assertEquals(result, output, message);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open reverse domains case file");
            e.printStackTrace();
        }
    }
}
