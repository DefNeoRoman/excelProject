package stepik.workWrong.genTest;

import java.util.Objects;

public class Pair<T,U> {
    private  T first;
    private  U second;

    private Pair(T x, U y) {
        this.first = x;
        this.second = y;
    }
    public static <T,U> Pair<T,U> of(T x, U y){
        return new Pair<>(x,y);
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public int hashCode(){
        int result = 0;
        if(first == null){
           first = (T)new Object();
        }
        if(second == null){
            second = (U)new Object();
        }

        return result;
    }
}
