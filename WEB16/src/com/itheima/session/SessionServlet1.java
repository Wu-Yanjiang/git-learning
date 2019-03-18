package com.itheima.session;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class SessionServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //创建属于该客户端私有的session区域
        //该方法会判断客户端是否在服务器端已存在session
        /*
         * 实质就是根据JSESSIONID判断是否存在
         * 不存在就创建，存在则返回引用
         * */
        HttpSession session = request.getSession();

        session.setAttribute("name", "jerry");


        String id = session.getId();

        //默认session会话级别，所有需要持久化
        //手动创建一个存储JSESSIONID的Cookie为该Cookie设置持久化时间
        Cookie cookie = new Cookie("JSESSIONID", id);
        cookie.setPath("/WEB16");
        cookie.setMaxAge(60 * 16);
        response.addCookie(cookie);

        response.getWriter().write("JSESSIONID:" + id);
    }

    @Test
    public void moveZeroes(int[] nums) {
        int total = 0;
        //计算0的个数
        for (int i : nums) {
            if (0 == i)
                total++;
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]) {
                k++;
                continue;
            }
            nums[i - k] = nums[i];
        }
        //k = 0
        //
        // i 0 1 2 3 4 5;
        //---------------
        //   v
        //   0,1,0,3,12

        //最后total位清0
        for (int i = (nums.length - total); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    @Test
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0;
        int[] nn = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (j < nums1.length)
            nn[i++] = nums1[j++];
        while (k < nums2.length)
            nn[i++] = nums2[k++];

        Arrays.sort(nn);

        int length = nums1.length + nums2.length;
        if (0 == length % 2) {
            ans = (double) (nn[length / 2] + nn[length / 2 - 1]) / 2;
        } else {
            ans = (double) nn[length / 2];
        }

        for (int tmp : nn) {
            System.out.print(tmp + " ");
        }

        return ans;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i : nums) {
            if (s.contains(i))
                return true;
            s.add(i);
        }
        return false;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n2_p = 0;
        for (int i = 0; i < m + n; i++) {
            if (0 == nums1[i]) {
                nums1[i] = nums2[n2_p];
                if (n2_p++ == n)
                    break;
            }
        }

        Arrays.sort(nums1);
    }

    public int mySqrt(int x) {

        return (int) Math.sqrt(x);
    }

    /**
     * @param a
     * @param b
     * @return a + b 二进制
     */
    //  1 0 1 0
    //  1 0 1 1
    //-----------
    //1 0 1 0 1
    @NotNull
    private String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int length = a.length() > b.length() ? a.length() : b.length();
        int[] a1 = new int[length + 1];
        int[] b1 = new int[length + 1];
        int index = a.length() - 1, i = 0;

        while (index != -1) {
            a1[i++] = a.charAt(index--) - '0';
        }

        index = b.length() - 1;
        i = 0;
        while (index != -1) {
            b1[i++] = b.charAt(index--) - '0';
        }

        int carry = 0;
        int value = 0;
        for (int j = 0; j < a1.length; j++) {
            value = a1[j] ^ b1[j] ^ carry;
            carry = a1[j] & b1[j] | a1[j] & carry | b1[j] & b1[j];
            a1[j] = value;
        }

        index = a1.length - 1;
        while (a1[index] != 0) {
            index--;
        }

        while (index >= 0) {
            ans.append(a1[index] + '0');
        }

        return ans.toString();
    }

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
}
