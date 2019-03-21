package cn.wyj.solution;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddToArrayForm {
    // 法1：求A[]的bigInteger与K相加再求List
//    public List<Integer> addToArrayForm(int[] A, int K) {
//        //A.length <1000
//        BigInteger a = new BigInteger("0");
//        int in = 1;
//        //求A的整数形式
//        for (int i = A.length - 1; i >= 0; i--) {
//            a.add(new BigInteger() );
//            a += A[i] * in;
//            in *= 10;
//        }
//        int sum = a + K;
//        List<Integer> ans = new ArrayList<>();
//        while (sum != 0) {
//
//            ans.add(sum % 10);
//            sum /= 10;
//        }
//        Collections.reverse(ans);
//        return ans;
//    }
    //法2：求K的int[]与A[]相加
    public List<Integer> addToArrayForm2(int[] A, int K) {
        int[] kArray = new int[5];
        //将K数组化
        for (int i = kArray.length - 1; i >= 0; i--) {
            kArray[i] = K % 10;
            K /= 10;
        }
        //t是第一个K不为0的索引
        int t = 0;
        while ( 0 == kArray[t] ){
            if (t == kArray.length-1)
                break;
            t++;
        }

        List<Integer> ans = new ArrayList<>();
        int carry = 0;

        //数组加
        int i = A.length - 1, j = kArray.length - 1;
        while (true) {
            int sum = carry;
            if (i >= 0) {
                sum += A[i--];
            }
            if (j >= t) {
                sum += kArray[j--];
            }
//1 2 0 0
//0 0 0 1
            /**
             * [2,7,4]
             *  1 8 1
             * =5 5 4 0 0
             */
            System.out.print(sum%10);
            ans.add(sum % 10);
            carry = sum / 10;

            if (i < 0 && j < t)
                break;
        }
        //如果最后加完有进位，说明溢出，再补一个1
        if (carry != 0){
            ans.add(carry);
        }

        //尾插法添加的数，再逆序一次
        Collections.reverse(ans);

        return ans;
    }
}
