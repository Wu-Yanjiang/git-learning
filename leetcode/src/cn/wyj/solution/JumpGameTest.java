package cn.wyj.solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameTest {

    @Test
    public void canJump() {
        assert new JumpGame().canJump(new int[]{2, 5, 0, 0});
    }
}