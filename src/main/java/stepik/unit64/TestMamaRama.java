package stepik.unit64;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class TestMamaRama {
    public static void main(String[] args) {
      BinaryOperator<Integer> binaryOperator = (integer, integer2) -> integer+integer2;
        String input = "Мама мыла-мыла раму";
        List<String> wordsList = Arrays.asList(input.split("[^\\p{L}\\p{Digit}_]+"));
        ConcurrentMap<String, Integer> collect = wordsList.stream().map(String::toLowerCase)
                .collect(Collectors.toConcurrentMap(elem -> elem, elem -> 1,(value1,value2)->value1+value2));
        collect.entrySet().stream().sorted(Collections.reverseOrder((o1, o2) -> {
            if(o1.getValue().compareTo(o2.getValue()) == 0){
                return o2.getKey().compareTo(o1.getKey());
            }
            return o1.getValue().compareTo(o2.getValue());
        })).limit(10).forEach(elem-> System.out.println(elem.getKey()));

    }
}
