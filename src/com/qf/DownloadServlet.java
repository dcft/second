package com.qf;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        String realname = request.getServletContext().getRealPath("/img/"+filename);
        FileInputStream is = new FileInputStream(realname);
        String mimeType = request.getServletContext().getMimeType(filename);
        response.setHeader("context-type",mimeType);
        response.setHeader("content-disposition","attachment;filename="+filename);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[1024*8];

        int len = 0;
        while ((len=is.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        is.close();
        outputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
