package com.qf.market.service;

import com.qf.market.dto.BillDto1;
import com.qf.market.tool.PageTool;

import java.util.List;

/**
 *账单业务接口
 *@author sx
 * @version 1.0 2020-04-07
 */
public interface ItbillService {
    /**
     * 分页查询账单
     * @param page
     * @param curr
     * @return List<BillDto1>
     */
    List<BillDto1> fenyeQuery(PageTool page, String curr);
}
