package Servlet;

import Util.MD5;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        Part part = request.getPart("file"); // 获取文件

        // 原文件名在头信息的Content-Disposition中
        // Content-Disposition:form-data; name="photo"; filename="测试文件.txt"
        String header = part.getHeader("Content-Disposition");
        // 获取原文件名
        int start = header.lastIndexOf("=")+1;
        String name = header.substring(start).replace("\"", "");
        // 生成随机文件名
        String fileName = MD5.MD5Encode(UUID.randomUUID().toString(), "utf-8") + "@" + name;
        // 文件存放路径
        String savePath = "D:";
        System.out.println("1");
        if (fileName != null && !"".equals(fileName)) {
            // 写入磁盘
            part.write(savePath + File.separator + fileName);
        }

        out.print("ok");
        out.flush();
        out.close();
    }
}