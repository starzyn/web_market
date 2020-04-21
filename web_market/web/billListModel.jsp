<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2020/4/8
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--账单表格 样式和供应商公用-->
<table class="providerTable" cellpadding="0" cellspacing="0">
    <tr class="firstTr">
        <th width="10%">账单id</th>
        <th width="20%">商品名称</th>
        <th width="10%">供应商</th>
        <th width="10%">账单金额</th>
        <th width="10%">是否付款</th>
        <th width="10%">创建时间</th>
        <th width="30%">操作</th>
    </tr>

    <c:forEach var="b" items="${billList}">
        <tr>
            <td>${b.bid}</td>
            <td>${b.pname}</td>
            <td>${b.providerName}</td>
            <td>${b.bprice}</td>
            <td>
                <c:choose>
                    <c:when test="${b.ptype==1}">已付款</c:when>
                    <c:when test="${b.ptype==0}">未付款</c:when>
                </c:choose>
            </td>
            <td>${b.bdate}</td>
            <td>
                <a href="billView.html"><img src="img/read.png" alt="查看" title="查看"/></a>
                <a href="billUpdate.html"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                <a href="#" class="removeBill"><img src="img/schu.png" alt="删除" title="删除"/></a>
            </td>
        </tr>
    </c:forEach>
</table>
<div style="float:right;padding:10px"><input type="hidden" id="totalPage" value="${page.totalPage}"/>
    <a href="javaScript:void(0)" onclick="fenye(1)">首页</a>
    <a href="javaScript:void(0)" onclick="fenye(${page.currPage-1})">上一页</a>
    <a href="javaScript:void(0)" onclick="fenye(${page.currPage+1})">下一页</a>
    <a href="javaScript:void(0)" onclick="fenye(${page.totalPage})">尾页</a>
</div>
