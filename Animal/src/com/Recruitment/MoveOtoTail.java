package com.Recruitment;

import java.util.Random;

public class MoveOtoTail extends Question {
    private int[] nums;

    public MoveOtoTail(){
        Random rd = new Random();
//        数组大小至少为10
        int size = rd.nextInt(10) + 10;
        nums = new int[size];
        for (int i=0; i<nums.length; i++){
            nums[i] = rd.nextInt(3);
        }
        nums[0] = 0;
    }
    @Override
    public String description() {
        return "将一个数组的元素，其中是0的，放在数组的最后";
    }

    @Override
    public void input() {
        for (int i : nums){
            System.out.print(i + " ");
        }
    }

    @Override
    public void resolve() {
        int high = nums.length-1;
        while (nums[high] == 0){
            high--;
        }

        for (int i=0; i<high; i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[high];
                nums[high] = temp;
                high--;
            }
        }

        for (int i : nums){
            System.out.print(i + " ");
        }
    }
}
