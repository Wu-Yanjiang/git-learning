package cn.wyj.solution;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PascalsTriangleIITest {

    @Test
    public void getRow2() {
        int n = 0;
        while (n<=0) {
            List<Integer> ans = new PascalsTriangleII().getRow2(n);
            for (Integer i : ans) {
                System.out.print(i.toString() + " ");
            }
            System.out.println();
            n++;
        }
    }
}