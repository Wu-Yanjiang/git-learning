package cn.wyj.solution;

import java.util.Arrays;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        ans[1] = nums[0];
        for (int i = 0, j = 1; j < nums.length; i++, j++) {
            if (nums[j] == nums[i]) {
                ans[0] = nums[i];
                continue;
            }
            ans[1] += nums[j];
        }
        ans[1] = nums.length * (1 + nums.length) / 2 - ans[1];
        return ans;
    }
}
