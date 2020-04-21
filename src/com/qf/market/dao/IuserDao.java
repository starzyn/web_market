package com.qf.market.dao;

import com.qf.market.entity.Tpage;
import com.qf.market.entity.Tuser;

import java.sql.SQLException;
import java.util.List;

public interface IuserDao {
    Tuser queryByNameAndPwd(Tuser u);
    int updateByPwd(String newPdw,String oldPwd,String uid);
    List<Tuser> queryAllUsers();
    List<Tuser> queryByPage(Tpage page,int pos) throws SQLException;
}
