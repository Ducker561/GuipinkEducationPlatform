package Servlet;

import com.alibaba.fastjson.JSON;
import Dao.AdminUserDao;
import Domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/AdminUserServlet")
public class AdminUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //1.接收客户端请求，及请求参数
        String type = request.getParameter("type");
        if ("findAll".equals(type)) {
            getAllUsers(request, response);
        }
//        else if("findDetail".equals(type)){
//            getDetailById(request,response);
//        }
        else if("findByuName".equals(type)){
            findByuName(request,response);
        }
        else if("deleteUser".equals(type)){
            deleteUser(request,response);
        }
//        else if("suggestion".equals(type)){
//            suggestion(request,response);
//        }
    }

    AdminUserDao ud = new AdminUserDao();

    protected void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("1");
        //2.找dao操作数据 获取数据
        ArrayList<User> users = ud.getAllUsers();
        //3.把数据返回客户端
        String usersstr = JSON.toJSONString(users);
        response.getWriter().print(usersstr);
        response.addHeader("access-control-allow-origin", "*");
    }

//    protected void getDetailById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String pid=request.getParameter("pid");
////        System.out.println(id);
//        ArrayList<SP_Project> proobj = sp_dao.getDetail(pid);
//        JSONObject json=new JSONObject();
//        json.put("projects",proobj);
//        response.getWriter().print(json.toString());
//        response.addHeader("access-control-allow-origin", "*");
//        //System.out.println(prostr);
//    }
//
    protected void findByuName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uName=request.getParameter("uName");
        ArrayList<User> users = ud.findByPname(uName);
        System.out.println(users);
        String usersstr = JSON.toJSONString(users);
        response.getWriter().print(usersstr);
        response.addHeader("access-control-allow-origin", "*");
    }
//
    protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        int udresult=ud.deleteUser(uid);
        response.getWriter().print(udresult);
        response.addHeader("access-control-allow-origin", "*");
    }
//
//    protected void suggestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
//        String pid=request.getParameter("pid");
//        String suggestion=request.getParameter("suggestion");
//        sp_dao.suggestion(pid,suggestion);
//        System.out.println("1");
//    }
}
