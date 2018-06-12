package myRealizationLists;

import java.util.Objects;

public class Pair {
    private String left;
    private String right;

    public Pair(String left, String right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(left, pair.left) &&
                Objects.equals(right, pair.right);
    }

    @Override
    public int hashCode() {

        return Objects.hash(left, right);
    }
}
