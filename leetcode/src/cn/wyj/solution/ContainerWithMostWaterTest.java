package cn.wyj.solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {

    @Test
    public void maxArea() {
    }

    @Test
    public void maxArea2() {
        int[] a = {1,8,6,2,5,4,8,3,7};
        assert new ContainerWithMostWater().maxArea2(a) == new ContainerWithMostWater().maxArea(a);
    }
}