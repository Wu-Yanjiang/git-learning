package cn.wyj.solution;

import org.junit.Test;

public class AddBinaryTest {

    @Test
    public void addBinary() {
        //100
//        new AddBinary().addBinary("11", "1");
        //10101
//        new AddBinary().addBinary("1010", "1011");
        //0
        new AddBinary().addBinary("0", "0");
    }

    @Test
    public void addBinary2(){
        //100
       System.out.println(new AddBinary().addBinary2("11", "1"));
        //10101
        System.out.println(new AddBinary().addBinary2("1010", "1011"));
        //0
        System.out.println(new AddBinary().addBinary2("0", "0"));
    }
}