package cn.wyj.solution;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrimeFactorDecomposition {

    static {
        LinkedList<Integer> prime = new LinkedList<>();
        /******生成质数表***/
        for (int i = 2; i <= 2000; i++)
            prime.add(i);
        for (int i = 0; i < prime.size(); i++) {
            for (int j = i + 1; j < prime.size() && 0 != prime.get(i); j++) {
                int num1 = prime.get(i);
                int num2 = prime.get(j);
                if (num2 / num1 == 0) {
                    prime.set(j, 0);
                }
            }
        }
        for (int i = 0; i < prime.size(); i++) {
            if (prime.get(i) == 0)
                prime.remove(i);
        }
    }

    public static void decomposition(int N) {
        ArrayList<Integer> ans = new ArrayList<>();

        while (N != 1) {
            int i = 0;
            while (N % prime.get(i) != 0)
                i++;
            ans.add(prime.get(i));
            N /= prime.get(i);
        }
        for (int i : ans) {
            System.out.print(i + " ");
        }

    }
}
