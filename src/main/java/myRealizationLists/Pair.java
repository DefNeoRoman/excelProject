package myRealizationLists;

import java.util.Objects;

public class Pair {
    private String left;
    private String right;
    private String checkString;
    public Pair(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public String getCheckString() {
        return checkString;
    }

    public void setCheckString(String checkString) {
        this.checkString = checkString;
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

    @Override
    public String toString() {
        return "Pair{" +
                "left='" + left + '\'' +
                ", right='" + right + '\'' +
                '}';
    }
}
