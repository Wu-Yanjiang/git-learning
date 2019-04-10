package cn.wyj.solution;

import java.lang.reflect.Array;
import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        //"ab"
        //"aa"
        Map<Character, Character> mp = new HashMap<>();
        Set<Character> se = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp1 = s.charAt(i);
            char tmp2 = t.charAt(i);
            if (mp.containsKey(tmp1)) {
                if (tmp2 != mp.get(tmp1))
                    return false;
            } else if (se.contains(tmp2)) {
                return false;
            } else {
                mp.put(tmp1, tmp2);
                se.add(tmp2);
            }
        }

        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        int[] tb = new int[128];
        int[] tb2 = new int[128];
        Arrays.fill(tb, 0);
        Arrays.fill(tb2, 0);
        for (int i = 0; i < s.length(); i++) {
            char tmp1 = s.charAt(i);
            char tmp2 = t.charAt(i);
            if (tb[tmp1] == 0) {
                //要加时发现tmp2已经被射过了
                if (tb2[tmp2] == 1)
                    return false;
                //hash表中没有就加<tmp1, tmp2>
                tb[tmp1] = tmp2;
                tb2[tmp2] = 1;
            } else if(tb[tmp1] != tmp2) {
                //hash表中有但是对不上
                return false;
            }
        }
        return true;
    }
}
