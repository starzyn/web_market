package com.qf.market.service.impl;

import com.qf.market.dao.ItbillDao;
import com.qf.market.dao.impl.TbillDaoImpl;
import com.qf.market.dto.BillDto1;
import com.qf.market.service.ItbillService;
import com.qf.market.tool.PageTool;

import java.util.List;

/**
 *账单业务实现类
 *@author sx
 * @version 1.0 2020-04-07
 */
public class TbillServiceImpl implements ItbillService {
    /**
     * 创建数据访问对象
     */
    ItbillDao billDao=new TbillDaoImpl();

    /**
     * 分页查询账单
     * @param p
     * @param curr
     * @return List<BillDto1>
     */
    @Override
    public List<BillDto1> fenyeQuery(PageTool p, String curr) {
        /*初始化分页工具类*/
        if (curr==null){
            //当前页码,默认显示第一页
            p.setCurrPage(1);
        }else{
            //当前页码,默认显示第一页
            p.setCurrPage(Integer.valueOf(curr));
        }


        //每页显示的记录条数
        p.setPageCount(5);
        //总记录数
        p.setTotalCount(billDao.queryTotalCount());
        //总页数
        p.setTotalPage(p.getTotalCount(),p.getPageCount());
        //计算当前页起始记录数
        p.setStart((p.getCurrPage()-1)*p.getPageCount());

        //根据分页工具类查询当前页的数据,并接收
        List<BillDto1> billList=billDao.fenyeQuery(p);

        return billList;
    }
}
