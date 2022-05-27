package Dao;

import Domain.Goods;
import Util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ShopDao {
    public ArrayList<Goods> getAll(){
        //创建返回的集合
        ArrayList<Goods> goodss=new ArrayList<>();
        try{
            String sql="SELECT * FROM goods ORDER BY gid ASC";
            Connection con= DBUtil.getCon();
            ResultSet rs=DBUtil.query(con,sql);
            //全部读取结果集
            while(rs.next()){ //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                Goods goods=new Goods();
                //封装数据:从表中转换为对象
                goods.setGid(rs.getInt(1));
                goods.setgHref(rs.getString(2));
                goods.setgPrice(rs.getInt(3));

                //添加到集合
                goodss.add(goods);
            }
            //关闭连接
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return goodss;//返回查询结果
    }

    public int getgPrice(String gid) {
        int gPrice=0;
        try {
            String sql = "SELECT * FROM goods WHERE gid=?";
            Connection con = DBUtil.getCon();
            ResultSet rs = DBUtil.query(con, sql, gid);
            while (rs.next()) { //从头到尾逐行移动指针
                //每查询一行，封装为一个User对象
                Goods goods = new Goods();
                //封装数据:从表中转换为对象
                goods.setGid(rs.getInt(1));
                goods.setgPrice(rs.getInt(3));
                gPrice = goods.getgPrice();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return gPrice;
    }

}
