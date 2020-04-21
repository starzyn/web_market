<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/10
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript">
        function pageTo(pos){
            //获取页面总数
            var totalPages = document.getElementById("totalPages").value;
            if(pos<1){
                alert("已经是首页啦");
            }else if(pos>totalPages){
                alert("已经是尾页啦");
            }else {
                //使用ajax进行分页
                var ajaxObj;
                if(window.XMLHttpRequest){//如果是高版本的浏览器
                    ajaxObj = new XMLHttpRequest();
                }else {//如果是低版本的浏览器
                    ajaxObj = new  ActiveXObject("Microsoft.XMLHTTP");
                }
                //创建请求
                ajaxObj.open("get","UserServlet?method=listUserByPage&pos="+pos,true);
                //发送请求
                ajaxObj.send();
                ajaxObj.onreadystatechange = function() {//回调函数
                    if (ajaxObj.readyState == 4 && ajaxObj.status == 200) {//如果响应成功
                        var innerHtml = ajaxObj.responseText;
                        // alert(innerHtml);
                        document.getElementById("userListContent").innerHTML = innerHtml;
                    }
                }
            }
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<!--主体内容-->
<section class="publicMian ">
    <jsp:include page="menu.jsp"></jsp:include>
    <div class="right" id="userListContent">
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
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>
