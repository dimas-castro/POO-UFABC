import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test whether IOException is being thrown in the proper places.
 */
public class InputOuputExceptionTest extends GenericExceptionTest {
    private static final int year  = 2001;
    private static final char gender = 'm';
    private static final Class<IOException> exception = IOException.class;

    @Test
    public void throwsAtExport() {
        final var fakePath = Path.of("random/path/does/not/exist.csv");

        Assertions.assertThrows(exception,
            () -> namesPopularity.export(year, gender, fakePath.toString()),
            buildThrowMessage(exception.getName(), year, gender, fakePath));
    }

    @Test
    public void doesNotThrowAtExport() {
        try {
            var tempPath = Files.createTempFile("", "");

            Assertions.assertDoesNotThrow(
                () -> namesPopularity.export(year, gender, tempPath.toString()),
                buildNotThrowMessage(year, gender, tempPath));
        } catch (IOException e) {
            System.err.println("Failed to create temp file during tests");
            e.printStackTrace();
        }
    }
}
