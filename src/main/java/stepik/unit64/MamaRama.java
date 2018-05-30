package stepik.unit64;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MamaRama {
    static String readString(InputStream is) throws IOException {
        char[] buf = new char[2048];
        Reader r = new InputStreamReader(is, "UTF-8");
        StringBuilder s = new StringBuilder();
        while (true) {
            int n = r.read(buf);
            if (n < 0)
                break;
            s.append(buf, 0, n);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String inputStr = null;
//        try { inputStr = readString(System.in); } catch (IOException e) { e.printStackTrace(); }
       inputStr = "Мама мыла-мыла-мыла раму!";
      //  inputStr = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";

        List<String> wordsList = Arrays.asList(inputStr.split("[^\\p{L}\\p{Digit}_]+"));
        Map<String, Integer> counts = wordsList.parallelStream()
                .map(String::toLowerCase)
                .collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum));

        counts.entrySet().stream()
                 .sorted((o1, o2) -> {
                    if (o1.getValue() == o2.getValue()) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else if (o1.getValue() > o2.getValue()) {
                        return -1;
                    } else if (o1.getValue() < o2.getValue()) {
                        return 1;
                    }
                    return 0;
                })
                .limit(10)
                .forEach(stringIntegerEntry -> {
                       System.out.println(stringIntegerEntry.getKey() + " : " + stringIntegerEntry.getValue());
                   // System.out.println(stringIntegerEntry.getKey());

                });
    }
}
