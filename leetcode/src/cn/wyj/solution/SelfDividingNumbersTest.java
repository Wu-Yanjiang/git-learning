package cn.wyj.solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class SelfDividingNumbersTest {

    @Test
    public void selfDividingNumbers() {
        for (int i : new SelfDividingNumbers().selfDividingNumbers(1,22))
            System.out.print(i + " ");
    }
}