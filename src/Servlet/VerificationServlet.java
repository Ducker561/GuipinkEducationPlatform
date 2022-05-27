package Servlet;

import Dao.VerificationDao;
import Domain.Verification;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/VerificationServlet")
public class VerificationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String type = request.getParameter("type");
        if("register".equals(type)){
            register(request,response);
        }else if("updateVerification".equals(type)){
            updateVerification(request,response);
        }else if("getAllVerification".equals(type)){
            getAllVerification(request,response);
        }else if("getPassed".equals(type)){
            getPassed(request,response);
        }else if("uploaded".equals(type)){
            uploaded(request,response);
        }else if("downdateVerification".equals(type)){
            downdateVerification(request,response);
        }
    }


    VerificationDao vd= new VerificationDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        int ifsuccess=vd.register(uid);
        response.getWriter().print(ifsuccess);
    }

    protected void updateVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        int res=vd.updateVerification(uid);
        response.getWriter().print(res);
        response.addHeader("access-control-allow-origin", "*");
    }

    protected void downdateVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        int res=vd.downdateVerification(uid);
        response.getWriter().print(res);
        response.addHeader("access-control-allow-origin", "*");
    }

    protected void uploaded(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        int res=vd.updateUploaded(uid);
        response.getWriter().print(res);
        response.addHeader("access-control-allow-origin", "*");
    }

    protected void getAllVerification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Verification> verificationss = vd.getAllVerification();
        String verificationsstr = JSON.toJSONString(verificationss);
        response.getWriter().print(verificationsstr);
        response.addHeader("access-control-allow-origin", "*");
    }

    protected void getPassed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        int ifPass=vd.ifPassed(uid);
        response.getWriter().print(ifPass);
    }

}
