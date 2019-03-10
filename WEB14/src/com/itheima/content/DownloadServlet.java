package com.itheima.content;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得要下载的文件名称
        String filename = request.getParameter("filename");
        //要下载的文件类型--通过文件MIME类型去区分
        response.setContentType(this.getServletContext().getMimeType(filename));
        //告诉客户端，文件不直接解析，而是以附件形式打开
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);

        //获取文件的绝对路径 ---debug 这个路径居然是不包含download的错误路径
//        String path = this.getServletContext().getRealPath(filename);


        InputStream inputStream = this.getServletContext().getResourceAsStream("/download/"+filename);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer))>0){
            outputStream.write(buffer, 0, len);
        }
        inputStream.close();
        outputStream.close();

//        //获得文件输入流
//        FileInputStream in = new FileInputStream(path);
//        //获得输出流--用response
//        ServletOutputStream out = response.getOutputStream();
//        //文件拷贝模板代码
//        int len = 0;
//        byte[] buffer = new byte[1024];
//        while ((len = in.read(buffer)) > 0) {
//            out.write(buffer, 0, len);
//        }
//        in.close();
//        out.close();//会自动关闭
    }
}
