package stepik.unit9;

import java.util.Locale;
import java.util.Scanner;

public class ParseScanner {
    public static void main(String[] args) {
        // Не забыть про ctrl+D это выход из консольного ввода
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\\s");
            scanner.useLocale(Locale.ENGLISH);
            double d;
            double sum = 0.0;
            while(scanner.hasNext()){
                if (scanner.hasNextDouble()) {
                    d = scanner.nextDouble();
                    sum += d;
                } else {
                    scanner.next();
                }
            }

            System.out.printf(Locale.ENGLISH, "%.6f", sum);
        }
}
