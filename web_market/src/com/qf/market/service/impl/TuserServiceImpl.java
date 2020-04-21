package com.qf.market.service.impl;

import com.qf.market.dao.ItuserDao;
import com.qf.market.dao.impl.TuserDaoImpl;
import com.qf.market.entity.Tuser;
import com.qf.market.service.ItuserService;

/**
 *用户业务实现类
 *@author sx
 * @version 1.0 2020-04-07
 */
public class TuserServiceImpl implements ItuserService {
    /**
    *创建数据访问类的对象
    */
    ItuserDao userDao=new TuserDaoImpl();

    /**
     *登录功能
     *@param u1
     *@return com.qf.market.entity.Tuser
     */
    @Override
    public Tuser login(Tuser u1) {
        return userDao.queryUserByNameAndPwd(u1);
    }

    /**
     * 修改密码
     * @param newPwd
     * @param account
     * @return
     */
    @Override
    public int updatePassword(String newPwd, String account) {
        return userDao.updatePassword(newPwd,account);
    }
}
