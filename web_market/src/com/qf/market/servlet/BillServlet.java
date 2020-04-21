package com.qf.market.servlet;

import com.qf.market.dto.BillDto1;
import com.qf.market.service.ItbillService;
import com.qf.market.service.impl.TbillServiceImpl;
import com.qf.market.tool.PageTool;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
*账单模块控制器
*@author sx
 * @version 1.0 2020-04-07
*/
@WebServlet(value = "/BillServlet")
public class BillServlet extends FatherServlet {
    /**
     * 创建账单的业务对象
     */
    ItbillService billService=new TbillServiceImpl();

    /**
     * 分页查询账单
     * @param request
     * @param response
     * @return String
     */
    public String fenyeQuery(HttpServletRequest request, HttpServletResponse response){
        //1.获取请求中参数
        String curr=request.getParameter("curr");

        //创建分页工具类的对象
        PageTool page=new PageTool();

        //2.调用业务层处理请求,并接收结果
        List<BillDto1> billdto1List=billService.fenyeQuery(page,curr);

        //3.跳转页面
        request.setAttribute("billList",billdto1List);
        request.setAttribute("page",page);

        if (curr==null){//从首页开始跳转过来,第一次默认显示第一页
            return "billList.jsp";
        }else{//点击上一页,下一页
            //将当前页的数据转发到模板页面中显示,再将模板页面编译成html页面,响应ajax引擎
            return "billListModel.jsp";
        }
    }

    /**
     * 按条件分页查询账单
     * @param request
     * @param response
     * @return String
     */
    public String fenyeQueryByTiaojian(HttpServletRequest request, HttpServletResponse response){
        //1.获取请求中参数
        String goodsName=request.getParameter("goodsName");
        String pid=request.getParameter("pid");
        String ptype=request.getParameter("ptype");

        //创建分页工具类的对象
        PageTool page=new PageTool();

        //2.调用业务层处理请求,并接收结果
        List<BillDto1> billdto1List=billService.fenyeQueryByTiaojian(page,goodsName,pid,ptype);

        //3.跳转页面
        request.setAttribute("billList",billdto1List);
        request.setAttribute("page",page);

        //将当前页的数据转发到模板页面中显示,再将模板页面编译成html页面,响应ajax引擎
        return "billListModel.jsp";


    }

}
