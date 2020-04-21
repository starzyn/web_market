package com.qf.market.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.qf.market.dao.ItbillDao;
import com.qf.market.dto.BillDto1;
import com.qf.market.tool.PageTool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *账单数据访问实现类
 *@author sx
 * @version 1.0 2020-04-07
 */
public class TbillDaoImpl implements ItbillDao {
    /**
     * 创建dbutils工具类的执行对象,将数据库连接池作为参数
     */
    QueryRunner qr=new QueryRunner(new ComboPooledDataSource());

    /**
     * 查询总记录数
     * @return Integer
     */
    @Override
    public Integer queryTotalCount() {
        //声明变量存结果
        int total=0;
        try {
            //准备sql语句
            String sql="select count(b_id) as total from t_bill";
            //调用dbutils工具类的方法执行sql语句
            Map<String,Object> resultMap=qr.query(sql,new MapHandler());
            //获得结果值
            total=Integer.valueOf(resultMap.get("total").toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return total;
    }

    /**
     * 分页查询当前页的数据
     * @param p
     * @return  List<BillDto1>
     */
    @Override
    public List<BillDto1> fenyeQuery(PageTool p) {
        //声明变量存结果
        List<BillDto1> billList=new ArrayList();
        try {
            //准备sql语句
            String sql="select b.b_id as bid,b.p_name as pname,b.b_date as bdate,b.b_price as bprice,b.p_type as ptype,p.p_name as providerName" +
                    " from t_bill as b " +
                    " inner join t_provider as p on b.p_id=p.p_id limit ?,?";
            //调用dbutils工具类的方法执行sql语句
            billList=qr.query(sql,new BeanListHandler<>(BillDto1.class),p.getStart(),p.getPageCount());
        }catch (Exception e){
            e.printStackTrace();
        }
        return billList;
    }
}
