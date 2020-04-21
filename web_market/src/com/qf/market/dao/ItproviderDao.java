package com.qf.market.dao;

import com.qf.market.entity.Tprovider;

import java.util.List;

/**
 * 供应商数据访问接口
 * @version 1.0
 * @auth sx
 * @date 2020/4/8
 */
public interface ItproviderDao {

    /**
     * 查询所有供应商数据
     * @return List<Tprovider>
     */
    List<Tprovider> queryAllProvider();
}
