package Dao;

import Util.DBUtil;
import Domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoginDao {
    public int ifRegister(String uid, String pwd) {
        int result = 0;
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM user WHERE uid=? and upwd=md5(?)";
            Connection con = DBUtil.getCon();
            ResultSet rs = DBUtil.query(con, sql, uid, pwd);
            while (rs.next()) { //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                User usr = new User();
                //封装数据:从表中转换为对象
                usr.setUid(rs.getString(1));
                usr.setPwd(rs.getString(2));
                usr.setuType(rs.getString(7));
                users.add(usr);
                if (usr.getuType().equals("1")) result = 1;
                else if (usr.getuType().equals("2")) result = 2;
                else if (usr.getuType().equals("3")) result = 3;
                else if (usr.getuType().equals("4")) result = 4;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int register(String uid, String pwd, String name, String sex, String age, String tel, String utype) {
        int result = wasRegister(uid);
        int ifsuccess = 0;
        if (result == 0) {
            try {
                //加载驱动
                String sql = "INSERT INTO user(uid,upwd,uName,usex,uage,utel,utype,uScore) VALUES(?,md5(?),?,?,?,?,?,?)";
                ifsuccess = DBUtil.update(sql, uid, pwd,name,sex,age,tel,utype,5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ifsuccess;
    }

    public int wasRegister(String uid){
        int result = 0;
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM user WHERE uid=?";
            Connection con = DBUtil.getCon();
            ResultSet rs = DBUtil.query(con, sql, uid);
            while (rs.next()) { //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                User usr = new User();
                //封装数据:从表中转换为对象
                usr.setUid(rs.getString(1));
//                usr.setPwd(rs.getString(2));
//                usr.setuName(rs.getString(3));
//                usr.setuSex(rs.getString(4));
//                usr.setuAge(rs.getInt(5));
//                usr.setuTel(rs.getString(6));
//                usr.setuType(rs.getString(7));
                users.add(usr);
                if (!users.isEmpty()) result = 1;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int scoreIncrease(String uid){
        int result=0;
        try{
            //加载驱动
            String sql="UPDATE user SET uScore=uScore+100 WHERE uid=?";
            result=DBUtil.update(sql,uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int scoreDecrease(String uid, String gPrice){
        int result=2;
        try{
            //加载驱动
            String sql="UPDATE user SET uScore=uScore-? WHERE uid=? AND uScore > ?";
            result=DBUtil.update(sql,gPrice,uid, gPrice);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<User> getUserDetail(String uid) {
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM user WHERE uid=?";
            Connection con = DBUtil.getCon();
            ResultSet rs = DBUtil.query(con, sql, uid);
            while (rs.next()) { //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                User usr = new User();
                //封装数据:从表中转换为对象
                usr.setUid(rs.getString(1));
                usr.setuName(rs.getString(3));
                usr.setuSex(rs.getString(4));
                usr.setuAge(rs.getString(5));
                usr.setuTel(rs.getString(6));
                usr.setuType(rs.getString(7));
                usr.setuScore(rs.getInt(8));
                users.add(usr);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public String getUserName(String uid) {
        String uName="";
        try {
            String sql = "SELECT * FROM user WHERE uid=?";
            Connection con = DBUtil.getCon();
            ResultSet rs = DBUtil.query(con, sql, uid);
            while (rs.next()) { //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                User usr = new User();
                //封装数据:从表中转换为对象
                usr.setUid(rs.getString(1));
                usr.setuName(rs.getString(3));
                uName = usr.getuName();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return uName;
    }

}
