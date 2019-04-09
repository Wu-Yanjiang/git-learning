package cn.wyj.solution;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += i;
        int pivot;
        int preSum = 0;
        for (pivot = 0; pivot < nums.length; pivot++) {
            int reSum = sum - nums[pivot] - preSum;
            if (reSum == preSum) return pivot;
            preSum += nums[pivot];
        }

        return -1;
    }
}
