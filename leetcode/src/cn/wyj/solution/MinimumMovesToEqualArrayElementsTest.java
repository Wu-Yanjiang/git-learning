package cn.wyj.solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumMovesToEqualArrayElementsTest {

    @Test
    public void minMoves() {
        int[] a = {1,2,3};
        assert 3 == new MinimumMovesToEqualArrayElements().minMoves(a);
    }
}