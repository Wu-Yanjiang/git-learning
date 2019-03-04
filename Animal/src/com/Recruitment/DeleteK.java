package com.Recruitment;

import java.util.ArrayList;
import java.util.Random;

public class DeleteK extends Question{
    ArrayList<Integer> nums;
    int k;

    public DeleteK(int k){
        this.k = k;
    }

    @Override
    public String description() {
        return "删除数组下标为"+ k +"的元素";
    }

    @Override
    public void input() {
        nums = new ArrayList<>();
        Random rd = new Random();
        for(int i = 0; i < 20; i++){
            nums.add(rd.nextInt(20));
            System.out.print(nums.get(i) + " ");
        }
        System.out.println();
    }

    @Override
    public void resolve() {
        if(k<0 || k>=nums.size()){
            System.out.println("数组越界。");
            return;
        }
        for(int i=k; i<nums.size()-1; i++){
            nums.set(i, nums.get(i+1));
        }
        nums.remove(nums.size()-1);

        for (int i : nums){
            System.out.print(i + " ");
        }
    }
}
