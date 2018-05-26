package stepik.unit62;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FuncInterFace {
    // Consumer принимает, но ничего не возвращает
    // BiConsumer принимает два занчения, и ничего не возвращает
    // Supplier ничего не принимает, но возращает
    // Predicate принимает аргумент и возвращает истину или ложь
    // Function принимает Определенное значение и возвращает Определенное значение
    Function<Integer,Integer> f = (f)-> f*2;

    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        Stream<Object> stream = new ArrayList<>().stream();

        System.out.println(safeStringLength.apply("Str"));
    }
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return t->condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);

    }
}
