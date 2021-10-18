/**
 * Helper class to process dna sequences.
 */
public final class DnaUtils {

    private DnaUtils() {}

    /**
     * Transforma a string de entrada (no formato de sequencia DNA) no complemento
     * de Watson-Crick, isto eh, substitui A por T e C por G, e vice versa.
     * @param dna a sequencia DNA formada por uma sequencia de A, C, G ou T
     * @return o complemento de Watson-Crick para a sequencia
     */
    public static String watsonCrick(String dna) {
        // TODO: Completar
        int n = dna.length();
        String resposta = "";
        for (int i = 0; i < n; i++) {
            if (dna.charAt(i) == 'A') {
                resposta = resposta.concat("T");
            } else if (dna.charAt(i) == 'T') {
                resposta = resposta.concat("A");
            } else if (dna.charAt(i) == 'G') {
                resposta = resposta.concat("C");
            } else {
                resposta = resposta.concat("G");
            }
        }
        return resposta;
    }
}
