package com.itheima.session;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

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

        while (j<nums1.length)
            nn[i++] = nums1[j++];
        while (k<nums2.length)
            nn[i++] = nums2[k++];

        Arrays.sort(nn);

        int length = nums1.length + nums2.length;
        if (0 == length % 2) {
            ans = (double) (nn[length / 2] + nn[length / 2 - 1]) / 2;
        } else {
            ans = (double) nn[length / 2];
        }

        for (int tmp : nn){
            System.out.print( tmp + " ");
        }

        return ans;
    }
}
