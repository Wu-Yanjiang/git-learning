package cn.wyj.solution;

import java.util.Arrays;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], nums[i] + pre);
            ans = Math.max(pre, ans);
        }
        return ans;
    }
}
