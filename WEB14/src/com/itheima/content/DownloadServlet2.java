package com.itheima.content;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Base64;

public class DownloadServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //*********文件名称是中文

        //获得要下载的文件名称
        String filename = request.getParameter("filename");
        //解决获得中文参数的乱码
        filename = new String(filename.getBytes("ISO8859-1"), "UTF-8");


        //获得请求头中的User-Agent
        String agent = request.getHeader("User-Agent");
        String filenameEncoder = "";
        if (agent.contains("MSIE")) {
            // IE浏览器
            filenameEncoder = URLEncoder.encode(filename, "utf-8");
            filenameEncoder = filenameEncoder.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            Base64.Encoder base64Encoder = Base64.getEncoder();
            filenameEncoder = "=?utf-8?B?"
                    + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filenameEncoder = URLEncoder.encode(filename, "utf-8");
        }


        //要下载的文件类型--通过文件MIME类型去区分
        response.setContentType(this.getServletContext().getMimeType(filename));
        //告诉客户端，文件不直接解析，而是以附件形式打开,客户端默认对名字进行解码
        response.setHeader("Content-Disposition", "attachment;filename=" + filenameEncoder);


        InputStream inputStream = this.getServletContext().getResourceAsStream("/download/" + filename);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }
        inputStream.close();
        outputStream.close();
    }
}
