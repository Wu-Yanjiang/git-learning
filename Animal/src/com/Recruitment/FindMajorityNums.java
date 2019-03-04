package com.Recruitment;

import java.util.HashSet;
import java.util.Random;
import java.util.Stack;

public class FindMajorityNums extends Question {
    int[] nums;
    Stack<Integer> st;

    /*
     *
     * @param null
      * @return
     * @author wuyanjiang
     * @date
     * @description
     */
    public FindMajorityNums(){
        nums = new int[30];
        Random rd = new Random();
        for(int i = 0; i < nums.length; i++){
            nums[i] = rd.nextInt(10);
            //随机数组置数
        }

//        HashSet<Integer> a = new HashSet<Integer>();
//        getIndex(nums.length/2, a, rd);

        //一半的数置-1
        for (int i = 0; i < nums.length; i+=2){
            nums[i] = -1;
        }
        nums[nums.length-1] = -1;
    }

//    private void getIndex(int n, HashSet<Integer> a, Random rd){
//        for(int i = 0; i < 10; i++){
//            a.add(rd.nextInt(10) + 5);
//        }
//        if (a.size() != 10)
//            getIndex(n - a.size(), a, rd);
//    }

    @Override
    public String description() {
        return "给你一个长度为n的数组，其中有一个数字出现的次数至少为n/2，找出这个数字";
    }

    @Override
    public void input() {
        for(int i : nums){
            System.out.print(i + " ");
        }
    }

    @Override
    public void resolve() {
        st = new Stack<Integer>();
        for (int i : nums){
            if (st.empty()){
                st.push(i);
                continue;
            }
            if(st.peek() == i){
                st.push(i);
            }
            else {
                st.pop();
            }
        }

        System.out.println("\n这个数字是：" + st.peek());
    }
}
