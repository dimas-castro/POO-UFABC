/**
 * exceção para lista cheia.
 */
public final class StackFullException extends RuntimeException {
    public StackFullException(String message) {
        super(message);
    }
}