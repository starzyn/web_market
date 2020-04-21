package com.qf.market.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.qf.market.dao.ItuserDao;
import com.qf.market.entity.Tuser;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 *用户数据访问实现类
 *@author sx
 * @version 1.0 2020-04-07
 */
public class TuserDaoImpl implements ItuserDao {
    /**
    *创建dbutils工具类的执行对象,传连接池对象作为参数
    */
    QueryRunner qr=new QueryRunner(new ComboPooledDataSource());

    /**
     *登录功能
     *@param u1
     *@return com.qf.market.entity.Tuser
     */
    @Override
    public Tuser queryUserByNameAndPwd(Tuser u1) {
        //声明用户对象
        Tuser u2=null;
       try {
           //准备sql语句
           String sql="SELECT u_id as uid,u_account as uaccount,u_password as upassword,u_name as uname,u_sex as usex," +
                   " u_age as uage,u_tel as utel,u_type as utype from t_user "
                   +" where u_account=? and u_password=? ";
           //调用dbutils工具类的方法来执行sql语句,并接收结果
           u2=qr.query(sql,new BeanHandler<>(Tuser.class),u1.getUaccount(),u1.getUpassword());
       }catch (Exception e){
           e.printStackTrace();
       }
        return u2;
    }

    /**
     * 修改密码
     * @param newPwd
     * @param account
     * @return
     */
    @Override
    public int updatePassword(String newPwd, String account) {
        //声明一个变量存结果
        int result=0;
        try {
            //准备sql语句
            String sql="update t_user set u_password=? where u_account=? ";
            //调用dbutils工具类的方法来执行sql语句,并接收结果
           result=qr.update(sql,newPwd,account);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
