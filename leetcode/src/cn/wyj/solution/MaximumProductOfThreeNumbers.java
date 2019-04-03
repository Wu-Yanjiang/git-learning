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
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        // min1 min2 ... ... max3 max2 max1
        for (int i : nums) {
            if (i <= min1) {
                min2 = min1;
                min1 = i;

            } else if (i <= min2) {
                min2 = i;
            }
            if (i >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i >= max2) {
                max3 = max2;
                max2 = i;
            } else if (i >= max3) {
                max3 = i;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
