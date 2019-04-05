package cn.wyj.solution;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return 0;
        if (nums.length == 0)
            return 0;
        return Math.max(nums[0] + robYou(nums, 2),
                nums[1] + robYou(nums, 3));
    }

    //[226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124]
    int robYou(int[] nums, int start) {
        if (start >= nums.length)
            return 0;
        if (start + 1 >= nums.length)
            return nums[start] + robYou(nums, start + 2);
        return Math.max(nums[start] + robYou(nums, start + 2),
                nums[start + 1] + robYou(nums, start + 3));
    }

    int rob2(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 0)
            return 0;
        int ret = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int max = nums[0];
            for (int j = 0; j < i - 1; j++) {
                if (nums[j] > max)
                    max = nums[j];
            }
            nums[i] += max;
            if (nums[i] > ret)
                ret = nums[i];
        }
        return ret;
    }

    int rob3(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i-2], nums[i-1]);
        }
        return nums[nums.length - 1];
    }
}
