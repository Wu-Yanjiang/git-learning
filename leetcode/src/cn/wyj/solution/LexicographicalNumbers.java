package cn.wyj.solution;

import java.util.LinkedList;
import java.util.List;

//Given an integer n, return 1 - n in lexicographical order.
//
//        For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
//
//        Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

public class LexicographicalNumbers {
//    按个位数遍历，在遍历下一个个位数之前，先遍历十位数，十位数的高位为之前的个位数，只要这个多位数并没有超过n，就可以一直往后遍历，
//    如果超过了，我们除以10，然后再加1，
//    如果加1后末尾形成了很多0，
//    那么我们要用个while循环把0都去掉，然后继续运算
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new LinkedList<>();
        int cur = 1;
        for (int i = 0; i < n; i++) {
            ans.add(cur);
            if (cur * 10 <= n)
                cur *= 10;
            else {
                if (cur >= n) cur /= 10;
                cur += 1;
                while (cur % 10 == 0) cur /= 10;
            }
        }
        return ans;
    }
}
