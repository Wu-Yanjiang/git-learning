package cn.wyj.solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindWordsTest {

    @Test
    public void findWords() {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] a = new FindWords().findWords(words);
        for (String i : a) {
            System.out.println(i);
        }
    }
}