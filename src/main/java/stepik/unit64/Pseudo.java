package stepik.unit64;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Pseudo {

    public static IntStream pseudoRandomStream(int seed) {
       return IntStream.iterate(seed, n -> ( (n * n) / 10 ) % 1000);
    }



    public static void main(String[] args) {
        System.out.println((169/10)%1000);
        IntStream i = pseudoRandomStream(13);
        i.limit(10).forEach(System.out::println);
    }
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        minMaxConsumer.accept((T)stream.min(order),(T)stream.max(order));
    }
}
