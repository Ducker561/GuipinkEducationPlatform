package Servlet;

import Dao.CourseDao;
import Domain.Course;
import Domain.TakeCourse;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String type = request.getParameter("type");
        if ("signup".equals(type)) {
            signup(request, response);
        }
        else if("addCourse".equals(type)){
            addCourse(request,response);
        }
        else if("getAllCourses".equals(type)){
            getAllCourses(request,response);
        }
        else if("deleteCourses".equals(type)){
            deleteCourses(request,response);
        }
        else if("findBycName".equals(type)){
            findBycName(request,response);
        }else if("getMyCourses".equals(type)){
            getMyCourses(request,response);
        }
    }

    CourseDao cd= new CourseDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void getAllCourses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Course> courses = cd.getAllCourses();
        //3.把数据返回客户端
        String coursesstr = JSON.toJSONString(courses);
        response.getWriter().print(coursesstr);
        response.addHeader("access-control-allow-origin", "*");
    }

    protected void getMyCourses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        ArrayList<Course> courses = cd.getMyCourses(uid);
        //3.把数据返回客户端
        String coursesstr = JSON.toJSONString(courses);
        response.getWriter().print(coursesstr);
        response.addHeader("access-control-allow-origin", "*");
    }

    protected void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        String cName=request.getParameter("cName");
        int ifsuccess=cd.insert(uid,cName);
        response.getWriter().print(ifsuccess);
    }

    protected void addCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        String cName=request.getParameter("cName");
        String cInfo=request.getParameter("cInfo");
        String cLast=request.getParameter("cLast");
        int ifsuccess=cd.addCourse(uid,cName,cInfo,cLast);
        response.getWriter().print(ifsuccess);
    }

    protected void deleteCourses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid=request.getParameter("cid");
        int cdresult=cd.deleteCourses(cid);
        response.getWriter().print(cdresult);
        response.addHeader("access-control-allow-origin", "*");
    }

    protected void findBycName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cName=request.getParameter("cName");
        ArrayList<Course> courses = cd.findBycName(cName);
        System.out.println(courses);
        String usersstr = JSON.toJSONString(courses);
        response.getWriter().print(usersstr);
        response.addHeader("access-control-allow-origin", "*");
    }

}
