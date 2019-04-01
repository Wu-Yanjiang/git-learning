package cn.wyj.solution;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int a = 0, b = numbers.length - 1;
        while (target != numbers[a] + numbers[b]) {
            if (numbers[a] + numbers[b] > target)
                b--;
            else
                a++;
        }
        ans[0] = a+1;
        ans[1] = b+1;

        return ans;
    }
}
