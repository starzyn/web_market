<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/20
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="location">
    <strong>你现在所在的位置是:</strong>
    <span>用户管理页面</span>
</div>
<div class="search">
    <span>用户名：</span>
    <input type="text" placeholder="请输入用户名"/>
    <input type="button" value="查询"/>
    <a href="UserServlet?method=addUser">添加用户</a>
</div>
<!--用户-->
<table class="providerTable" cellpadding="0" cellspacing="0">
    <tr class="firstTr">
        <th width="10%">用户编码</th>
        <th width="20%">用户名称</th>
        <th width="10%">性别</th>
        <th width="10%">年龄</th>
        <th width="10%">电话</th>
        <th width="10%">用户类型</th>
        <th width="30%">操作</th>
    </tr>
    <div>
        <c:forEach var="u" items="${uList}">
            <tr>
                <td>${u.uid}</td>
                <td>${u.uname}</td>
                <td>${u.usex}</td>
                <td>${u.uage}</td>
                <td>${u.utel}</td>
                <td>${u.utype}</td>
                <td>
                    <a href="userView.html"><img src="img/read.png" alt="查看" title="查看"/></a>
                    <a href="userUpdate.html"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                    <a href="#" class="removeUser"><img src="img/schu.png" alt="删除" title="删除"/></a>
                </td>
            </tr>
        </c:forEach>
    </div>
</table>
<div style="text-align: center;font-size: 20px">
    <input id=totalPages type="hidden" value="${page.totalPage}"/>
    <a href="javascript:void(0)" onclick="pageTo(1)">首页</a>
    <a href="javascript:void(0)" onclick="pageTo(${page.pos-1})">上一页</a>
    <a href="javascript:void(0)" onclick="pageTo(${page.pos+1})">下一页</a>
    <a href="javascript:void(0)" onclick="pageTo(${page.totalPage})">尾页</a>
</div>