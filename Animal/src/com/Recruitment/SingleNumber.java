package com.Recruitment;

import java.util.HashMap;

public class SingleNumber extends Question {
    private int[] nums;
    private int ans;

    public SingleNumber() {
        nums = new int[]{4, 1, 2, 1, 2};
    }

    @Override
    public String description() {
        return "Given a non-empty array of integers, every element appears twice except for one. Find that single one.";
    }

    @Override
    public void input() {
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    @Override
    public void resolve() {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (!mp.containsKey(i)) {
                mp.put(i, 1);
                continue;
            } else {
                mp.remove(i);
            }
        }
        int[] i = new int[1];
        for (int j : mp.keySet()){
            i[0] = j;
        }
        System.out.println("Single number is " + i[0]);

    }
}
