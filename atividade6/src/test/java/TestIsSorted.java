import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for isSorted() static method.
 */
@DisplayName("Tests for ArrayUtils.isSorted")
public class TestIsSorted {
    @Test
    public void testUnsortedInts() {
        try (var scanner = new Scanner(new File(TestUtil.unsortedIntFile))) {
            while (scanner.hasNext()) {
                int size = scanner.nextInt();
                Integer[] v = new Integer[size];

                for (int i = 0; i < size; i++) {
                    v[i] = scanner.nextInt();
                }

                Assertions.assertFalse(ArraysUtil.isSorted(v),
                    "Array is not sorted: " + Arrays.toString(v));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open unsorted ints case file");
            e.printStackTrace();
        }
    }

    @Test
    public void testSortedInts() {
        try (var scanner = new Scanner(new File(TestUtil.sortedIntFile))) {
            while (scanner.hasNext()) {
                int size = scanner.nextInt();
                Integer[] v = new Integer[size];

                for (int i = 0; i < size; i++) {
                    v[i] = scanner.nextInt();
                }

                Assertions.assertTrue(ArraysUtil.isSorted(v),
                    "Array is sorted: " + Arrays.toString(v));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open unsorted ints case file");
            e.printStackTrace();
        }
    }

    @Test
    public void testUnsortedDoubles() {
        try (var scanner = new Scanner(new File(TestUtil.unsortedDoubleFile))) {
            while (scanner.hasNext()) {
                int size = scanner.nextInt();
                Double[] v = new Double[size];

                for (int i = 0; i < size; i++) {
                    v[i] = scanner.nextDouble();
                }

                Assertions.assertFalse(ArraysUtil.isSorted(v),
                    "Array is not sorted: " + Arrays.toString(v));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open unsorted doubles case file");
            e.printStackTrace();
        }
    }

    @Test
    public void testSortedDoubles() {
        try (var scanner = new Scanner(new File(TestUtil.sortedDoubleFile))) {
            while (scanner.hasNext()) {
                int size = scanner.nextInt();
                Double[] v = new Double[size];

                for (int i = 0; i < size; i++) {
                    v[i] = scanner.nextDouble();
                }

                Assertions.assertTrue(ArraysUtil.isSorted(v),
                    "Array is sorted: " + Arrays.toString(v));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open unsorted ints case file");
            e.printStackTrace();
        }
    }

    @Test
    public void testUnsortedStrings() {
        try (var scanner = new Scanner(new File(TestUtil.unsortedShakespeareFile))) {
            while (scanner.hasNext()) {
                int size = scanner.nextInt();
                String[] v = new String[size];

                for (int i = 0; i < size; i++) {
                    v[i] = scanner.next();
                    System.out.println(v[i]);
                }

                Assertions.assertFalse(ArraysUtil.isSorted(v),
                    "Array is not sorted: " + Arrays.toString(v));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open unsorted doubles case file");
            e.printStackTrace();
        }
    }

    @Test
    public void testSortedStrings() {
        try (var scanner = new Scanner(new File(TestUtil.sortedShakespeareFile))) {
            while (scanner.hasNext()) {
                int size = scanner.nextInt();
                String[] v = new String[size];

                for (int i = 0; i < size; i++) {
                    v[i] = scanner.next();
                }

                Assertions.assertTrue(ArraysUtil.isSorted(v),
                    "Array is sorted: " + Arrays.toString(v));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open unsorted ints case file");
            e.printStackTrace();
        }
    }
}
