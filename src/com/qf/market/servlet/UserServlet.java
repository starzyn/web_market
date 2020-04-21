package com.qf.market.servlet;

import com.qf.market.entity.Tpage;
import com.qf.market.entity.Tuser;
import com.qf.market.service.IuserService;
import com.qf.market.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
    /**
     * @Author starzyn
     * @Description 处理登陆请求
     * @Date 16:22 2020/4/7
     * @Param [req, resp]
     * @return java.lang.String
     **/
   public String login(HttpServletRequest req,HttpServletResponse resp) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
       Tuser u1 = requestMap(Tuser.class,req,resp);
//       System.out.println(u1.toString());
       //调用业务层去处理请求并得到结果,声明的变量存结果
       UserService us = new UserService();
       Tuser u2 = us.login(u1);
       if(u2==null){//登陆失败
           req.setAttribute("mess","LoginFailed");
           return "dis:login.jsp";
       }else{//登陆成功
           req.getSession().setAttribute("u",u2);
           return "dis:index.jsp";
       }
   }

   public String exit(HttpServletRequest req,HttpServletResponse resp){
        req.getSession().removeAttribute("u");
        return "red:login.jsp";
   }

   public String modifyPwd(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String oldPwd = req.getParameter("oldPassword");
        String newPwd = req.getParameter("newPassword");
        Tuser u = (Tuser) req.getSession().getAttribute("u");

        IuserService us = new UserService();
        int res = us.modifyPwd(newPwd,oldPwd,String.valueOf(u.getUid()));
        if(res!=0)
            return "red:login.jsp";
        else {
            return "dis:password.jsp";
        }
   }
   
   /**
    * @Author starzyn
    * @Description 遍历所有的用户
    * @Date 19:37 2020/4/16
    * @Param 
    * @return 
    **/
   public String listUser(HttpServletRequest req,HttpServletResponse resp){
       UserService us = new UserService();
       List<Tuser> users = new ArrayList<>();
       users = us.listUser();
       if(users.size()!=0){
           req.setAttribute("uList",users);
           return "dis:userList.jsp";
       }else {
           return "red:index.jsp";
       }
   }

   public String listUserByPage(HttpServletRequest req,HttpServletResponse resp) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
       int pos = Integer.valueOf(req.getParameter("pos"));//获取当前页
       String flag = req.getParameter("flag");
       Tpage page = new Tpage();
       UserService us = new UserService();
       List<Tuser> list = us.queryByPage(page,pos);
       if(list.isEmpty()){
        //如果为空，证明当前页没有数据,则查询前一页
           list = us.queryByPage(page,pos-1);
       }else {//如果当前页不为空
           req.setAttribute("uList",list);
           req.setAttribute("page",page);
       }
       if(flag!=null)//表明是从首页过来的
           return "dis:userList.jsp";
       else return "dis:userListMode.jsp";
   }

}
