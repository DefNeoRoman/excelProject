package stepik.workWrong;

import org.apache.poi.ss.formula.functions.T;

import java.util.*;

//Не могу наследоввть финальный класс
public class OverLoadExample //extends ProStatic
{
    Number n = 5;


    public static void main(String[] args) {
        Collection<?> collection = new ArrayList<>();

        Object object = new Object();

        collection.remove(object);
        collection.contains(object);
        collection.size();
        collection.toArray();

    }
}
