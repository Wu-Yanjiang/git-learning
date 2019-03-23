package cn.wyj.solution;

public class JumpGameII {
    /*[0]
     *0
     *
     * [1]
     * 0
     *
     */
    public int jump(int[] nums) {
        int max = 0;
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) break;

            max = Math.max(max, i + nums[i]);
            if (max < i + nums[i]) {
                step++;
                max = i + nums[i];
            }
            if (max >= nums.length - 1)
                break;
        }
        return step;
    }
}
