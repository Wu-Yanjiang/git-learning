package com.algorithm;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Sort {
    private static int[] nums;

    public static void main(String[] args){
        show(new BubbleSort());
        show(new InsertSort());
        show(new quicSort());

    }

    private static void show(@NotNull StandardSort s){
        System.out.printf("%s----------------------------------------------------------%n", s.name());
        getRandom();
        beforeSort(nums);
        s.Sort(nums);
        afterSort(nums);
    }

    private static void getRandom(){
        nums = new int[20];
        Random rd = new Random(System.currentTimeMillis());
        for(int i = 0; i < 20; i++){
            nums[i] = rd.nextInt(50);
        }

    }

    private static void beforeSort(@NotNull int[] nums){
        System.out.print("排序前:");
        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void afterSort(@NotNull int[] nums){
        System.out.print("排序后:");
        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
