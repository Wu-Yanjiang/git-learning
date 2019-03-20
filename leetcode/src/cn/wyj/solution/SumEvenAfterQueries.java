package cn.wyj.solution;

public class SumEvenAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        //第一位是值，第二位是索引
        int[] ans = new int[queries.length];
        // even + old  = old
        // even + even = even
        // old  + even = old
        // old  + old  = even
        // 遍历每一组queries
        int total = queries.length;
        int even_nums = 0;
        int old_nums = 0;
        int even_sum = 0;
        int old_sum = 0;
        for (int i : A) {
            if (0 == i % 2) {
                //偶数
                even_nums++;
                even_sum += i;
            } else {
                //奇数
                old_nums++;
                old_sum += i;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            boolean even = false;
            int pre = A[queries[i][1]];
            if (0 == pre % 2) {
                //原来的数是偶数
                even = true;
            } else {
                even = false;
            }
            //将指定值加到指定索引
            A[queries[i][1]] += queries[i][0];
            // 求偶数和
            //int sum = 0;

            if (even && 0 == queries[i][0] % 2) {
                //原来的数是偶数，加上的是偶数
                even_sum += queries[i][0];
            } else if (!even && 0 != queries[i][0] % 2) {
                //原来是奇数，加的数也是奇数
                even_sum += pre + queries[i][0];
            } else if (even && 0 != queries[i][0] % 2){
                //原来是偶数，加的是奇数
                even_sum -= pre;
            }
//            else if (!even && 0 == queries[i][0] % 2) {
//                //原来的数是奇数，但加的数是偶数,不变
//                ;
//            }


            // sum送进ans[]
                ans[i] = even_sum;
        }

        return ans;
    }
}
