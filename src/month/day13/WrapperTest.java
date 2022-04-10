package month.day13;

import org.junit.Test;

public class WrapperTest {

    @Test
    public void test1(){
        int num1 = 10;
        Integer integer = 10;
        System.out.println(integer.toString());

        Integer in2 = Integer.valueOf("123");
        System.out.println(in2);
    }

    @Test
    public void test2(){
        Integer integer = 12;
        int a = integer+3;
        System.out.println(integer+2);
        System.out.println(a);
    }
}
