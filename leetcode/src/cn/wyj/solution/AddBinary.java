package cn.wyj.solution;

public class AddBinary {

    /**
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        final int length = a.length() > b.length() ? a.length() : b.length();
        int[] a1 = new int[length + 1];
        int[] b1 = new int[length + 1];
        int index = a.length() - 1, i = 0;

        System.out.println("a1.lenght:---->" + a1.length);

        while (index != -1) {
            a1[i++] = a.charAt(index--) - '0';
            System.out.print(a1[i - 1] + " ");
        }
        System.out.println("\n---------------------");

        index = b.length() - 1;
        i = 0;
        while (index != -1) {
            b1[i++] = b.charAt(index--) - '0';
            System.out.print(b1[i - 1] + " ");
        }
        System.out.println("\n运算如下---------------------");

        /**a b c v c
         * 0 0 0 0 0
         * 0 0 1 1 0
         * 0 1 0 1 0
         * 0 1 1 0 1
         * 1 0 0 1 0
         * 1 0 1 0 1
         * 1 1 0 0 1
         * 1 1 1 1 1
         */

        int carry = 0;
        int value = 0;
        for (int j = 0; j < a1.length; j++) {
            value = a1[j] ^ b1[j] ^ carry;
            carry = a1[j] & b1[j] | a1[j] & carry | b1[j] & carry;
            a1[j] = value;
            System.out.print(a1[j] + " ");
        }

        index = a1.length - 1;
        while (index >= 0 && a1[index] != 1) {
            index--;
        }
        if (index == -1) {
            System.out.println("index越界");
            return "0";
        }
        System.out.println("\nindex = " + index);


        while (index >= 0) {
            ans.append((char) (a1[index--] + '0'));
        }

        System.out.println("\nans:" + ans.toString());

        return ans.toString();
    }
}
