package com.sicau.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;



import com.sicau.javabean.Users;
import com.sicau.jdbc.domain.jdbcUsers;
import com.sicau.service.loginService;
import com.sicau.service.userAuthenService;


public class loginServlet extends HttpServlet {

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
		request.setCharacterEncoding("UTF-8");
		doPost( request, response);
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

		request.setCharacterEncoding("UTF-8");
     
		boolean authenResult = true;//验证是否通过的结果
		boolean isSuperAdmin =true;//是否是超级管理员
		
		//获取账号密码登录的表单数据
		//普通组件
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if(username == null && password == null){
			//使用的是生物识别登录
			
			//上传组件
		    //创建出一个工厂类
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//设置缓存位置
			File file = new File("G://");
			factory.setRepository(file);
		//创建一个 上传的实现
			ServletFileUpload upload = new ServletFileUpload(factory);
			//指纹图片的路径
			String fingerPath = "";
			//面部图片的路径
			String facePath = "";
			try {
				//获取所有的组件
				//信息存放在request之中
				List <FileItem>fileItems = upload.parseRequest(request);
				 //遍历所有组件
				System.out.println(fileItems.size());
				for(FileItem F:fileItems){
					//确认一遍是上传组件
					if(!F.isFormField()){
						//上传并保存图片
						String path=uploadFileItem(F);//得到图片的完整路径
						System.out.println("success");
						System.out.println(path);
						if(F.getFieldName().equals("finger")){
							fingerPath = path;
						}else if(F.getFieldName().equals("face")){
							facePath = path;
						}
					}
					/*
					 * 现在已经将图片写入本地
					 * 并得到了两个图片的路径
					 * */
					userAuthenService service = new userAuthenService();
					authenResult = service.adminfaceCompare(facePath);
					/*
					jdbcUsers u_face = aService.adminfaceCompare(facePath);//与脸部信息匹配的管理员
					jdbcUsers u_finger = aService.adminfingerCompare(fingerPath);//与指纹信息匹配的管理员
					if(u_face == null || u_finger==null || !u_face.equals(u_finger)){
						authenResult = false;
					}else{
						authenResult = true;
					}
					*/

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(username != null && password != null){
			//使用账号密码登录
			/*
			 * 得到是否匹配的结果
			 * */
			//调用service层完成
			loginService service = new loginService();
			authenResult = service.getResult(username, password);
		}else{
			authenResult = false;
		}
		
		//根据验证结果做出相应的处理
		if (authenResult) {
			//重定向
			if(isSuperAdmin){
				request.getSession().setAttribute("messagepermi", "issuperadmin");
				//这一条消息是保存在session里的，在当次会话中一直存在
				System.out.println("是超级管理员！！！");
			}
			response.sendRedirect("admin.jsp");
		}else{
			//转发
			request.setAttribute("message", "fail");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
	}
	
	//上传组件
	//返回图片的路径
	private String uploadFileItem(FileItem f){
		/*
		 * 1.获取图片名字
		 * 2.在服务器中创建图片储存的区域(文件夹)
		 * 3.储存图片
		 */
		//文件的抽象路径
		String path = this.getServletContext().getRealPath("/WEB-INF/upload");//完整路径
		System.out.println(path);
		File photoDir = new File(path);
		//这个目录是否存在
		if (!photoDir.exists()) {
			//如果不存在   创建
			photoDir.mkdirs();
		}
 	    //获取图片名字
		String fileName = f.getName(); 
		System.out.println(fileName);
		//通过文件名字工具类  将文件名字统一   
		String imgName = FilenameUtils.getName(fileName);
		//创建图片文件对象
		File img = new File(path, imgName);
		//得到图片的路径
		String imgPath = path+"\\"+imgName;
		
		//将图片写入
		try {
			f.write(img);
			//清除缓存
			f.delete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgPath;
	}

}
