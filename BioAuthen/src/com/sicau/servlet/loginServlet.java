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
     
		boolean authenResult = true;//��֤�Ƿ�ͨ���Ľ��
		boolean isSuperAdmin =true;//�Ƿ��ǳ�������Ա
		
		//��ȡ�˺������¼�ı�����
		//��ͨ���
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if(username == null && password == null){
			//ʹ�õ�������ʶ���¼
			
			//�ϴ����
		    //������һ��������
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//���û���λ��
			File file = new File("G://");
			factory.setRepository(file);
		//����һ�� �ϴ���ʵ��
			ServletFileUpload upload = new ServletFileUpload(factory);
			//ָ��ͼƬ��·��
			String fingerPath = "";
			//�沿ͼƬ��·��
			String facePath = "";
			try {
				//��ȡ���е����
				//��Ϣ�����request֮��
				List <FileItem>fileItems = upload.parseRequest(request);
				 //�����������
				System.out.println(fileItems.size());
				for(FileItem F:fileItems){
					//ȷ��һ�����ϴ����
					if(!F.isFormField()){
						//�ϴ�������ͼƬ
						String path=uploadFileItem(F);//�õ�ͼƬ������·��
						System.out.println("success");
						System.out.println(path);
						if(F.getFieldName().equals("finger")){
							fingerPath = path;
						}else if(F.getFieldName().equals("face")){
							facePath = path;
						}
					}
					/*
					 * �����Ѿ���ͼƬд�뱾��
					 * ���õ�������ͼƬ��·��
					 * */
					userAuthenService service = new userAuthenService();
					authenResult = service.adminfaceCompare(facePath);
					/*
					jdbcUsers u_face = aService.adminfaceCompare(facePath);//��������Ϣƥ��Ĺ���Ա
					jdbcUsers u_finger = aService.adminfingerCompare(fingerPath);//��ָ����Ϣƥ��Ĺ���Ա
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
			//ʹ���˺������¼
			/*
			 * �õ��Ƿ�ƥ��Ľ��
			 * */
			//����service�����
			loginService service = new loginService();
			authenResult = service.getResult(username, password);
		}else{
			authenResult = false;
		}
		
		//������֤���������Ӧ�Ĵ���
		if (authenResult) {
			//�ض���
			if(isSuperAdmin){
				request.getSession().setAttribute("messagepermi", "issuperadmin");
				//��һ����Ϣ�Ǳ�����session��ģ��ڵ��λỰ��һֱ����
				System.out.println("�ǳ�������Ա������");
			}
			response.sendRedirect("admin.jsp");
		}else{
			//ת��
			request.setAttribute("message", "fail");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
	}
	
	//�ϴ����
	//����ͼƬ��·��
	private String uploadFileItem(FileItem f){
		/*
		 * 1.��ȡͼƬ����
		 * 2.�ڷ������д���ͼƬ���������(�ļ���)
		 * 3.����ͼƬ
		 */
		//�ļ��ĳ���·��
		String path = this.getServletContext().getRealPath("/WEB-INF/upload");//����·��
		System.out.println(path);
		File photoDir = new File(path);
		//���Ŀ¼�Ƿ����
		if (!photoDir.exists()) {
			//���������   ����
			photoDir.mkdirs();
		}
 	    //��ȡͼƬ����
		String fileName = f.getName(); 
		System.out.println(fileName);
		//ͨ���ļ����ֹ�����  ���ļ�����ͳһ   
		String imgName = FilenameUtils.getName(fileName);
		//����ͼƬ�ļ�����
		File img = new File(path, imgName);
		//�õ�ͼƬ��·��
		String imgPath = path+"\\"+imgName;
		
		//��ͼƬд��
		try {
			f.write(img);
			//�������
			f.delete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgPath;
	}

}
