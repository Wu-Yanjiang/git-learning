package cn.wyj.solution;

import java.util.*;

public class Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();
        int n = 0;
        //n表示当前轮次,共numRows轮
        while (n++ < numRows) {
            //用n初始化，他的size不是n,还是0
            //List中真实有多少个元素，size就是多少
            //用add方法，size就会变长
            //set只能用在size范围内
            /*******************初始化同一个值新技能  get!!!  **************************/
            List<Integer> tmp = new ArrayList<>(Collections.nCopies(n, 0));
            //添加头1
            tmp.set(0, 1);

            if (n >= 3) {
                List<Integer> last = ((LinkedList<List<Integer>>) ans).getLast();
                int cur = 1;
                for (int i = 1; i <= last.size() - 1; i++) {
                    tmp.set(cur++, last.get(i) + last.get(i - 1));
                }
            } else if (2 == n) {
                // 第二层手动添加尾1
                tmp.set(tmp.size() - 1, 1);
                ans.add(tmp);
                continue;
            }
            //添加尾1
            tmp.set(tmp.size() - 1, 1);

            ans.add(tmp);
        }
        return ans;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();
        ArrayList<Integer> row = new ArrayList<>();
        while (numRows-- > 0) {
            //添加头1
            row.add(0, 1);
            //添加中部
            for (int i = 1; i < row.size() - 1; i++) {
                row.set(i, row.get(i) + row.get(i + 1));
            }
            ans.add(new ArrayList<>(row));
        }

        return ans;
    }
}
