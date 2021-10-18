import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test whether RankingOutOfBoundsException is thrown at the proper places.
 */
public class RankingOutOfBoundsExceptionTest extends GenericExceptionTest {
    private static final Class<RankingOutOfBoundsException> exception
        = RankingOutOfBoundsException.class;

    @Test
    public void doesNotThrowAtTopK() {
        final var years = new int[]{2001};
        final var gender = 'f';

        for (var k : new int[]{1, 25, 50, 100, 200, 500, 1000}) {
            Assertions.assertDoesNotThrow(
                () -> namesPopularity.getTopK(k, years, gender),
                buildNotThrowMessage(k, years, gender));
        }
    }

    @Test
    public void throwsAtTopK() {
        final var years = new int[]{2001};
        final var gender = 'f';

        for (var k : new int[]{-10, -1, 0, 1001, 2000}) {
            Assertions.assertThrows(exception,
                () -> namesPopularity.getTopK(k, years, gender),
                buildThrowMessage(exception.getName(), k, years, gender));
        }
    }
}
