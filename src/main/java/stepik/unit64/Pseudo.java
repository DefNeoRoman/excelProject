package stepik.unit64;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Pseudo {

    public static IntStream pseudoRandomStream(int seed) {
       return IntStream.iterate(seed, n -> ( (n * n) / 10 ) % 1000);
    }



    public static void main(String[] args) {

       List<Integer> listInteger = new ArrayList<>();
       listInteger.add(5);
       listInteger.add(6);
       listInteger.add(3);
       listInteger.add(8);
       listInteger.add(1);
       listInteger.add(10);

    }
    public static <T> void findMinMax(
            Stream<? extends T> stream, Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<? extends T> collect = stream.collect(Collectors.toList());

        T min = (T) collect.stream().min(order);

        T max = (T) collect.stream().max(order);


        if(min == null || max == null){
            minMaxConsumer.accept(null,null);
        }
        minMaxConsumer.accept(min,max);
    }
}
