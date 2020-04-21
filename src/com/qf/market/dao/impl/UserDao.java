/**
 * @ClassName UserDao
 * @Description TODO
 * @Author Administrator
 * @Date 2020/4/7 15:57
 * @Version 1.0
 */
package com.qf.market.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.qf.market.dao.IuserDao;
import com.qf.market.entity.Tpage;
import com.qf.market.entity.Tuser;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao implements IuserDao {
    QueryRunner qr = new QueryRunner(new ComboPooledDataSource());

    public Tuser queryByNameAndPwd(Tuser u1){
        String sql = "select u_id as uid,u_account as uaccount,u_password as upassword," +
                " u_name as uname,u_sex as usex,u_age as uage,u_tel as utel,u_type as utype from t_user where u_account=? and u_password=?";
        Tuser u2 = null;
        try {
            u2 = qr.query(sql,new BeanHandler<>(Tuser.class),u1.getUaccount(),u1.getUpassword());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return u2;
    }

    @Override
    public int updateByPwd(String newPdw, String oldPwd,String uid) {
        String sql = "UPDATE t_user SET u_password=? WHERE u_id=? AND u_password=?";
        int res = 0;
        try {
            res = qr.update(sql,newPdw,uid,oldPwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Tuser> queryAllUsers() {
        String sql = "select u_id as uid,u_account as uaccount,u_password as upassword," +
                " u_name as uname,u_sex as usex,u_age as uage,u_tel as utel,u_type as utype from t_user";
        List<Tuser> users = new ArrayList<>();
        try {
           users  = (List)qr.query(sql, new BeanListHandler(Tuser.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Tuser> queryByPage(Tpage page, int pos){
        String countSql = "SELECT COUNT(u_id) as counter FROM t_user";
        Map<String,Object> counter;
        List<Tuser> list = new ArrayList();
        try {
             counter = qr.query(countSql,new MapHandler());
             int start = page.pageCount*(pos-1);
             long sum = (long) counter.get("counter");
             String querySql =  "select u_id as uid,u_account as uaccount,u_password as upassword," +
                     " u_name as uname,u_sex as usex,u_age as uage,u_tel as utel,u_type as utype from t_user limit ?,?";
             list = qr.query(querySql,new BeanListHandler<>(Tuser.class),start,page.pageCount);
             page.setStart(start);
             page.setEnd(start+list.size());
             page.setPos(pos);
             page.setTotalPage((int)Math.ceil(sum/(page.pageCount*1.0)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
