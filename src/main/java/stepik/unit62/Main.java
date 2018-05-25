package stepik.unit62;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque re = new LinkedList();

        int index = 0;
        while(scanner.hasNext()){
            index++;
            if(index % 2 != 0){
                scanner.nextInt();
            } else{
                re.add(scanner.nextInt());
            }
        }
        List list = new ArrayList();
        re.descendingIterator().forEachRemaining(elem->{
            System.out.print(elem + " ");
        });

    }
}

