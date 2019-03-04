package com.algorithm;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class quicSort extends StandardSort{
    @Contract(pure = true)
//    There is something wrong in this function.
/*
 *
 * @param low 低位
	* @param high 高位
	* @param numbers 待排序数组
  * @return 中间数
 * @author wuyanjiang
 * @date
 */
    private static int getMiddle(int low, int high, @NotNull int[] numbers){
        int middle = numbers[low];
        while (low < high){
            while (low < high  && numbers[high] >= middle){
                high--;
            }

            numbers[low] = numbers[high];

            while (low < high && numbers[low] < middle){
                low++;
            }

            numbers[high] = numbers[low];
        }
        numbers[low] = middle;

        return  low;
    }

    private void Quick(int low, int high, int[] numbers){
        if(low < high){
            int mid = getMiddle(low, numbers.length, numbers);
            Quick(0, mid-1, numbers);
            Quick(mid+1, high, numbers);
        }
    }
    @Override
    public void Sort(int[] numbers) {
        if (numbers.length > 0) {
            Quick(0, numbers.length-1, numbers);
        }
    }

    @Override
    public String name() {
        return "快速排序";
    }
}
