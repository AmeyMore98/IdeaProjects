package Tests;

/**
 * Created by Vinay on 2/2/2018.
 */

import BusinessLogic.*;
import org.junit.Before;
import org.junit.Test;

import  static org.junit.Assert.*;

public class CalTest {
    private calLogic cal;
    @Before
    public  void setUp(){
        cal = new calLogic();
    }

    @Test
    public void test1(){
        int actual = cal.cal("1 + 3");
        int expedted = 4;
        assertEquals(expedted, actual);
    }

    @Test
    public void test2(){
        int actual = cal.cal("5 - 1");
        int expedted = 4;
        assertEquals(expedted, actual);
    }

    @Test
    public void test3(){
        int actual = cal.cal("3 * 7");
        int expedted = 21;
        assertEquals(expedted, actual);
    }

    @Test
    public void test4(){
        int actual = cal.cal("3 / 2");
        int expedted = 1;
        assertEquals(expedted, actual);
    }

    @Test
    public void test5(){
        int actual = cal.cal("20 + 3 * 3 / 4");
        int expedted = 22;
        assertEquals(expedted, actual);
    }

    @Test
    public void test6(){
        int actual = cal.cal("8 * 8 + 3 * 2");
        int expedted = 70;
        assertEquals(expedted, actual);
    }

    @Test
    public void test7(){
        int actual = cal.cal("1 + 3");
        String expedted = "Math Error";
        assertEquals(expedted, actual);
    }

    @Test
    public void test8(){
        int actual = cal.cal("5 / 0");
        int expedted = 4;
        assertEquals(expedted, actual);
    }

    @Test
    public void test9(){
        int actual = cal.cal("0 / 10");
        int expedted = 0;
        assertEquals(expedted, actual);
    }

    @Test
    public void test10(){
        int actual = cal.cal("2 / 2 * 0 + 5");
        int expedted = 0;
        assertEquals(expedted, actual);
    }

    @Test
    public void test11(){
        int actual = cal.cal("7 + 2 + 4 + 5 + 6 + 7 + 9 + 8 + 12");
        String expected = "Please enter String of  max 10 characters";
        assertEquals(expected, actual);
    }

    @Test
    public void test12(){
        int actual = cal.cal("8 - 8 - 0");
        int expedted = 0;
        assertEquals(expedted, actual);
    }

    @Test
    public void test13(){
        int actual = cal.cal("abcd");
        String expected = "Give input in digits only";
        assertEquals(expected, actual);
    }

    @Test
    public void test14(){
        int actual = cal.cal("(10 + 3 ) * 5");
        int expedted = 65;
        assertEquals(expedted, actual);
    }

    @Test
    public void test15(){
        int actual = cal.cal("(2 + 6) + 0) * 5");
        int expedted = 35;
        assertEquals(expedted, actual);
    }

    @Test
    public void test16(){
        int actual = cal.cal("22222");
        int expedted = 22222;
        assertEquals(expedted, actual);
    }

    @Test
    public void test17(){
        int actual = cal.cal("1@3");
        String expedted = "Enter valid input";
        assertEquals(expedted, actual);
    }



    @Test
    public void test18(){
        int actual = cal.cal("+++");
        String expedted = "Enter digit and operation";
        assertEquals(expedted, actual);
    }



    @Test
    public void test19(){
        int actual = cal.cal("");
        String expedted = "enter valid input";
        assertEquals(expedted, actual);
    }

    @Test
    public void test20(){
        int actual = cal.cal("2%2");
        String expedted = "operation mod is not available";
        assertEquals(expedted, actual);
    }

    @Test
    public void test21(){
        int actual =cal.cal("( 2 [ 7 + 4 ] + 5 ( + 3 ))");
        String expedted = "input is not valid";
        assertEquals(expedted, actual);
    }

    @Test
    public void test22(){
        int actual = cal.cal("( 1 + 9 ) * ( 3 + 5 ( 5 ) - 3)");
        int expedted = 250;
        assertEquals(expedted, actual);
    }

    @Test
    public void test23(){
        int actual = cal.cal("2 / 2 - ( - 9 )");
        int expedted = 10;
        assertEquals(expedted, actual);
    }

    @Test
    public void test24(){
        int actual = cal.cal("0 9 0 0 0 0 * 1 0");
        int expedted = 900000;
        assertEquals(expedted, actual);
    }

    @Test
    public void test25(){
        int actual = cal.cal("3 * 3 + 10 + 2");
        int expedted = 21;
        assertEquals(expedted, actual);
    }

    @Test
    public void test26(){
        int actual = cal.cal("0 / 0");
        String expedted = "Math Error";
        assertEquals(expedted, actual);
    }

    @Test
    public void test27(){
        int actual = cal.cal("((()))");
        String expedted = "Enter digits and operation";
        assertEquals(expedted, actual);
    }

    @Test
    public void test28(){
        int actual = cal.cal("11+22-32");
        int expedted = 1;
        assertEquals(expedted, actual);
    }

    @Test
    public void test29(){
        int actual = cal.cal("2++2");
        String expedted = "enter valid input";
        assertEquals(expedted, actual);
    }

    @Test
    public void test30(){
        int actual = cal.cal("2 * 2 + 2 - 1 / 1");
        int expedted = 5;
        assertEquals(expedted, actual);
    }
}

