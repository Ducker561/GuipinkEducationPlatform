package Dao;

import Domain.Comment;
import Util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CommentDao {
    public ArrayList<Comment> getComments(){
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM comment order by commentid desc";
            Connection con = DBUtil.getCon();
            ResultSet rs = DBUtil.query(con, sql);
            while (rs.next()) { //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                Comment comment = new Comment();
                //封装数据:从表中转换为对象
                comment.setCommentid(rs.getInt(1));
                comment.setUid(rs.getString(2));
                comment.setCommentContent(rs.getString(3));
                comment.setCommentTime(rs.getString(4));
                comments.add(comment);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    public int insert(String uid,String commentContent,String commentTime) {
        deleteMessage();
        int ifsuccess = 0;
        try {
            //加载驱动
            String sql = "INSERT INTO comment(uid,commentContent,commentTime) VALUES(?,?,?)";
            ifsuccess = DBUtil.update(sql, uid, commentContent, commentTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ifsuccess;
    }

    public void deleteMessage(){
        if(ifDelete()){
            try {
                //加载驱动
                String sql = "DELETE FROM message ORDER BY time LIMIT 1";
                DBUtil.update(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return;
    }

    public boolean ifDelete(){
        boolean ifDel=false;
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM comment";
            Connection con = DBUtil.getCon();
            ResultSet rs = DBUtil.query(con, sql);
            while (rs.next()) { //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                Comment comment = new Comment();
                //封装数据:从表中转换为对象
                comment.setCommentid(rs.getInt(1));
                comment.setUid(rs.getString(2));
                comment.setCommentContent(rs.getString(3));
                comment.setCommentTime(rs.getString(4));
                comments.add(comment);
                if (comments.size()>30){
                    ifDel = true;
                    break;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return ifDel;
    }

}
