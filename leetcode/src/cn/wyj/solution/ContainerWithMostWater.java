package cn.wyj.solution;

public class ContainerWithMostWater {

    //复杂的太高，不好
    public int maxArea(int[] height) {
        int con = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                if (i == j)
                    continue;
                con = Math.max(con, Math.min(height[i], height[j]) * Math.abs(i - j));
            }
        }

        return con;
    }

    //贪心
    public int maxArea2(int[] height) {
        int start = 0, end = height.length - 1;
        int conn = 0;
        while (start <= end) {
            conn = Math.max(conn, (end - start) * Math.min(height[start], height[end]));
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return conn;
    }
}
