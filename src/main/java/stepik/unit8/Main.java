package stepik.unit8;

import java.io.*;
import java.util.Arrays;

//        Из System.in зачитаны следующие байты: 65 13 10 10 13. Внимание! Это не строка "65 13 10 10 13", а последовательность чисел, возвращаемая методом System.in.read().
//
//                В System.out должны быть выведены байты: 65 10 10 13
public class Main {

    public static void main(String[] args) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[]{65, 13, 10,13, 10, 13,13,10,85});
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        windowsToUnix(byteArrayInputStream,byteArrayOutputStream);
        System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
      }

    public static void windowsToUnix(InputStream bis, OutputStream bos) throws IOException {
        int buffer1 = bis.read();
        int buffer2 = 0;
        while (buffer1 != -1) {
            buffer2 = bis.read();
            if (!(buffer1 == 13 && buffer2 == 10)) {
                bos.write(buffer1);
            }
            buffer1 = buffer2;
        }
        bos.flush();
    }
}

