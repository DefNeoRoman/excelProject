import org.junit.Test;
import stepik.Unit1;

import static org.junit.Assert.assertEquals;

public class Unit1Test {
    @Test()
    public  void test(){
        Unit1 unit1 = new Unit1();

        assertEquals(unit1.isPalindrome("Madam, I'm Adam!"),true)  ;
        assertEquals(unit1.isPalindrome("Madam"),true)  ;
        assertEquals(unit1.isPalindrome("Hello World"),false)  ;

    }
}
