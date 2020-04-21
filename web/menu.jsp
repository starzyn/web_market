<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/16
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="billList.html">账单管理</a></li>
                <li><a href="providerList.html">供应商管理</a></li>
                <li><a href="UserServlet?method=listUserByPage&pos=1&flag=1">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="UserServlet?method=exit">退出系统</a></li>
            </ul>
        </nav>
    </div>