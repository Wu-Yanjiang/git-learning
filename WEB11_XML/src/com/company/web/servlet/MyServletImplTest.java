package com.company.web.servlet;

import org.junit.Test;

import java.util.*;

public class MyServletImplTest {
//    @Test
//    public void  testMyServlet(){
//        MyServletImpl my = new MyServletImpl();
//        my.init();
//        my.service();
//        my.destroy();
//    }

    @Test
    public void testMyServlet1() {
        try {
            String className = "com.company.web.servlet.MyServletImpl";
            Class clazz = Class.forName(className);
            MyServletImpl my = (MyServletImpl) clazz.newInstance();
            my.init();
            my.service();
            my.destroy();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void init() {
    }

    @Test
    public void service() {
    }

    @Test
    public void destroy() {
    }


    @Test
    public void numUniqueEmails() {
        String[] emails = new String[]{"test.email+alex@leetcode.com",
                "t...e....s...t.......e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};
        int indexP = -1;
        int indexAt = -1;
        String subStr = null;
        Set<String> ans = new HashSet<>();

        for (String str : emails) {
            indexAt = str.indexOf('@');//找到@
            indexP = str.indexOf('+');//找到 + 号
            if (indexP > 0) {
                subStr = str.substring(0, indexP);// +号之前的子串
            } else {//没有找到 + 号
                subStr = str.substring(0, indexAt); //取得@号之前的子串

            }
            subStr = subStr.replace(".", ""); //消除子串的 . 号
            subStr = subStr + str.substring(indexAt);//拼接子串和 @ 号之后的子串
            ans.add(subStr);
        }

        System.out.println(ans.size());
    }


    @Test
    public void uniqueMorseRepresentations() {
        String[] words = {"gin", "zen", "gig", "msg"};
        String[] table = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> ans = new HashSet<>();
        StringBuilder tf = new StringBuilder();
        for (String str : words) {
            for (char c : str.toCharArray()) {
                tf.append(table[c - 'a']);
            }
            ans.add(tf.toString());
            tf.delete(0, tf.length());
        }
        System.out.println(ans.size());
    }

    public void reverseString(char[] s) {
        int length = s.length;
        char temp;
        for (int i = 0; i < length / 2; i++) {
            temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
    }

    public List<String> fizzBuzz(int n) {
        List<String> ans = new LinkedList<>();
        for (int i=1; i<=n; i++){
            if ( 0 == i%15){
                ans.add("FizzBuzz");
            }
            else if ( 0 == i%3){
                ans.add("Fizz");
            }
            else if ( 0 == i%5){
                ans.add("Buzz");
            }
            else {
                ans.add(String.valueOf(i));
            }
        }
        return  ans;
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> set = new HashMap<>();
        for (char c : s.toCharArray()){
            if (set.containsKey(c)){
                int value = set.get(c);
                value++;
                set.remove(c);
                set.put(c, value);
            }else {
                set.put(c, 1);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (char c : t.toCharArray()){
            if(!set.containsKey(c)){
                return false;
            }else {
                int value = set.get(c);
                value--;
                if (value<0)
                    return false;
                set.remove(c);
                set.put(c, value);
            }
        }

        return true;
    }
}