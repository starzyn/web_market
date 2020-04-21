<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2020/4/7
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.setAttribute("mess1","abc");
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 超市账单管理系统</title>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript">
        function show1(){
            if (document.getElementById("mess").value=="loginFailed"){
                alert("账号或密码错误,登录失败!");
            }else if(document.getElementById("mess").value=="updatePwdSucc"){
                alert("密码修改成功!");
            }
        }
    </script>
</head>
<body class="login_bg" onload="show1()">
<section class="loginBox">
    <header class="loginHeader">
        <h1>超市账单管理系统</h1>
    </header>
    <section class="loginCont">
        <form class="loginForm" method="post" action="UserServlet">
            <!--用隐藏域传请求的方法名-->
            <input type="hidden" name="method" value="login"/>

            <!--接收登录失败提示信息-->
            <input type="hidden" id="mess" value="${mess}"/>

            <div class="inputbox">
                <label for="user">用户名：</label>
                <input id="user" type="text" name="uaccount" placeholder="请输入用户名" required/>
            </div>
            <div class="inputbox">
                <label for="mima">密码：</label>
                <input id="mima" type="password" name="upassword" placeholder="请输入密码" required/>
            </div>
            <div class="subBtn">
                <input type="submit" value="登录" />
                <input type="reset" value="重置"/>
            </div>

        </form>
    </section>
</section>

</body>
</html>
