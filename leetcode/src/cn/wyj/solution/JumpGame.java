package cn.wyj.solution;

public class JumpGame {
    /*
    * [2,5,0,0]
    * */
    public boolean canJump(int[] nums) {
        //遍历一下数组，判断数组每个元素当前最远可以跳到哪里
        //max表示最远可以到达的位置
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            //i表示当前位置,比最远位置还远了，就表示不可达
            if (i > max)
                return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
