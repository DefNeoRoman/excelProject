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

       List<Integer> listInteger = new LinkedList<>();
       listInteger.add(5);
       listInteger.add(6);
       listInteger.add(3);
       listInteger.add(8);
       listInteger.add(1);
       listInteger.add(10);
        findMinMax(listInteger.stream(), Integer::compareTo, (integer, integer2) -> {
            System.out.println(integer);
            System.out.println(integer2);
        });
    }
    public static <T> void findMinMax(
            Stream<? extends T> stream, Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        LinkedList<? extends T> collect = new LinkedList<>();
Deque deque = new LinkedList();

        stream.sorted(order).forEach(el->deque.addFirst(el));


        T min = (T)deque.getLast();
        T max = (T)deque.getFirst();


        if(min == null || max == null){
            minMaxConsumer.accept(null,null);
        }
        minMaxConsumer.accept(min,max);
    }
}
