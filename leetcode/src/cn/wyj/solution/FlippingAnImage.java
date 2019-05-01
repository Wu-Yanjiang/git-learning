package cn.wyj.solution;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] i : A) {
            //invert middle number
            if (i.length % 2 != 0)
                i[i.length / 2] = 1 - i[i.length / 2];
            for (int j = 0; j < i.length / 2; j++) {
                //swap
                int tmp = i[j];
                i[j] = i[i.length - 1 - j];
                i[i.length - 1 - j] = tmp;

                //invert
                i[j] = 1 - i[j];
                i[i.length - 1 - j] = 1 - i[i.length - 1 - j];
            }
        }

        return A;
    }
}
