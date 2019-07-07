package cn.wyj.solution;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int ans = 0;
        int len = s.length();
        for (char t : s.toCharArray()) {
            int tmp = t - 'A' + 1;
            ans += tmp * Math.pow(26, len-1);
            len--;
        }

        return ans;
    }
}
