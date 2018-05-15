package old;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder("fffff");
        System.out.println("STRING_BUILDER");
        System.out.println(new Date());
        for(int i=0; i<100000; i++){
            stringBuilder.append("popop");
        }

        System.out.println(new Date());
        System.out.println("STRING_SIMPLE");
        String string = "pppp";
        System.out.println(new Date());
        for (int i = 0; i<100000; i++){
            string = string+"ghgh";
        }
        System.out.println(new Date());
    }
}
