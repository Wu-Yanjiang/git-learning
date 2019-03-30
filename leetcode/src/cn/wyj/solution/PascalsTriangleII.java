package cn.wyj.solution;

import java.util.*;

public class PascalsTriangleII {

    //0开始
    /*
     *
     * */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new LinkedList<>();
        ans.add(1);
        if (rowIndex == 0) {
            return ans;
        } else if (rowIndex == 1) {
            ans.add(1);
            return ans;
        }
        ans.add(1);
        while (rowIndex > 1) {
            List<Integer> tmp = new LinkedList<>();
            tmp.add(1);
            for (int i = 0; i < ans.size() - 1; i++) {
                tmp.add(ans.get(i) + ans.get(i + 1));
            }
            tmp.add(1);
            ans = tmp;
            rowIndex--;
        }

        return ans;
    }

    public List<Integer> getRow2(int rowIndex) {
        Integer[] ans = new Integer[rowIndex + 1];
        ans[0] = 1;
        for (int i=1; i<ans.length; i++)
            ans[i] = 0;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                ans[j] += ans[j - 1];
            }
        }

        return Arrays.asList(ans);
    }
}
