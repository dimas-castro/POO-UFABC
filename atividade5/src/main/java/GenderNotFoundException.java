/**
 * Excecao de genero.
 */
public class GenderNotFoundException extends Exception {
    public GenderNotFoundException(char genero) {
        super("Gender must be f or m: " + genero);
    }
}
