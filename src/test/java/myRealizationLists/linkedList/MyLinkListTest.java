package myRealizationLists.linkedList;

import myRealizationLists.MyList;
import myRealizationLists.Pair;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkListTest {
    private MyList<Pair> testStorage = new MyLinkList<>();
    @Before
    public void setUp(){
        for(int i = 0; i<10; i++){
            testStorage.add(new Pair("left"+i,"right"+i));
        }
    }
    @Test
    public void get() {
        for(int i = 0; i<10; i++){
           assertEquals(testStorage.get(i),new Pair("left"+i,"right"+i));
        }
    }

    @Test
    public void getOrDefault() {

    }

    @Test
    public void getFirst() {
        assertEquals(testStorage.getFirst(),new Pair("left0","right0"));
    }

    @Test
    public void getLast() {
        assertEquals(testStorage.getLast(),new Pair("left9","right9"));
    }

    @Test
    public void add() {
    }

    @Test
    public void add1() {
    }

    @Test
    public void addIfAbsent() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
        //здесь удаляем седьмой элемент то есть Pair8
        testStorage.delete(7);
        for(int i = 0; i<8; i++){
            assertEquals(testStorage.get(i),new Pair("left"+i,"right"+i));
        }
        for(int i = 9; i<10; i++){
            assertEquals(testStorage.get(i),new Pair("left"+i,"right"+i));
        }
    }

    @Test
    public void delete1() {

    }

    @Test
    public void size() {
        assertEquals(testStorage.size(),10);
    }

    @Test
    public void clear() {
        testStorage.clear();
        assertEquals(testStorage.size(),0);
    }
}