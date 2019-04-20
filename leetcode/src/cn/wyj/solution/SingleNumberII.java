package cn.wyj.solution;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                // 求末位1的个数
                sum += (nums[j] >> i) & 1;
            }
            //用或运算和左移还原数字
            res |= (sum % 3) << i;
        }
        return res;
    }
}
