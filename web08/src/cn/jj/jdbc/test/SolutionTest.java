package cn.jj.jdbc.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Solution {

    public static void main(String[] args) {

        assert numJewelsInStones("ngm", "kxg") == numJewelsInStones2("ngm", "kxg");
        assert numJewelsInStones("ebd", "bbb") == numJewelsInStones2("ebd", "bbb");
        assert numJewelsInStones("aA", "aAAbbbb") == numJewelsInStones2("aA", "aAAbbbb");
//
//        System.out.println(numJewelsInStones("ngm", "kxg"));
//        System.out.println(numJewelsInStones("ebd", "bbb"));
//        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }


    public int numUniqueEmails(String[] emails) {
        String tmp = null;
        HashSet<String> hs = new HashSet<>();
        int indexP = 0;
        int indexA = 0;
        for (String str : emails){
            indexP = str.indexOf('+');
        }
        return hs.size();
    }

    public static int numJewelsInStones2(String J, String S){
        int ans = 0;
        //J 字符数组中对应有J的字符的置为true
        boolean[] charJ = new boolean[128];
        for (char j : J.toCharArray()){
            charJ[j] = true;
        }

        for (char s : S.toCharArray()){
            //如果S中对应的字符，数组中找得到
            if (charJ[s]){
                ans ++;
            }
        }
        return ans;
    }

    /**
     * 构造一个HashMap键为J的每一个字符,值为S中每个字符的个数
     *
     * @param J
     * @param S
     * @return
     */
    public static int numJewelsInStones(String J, String S) {
        int num = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < J.length(); i++) {
            map.put(J.charAt(i), 0);
        }

        LinkedList<Character> ls = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            ls.add(S.charAt(i));
        }

        int value = 0;
        int index = 0;
        char c;
        for (int i=0; i<J.length(); i++) {
            c = J.charAt(i);
            index = ls.indexOf(c);
            System.out.println("字符:" + c + " index:" + index);
            while (index >= 0) {
                value = map.get(c);
                map.remove(c);
                map.put(c, value + 1);
                ls.remove(index);
                index = ls.indexOf(c);
            }
        }


        for (int i : map.values()) {
            num += i;
        }
        return num;
    }
}