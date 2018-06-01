package stepik.unit61;

import java.util.Optional;
import java.util.function.BiConsumer;

public class Main<X> {
    public static void main(String[] args) {
        Object obj = new Object();


        System.out.println("success");
//        Проверка (obj instanceof Optional<x>)
//        Создание экземпляра X
//        Создание массива X
//        Приведение obj к типу X
//        Проверка (obj instanceof X)
//        Получение экземпляра Optional<x> через Optional.empty()
    }
    public void someMethod(Object obj) {
        Optional<X> o = Optional.empty();
        Optional<X>c = Optional.empty();
    }
    class Pair<T, U> {







        // вариант 5
        public <X, Y> void ifPresent(BiConsumer<X, Y> consumer) {  }
    }
}
