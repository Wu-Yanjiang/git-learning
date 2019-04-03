package cn.wyj.solution;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean flag = true;
            int tmp = i;
            while (tmp != 0) {
                int t = tmp % 10;
                if (t == 0) {
                    flag = false;
                    break;
                }
                if (0 != i % t) {
                    flag = false;
                    break;
                }
                tmp /= 10;
            }
            if (flag)
                ans.add(i);
        }

        return ans;
    }
}
