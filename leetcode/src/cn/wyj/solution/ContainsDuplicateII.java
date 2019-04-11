package cn.wyj.solution;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);//每添加一个元素，就移除掉最左边K区间外的元素，始终保存set里最多k+1个元素
            if (!set.add(nums[i])) return true;//HashSet添加失败说明有重复值
        }

        return false;
    }
}
