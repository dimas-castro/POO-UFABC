/**
 * App class.
 */
public final class MainHelper {

    private MainHelper() {}

    /**
     * Retorna a quantidade de dígitos presente no inteiro.
     * @param n o inteiro
     * @return a quantidade de digitos
     */
    public static int contaDigitos(int n) {
        // TODO: completar
        int cont = 1;
        if (n < 0) {
            n = n * (-1);
        }
        while (n > 10) {
            n = n / 10;
            cont++;
        }
        return cont;
    }

    /**
     * Retorna um array contendo os maximos das colunas.
     * da matriz
     * @param v a matriz
     * @return o array de maximos
     */
    public static int[] maximosColunas(int[][] v) {
        // TODO: completar

        int[] maior;
        maior = new int[v[0].length];
        for (int i = 0; i < v[0].length; i++) {
            maior[i] = -2147483648;
        }
        for (int j = 0; j < v[0].length; j++) {
            for (int i = 0; i < v.length; i++) {
                if (v[i][j] > maior[j]) {
                    maior[j] = v[i][j];
                }
            }
        }
        return maior;
    }

}
