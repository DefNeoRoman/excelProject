package myRealizationLists.arrayList;

import myRealizationLists.MyList;
import myRealizationLists.Pair;
import myRealizationLists.linkedList.MyLinkList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrListTest {
    //Чтобы можно было подменить реализацию
    // и не писать одни и те же тесты под разные реализации одного и того же
   private MyList<String> testStorage = new MyArrList();
   // private MyList<String> testStorage = new MyLinkList<>();

    private MyList<Pair>   pairStorage  = new MyArrList<>();

    @Before
    public void defineTestList() {
        testStorage.add("one");
        testStorage.add("two");
        testStorage.add("three");
        testStorage.add("four");
        for (int i = 0; i <= 10; i++) {
            testStorage.add("iterString" + i);
        }
    }

    @Test
    public void getLast() {
        assertEquals(testStorage.getLast(),"iterString10");
    }
    @Test
    public void get() {

        assertEquals(testStorage.get(4), "iterString0");
        assertEquals(testStorage.get(11), "iterString7");
    }

    @Test
    public void getOrDefault() {
        assertEquals(testStorage.getOrDefault(100,"Default Value"),"Default Value");
    }

    @Test
    public void getFirst() {
        assertEquals(testStorage.getFirst(),"one");
    }



    @Test(expected = OutOfMemoryError.class)
    public void add() {
        int currentIndex = testStorage.size();
        testStorage.add("rty");
        assertEquals(testStorage.get(currentIndex),"rty");
        for(int i = 0; i<=Integer.MAX_VALUE; i++){
            testStorage.add("asdf");
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void add1() {
        testStorage.clear();
        testStorage.add(1,"qwerty");
    }

    @Test
    public void addIfAbsent() {
        pairStorage.add(new Pair("left","right"));
        pairStorage.add(new Pair("qwe","asd"));
        pairStorage.addIfAbsent(new Pair("left","right"));
        assertEquals(2,pairStorage.size());
    }

    @Test
    public void update() {
        testStorage.update(2,"updated");
        assertEquals(testStorage.get(2),"updated");
    }

    @Test
    public void delete() {

        testStorage.delete(2);
        assertEquals(14,testStorage.size());

    }

    @Test
    public void delete1() {
        testStorage.delete("one");
        assertEquals(14,testStorage.size());

    }

    @Test
    public void size() {
        assertEquals(testStorage.size(),15);
    }
}