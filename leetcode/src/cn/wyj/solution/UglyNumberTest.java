package cn.wyj.solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class UglyNumberTest {

    @Test
    public void isUgly() {
        new UglyNumber().isUgly(-2147483648);
        System.out.println();
        new UglyNumber().isUgly(1332185066);

    }
}