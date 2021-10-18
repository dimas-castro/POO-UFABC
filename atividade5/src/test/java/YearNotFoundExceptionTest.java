import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test whether NameNotFoundException is thrown at the proper places.
 */
public class YearNotFoundExceptionTest extends GenericExceptionTest {
    private static final Class<YearNotFoundException> exception = YearNotFoundException.class;

    @Test
    public void throwsAtGetRanking() {
        final var name = "Jacob";
        final var gender = 'f';

        for (var year : new int[]{-10, 0, 1000, 2000, 2011, 2020}) {
            Assertions.assertThrows(exception,
                () -> namesPopularity.getRank(year, gender, name),
                buildThrowMessage(exception.getName(), year, gender, name));
        }
    }

    @Test
    public void doesNotThrowAtGetRanking() {
        for (int year = 2001; year <= 2010; year++) {
            final int finalYear = year;
            final char[] genders = new char[]{'m', 'f'};
            final String[] names = new String[]{"Jacob", "Emma"};

            for (int i = 0; i < genders.length; i++) {
                final var gender = genders[i];
                final var name = names[i];

                Assertions.assertDoesNotThrow(
                    () -> namesPopularity.getRank(finalYear, gender, name),
                    buildNotThrowMessage(year, gender, name));
            }
        }
    }

    @Test
    public void throwsAtGetCount() {
        final var gender = 'm';
        final var name = "Jacob";

        for (var year : new int[]{-10, 0, 1000, 2000, 2011, 2020}) {
            Assertions.assertThrows(exception,
                () -> namesPopularity.getCount(year, gender, name),
                buildThrowMessage(exception.getName(), year, gender, name));
        }
    }

    @Test
    public void doesNotThrowAtGetCount() {
        for (int year = 2001; year <= 2010; year++) {
            final int finalYear = year;
            final char[] genders = new char[]{'m', 'f'};
            final String[] names = new String[]{"Jacob", "Emma"};

            for (int i = 0; i < genders.length; i++) {
                final var gender = genders[i];
                final var name = names[i];

                Assertions.assertDoesNotThrow(
                    () -> namesPopularity.getCount(finalYear, gender, name),
                    buildNotThrowMessage(finalYear, gender, name));
            }
        }
    }

    @Test
    public void throwsAtGetTotal() {
        final var gender = 'f';

        for (var year : new int[]{-10, 0, 1000, 2000, 2011, 2020}) {
            Assertions.assertThrows(exception,
                () -> namesPopularity.getTotal(year, gender),
                buildThrowMessage(exception.getName(), year, gender));
        }
    }

    @Test
    public void doesNotThrowAtGetTotal() {
        final var gender = 'm';
        for (int year = 2001; year <= 2010; year++) {
            final int finalYear = year;
            Assertions.assertDoesNotThrow(() -> namesPopularity.getTotal(finalYear, gender),
                buildNotThrowMessage(finalYear, gender));
        }
    }

    @Test
    public void throwsAtGetTopK() {
        final var k = 1;
        final var gender = 'f';

        // invalid array values
        for (var year : new int[]{-10, 0, 1000, 2000, 2011, 2020}) {
            final var yearArray = new int[]{year};

            Assertions.assertThrows(exception,
                () -> namesPopularity.getTopK(k, yearArray, gender),
                buildThrowMessage(exception.getName(), k, yearArray, gender));
        }

        // empty year array
        final var years = new int[0];

        Assertions.assertThrows(exception,
            () -> namesPopularity.getTopK(k, years, gender),
            buildThrowMessage(exception.getName(), k, years, gender));
    }

    @Test
    public void doesNotThrowAtGetTopK() {
        final var k = 1;
        final var gender = 'm';
        final var years = new int[10];

        for (int i = 0; i < 10; i++) {
            years[i] = i + 2001;
        }

        // test individual years
        for (var year: years) {
            final var yearArray = new int[]{year};
            Assertions.assertDoesNotThrow(
                () -> namesPopularity.getTopK(k, yearArray, gender),
                buildNotThrowMessage(year, gender));
        }

        // test all years
        Assertions.assertDoesNotThrow(() -> {
            namesPopularity.getTopK(1, years, 'm');
        });
    }

    @Test
    public void throwsAtExport() {
        final var gender = 'f';
        try {
            var tempPath = Files.createTempFile("", "");

            for (var year : new int[]{-10, 0, 1000, 2000, 2011, 2020}) {
                Assertions.assertThrows(exception,
                    () -> namesPopularity.export(year, 'f', tempPath.toString()),
                    buildThrowMessage(exception.getName(), year, gender, tempPath));
            }
        } catch (IOException e) {
            System.err.println("Failed to create temp file during tests");
            e.printStackTrace();
        }
    }

    @Test
    public void doesNotThrowAtExport() {
        final var gender = 'f';
        try {
            var tempPath = Files.createTempFile("", "");

            for (int year = 2001; year <= 2010; year++) {
                final var finalYear = year;

                Assertions.assertDoesNotThrow(
                    () -> namesPopularity.export(finalYear, gender, tempPath.toString()),
                    buildNotThrowMessage(finalYear, gender, tempPath));
            }
        } catch (IOException e) {
            System.err.println("Failed to create temp file during tests");
            e.printStackTrace();
        }
    }

}
