package stepik.unit64;

import java.util.Arrays;
import java.util.List;
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
        collect.entrySet().stream().sorted(((o1, o2) -> {
            int compareTo = o1.getValue().compareTo(o2.getValue());
            if(compareTo == 1){
                return -1;
            }else if(compareTo == -1){
                return 1;
            }else if(compareTo == 0){
                return o1.getKey().compareTo(o2.getKey());
            }
            return 0;
        })).limit(10).forEach(elem-> System.out.println(elem.getKey()));

    }
}
