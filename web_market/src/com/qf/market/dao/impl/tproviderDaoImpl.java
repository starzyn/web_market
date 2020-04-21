package com.qf.market.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.qf.market.dao.ItproviderDao;
import com.qf.market.entity.Tprovider;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 供应商数据访问实现类
 * @version 1.0
 * @auth sx
 * @date 2020/4/8
 */
public class tproviderDaoImpl implements ItproviderDao {
    /**
     * 创建dbutils工具类的执行对象,将数据库连接池作为参数
     */
    QueryRunner qr=new QueryRunner(new ComboPooledDataSource());

    /**
     * 查询所有供应商数据
     * @return List<Tprovider>
     */
    @Override
    public List<Tprovider> queryAllProvider() {
        List<Tprovider> providerList=new ArrayList<>();
        try {
            //准备sql语句
            String sql="select p_id as pid,p_name as pname from t_provider";
            //调用dbutils工具类中方法
            providerList=qr.query(sql,new BeanListHandler<>(Tprovider.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return providerList;
    }
}
