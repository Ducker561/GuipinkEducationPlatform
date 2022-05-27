package Servlet;

import Dao.ShopDao;
import Domain.Goods;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String type = request.getParameter("type");
        if ("getAll".equals(type)) {
            getAll(request, response);
        }
        else if("getgPrice".equals(type)){
            getgPrice(request,response);
        }
//        else if("scoreIncrease".equals(type)){
//            scoreIncrease(request,response);
//        }else if("getMine".equals(type)){
//            getUserDetail(request,response);
//        }else if("getUserName".equals(type)){
//            getUserName(request,response);
//        }
    }


    ShopDao sd= new ShopDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

//    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String uid=request.getParameter("uid");
//        String pwd=request.getParameter("pwd");
//        int ifLogin=ld.ifRegister(uid,pwd);
//        response.getWriter().print(ifLogin);
//    }
//
//    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String uid=request.getParameter("uid");
//        String pwd=request.getParameter("pwd");
//        String name=request.getParameter("name");
//        String sex=request.getParameter("sex");
//        String age=request.getParameter("age");
//        String tel=request.getParameter("tel");
//        String utype=request.getParameter("utype");
//        int ifsuccess=ld.register(uid,pwd,name,sex,age,tel,utype);
//        response.getWriter().print(ifsuccess);
//    }

//    protected void scoreIncrease(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        String uid=request.getParameter("uid");
////        int scoreIncreaseres=ld.scoreIncrease(uid);
////        response.getWriter().print(scoreIncreaseres);
////    }

    protected void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Goods> goodss = sd.getAll();
        JSONObject json=new JSONObject();
        json.put("goods",goodss);
        response.getWriter().print(json.toString());
        response.addHeader("access-control-allow-origin", "*");
    }

    protected void getgPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gid=request.getParameter("gid");
        int gPrice = sd.getgPrice(gid);
        response.getWriter().print(gPrice);
        response.addHeader("access-control-allow-origin", "*");
    }


}
