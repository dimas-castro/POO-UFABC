import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for App class.
 */
public class MainTest {

    @Test
    public void testContaDigitos() {
        Assertions.assertEquals(4, MainHelper.contaDigitos(1234));
        Assertions.assertEquals(1, MainHelper.contaDigitos(0));
        Assertions.assertEquals(1, MainHelper.contaDigitos(1));
        Assertions.assertEquals(2, MainHelper.contaDigitos(23));
        Assertions.assertEquals(6, MainHelper.contaDigitos(675483));
    }

    @Test
    public void testMaximosColunasCaso1() {
        int[][] input = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        int[] output = {15, 16, 17};

        int[] result = MainHelper.maximosColunas(input);

        Arrays.sort(result);
        Arrays.sort(output);

        System.err.println("Result: " + Arrays.toString(result));
        System.err.println("Expected: " + Arrays.toString(output));

        Assertions.assertTrue(Arrays.equals(result, output));
    }

    @Test
    public void testMaximosColunasCaso2() {
        int[][] input = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        int[] output = {15, 16, 17, 12};

        int[] result = MainHelper.maximosColunas(input);

        Arrays.sort(result);
        Arrays.sort(output);

        System.err.println("Result: " + Arrays.toString(result));
        System.err.println("Expected: " + Arrays.toString(output));

        Assertions.assertTrue(Arrays.equals(result, output));
    }

    @Test
    public void testMaximosColunasCaso3() {
        int[][] input = {{7, 8}, {1, 2}};
        int[] output = {7, 8};

        int[] result = MainHelper.maximosColunas(input);

        Arrays.sort(result);
        Arrays.sort(output);

        System.err.println("Result: " + Arrays.toString(result));
        System.err.println("Expected: " + Arrays.toString(output));

        Assertions.assertTrue(Arrays.equals(result, output));
    }

    @Test
    public void testMaximosColunasCaso4() {
        int[][] input = {{45, 12, 56, 78}, {39, 80, 14, 75}, {92, 9, 4, 48}};
        int[] output = {92, 80, 56, 78};

        int[] result = MainHelper.maximosColunas(input);

        Arrays.sort(result);
        Arrays.sort(output);

        System.err.println("Result: " + Arrays.toString(result));
        System.err.println("Expected: " + Arrays.toString(output));

        Assertions.assertTrue(Arrays.equals(result, output));
    }
}
