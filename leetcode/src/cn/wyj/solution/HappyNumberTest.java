package cn.wyj.solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class HappyNumberTest {

    @Test
    public void isHappy() {

        int p = 987654321;
        assert new HappyNumber().isHappy2(p) == new HappyNumber().isHappy(p);

    }

    @Test
    public void isHappy2(){
        assert false == new HappyNumber().isHappy2(99);
    }


}