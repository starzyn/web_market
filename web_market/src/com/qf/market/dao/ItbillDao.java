package com.qf.market.dao;

import com.qf.market.dto.BillDto1;
import com.qf.market.tool.PageTool;

import java.util.List;

/**
 *账单数据访问接口
 *@author sx
 * @version 1.0 2020-04-07
 */
public interface ItbillDao {
    /**
     * 查询总记录数
     * @return Integer
     */
    Integer queryTotalCount();

    /**
     * 分页查询当前页的数据
     * @param p
     * @return  List<BillDto1>
     */
    List<BillDto1> fenyeQuery(PageTool p);
}
