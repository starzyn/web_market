package com.qf.market.service;

import com.qf.market.entity.Tprovider;

import java.util.List;

/**
 * 供应商业务接口
 * @author sx
 * @version 1.0 2020-04-08
 */
public interface ItproviderService {

    /**
     * 查询所有供应商
     * @return List<Tprovider>
     */
    List<Tprovider> queryAllProvider();
}
