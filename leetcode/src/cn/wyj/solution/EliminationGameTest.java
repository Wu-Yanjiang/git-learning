package cn.wyj.solution;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EliminationGameTest {

    @Test
    public void lastRemaining() {
        for (int i=1; i<=100; i++) {
            int ls = new EliminationGame().lastRemaining(i);
            System.out.println(i + ":\t\t" + ls);
        }
    }
}