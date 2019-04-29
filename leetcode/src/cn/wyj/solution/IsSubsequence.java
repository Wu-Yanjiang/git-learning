package cn.wyj.solution;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sIndex, tIndex;
        for (sIndex = 0, tIndex = 0; sIndex < s.length() && tIndex < t.length(); tIndex++) {
            if (s.charAt(sIndex) == t.charAt(tIndex))
                sIndex++;
        }
        return sIndex == s.length();
    }
}
