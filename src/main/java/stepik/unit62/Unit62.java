package stepik.unit62;

import java.util.HashSet;
import java.util.Set;

public class Unit62 {
    //Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        Set<Integer> integers2 = new HashSet<>();
        integers2.add(0);
        integers2.add(1);
        integers2.add(2);
        System.out.println(symmetricDifference(integers, integers2));
    }
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> symmetricDiff = new HashSet<T>(set1);
        symmetricDiff.addAll(set2);
        Set<T> tmp = new HashSet<T>(set1);
        tmp.retainAll(set2);
        symmetricDiff.removeAll(tmp);
        return symmetricDiff;
    }
}
