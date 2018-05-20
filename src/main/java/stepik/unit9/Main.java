package stepik.unit9;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Main {
    //symbolStream
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "Ы";
        byte [] b = s.getBytes("UTF-8");
        for (int i = 0; i < b.length; i++) {
            System.out.print(((int)b[i]));
        }
    }
}
