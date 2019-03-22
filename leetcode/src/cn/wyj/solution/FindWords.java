package cn.wyj.solution;

import java.util.ArrayList;

public class FindWords {
    public String[] findWords(String[] words) {
        ArrayList<String> ans = new ArrayList<>();

        //字母表
        String[] line = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        //
        for (String j : words) {
            String i = j.toLowerCase();
            int line_num;
            //确定第一个字母的行号
            char f1 = i.charAt(0);
            for (line_num = 0; line_num < line.length; line_num++) {
                if (find(f1, line_num, line)) {
                    break;
                }
            }

            boolean suc = true;
            for (char c : i.toCharArray()) {
                if (!find(c, line_num, line)) {
                    suc = false;
                    break;
                }
            }
            if (suc) {
                ans.add(j);
            }
        }
        String[] ret = new String[ans.size()];
        for (int i=0; i<ans.size(); i++){
            ret[i] = ans.get(i);
        }
        return ret;
    }

    //该行是否含指定字母
    public boolean find(char a, int line_num, String[] line) {
        for (char i : line[line_num].toCharArray()) {
            if (i == a)
                return true;
        }
        return false;
    }
}
