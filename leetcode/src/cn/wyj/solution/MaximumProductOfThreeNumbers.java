package cn.wyj.solution;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    /*
     *   The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
     *   Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
     * */

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    public int maximumProduct2(int[] nums) {
        int min1 = Integer.MIN_VALUE, min2 = Integer.MIN_VALUE;
        int max1 = Integer.MAX_VALUE, max2 = Integer.MAX_VALUE, max3 = Integer.MAX_VALUE;
        for (int i : nums) {
            
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
