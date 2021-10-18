/**
 * exceção para lista vazia.
 */
public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException(String message) {
        super(message);
    }
}