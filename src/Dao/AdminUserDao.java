package Dao;

import Domain.User;
import Util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminUserDao {
    //获得全部用户数据
    public ArrayList<User> getAllUsers(){
        //创建返回的集合
        ArrayList<User> users=new ArrayList<>();
        try{
            String sql="SELECT * FROM user ORDER BY uid ASC";
            Connection con=DBUtil.getCon();
            ResultSet rs=DBUtil.query(con,sql);
            //全部读取结果集
            while(rs.next()){ //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                User usr=new User();
                //封装数据:从表中转换为对象
                usr.setUid(rs.getString(1));
                usr.setuName(rs.getString(3));
                usr.setuSex(rs.getString(4));
                usr.setuAge(rs.getString(5));
                usr.setuTel(rs.getString(6));
                usr.setuType(rs.getString(7));

                //添加到集合
                users.add(usr);
            }
            //关闭连接
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return users;//返回查询结果
    }


    public ArrayList<User> findByPname(String name) {
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM user WHERE uName=? ";
            Connection con = DBUtil.getCon();
            ResultSet rs = DBUtil.query(con, sql, name);
            while (rs.next()) { //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                User usr=new User();
                //封装数据:从表中转换为对象
                usr.setUid(rs.getString(1));
                usr.setuName(rs.getString(3));
                usr.setuSex(rs.getString(4));
                usr.setuAge(rs.getString(5));
                usr.setuTel(rs.getString(6));
                usr.setuType(rs.getString(7));
                users.add(usr);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
//
    public int deleteUser(String uid){
        int result=0;
        try{
            //加载驱动
            String sql="DELETE FROM user WHERE uid=?";
            result=DBUtil.update(sql,uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
//
//    public int suggestion(String pid, String suggestion){
//        int result=0;
//        try{
//            //加载驱动
//            String sql="UPDATE project SET suggestion=? WHERE pid=?";
//            result=SP_DBUtil.update(sql,suggestion,pid);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return result;
//    }

}
