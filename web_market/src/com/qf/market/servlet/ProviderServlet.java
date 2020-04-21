package com.qf.market.servlet;

import com.alibaba.fastjson.JSON;
import com.qf.market.entity.Tprovider;
import com.qf.market.service.ItproviderService;
import com.qf.market.service.impl.TproviderServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 供应商控制器
 */
@WebServlet(value = "/ProviderServlet")
public class ProviderServlet extends FatherServlet {
    /**
     * 创建业务对象
     */
    ItproviderService providerSerice=new TproviderServiceImpl();

    /**
     * 查询所有供应商
     * @param request
     * @param response
     * @return String
     */
    public String queryAllProvider(HttpServletRequest request, HttpServletResponse response){
        //调用相应业务层处理请求,并接收结果
        List<Tprovider> providerList=providerSerice.queryAllProvider();
        //将集合转换为json数组字符串
        String result= JSON.toJSONString(providerList);
        //将结果写入ajax引擎对象
        return "ajax:"+result;
    }
}
