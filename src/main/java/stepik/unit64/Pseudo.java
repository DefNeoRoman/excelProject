package stepik.unit64;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
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

Deque deque = new LinkedList();

        stream.sorted(order).forEach(deque::addFirst);


        T min = null;
        T max = null;
        if(deque.size() == 0){
            minMaxConsumer.accept(null,null);
        }else{
            min = (T)deque.getLast();
            max = (T)deque.getFirst();
            minMaxConsumer.accept(min,max);
        }


    }
}
