/**
 * Excecao de ranking.
 */
public class RankingOutOfBoundsException extends Exception {
    public RankingOutOfBoundsException(int rank) {
        super("Rank must be in the range ([1,1000]): " + rank);
    }
}
