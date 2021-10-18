/**
 * exceção para pilha vazia.
 */
public final class StackEmptyException extends RuntimeException {
    public StackEmptyException(String message) {
        super(message);
    }
}