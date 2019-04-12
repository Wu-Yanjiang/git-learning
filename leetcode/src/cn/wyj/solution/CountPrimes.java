package cn.wyj.solution;

public class CountPrimes {
    public static int countPrimes(int n) {
        boolean[] tb = new boolean[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            tb[i] = true;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i + i; j <= n && tb[i]; j += i) {
                if (j % i == 0)
                    tb[j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (tb[i])
                count++;
        }
        return count;
    }
}
