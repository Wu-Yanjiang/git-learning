package cn.wyj.solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetMismatchTest {

    @Test
    public void findErrorNums() {
        int[] a = {2,3,3,4,5,6};
        a = new SetMismatch().findErrorNums(a);
        System.out.println(a);
    }
}