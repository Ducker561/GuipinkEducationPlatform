package Dao;

import Domain.Course;
import Util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CourseDao {

    public int search(String cName){
        int cid=0;
        try {
            String sql = "SELECT * FROM course WHERE cName=?";
            Connection con = DBUtil.getCon();
            ResultSet rs = DBUtil.query(con, sql, cName);
            while (rs.next()) { //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                Course course = new Course();
                //封装数据:从表中转换为对象
                course.setCid(rs.getInt(1));
                cid=course.getCid();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return cid;
    }

    public int insert(String uid,String cName) {
        int cid = search(cName);
        if (cid!=0) {
            int ifsuccess = 2;
            try {
                //加载驱动
                String sql = "INSERT INTO take_course(uid,cid) VALUES(?,?)";
                ifsuccess = DBUtil.update(sql, uid, cid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ifsuccess;
        }
        else return 0;  //没有该课程
    }

    public int addCourse(String uid, String cName, String cInfo, String cLast) {
        int result=0;
        int cid=search(cName);
        if(cid!=0){
            result=2;
            return result;  //有重复课程
        }
        else{
            try {
                //加载驱动
                String sql = "INSERT INTO course(cName,cInfo,cLast) VALUES(?,?,?)";
                result = DBUtil.update(sql, cName, cInfo, cLast);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(result!=1) return 3; //插入课程失败
            int newcid = search(cName);
            try {
                //加载驱动
                String sql = "INSERT INTO take_course(uid,cid) VALUES(?,?)";
                result = DBUtil.update(sql, uid, newcid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(result!=1) return 4; //插入授课失败
        }
        return result;
    }


    public Course searchMyCourse(int cid){
        try {
            String sql = "SELECT * FROM course WHERE cid=?";
            Connection con = DBUtil.getCon();
            ResultSet rs = DBUtil.query(con, sql, cid);
            while (rs.next()) { //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                Course course = new Course();
                //封装数据:从表中转换为对象
                course.setCid(rs.getInt(1));
                course.setcName(rs.getString(2));
                course.setcInfo(rs.getString(3));
                course.setcLast(rs.getInt(4));
                return course;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Course> getAllCourses(){
        //创建返回的集合
        ArrayList<Course> courses=new ArrayList<>();
        try{
            String sql="SELECT * FROM course ORDER BY cid ASC";
            Connection con=DBUtil.getCon();
            ResultSet rs=DBUtil.query(con,sql);
            //全部读取结果集
            while(rs.next()){ //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                Course course=new Course();
                //封装数据:从表中转换为对象
                course.setCid(rs.getInt(1));
                course.setcName(rs.getString(2));
                course.setcInfo(rs.getString(3));
                course.setcLast(rs.getInt(4));

                //添加到集合
                courses.add(course);
            }
            //关闭连接
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return courses;//返回查询结果
    }

    public ArrayList<Course> getMyCourses(String uid){
        //创建返回的集合
        ArrayList<Course> courses=new ArrayList<>();
        try{
            String sql="SELECT * FROM take_course WHERE uid=?";
            Connection con=DBUtil.getCon();
            ResultSet rs=DBUtil.query(con,sql, uid);
            //全部读取结果集
            while(rs.next()){ //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                Course course=new Course();
                //封装数据:从表中转换为对象
                course.setCid(rs.getInt(1));
                course = searchMyCourse(course.getCid());
                //添加到集合
                courses.add(course);
            }
            //关闭连接
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return courses;//返回查询结果
    }

    public int deleteCourses(String cid){
        int result=0;
        try{
            //加载驱动
            String sql="DELETE FROM course WHERE cid=?";
            result=DBUtil.update(sql,cid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Course> findBycName(String cName) {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String sql = "SELECT * FROM course WHERE cName=? ";
            Connection con = DBUtil.getCon();
            ResultSet rs = DBUtil.query(con, sql, cName);
            while (rs.next()) { //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                Course course=new Course();
                //封装数据:从表中转换为对象
                course.setCid(rs.getInt(1));
                course.setcName(rs.getString(2));
                course.setcInfo(rs.getString(3));
                course.setcLast(rs.getInt(4));
                courses.add(course);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }

}
