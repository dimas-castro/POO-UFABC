/**
 * Excecao de nome.
 */
public class NameNotFoundException extends Exception {
    public NameNotFoundException(String nome) {
        super("Name not found: " + nome);
    }
}
