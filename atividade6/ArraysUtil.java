/**
 * Classe ArraysUtil.
 */
public abstract class ArraysUtil {

    /**
     * Transforma em string.
     *
     * @param elements vetor de T
     * @param <T>      tipo de dado
     * @return string formatada
     */
    public static <T> String toString(T[] elements) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i < elements.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * Compara se são iguais.
     *
     * @param a   vetor a
     * @param b   vetor b
     * @param <T> tipo de dado
     * @return verdadeiro caso sejam iguais ou falso caso contrário
     */
    public static <T extends Comparable<T>> boolean equals(T[] a, T[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(b[i]) != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Selection sort (inline). Warn: performing some redundant checks to simplify the algorithm.
     *
     * @param v   the input array
     * @param <T> the generic array type
     */
    public static <T extends Comparable<T>> void sort(T[] v) {
        for (int i = 0; i < v.length; i++) {
            int k = i;

            for (int j = i; j < v.length; j++) {
                if (v[j].compareTo(v[k]) < 0) {
                    k = j;
                }
            }
            // swap elements i and k
            T temp = v[i];
            v[i] = v[k];
            v[k] = temp;
        }
    }

    /**
     * Verifica se está ordenado em ordem crescente.
     *
     * @param v   vetor de T
     * @param <T> tipo de dado
     * @return verdadeiro caso esteja ordenado
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] v) {
        //System.out.println(Arrays.toString(v));
        for (int i = 1; i < v.length; i++) {
            if (v[i].compareTo(v[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }
}