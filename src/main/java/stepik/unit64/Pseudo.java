package stepik.unit64;

import java.util.Calendar;
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

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.getTime().toString());// это будет начало месяца
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.getTime().getTime());// это будет конец месяца
        BiConsumer biConsumer = new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {

            }
        };
    }
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        minMaxConsumer.accept((T)stream.min(order),(T)stream.max(order));
    }
}
