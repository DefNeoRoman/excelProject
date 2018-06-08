package stepik.workWrong.genTest;

import stepik.unit6.Robot;

import java.util.*;

public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Deque re = new LinkedList();
            while(scanner.hasNext()){
                scanner.nextInt();
                if(scanner.hasNext()){
                    re.add(scanner.nextInt());
                }

            }
            re.descendingIterator().forEachRemaining(elem->{
                System.out.print(elem + " ");
            });
   }

    public <T extends Robot> void addFriend(String name, Class<T> type, T animal){

    }
    public <T extends Robot> T callFriend(String name, Class<T> type){
        return (T)new Object();
    }
}
