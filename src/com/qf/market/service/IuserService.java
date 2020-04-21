package com.qf.market.service;

import com.qf.market.entity.Tpage;
import com.qf.market.entity.Tuser;

import java.util.List;

public interface IuserService {
    /**
     * @Author starzyn
     * @Description
     * @Date 16:22 2020/4/7
     * @Param 
     * @return 
     **/
    Tuser login(Tuser u);

    /**
     * @Author starzyn
     * @Description 修改密码操作
     * @Date 20:05 2020/4/16
     * @Param [newPwd, oldPwd, uid]
     * @return int
     **/
    int modifyPwd(String newPwd,String oldPwd,String uid);

    /**
     * @Author starzyn
     * @Description 查询所有的用户信息
     * @Date 20:06 2020/4/16
     * @Param []
     * @return java.util.List<com.qf.market.entity.Tuser>
     **/
    List<Tuser> listUser();

    /**
     * @Author starzyn
     * @Description 分页查询
     * @Date 10:40 2020/4/20
     * @Param [page, pos]
     * @return java.util.List<com.qf.market.entity.Tuser>
     **/
    List<Tuser> queryByPage(Tpage page,int pos);
}
