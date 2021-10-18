/**
 * Excecao de ano.
 */
public class YearNotFoundException extends Exception {
    public YearNotFoundException(int ano) {
        super("Year must be in the range ([2001,2010): " + ano);
    }
}
