package Servlet;

import Dao.FeedbackDao;
import Domain.Feedback;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String type = request.getParameter("type");
        if ("insert".equals(type)) {
            insert(request, response);
        }
//        else if("addCourse".equals(type)){
//            addCourse(request,response);
//        }
        else if("getAllFeedback".equals(type)){
            getAllFeedback(request,response);
        }
        else if("deleteFeedback".equals(type)){
            deleteFeedback(request,response);
        }
//        else if("findBycName".equals(type)){
//            findBycName(request,response);
//        }else if("getMyCourses".equals(type)){
//            getMyCourses(request,response);
//        }
    }

    FeedbackDao fd= new FeedbackDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void getAllFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Feedback> feedbacks = fd.getAllFeedback();
        //3.把数据返回客户端
        String feedbacksstr = JSON.toJSONString(feedbacks);
        response.getWriter().print(feedbacksstr);
        response.addHeader("access-control-allow-origin", "*");
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        String email=request.getParameter("email");
        String msg=request.getParameter("msg");
        int ifsuccess=fd.insert(uid,email,msg);
        response.getWriter().print(ifsuccess);
    }

    protected void deleteFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fid=request.getParameter("fid");
        int fdresult=fd.deleteFeedback(fid);
        response.getWriter().print(fdresult);
        response.addHeader("access-control-allow-origin", "*");
    }

}
