package cn.wyj.solution;

import java.util.*;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        Set<Character> u = new HashSet<>();
        u.add('a');
        u.add('e');
        u.add('i');
        u.add('o');
        u.add('u');
        u.add('A');
        u.add('E');
        u.add('I');
        u.add('O');
        u.add('U');
        ArrayList<Character> ls = new ArrayList<>();
        StringBuilder ans = new StringBuilder(s);
        for (int i = 0; i < ans.length(); i++) {
            if (u.contains(ans.charAt(i))) {
                ls.add(ans.charAt(i));
            }
        }
        for (int i = ans.length() - 1; i >= 0; i--) {
            if (u.contains(ans.charAt(i))) {
                char c = ls.remove(0);
                ans.setCharAt(i, c);
            }
        }

        return ans.toString();
    }

    public String reverseVowels2(String s) {
        int pre = 0, end = s.length() - 1;
        String tb = "aeiouAEIOU";
        char[] t = s.toCharArray();
        while (pre < end) {
            while (pre < end && !tb.contains(t[pre] + "")) pre++;
            while (pre < end && !tb.contains(t[end] + "")) end--;

            char tmp = t[pre];
            t[pre++] = t[end];
            t[end--] = tmp;
        }
        return new String(t);
    }
}
