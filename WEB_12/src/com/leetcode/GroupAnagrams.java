package com.leetcode;

import org.junit.Test;

import java.util.*;

/*
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*
* */

public class GroupAnagrams {

    @Test
    public void test() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        for (List<String> l1 : groupAnagrams(strs)) {
            for (String st : l1) {
                System.out.print(st + ',');
            }
            System.out.println();
        }
        int str = new String().indexOf('2');
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> ans = new HashMap<>();
        for (String str : strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = String.valueOf(s);
            if (!ans.containsKey(key)){
                //Map中不包含key,就插入新的key和List
                ans.put(key, new ArrayList());
            }
            //取得key对应的List，再在List中插入str
            ans.get(key).add(str);
        }

        return new ArrayList(ans.values());
















        //官方版本
//
//        if (strs.length == 0) return new ArrayList();
//        Map<String, List> ans = new HashMap<String, List>();
//        for (String s : strs) {
//            char[] ca = s.toCharArray();
//            Arrays.sort(ca);
//            String key = String.valueOf(ca);
//            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
//            ans.get(key).add(s);
//        }
//        return new ArrayList(ans.values());
//


//        List<List<String>> ans = new ArrayList<>();
//        LinkedList<String> ll = new LinkedList<>();//初试化LinkedList对象
//
//        for (String str : strs) {
//            ll.add(str);
//        }
//
//        //版本2， 增加一个int[]来保存下标
//        ArrayList<Integer> index_xy = new ArrayList<>();
//        for (int i = 0; i < index_xy.size(); i++) {
//            index_xy.set(i, -1);            //初始化索引数组
//        }
//
//        for (String str : ll) {
//            List<String> tmp = new ArrayList<>();//当前暂存的同义词列表
//            char[] s = str.toCharArray();   //s是用于比较的正序同义词
//            Arrays.sort(s);
//            tmp.add(str);
//            ll.remove(str);//将第一个字符串从ll中移除，因为其char[]与s相等，故可以用s来比较
//
//            for (String str2 : ll) {
//                char[] s2 = str2.toCharArray();//将str2变为char[] s2,并对数组排序用于和s比较来得是否相等
//                Arrays.sort(s2);
//                if (Arrays.equals(s, s2)) {
//                    tmp.add(str2);
//                    ll.remove(str2);//tmp已经添加str2,故将str2从ll中移除
//                }
//            }
//            ans.add(tmp);
//        }

//        //版本1 因为修改了list,不能运行
//        for (String str : ll) {
//            List<String> tmp = new ArrayList<>();//当前暂存的同义词列表
//            char[] s = str.toCharArray();   //s是用于比较的正序同义词
//            Arrays.sort(s);
//            tmp.add(str);
//            ll.remove(str);//将第一个字符串从ll中移除，因为其char[]与s相等，故可以用s来比较
//
//            for (String str2 : ll){
//                char[] s2 = str2.toCharArray();//将str2变为char[] s2,并对数组排序用于和s比较来得是否相等
//                Arrays.sort(s2);
//                if (Arrays.equals(s, s2)){
//                    tmp.add(str2);
//                    ll.remove(str2);//tmp已经添加str2,故将str2从ll中移除
//                }
//            }
//            ans.add(tmp);
//        }

//        return ans;
    }
}
