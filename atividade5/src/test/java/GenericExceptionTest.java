import java.nio.file.Path;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;

/**
 * Generic methods for Exception Tests.
 */
public abstract class GenericExceptionTest {
    protected BabyNamesPopularityQuery namesPopularity;

    @BeforeEach
    public void setup() {
        namesPopularity = new BabyNamesPopularityQuery();
    }

    /**
     * Build a parameterized "exception should be thrown" message.
     * @param exceptionName the name of the exception
     * @param year the year
     * @param gender the gender
     * @param name the name parameter
     * @return the message string
     */
    public String buildThrowMessage(String exceptionName, int year,
        char gender, String name) {
        return String.format("Should throw %s for year %d, gender %c "
            + "and name %s", exceptionName, year, gender, name);
    }

    /**
     * Build a parameterized "exception should be thrown" message.
     * @param exceptionName the name of the exception
     * @param year the year
     * @param gender the gender
     * @param tempPath the temp file path
     * @return the message string
     */
    public String buildThrowMessage(String exceptionName, int year,
        char gender, Path tempPath) {
        return String.format("Should throw %s for year %d, gender %c "
            + "and path %s", exceptionName, year, gender, tempPath.toString());
    }

    /**
     * Build a parameterized "exception should be thrown" message.
     *
     * @param exceptionName the exception
     * @param year the year
     * @param gender the gender
     * @return the message string
     */
    public String buildThrowMessage(String exceptionName, int year, char gender) {
        return String.format("Should throw %s with year %d and gender %c",
            YearNotFoundException.class.getName(), year, gender);
    }

    /**
     * Build a parameterized "exception should be thrown" message.
     *
     * @param exceptionName the exception
     * @param year the years array
     * @param gender the gender
     * @return the message string
     */
    public String buildThrowMessage(String exceptionName, int k, int[] year, char gender) {
        return String.format("Should throw %s with k %d, years %s and gender %c",
            exceptionName, k, Arrays.toString(year), gender);
    }

    /**
     * Build a parameterized "exception should not be thrown" message.
     * @param year the year
     * @param gender the gender
     * @param name the name
     * @return the message string
     */
    public String buildNotThrowMessage(int year, char gender, String name) {
        return String.format("Should not throw any exception for year %d, gender %c "
            + "and name %s", year, gender, name);
    }

    /**
     * Build a parameterized "exception should not be thrown" message.
     * @param year the year
     * @param gender the gender
     * @param path the temp file path
     * @return the message string
     */
    public String buildNotThrowMessage(int year, char gender, Path path) {
        return String.format("Should not throw any exception for year %d, gender %c "
            + "and path %s", year, gender, path.toString());
    }

    /**
     * Build a parameterized "exception should not be thrown" message.
     * @param year the year
     * @param gender the gender
     * @return the message string
     */
    public String buildNotThrowMessage(int year, char gender) {
        return String.format("Should not throw any exception for year %d, gender %c", year, gender);
    }

    /**
     * Build a parameterized "exception should not be thrown" message.
     * @param years the years array
     * @param gender the gender
     * @return the message string
     */
    public String buildNotThrowMessage(int k, int[] years, char gender) {
        return String.format("Should not throw any exception for k %d, years %s, gender %c",
            k, Arrays.toString(years), gender);
    }
}
