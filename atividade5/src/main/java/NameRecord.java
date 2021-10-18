import java.util.Objects;

/**
 * Represent a row in baby names record file.
 */
public class NameRecord {
    int rank;
    String name;
    int count;

    /**
     * The constructor.
     * @param rank the ranking
     * @param name the name
     * @param count the count
     */
    public NameRecord(int rank, String name, int count) {
        this.rank = rank;
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return String.join(" ", this.rank + "",
            this.name, this.count + "");
    }

    public String toCsv() {
        return String.format("%d %s %d\n", rank, name, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NameRecord that = (NameRecord) o;

        return rank == that.rank
            && count == that.count
            && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, name, count);
    }
}
