package cn.wyj;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(0.06 + 0.01);
        System.out.println(1.0 - 0.42);
        System.out.println(4.014 * 100);
        System.out.println(303.1 / 1000);
        System.out.println(2.0 / 0.0);

        BigDecimal a = new BigDecimal(Double.toString(0.06));
        BigDecimal b = BigDecimal.valueOf(0.01);
        System.out.println(a.add(b).doubleValue());
        System.out.println(BigDecimal.valueOf(1.0).
                subtract(BigDecimal.valueOf(0.42)));
        System.out.println(BigDecimal.valueOf(4.014).
                multiply(BigDecimal.valueOf(100)));
        System.out.println(BigDecimal.valueOf(303.1).
                divide(BigDecimal.valueOf(1000)));
        System.out.println(new BigDecimal("99999999999999999999999999999999.9999999999999999999").
                multiply(new BigDecimal("99999999999999999.99999999999999999999")).toString());
        System.out.println(BigDecimal.valueOf(2.0).
                divide(BigDecimal.valueOf(0.)));
    }
}
