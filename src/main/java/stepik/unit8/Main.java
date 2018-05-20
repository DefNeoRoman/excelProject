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

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int buffer =  0;
        while(bis.available() != 0){
            int inputByte = bis.read();
           if(inputByte == 13 && buffer == 10){
                byteArrayOutputStream.write(buffer);
                buffer = inputByte;
            }else if(inputByte != -1){
                byteArrayOutputStream.write(inputByte);
                buffer = inputByte;
            }else{
                byteArrayOutputStream.write(inputByte);
                byteArrayOutputStream.write(buffer);
            }

        }
        byteArrayOutputStream.flush();
        return byteArrayOutputStream;
    }
    }

