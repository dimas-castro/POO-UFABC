import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for GenericStack.
 */
@DisplayName("Tests for Stack")
public class TestGenericStack {
    private GenericStack<Integer> defaultGenericStack;

    @BeforeEach
    public void setUpDefaults() {
        defaultGenericStack = new GenericStack<>(TestUtil.defaultSize);
    }

    @Test
    public void testExceptionOnInvalidCapacity() {
        final var exception = IllegalArgumentException.class;
        Assertions.assertThrows(exception, () -> new GenericStack<Integer>(-10),
            String.format("Constructor should throw %s on negative capacity", exception.getName()));
    }

    @Test
    public void testNullStackIsFull() {
        var stack = new GenericStack<Integer>(0);

        Assertions.assertTrue(stack.isFull(),
            "Stack with capacity 0 should always be full");
    }

    @Test
    public void testStackIsFull() {
        var v = TestUtil.randomIntArray();

        for (int e : v) {
            Assertions.assertFalse(defaultGenericStack.isFull(),
                "Stack should not be full with size " + TestUtil.defaultSize);
            defaultGenericStack.push(e);
        }
        Assertions.assertTrue(defaultGenericStack.isFull(),
            "Stack should be full with size " + defaultGenericStack.size());
    }

    @Test
    public void testNullStackIsEmpty() {
        var stack = new GenericStack<Integer>(0);

        Assertions.assertTrue(stack.isEmpty(),
            "Stack with capacity 0 should always be empty");
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(defaultGenericStack.isEmpty(),
            "Newly created stack should be empty");

        var v = TestUtil.randomIntArray();

        for (int e : v) {
            defaultGenericStack.push(e);
            Assertions.assertFalse(defaultGenericStack.isEmpty(),
                "Stack should not be empty with size " + defaultGenericStack.size());
        }
        for (int i = 0; i < TestUtil.defaultSize; i++) {
            Assertions.assertFalse(defaultGenericStack.isEmpty(),
                "Stack should not be empty with size " + defaultGenericStack.size());
            defaultGenericStack.pop();
        }
        Assertions.assertTrue(defaultGenericStack.isEmpty(),
            "Stack should be empty after popping all elements.");
    }

    @Test
    public void testFullExceptionOnPush() {
        final var exception = StackFullException.class;

        Assertions.assertThrows(exception, () -> {
            for (int i = 0; i < TestUtil.defaultSize; i++) {
                defaultGenericStack.push(i);
            }
            defaultGenericStack.push(TestUtil.defaultSize);
        }, "Should throw exception when pushing on full stack");
    }

    @Test
    public void testPushPeek() {
        final var sizeMessage = "Stack does not match expected size";
        final var topMessage = "Stack top value does not match expected value";
        final var v = TestUtil.randomIntArray();

        Assertions.assertEquals(0, defaultGenericStack.size(), sizeMessage);
        for (int i = 0; i < v.length; i++) {
            defaultGenericStack.push(v[i]);
            Assertions.assertEquals(i + 1, defaultGenericStack.size(), sizeMessage);
            Assertions.assertEquals(v[i], defaultGenericStack.peek(), topMessage);
        }
    }

    @Test
    public void testEmptyExceptionOnPop() {
        final var exception = StackEmptyException.class;

        Assertions.assertThrows(exception, () -> defaultGenericStack.pop(),
            String.format("Should throw %s when popping empty stack", exception.getName()));
    }

    @Test
    public void testPop() {
        final var sizeMessage = "Stack size is out of expected value";
        int[] v = TestUtil.randomIntArray();

        for (int j : v) {
            defaultGenericStack.push(j);
        }

        Assertions.assertEquals(TestUtil.defaultSize, defaultGenericStack.size(), sizeMessage);
        for (int i = v.length - 1; i >= 0; i--) {
            int value = defaultGenericStack.pop();

            Assertions.assertEquals(v[i], value, "Stack top does not match expected value");
            Assertions.assertEquals(i, defaultGenericStack.size());
        }
        Assertions.assertEquals(0, defaultGenericStack.size(), sizeMessage);
    }

    @Test
    public void testEmptyExceptionOnPeek() {
        final var exception = StackEmptyException.class;

        Assertions.assertThrows(exception, () -> defaultGenericStack.peek(),
            String.format("Should throw %s when peeking on empty stack", exception.getName()));
    }

    @Test
    public void testClear() {
        defaultGenericStack.push(10);
        Assertions.assertFalse(defaultGenericStack.isEmpty(),
            "Stack should not be empty after one push");
        defaultGenericStack.clear();
        Assertions.assertTrue(defaultGenericStack.isEmpty(),
            "Stack should be empty after clear");
    }

    @Test
    public void testStringStack() {
        var stack = new GenericStack<String>(TestUtil.stringArray.length);

        for (var s : TestUtil.stringArray) {
            stack.push(s);
            Assertions.assertEquals(stack.peek(), s,
                "Stack top value does match expected value");
        }

        for (int i = 0; i < TestUtil.stringArray.length; i++) {
            Assertions.assertEquals(stack.pop(),
                TestUtil.stringArray[TestUtil.stringArray.length - i - 1],
                "Stack popped value does not match expected value");
        }
    }
}
