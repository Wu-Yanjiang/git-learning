package cn.wyj.solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountPrimesTest {

    @Test
    public void countPrimes() {
        int n = 100000000;
        System.out.println(CountPrimes.countPrimes(n));
    }
}