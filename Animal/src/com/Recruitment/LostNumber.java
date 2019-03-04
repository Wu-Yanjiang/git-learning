package com.Recruitment;

import java.util.Random;

public class LostNumber extends Question {
    private int[] nums;

    public LostNumber(){
        Random rd = new Random();
        int size = rd.nextInt(10) + 10;
        System.out.println("size is " + size);
        int lostNumber = rd.nextInt(size);
        System.out.println("lost number is " + lostNumber);
        nums = new int[size-1];
        for (int i=0; i<size-1; i++){
            if(i == lostNumber){
                nums[i] = 0x3f3f3f;
                continue;
            }
            nums[i] = i;
        }
    }
    @Override
    public String description() {
        return "给你一个数组{0,1,2,3,....n}，其中有一个数字缺失，请把缺失的数字找出来";
    }

    @Override
    public void input() {
        for(int i : nums){
            System.out.print(i + " ");
        }
    }

    @Override
    public void resolve() {
        for(int i = 0; i<nums.length-1; i++){
            if ( 1 != nums[i + 1] - nums[i]) {
                System.out.println("Lost number is " + (nums[i]+1));
                break;
            }
        }
    }
}
