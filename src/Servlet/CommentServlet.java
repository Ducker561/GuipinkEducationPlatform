package Servlet;

import Dao.CommentDao;
import Domain.Comment;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String type = request.getParameter("type");
        if ("get".equals(type)) {
            get(request, response);
        }
        else if("insert".equals(type)){
            insert(request,response);
        }
    }

    CommentDao cd= new CommentDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Comment> comments = new ArrayList<>();
        comments = cd.getComments();
        JSONObject json=new JSONObject();
        json.put("comments",comments);
        response.getWriter().print(json.toString());
        response.addHeader("access-control-allow-origin", "*");
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        String commentContent=request.getParameter("commentContent");
        String commentTime=request.getParameter("commentTime");
        int ifsuccess=cd.insert(uid,commentContent,commentTime);
        response.getWriter().print(ifsuccess);
    }
}
