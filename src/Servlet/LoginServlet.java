package Servlet;

import Dao.LoginDao;
import Domain.User;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String type = request.getParameter("type");
        if ("login".equals(type)) {
            login(request, response);
        }else if("register".equals(type)){
            register(request,response);
        }else if("scoreIncrease".equals(type)){
            scoreIncrease(request,response);
        }else if("scoreDecrease".equals(type)){
            scoreDecrease(request,response);
        }else if("getMine".equals(type)){
            getUserDetail(request,response);
        }else if("getUserName".equals(type)){
            getUserName(request,response);
        }
    }


    LoginDao ld= new LoginDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        String pwd=request.getParameter("pwd");
        int ifLogin=ld.ifRegister(uid,pwd);
        response.getWriter().print(ifLogin);
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        String pwd=request.getParameter("pwd");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String tel=request.getParameter("tel");
        String utype=request.getParameter("utype");
        int ifsuccess=ld.register(uid,pwd,name,sex,age,tel,utype);
        response.getWriter().print(ifsuccess);
    }

    protected void scoreIncrease(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        int scoreIncreaseres=ld.scoreIncrease(uid);
        response.getWriter().print(scoreIncreaseres);
    }

    protected void scoreDecrease(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        String gPrice=request.getParameter("gPrice");
        int scoreDecreaseres=ld.scoreDecrease(uid,gPrice);
        response.getWriter().print(scoreDecreaseres);
    }

    protected void getUserDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        ArrayList<User> users = ld.getUserDetail(uid);
        JSONObject json=new JSONObject();
        json.put("user",users);
        response.getWriter().print(json.toString());
        response.addHeader("access-control-allow-origin", "*");
    }

    protected void getUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        String uName = ld.getUserName(uid);
        response.getWriter().print(uName);
        response.addHeader("access-control-allow-origin", "*");
    }


}
