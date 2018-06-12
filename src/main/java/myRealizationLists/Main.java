package myRealizationLists;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] ints = {83,84,85,86,87};
        int [] gint ={1,2,34,74};
        // мы копируем ints в gint с  первой позиции на позицию 2 длиной 2
                        //что
                        //копируем
                        //    Откуда
                                    //Куда
                                            //На какую позицию
                                                    //Длина копируемого массива
        System.arraycopy(ints,1,gint,2,2);

        System.out.println(Arrays.toString(gint));
    }
}
