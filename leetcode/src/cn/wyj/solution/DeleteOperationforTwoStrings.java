package cn.wyj.solution;

import java.util.Arrays;
// wrong
public class DeleteOperationforTwoStrings {
    /*
     * "sea"
     * "ate"
     *
     *  4
     *
     * */

    public int minDistance(String word1, String word2) {
        int ans = 0;
        int[] tb = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            tb[word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word2.length(); i++) {
            int index = word2.charAt(i) - 'a';
            if (0 == tb[index])
                ans++;
            else
                tb[index]--;
        }
        for (int i : tb) {
            ans += i;
        }

        return ans;
    }
}
