package stepik.unit62;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class MinMaxConsumer {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        // your implementation here
    }

    public static void main(String[] args) {

    }
}
