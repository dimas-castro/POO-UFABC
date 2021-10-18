import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Generic tests for BabyNamesPopularityTest.
 */
public class GenericBabyNamesPopularityQueryTest {

    @Test
    public void topKReturnTypeIsRight() {
        try {
            var method = BabyNamesPopularityQuery.class
                .getDeclaredMethod("getTopK", int.class, int[].class, char.class);
            Assertions.assertEquals(NameRecord[][].class, method.getReturnType(),
                "getTopK() should return object of type NameRecord");
        } catch (NoSuchMethodException e) {
            System.err.println("BabyNamesPopularity is not implementing "
                + "method getTopK(int, int[], char)");
            e.printStackTrace();
        }
    }
}
