package cn.wyj.solution;

public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] value =     {1000, 900, 500, 400, 100,  90,  50,  40, 10,   9,  5,   4, 1 };
        String[] symbol = { "M","CM", "D","CD", "C","XC", "L","XL","X","IX","V","IV","I"};
        StringBuilder ans = new StringBuilder();
        if (num != 0){
            for (int i=0; i<value.length; i++){
                if (value[i] <= num){
                    ans.append(symbol[i]);
                    num -= value[i--];
                }
            }
        }

        return ans.toString();
    }
}
