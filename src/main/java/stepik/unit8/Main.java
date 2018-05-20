package stepik.unit8;

import java.io.*;

//        Из System.in зачитаны следующие байты: 65 13 10 10 13. Внимание! Это не строка "65 13 10 10 13", а последовательность чисел, возвращаемая методом System.in.read().
//
//                В System.out должны быть выведены байты: 65 10 10 13
public class Main {

    public static void main(String[] args) {
        try {
            ByteArrayOutputStream byteArrayOutputStream
                    = windowsToUnix(new ByteArrayInputStream(new byte[]{65, 13, 10, 10, 13}));
            byte[] bytes = byteArrayOutputStream.toByteArray();
            for(byte b: bytes){
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static ByteArrayOutputStream windowsToUnix(ByteArrayInputStream bis) throws IOException {

      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      int buffer1 = bis.read();
      int buffer2 = 0;
      while(bis.available() != 0){
          buffer2 = bis.read();
          if(buffer1 == 13 && buffer2 == 10){
              bos.write(buffer2);
              buffer1 = buffer2;
          }else{
              bos.write(buffer1);
              buffer1 = buffer2;
              if(bis.read() == -1){
                  bos.write(buffer1);
              }
          }
      }
      bos.flush();
      return bos;
    }
    }

