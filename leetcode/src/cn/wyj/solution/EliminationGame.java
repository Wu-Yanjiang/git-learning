package cn.wyj.solution;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EliminationGame {
    public int lastRemaining(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            ans.add(i);
        boolean lStart = true;
        while (ans.size() != 1) {
            List<Integer> tmp = new ArrayList<>();
            if (!lStart)
                Collections.reverse(ans);
            int k = 1;
            for (int i : ans) {
                if (k % 2 == 0)
                    tmp.add(i);
                k++;
            }
            if (!lStart)
                Collections.reverse(tmp);
            ans = tmp;
            lStart = !lStart;
        }
        return ans.get(0);
    }

    public int lastRemaining2(int n) {
        return n == 1 ? 1 : 2 * (1 + n / 2 - lastRemaining2(n / 2));
    }

//    public boolean haveFunWithNum(int n) {
//        BigInteger a = new BigInteger(String.valueOf((n)));
//        int b = a.intValue()/10;
//        a = a.multiply(new BigInteger(String.valueOf(2)));
//
//    }
}
