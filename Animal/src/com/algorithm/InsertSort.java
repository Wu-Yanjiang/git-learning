package com.algorithm;

public class InsertSort extends StandardSort{
    @Override
    public void Sort(int[] numbers) {
        int size = numbers.length;
        int temp = 0 ;
        int j =  0;

        for(int i = 0 ; i < size ; i++)
        {
            temp = numbers[i];
            //假如temp比前面的值小，则将前面的值后移
            for(j = i ; j > 0 && temp < numbers[j-1] ; j --)
            {
                numbers[j] = numbers[j-1];
            }
            numbers[j] = temp;
        }
    }

    @Override
    public String name() {
        return "插入排序";
    }
}
