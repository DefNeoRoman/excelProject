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
        assertEquals(testStorage.get(6),new Pair("left5","right5"));
    }

    @Test
    public void getOrDefault() {

    }

    @Test
    public void getFirst() {

    }

    @Test
    public void getLast() {
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
    }

    @Test
    public void delete1() {
    }

    @Test
    public void size() {
    }

    @Test
    public void clear() {
    }
}