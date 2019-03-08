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

    int[] ary;

    @Test
    public void fiboTest(){
        for (int i=0; i<10; i++){
            System.out.println(fibo(i));
        }
    }

    public int fibo(int num){
        if ( num <= 1){
            return 1;
        }
        int i = 1;
        int i1 = 0;
        int i2 = 1;
        for (int j=0; j<num; j++){
            i = i1 + i2;
            i1 = i2;
            i2 = i;
        }

        return i;
    }

    @Test
    public void maxSubArrayTest(){
        assert 6 == maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }

    public int maxSubArray(int[] nums) {
        int ans = 0;

        return  ans;
    }

    @Test
    public void test() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat", "abbab", "aabbb", "a", "aa"};

        for (List<String> l1 : groupAnagrams(strs)) {
            for (String st : l1) {
                System.out.print(st + ',');
            }
            System.out.println();
        }
        int str = new String().indexOf('2');
    }

    @Test
    public void sortAttayByParityTest() {
        /*
         *  1 <= A.length <= 5000
         *  0 <= A[i] <= 5000
         */
        int[] A = new int[]{3, 1, 2, 4};//{3，1，2，4}->{4，1，2，3}->{4，2，1，3}
        A = new int[]{0,2};
        for (int i : sortArrayByParity(A)) {
            System.out.print(i + " ");
        }
    }

    public int[] sortArrayByParity(int[] A) {
        //返回前偶后奇的数组


        //版本2:双指针+就地 不好做，需要的判断太多！！！
//        int even_p = A.length - 1;         //指向未排好的第一个偶数指针，从后往前
//        int odd_p = 0;                //指向未排好的第一一个奇数指针，从前往后
//        int temp;
//        while (even_p > odd_p) {
//            while (0 != A[even_p] % 2) {
//                even_p--;
//                if (even_p<0)
//                    return A;
//            }
//            while (1 != A[odd_p] % 2){
//                odd_p++;
//                if (odd_p>A.length-1)
//                    return A;
//            }
//            temp = A[even_p];
//            A[even_p] = A[odd_p];
//            A[odd_p] = temp;
//
//            even_p--;
//            odd_p++;
//
////            for (int i : A){
////                System.out.print(i + ",");
////            }
////            System.out.println("\nSwap: index[" + odd_p + "] and index[" + even_p + "]");
//        }
//        return A;

        //版本1 ：双指针法+临时数组
        int even_p = -1;         //指向已排好的最后一个偶数指针，从前往后
        int odd_p = A.length;   //指向已排好的最后一个奇数指针，从后往前
        int[] ans = new int[A.length];
        for (int i : A){
            if (0 == i%2){      //i为偶数,event_p指向的索引置数
                ++even_p;
                ans[even_p] = i;
            }else {
                --odd_p;
                ans[odd_p] = i;
            }
        }
        return ans;
    }

    //解法1，利用字符串排序后的String做为键,来分类Anagrams
    public static List<List<String>> groupAnagrams(String[] strs) {
//        if (0 == strs.length){
//            return new ArrayList<>();
//        }
//        Map<String, List> ans = new HashMap<>();
//        for (String str : strs){
//            char[] s = str.toCharArray();
//            Arrays.sort(s);
//            String key = String.valueOf(s);
//            if (!ans.containsKey(key)){
//                //Map中不包含key,就插入新的key和List
//                ans.put(key, new ArrayList<>());
//            }
//            //取得key对应的List，再在List中插入str
//            ans.get(key).add(str);
//        }
//
//        return new ArrayList(ans.values());


        //解法2，统计每个字符串的每一个字符的出现次数，全部一致则放在一个List当中
        if (0 == strs.length) {
            return new ArrayList<>();
        }
        Map<String, List> ans = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);//初始化数组置0
            for (char c : str.toCharArray()) {//计算字符出现次数
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {  //得到Anagrams唯一字符串
                // sb.append('#');         //不添加 ‘#’ 也可以，因为无论如何字符串长度都是26
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
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
