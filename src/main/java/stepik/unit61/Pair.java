package stepik.unit61;

import java.util.Objects;

public class Pair<T, U> {


    private  T first;
    private  U second;

    private Pair(T x, U y) {
        this.first = x;
        this.second = y;
    }
    public static <T,U> Pair<T,U> of(T x, U y){
        return new Pair<>(x,y);
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {

        return Objects.hash(first, second);
    }
}
