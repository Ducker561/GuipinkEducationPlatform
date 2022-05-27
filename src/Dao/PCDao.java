package Dao;

import Domain.PC;
import Util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PCDao {
    public int ifPassed(String pid) {
        int result = 2;
        try {
            String sql = "SELECT * FROM parent_child WHERE pid=?";
            Connection con = DBUtil.getCon();
            ResultSet rs = DBUtil.query(con, sql, pid);
            while (rs.next()) { //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                PC pc = new PC();
                //封装数据:从表中转换为对象
                pc.setUid(rs.getString(2));
                pc.setPid(rs.getString(1));
                pc.setPass(rs.getString(3));
                if (pc.getPass().equals("1")) result = 1;
                else if (pc.getPass().equals("0")) result = 0;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int register(String pid, String uid) {
        int ifsuccess = 0;
        try {
                //加载驱动
            String sql = "INSERT INTO parent_child(pid,uid,pass) VALUES(?,?,?)";
            ifsuccess = DBUtil.update(sql, pid, uid,0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ifsuccess;
    }

    public ArrayList<PC> getAllPC(){
        //创建返回的集合
        ArrayList<PC> pcs=new ArrayList<>();
        try{
            String sql="SELECT * FROM parent_child ORDER BY pid ASC";
            Connection con=DBUtil.getCon();
            ResultSet rs=DBUtil.query(con,sql);
            //全部读取结果集
            while(rs.next()){ //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                PC pc=new PC();
                //封装数据:从表中转换为对象
                pc.setUid(rs.getString(2));
                pc.setPid(rs.getString(1));
                pc.setPass(rs.getString(3));

                //添加到集合
                pcs.add(pc);
            }
            //关闭连接
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return pcs;//返回查询结果
    }

    public ArrayList<PC> getMyChild(String pid){
        //创建返回的集合
        ArrayList<PC> pcs=new ArrayList<>();
        try{
            String sql="SELECT * FROM parent_child WHERE pid=?";
            Connection con=DBUtil.getCon();
            ResultSet rs=DBUtil.query(con, sql, pid);
            //全部读取结果集
            while(rs.next()){ //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                PC pc=new PC();
                //封装数据:从表中转换为对象
                pc.setUid(rs.getString(2));
                pc.setPid(rs.getString(1));
                pc.setPass(rs.getString(3));

                //添加到集合
                pcs.add(pc);
            }
            //关闭连接
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return pcs;//返回查询结果
    }

    public int deletePC(String pid){
        int result=0;
        try{
            //加载驱动
            String sql="DELETE FROM parent_child WHERE pid=?";
            result=DBUtil.update(sql,pid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int updatePC(String pid){
        int result=0;
        try{
            //加载驱动
            String sql="UPDATE parent_child SET pass=1 WHERE pid=?";
            result=DBUtil.update(sql,pid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

//    public int wasRegister(String uid){
//        int result = 0;
//        ArrayList<User> users = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM user WHERE uid=?";
//            Connection con = DBUtil.getCon();
//            ResultSet rs = DBUtil.query(con, sql, uid);
//            while (rs.next()) { //从头到尾逐行移动指针
//                //每查询一行，封装为一个User对象
//                User usr = new User();
//                //封装数据:从表中转换为对象
//                usr.setUid(rs.getString(1));
////                usr.setPwd(rs.getString(2));
////                usr.setuName(rs.getString(3));
////                usr.setuSex(rs.getString(4));
////                usr.setuAge(rs.getInt(5));
////                usr.setuTel(rs.getString(6));
////                usr.setuType(rs.getString(7));
//                users.add(usr);
//                if (!users.isEmpty()) result = 1;
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

//    public int scoreIncrease(String uid){
//        int result=0;
//        try{
//            //加载驱动
//            String sql="UPDATE user SET uScore=uScore+100 WHERE uid=?";
//            result=DBUtil.update(sql,uid);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public ArrayList<User> getUserDetail(String uid) {
//        ArrayList<User> users = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM user WHERE uid=?";
//            Connection con = DBUtil.getCon();
//            ResultSet rs = DBUtil.query(con, sql, uid);
//            while (rs.next()) { //从头到尾逐行移动指针
//                //每查询一行，封装为一个User对象
//                User usr = new User();
//                //封装数据:从表中转换为对象
//                usr.setUid(rs.getString(1));
//                usr.setuName(rs.getString(3));
//                usr.setuSex(rs.getString(4));
//                usr.setuAge(rs.getString(5));
//                usr.setuTel(rs.getString(6));
//                usr.setuType(rs.getString(7));
//                usr.setuScore(rs.getInt(8));
//                users.add(usr);
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return users;
//    }

}
