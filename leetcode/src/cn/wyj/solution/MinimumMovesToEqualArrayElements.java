package cn.wyj.solution;

public class MinimumMovesToEqualArrayElements {


    //效率太慢，解数学题吧！
    public int minMoves(int[] nums) {
        int ans = 0;
        while (!checkEqual(nums)) {
            ans++;
            int maxIndex = findMax(nums);
            int minIndex= findMin(nums);
            int d = nums[maxIndex]-nums[minIndex];
            ans += d;
            increas(nums, maxIndex, d);
        }
        return ans;
    }

    /**
     * @param nums
     * @param skip
     * @param d    增量，n-1个元素要增加d
     */
    //n-1个元素自增1
    public void increas(int[] nums, int skip, int d) {
        for (int i = 0; i < nums.length; i++) {
            if (i == skip)
                continue;
            else
                nums[i] += d;
        }
    }

    //找到最大值的索引
    public int findMax(int[] nums) {
        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[p]) {
                p = i;
            }
        }
        return p;
    }

    public int findMin(int[] nums) {
        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[p]) {
                p = i;
            }
        }
        return p;
    }

    public boolean checkEqual(int[] nums) {
        int target = nums[0];
        for (int i : nums) {
            if (i != target)
                return false;
        }
        return true;
    }
}
