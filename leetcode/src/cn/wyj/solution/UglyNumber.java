package cn.wyj.solution;

public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0)
            return false;
        int i = 2;
        while (num != 1) {
            while (num % i != 0){
                i++;
                if (i>5)    return false;
            }
            num /= i;
        }

        return true;
    }
}
