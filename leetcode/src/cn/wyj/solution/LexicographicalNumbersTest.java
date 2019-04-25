package cn.wyj.solution;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LexicographicalNumbersTest {

    @Test
    public void lexicalOrder() {
        List<Integer> a = new LexicographicalNumbers().lexicalOrder(100);
        for (int i : a) {
            System.out.println(i);
        }
    }
}