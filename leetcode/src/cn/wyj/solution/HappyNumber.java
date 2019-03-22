package cn.wyj.solution;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        boolean ans = false;
        //保存sum
        HashSet<Integer> s = new HashSet<>();
        while (true) {
            int sum = 0;
            //求sum
            while (n != 0) {
                int k = n % 10;
                sum += k * k;
                n /= 10;
            }
            n = sum;

            System.out.println(sum);

            if (1 == sum) {
                ans = true;
                break;
            }
            if (s.contains(sum)) {
                ans = false;
                break;
            }
            s.add(sum);
        }
        return ans;
    }

    public boolean isHappy2(int n) {
        //此法也可以用于检测是否处在一个循环之中！！！！！！！！！！！！！！！太漂亮了这个解法
        int slow = n, fast = n;
        do {
            slow = sumOfSquareOfDigits(slow);
            System.out.print(slow + " ");
            fast = sumOfSquareOfDigits(fast);//每循环一次，fast就会快1，2，3，4，5,...步，最后总会相遇
            fast = sumOfSquareOfDigits(fast);
            System.out.println(fast );
        } while (slow != fast);
        if (slow == 1) {
            return true;
        }
        return false;
    }

    public int sumOfSquareOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int r = num % 10;
            sum += r * r;
            num = num / 10;
        }
        return sum;
    }


}
