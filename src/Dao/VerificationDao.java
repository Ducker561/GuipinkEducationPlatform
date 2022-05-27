package Dao;

import Domain.Verification;
import Util.DBUtil;


import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VerificationDao {

    public int register(String uid) {
        int ifsuccess = 0;
        try {
            //加载驱动
            String sql = "INSERT INTO verification(uid,teacherPass) VALUES(?,?)";
            ifsuccess = DBUtil.update(sql, uid, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ifsuccess;
    }

    public int updateVerification(String uid){
        int result=0;
        try{
            //加载驱动
            String sql="UPDATE verification SET teacherPass=1 WHERE uid=?";
            result=DBUtil.update(sql,uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int updateUploaded(String uid){
        int result=0;
        try{
            //加载驱动
            String sql="UPDATE verification SET teacherPass=3 WHERE uid=?";
            result=DBUtil.update(sql,uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int downdateVerification(String uid){
        int result=0;
        try{
            //加载驱动
            String sql="UPDATE verification SET teacherPass=4 WHERE uid=?";
            result=DBUtil.update(sql,uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Verification> getAllVerification(){
        //创建返回的集合
        ArrayList<Verification> verifications=new ArrayList<>();
        try{
            String sql="SELECT * FROM verification ORDER BY uid ASC";
            Connection con=DBUtil.getCon();
            ResultSet rs=DBUtil.query(con,sql);
            //全部读取结果集
            while(rs.next()){ //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                Verification ver=new Verification();
                //封装数据:从表中转换为对象
                ver.setUid(rs.getString(1));
                ver.setTeacherPass(rs.getString(2));

                //添加到集合
                verifications.add(ver);
            }
            //关闭连接
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return verifications;//返回查询结果
    }

    public int ifPassed(String uid) {
        int result = 2;
        try {
            String sql = "SELECT * FROM verification WHERE uid=?";
            Connection con = DBUtil.getCon();
            ResultSet rs = DBUtil.query(con, sql, uid);
            while (rs.next()) { //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                Verification ver = new Verification();
                //封装数据:从表中转换为对象
                ver.setUid(rs.getString(1));
                ver.setTeacherPass(rs.getString(2));
                if (ver.getTeacherPass().equals("1")) result = 1;
                else if (ver.getTeacherPass().equals("0")) result = 0;
                else if (ver.getTeacherPass().equals("3")) result = 3;
                else if (ver.getTeacherPass().equals("4")) result = 4;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
