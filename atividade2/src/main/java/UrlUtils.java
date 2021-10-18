/**
 * Utilities for processing URLs.
 */
public final class UrlUtils {
    private UrlUtils() {}

    /**
     * Convert a domain-only url to its reverse domain form.
     * @param url the input url
     * @return the reverse domain form
     */
    public static String reverseDomainName(String url) {
        // TODO: completar
        String inversa = "";
        String[] quebra = url.split("\\.");
        int n = quebra.length;
        for (int i = 0; i < n; i++) {
            inversa = inversa.concat(quebra[n - i - 1]);
            if (i + 1 != n) {
                inversa = inversa + ".";
            }
        }
        return inversa;
    }
}
