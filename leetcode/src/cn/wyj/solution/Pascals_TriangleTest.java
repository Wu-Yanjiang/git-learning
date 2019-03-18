package cn.wyj.solution;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Pascals_TriangleTest {

    @Test
    public void generate() {

        int numRows = 5;
        List<List<Integer>> l = new Pascals_Triangle().generate(numRows);
        int count = numRows;
        for (List<Integer> ll : l) {
            for (int i = 0; i < count; i++) {
                System.out.print(" ");
            }
            count--;

            for (int i : ll) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void generate2() {
        int numRows = 5;
        assert new Pascals_Triangle().generate2(numRows).equals(new Pascals_Triangle().generate(numRows));
    }
}