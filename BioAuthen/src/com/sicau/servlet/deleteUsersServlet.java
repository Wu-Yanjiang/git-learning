package com.sicau.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sicau.javabean.usersForSearch;
import com.sicau.service.deleteUsersService;

public class deleteUsersServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		/*
		 * 删除用户
		 */
		String s = request.getParameter("checked");
		System.out.println(s);
		
		ArrayList<usersForSearch> currentUsers = (ArrayList<usersForSearch>) request.getSession().getAttribute("users");
		
		deleteUsersService service = new deleteUsersService();
		String msg = "对用户：";
		System.out.println(s);
		//遍历字符串
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			System.out.println(ch);
			if(ch>='0'&&ch<='9'){
				int j = ch-'0'-1;//得到这个char型数字的int值-1,即在集合中的索引
				/*
				 * 这里用户的序号必须为个位数
				 * 如果超过9就会出错
				 */
				String id = currentUsers.get(j).getId();//得到了待删除信息的用户的id
				System.out.println(id);
				if(service.deleteUserInfoById(id)){
					msg += id+"用户全部信息删除成功，";
				}else{
					msg += id+"用户信息删除失败或部分删除失败";
				}

			}
		}
		
		PrintWriter out = response.getWriter();
		out.print(msg);
	}

}
