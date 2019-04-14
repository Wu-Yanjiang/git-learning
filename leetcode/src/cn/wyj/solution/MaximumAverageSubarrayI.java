package cn.wyj.solution;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int ans = 0;
        int tmp = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            //预备ans
            if (i < k) {
                ans += nums[i];
                tmp = ans;
            }
            else {
                tmp += nums[i]-nums[pre++];
                ans = Math.max(tmp, ans);
            }
        }

        return ans / (double)k;
    }
}
