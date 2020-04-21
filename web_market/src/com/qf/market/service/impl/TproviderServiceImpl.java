package com.qf.market.service.impl;

import com.qf.market.dao.ItproviderDao;
import com.qf.market.dao.impl.tproviderDaoImpl;
import com.qf.market.entity.Tprovider;
import com.qf.market.service.ItproviderService;

import java.util.List;

/**
 * 供应商业务实现类
 * @version 1.0
 * @auth sx
 * @date 2020/4/8
 */
public class TproviderServiceImpl implements ItproviderService {
    /**
     * 创建数据访问对象
     */
    ItproviderDao providerDao=new tproviderDaoImpl();

    /**
     * 查询所有供应商
     * @return List<Tprovider>
     */
    @Override
    public List<Tprovider> queryAllProvider() {
        return providerDao.queryAllProvider();
    }
}
