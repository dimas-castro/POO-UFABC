import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for GenericQueue.
 */
@DisplayName("Tests for Queue")
public class TestGenericQueue {
    private static final int defaultCapacity = 10;
    private GenericQueue<Integer> defaultGenericQueue;

    @BeforeEach
    public void setUpDefaults() {
        defaultGenericQueue = new GenericQueue<>(defaultCapacity);
    }

    @Test
    public void testInvalidCapacity() {
        final var exception = IllegalArgumentException.class;

        Assertions.assertThrows(exception, () -> new GenericStack<Integer>(-10),
            String.format("Should throw %s with a negative capacity value", exception.getName()));
    }

    @Test
    public void testNullQueueIsEmpty() {
        var queue = new GenericQueue<Integer>(0);

        Assertions.assertTrue(queue.isEmpty(), "Queue with capacity 0 should "
            + "always be empty");
    }

    @Test
    public void testIsEmpty() {
        final var v = TestUtil.randomIntArray();

        Assertions.assertTrue(defaultGenericQueue.isEmpty(), "Newly created queue should be empty");
        for (var e : v) {
            defaultGenericQueue.enqueue(e);
            Assertions.assertFalse(defaultGenericQueue.isEmpty(), "Queue should not be empty "
                + "with size " + defaultGenericQueue.size());
        }

        for (int i = 0; i < v.length; i++) {
            Assertions.assertFalse(defaultGenericQueue.isEmpty(), "Queue should not be empty "
                + "with size " + defaultGenericQueue.size());
            defaultGenericQueue.dequeue();
        }
        Assertions.assertTrue(defaultGenericQueue.isEmpty(), "Queue should be empty with "
            + "size " + defaultGenericQueue.size());
    }

    @Test
    public void testNullQueueIsFull() {
        var queue = new GenericQueue<Integer>(0);

        Assertions.assertTrue(queue.isFull(), "Queue with capacity 0 should "
            + "always be full");
    }

    @Test
    public void testIsFull() {
        final var v = TestUtil.randomIntArray();

        for (var e : v) {
            Assertions.assertFalse(defaultGenericQueue.isFull(), "Queue should not be full "
                + "with size: " + defaultGenericQueue.size());
            defaultGenericQueue.enqueue(e);
        }
        Assertions.assertTrue(defaultGenericQueue.isFull(), "Queue should be full "
            + "with size: " + defaultGenericQueue.size());
    }

    @Test
    public void testFullStackOnEnqueue() {
        final var exception = QueueFullException.class;
        final var v = TestUtil.randomIntArray();

        for (int e : v) {
            defaultGenericQueue.enqueue(e);
        }
        Assertions.assertThrows(exception, () -> defaultGenericQueue.enqueue(100),
            String.format("Should throw %s when enqueuing on full queue", exception.getName()));
    }

    @Test
    public void testEnqueue() {
        final var v = TestUtil.randomIntArray();

        for (int i = 0; i < v.length; i++) {
            defaultGenericQueue.enqueue(v[i]);
            Assertions.assertEquals(v[0], defaultGenericQueue.front(),
                "Queue front does not match expected value");
            Assertions.assertEquals(v[i], defaultGenericQueue.rear(),
                "Queue rear does not match expected value");
            Assertions.assertEquals(i + 1, defaultGenericQueue.size(),
                "Queue size does match expected value");
        }
        Assertions.assertTrue(defaultGenericQueue.isFull(),
            "Queue should be full when size reaches capacity");
    }

    @Test
    public void testDequeue() {
        final var v = TestUtil.randomIntArray();

        for (var e : v) {
            defaultGenericQueue.enqueue(e);
        }

        for (int i = 0; i < v.length; i++) {
            Assertions.assertEquals(v[v.length - 1], defaultGenericQueue.rear(),
                "Queue rear does not match expected value");
            Assertions.assertEquals(defaultGenericQueue.dequeue(), v[i],
                "Dequeue operation is not returning expected value");
            Assertions.assertEquals(v.length - 1 - i, defaultGenericQueue.size(),
                "Queue size does match expected value");
        }
        Assertions.assertEquals(0, defaultGenericQueue.size(),
            "Queue should be empty after dequeing all elements");
    }

    @Test
    public void testClear() {
        defaultGenericQueue.enqueue(10);
        Assertions.assertFalse(defaultGenericQueue.isEmpty(),
            "Queue should not be empty after one push");
        defaultGenericQueue.clear();
        Assertions.assertTrue(defaultGenericQueue.isEmpty(),
            "Stack should be empty after clear");
    }

    @Test
    public void testStringQueue() {
        var queue = new GenericQueue<String>(TestUtil.stringArray.length);

        for (var s : TestUtil.stringArray) {
            queue.enqueue(s);
            Assertions.assertEquals(queue.rear(), s,
                "Queue rear value does match expected value");
            Assertions.assertEquals(queue.front(), TestUtil.stringArray[0],
                "Queue front value does match expected value");
        }

        for (int i = 0; i < TestUtil.stringArray.length; i++) {
            Assertions.assertEquals(queue.dequeue(),
                TestUtil.stringArray[i],
                "Queue dequeued value does not match expected value");
        }
    }

}
