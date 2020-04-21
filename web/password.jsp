<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/15
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script>
        //验证新密码是否符合要求
        function isPwd(){
            //获取新密码
            var oldPwd = document.getElementById("oldPassword").value;
            var newPwd = document.getElementById("newPassword").value;
            var reg = /^[A-Za-z0-9]{6,12}$/;
            if(reg.test(newPwd)&&oldPwd!=newPwd){
                document.getElementById("newPwdMsg").innerText="";
                return true;
            }else {
                document.getElementById("newPwdMsg").style.color="red";
                document.getElementById("newPwdMsg").innerText="您输入的密码格式不符合要求，请重新你输入"
                return false;
            }
        }

        //验证新旧密码是否一致
        function checkPwd(){
            //获取原来的密码
            var oldPwd = document.getElementById("oldPassword").value;
            var newPwd = document.getElementById("newPassword");
            var reNewPwd = document.getElementById("reNewPassword");
            //先判断两次新密码是否一致
            if(reNewPwd.value==newPwd.value&&oldPwd!=reNewPwd){
                document.getElementById("reNewPwdMsg").innerText="";
                return true;
            }else{
                document.getElementById("reNewPwdMsg").style.color="red";
                document.getElementById("reNewPwdMsg").innerText="您输入的两次新密码不一致，请重新输入";
                return false;
            }
        }

        //提交时验证上述两个是否都成立
        function check(){
            if(isPwd()&&checkPwd())
                return true;
            return false;
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<!--主体内容-->
<section class="publicMian ">
    <jsp:include page="menu.jsp"></jsp:include>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>密码修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="UserServlet" method="post" onsubmit="return check()">
                <input type="hidden" name="method" value="modifyPwd">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="oldPassword">旧密码：</label>
                    <input type="password" name="oldPassword" id="oldPassword" required/>
                    <span>*请输入原密码</span>
                </div>
                <div>
                    <label for="newPassword">新密码：</label>
                    <input type="password" name="newPassword" id="newPassword" required onblur="isPwd()"/>
                    <span id="newPwdMsg">*请输入新密码（不能少于六位，同时包含数字和字符）</span>
                </div>
                <div>
                    <label for="reNewPassword">确认新密码：</label>
                    <input type="password" name="reNewPassword" id="reNewPassword" required onblur="checkPwd()"/>
                    <span id="reNewPwdMsg">*请输入新确认密码，保证和新密码一致</span>
                </div>
<%--                <div>--%>
<%--                    <label id="dialogMsg" style="color: red"></label>--%>
<%--                </div>--%>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <input type="submit" value="保存"/>
                </div>
            </form>
        </div>
    </div>
</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
