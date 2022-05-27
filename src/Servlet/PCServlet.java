package Servlet;

import Dao.LoginDao;
import Dao.PCDao;
import Domain.PC;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/PCServlet")
public class PCServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String type = request.getParameter("type");
        if ("register".equals(type)) {
            register(request, response);
        }
        else if("getPass".equals(type)){
            getPass(request,response);
        }
        else if("getAllPC".equals(type)){
            getAllPC(request,response);
        }
        else if("deletePC".equals(type)){
            deletePC(request,response);
        }
        else if("updatePC".equals(type)){
            updatePC(request,response);
        }
        else if("getMyChild".equals(type)){
            getMyChild(request,response);
        }
    }


    PCDao pd= new PCDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    protected void getPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid=request.getParameter("uid");
        int ifPass=pd.ifPassed(pid);
        response.getWriter().print(ifPass);
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid=request.getParameter("uid");
        String uid=request.getParameter("childUid");
        int ifsuccess=pd.register(pid,uid);
        response.getWriter().print(ifsuccess);
    }

    protected void deletePC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid=request.getParameter("pid");
        int udresult=pd.deletePC(pid);
        response.getWriter().print(udresult);
        response.addHeader("access-control-allow-origin", "*");
    }

    protected void getAllPC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<PC> PCs = pd.getAllPC();
        String PCsstr = JSON.toJSONString(PCs);
        response.getWriter().print(PCsstr);
        response.addHeader("access-control-allow-origin", "*");
    }

    protected void updatePC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid=request.getParameter("pid");
        int res=pd.updatePC(pid);
        response.getWriter().print(res);
        response.addHeader("access-control-allow-origin", "*");
    }

    protected void getMyChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid=request.getParameter("pid");
        ArrayList<PC> PCs = pd.getMyChild(pid);
        String PCsstr = JSON.toJSONString(PCs);
        response.getWriter().print(PCsstr);
        response.addHeader("access-control-allow-origin", "*");
    }

}
