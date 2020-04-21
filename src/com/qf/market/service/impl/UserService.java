/**
 * @ClassName UserService
 * @Description TODO
 * @Author Administrator
 * @Date 2020/4/7 15:29
 * @Version 1.0
 */
package com.qf.market.service.impl;

import com.qf.market.dao.impl.UserDao;
import com.qf.market.entity.Tpage;
import com.qf.market.entity.Tuser;
import com.qf.market.service.IuserService;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IuserService {
    @Override
    public Tuser login(Tuser u) {
        UserDao ud = new UserDao();
        Tuser u2 = ud.queryByNameAndPwd(u);
        return u2;
    }

    @Override
    public int modifyPwd(String newPwd, String oldPwd,String uid) {
        UserDao ud = new UserDao();
        int res = ud.updateByPwd(newPwd,oldPwd,uid);
        return res;
    }

    @Override
    public List<Tuser> listUser() {
        UserDao ud = new UserDao();
        List<Tuser> users = new ArrayList<>();
        users = ud.queryAllUsers();
        return users;
    }

    @Override
    public List<Tuser> queryByPage(Tpage page, int pos) {
        UserDao ud = new UserDao();
        List<Tuser> list = ud.queryByPage(page,pos);
        return list;
    }

}
