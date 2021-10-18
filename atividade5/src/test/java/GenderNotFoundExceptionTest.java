import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test whether GenderNotFoundException is thrown at the proper places.
 */
public class GenderNotFoundExceptionTest extends GenericExceptionTest {
    private static final Class<GenderNotFoundException> exception = GenderNotFoundException.class;

    @Test
    public void doesNotThrowAtGetRanking() {
        final char[] genders = new char[]{'m', 'M', 'f', 'F'};
        final String[] names = new String[]{"Jacob", "Jacob", "Emma", "Emma"};
        final var year = 2001;

        for (int i = 0; i < genders.length; i++) {
            final var gender = genders[i];
            final var name = names[i];

            Assertions.assertDoesNotThrow(
                () -> namesPopularity.getRank(year, gender, name),
                buildNotThrowMessage(year, gender, name));
        }
    }

    @Test
    public void throwsAtGetRanking() {
        final var year = 2001;
        final var name = "Emily";

        for (int i = 0; i < 256; i++) {
            final char gender = (char) i;
            if (Character.toUpperCase(gender) != 'M' && Character.toUpperCase(gender) != 'F') {
                Assertions.assertThrows(exception,
                    () -> namesPopularity.getRank(year, gender, name),
                    buildThrowMessage(exception.getName(), year, gender, name));
            }
        }
    }

    @Test
    public void throwsAtGetCount() {
        final var name = "Emily";
        final var year = 2001;

        for (int i = 0; i < 256; i++) {
            final char gender = (char) i;
            if (Character.toUpperCase(gender) != 'M' && Character.toUpperCase(gender) != 'F') {
                Assertions.assertThrows(exception,
                    () -> namesPopularity.getCount(year, gender, name),
                    buildThrowMessage(exception.getName(), year, gender, name));
            }
        }
    }

    @Test
    public void doesNotThrowAtGetCount() {
        final var fixedYear = 2001;
        final char[] genders = new char[]{'m', 'M', 'f', 'F'};
        final String[] names = new String[]{"Jacob", "Jacob", "Emma", "Emma"};

        for (int i = 0; i < genders.length; i++) {
            final var gender = genders[i];
            final var name = names[i];
            Assertions.assertDoesNotThrow(
                () -> namesPopularity.getCount(fixedYear, gender, name),
                buildNotThrowMessage(fixedYear, gender, name));
        }
    }

    @Test
    public void doesNotThrowAtGetTotal() {
        final var year = 2001;

        for (var gender: new char[]{'m', 'f', 'M', 'F'}) {
            Assertions.assertDoesNotThrow(() -> namesPopularity.getTotal(year, gender),
                buildNotThrowMessage(year, gender));
        }
    }

    @Test
    public void throwsAtGetTotal() {
        final var year = 2001;

        for (int i = 0; i < 256; i++) {
            final char gender = (char) i;
            if (Character.toUpperCase(gender) != 'M' && Character.toUpperCase(gender) != 'F') {
                Assertions.assertThrows(exception,
                    () -> namesPopularity.getTotal(year, gender),
                    buildThrowMessage(exception.getName(), year, gender));
            }
        }
    }

    @Test
    public void doesNotThrowAtTopK() {
        final var k = 1;
        final var years = new int[]{2001};
        final var genders = new char[]{'m', 'M', 'f', 'F'};

        for (var gender: genders) {
            Assertions.assertDoesNotThrow(
                () -> namesPopularity.getTopK(k, years, gender),
                buildNotThrowMessage(k, years, gender));
        }
    }

    @Test
    public void throwsAtTopK() {
        final var k = 1;
        final var years = new int[]{2001};

        for (int i = 0; i < 256; i++) {
            final char gender = (char) i;
            if (Character.toUpperCase(gender) != 'M' && Character.toUpperCase(gender) != 'F') {
                Assertions.assertThrows(exception,
                    () -> namesPopularity.getTopK(k, years, gender),
                    buildThrowMessage(exception.getName(), k, years, gender));
            }
        }
    }

    @Test
    public void doesNotThrowAtExport() {
        final var year = 2001;
        final var genders = new char[]{'m', 'f', 'M', 'F'};
        try {
            var tempPath = Files.createTempFile("", "");

            for (var gender : genders) {
                Assertions.assertDoesNotThrow(
                    () -> namesPopularity.export(year, gender, tempPath.toString()),
                    buildNotThrowMessage(year, gender, tempPath));
            }
        } catch (IOException e) {
            System.err.println("Failed to create temp file during tests");
            e.printStackTrace();
        }
    }

    @Test
    public void throwsAtExport() {
        final var year = 2001;

        try {
            final var tempPath = Files.createTempFile("", "");

            for (int i = 0; i < 256; i++) {
                final char gender = (char) i;
                if (Character.toUpperCase(gender) != 'M' && Character.toUpperCase(gender) != 'F') {
                    Assertions.assertThrows(exception,
                        () -> namesPopularity.export(year, gender, tempPath.toString()),
                        buildThrowMessage(exception.getName(), year, gender, tempPath));
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to create temp file during tests");
            e.printStackTrace();
        }
    }
}
