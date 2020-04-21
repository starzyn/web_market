<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2020/4/8
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript">
        //页面加载事件,将供应商数据加载到下拉框
        function show() {
            //ajax请求供应商的数据
            //1.创建ajax引擎对象
            var ajaxObject;
            if(window.XMLHttpRequest){//新浏览器
                ajaxObject=new XMLHttpRequest();
            }else{//IE5,6
                ajaxObject=new ActiveXObject("Microsoft.XMLHTTP")
            }

            //2.创建请求
            ajaxObject.open("get","ProviderServlet?method=queryAllProvider",true);

            //3.发送ajax请求
            ajaxObject.send();

            //4.调用回调函数,接收响应数据
            ajaxObject.onreadystatechange=function () {
                //判断请求正常处理完,响应也正常时就接收结果
                if (ajaxObject.readyState==4&&ajaxObject.status==200){
                    //声明一个变量接收响应String
                    var result=ajaxObject.responseText;
                    alert(result);
                    //将json数组字符串转换json数组
                    var arr=eval("("+result+")");

                    //获得下位框节点对象
                    var tigong=document.getElementById("tigong");

                    //遍历Json数据中每个json对象调出属性值,动态加载到下拉框
                    for (var i=0;i<arr.length;i++){
                        tigong.innerHTML=tigong.innerHTML+"<option value='"+arr[i].pid+"'>"+arr[i].pname+"</option>";
                    }

                }
            }
        }

        //分页功能
        function fenye(curr) {
            //接收总页数
            var total=document.getElementById("totalPage").value;
            if (curr<1){
                alert("已经是第一页了,没有上一页");
            }else if(curr>total){
                alert("已经是最后一页了,没有下一页");
            }else{
                //ajax分页
                //1.创建ajax引擎对象
                var ajaxObject;
                if(window.XMLHttpRequest){//新浏览器
                    ajaxObject=new XMLHttpRequest();
                }else{//IE5,6
                    ajaxObject=new ActiveXObject("Microsoft.XMLHTTP")
                }

                //2.创建请求
                ajaxObject.open("get","BillServlet?method=fenyeQuery&curr="+curr,true);

                //3.发送ajax请求
                ajaxObject.send();

                //4.调用回调函数,接收响应数据
                ajaxObject.onreadystatechange=function () {
                    //判断请求正常处理完,响应也正常时就接收结果
                    if (ajaxObject.readyState==4&&ajaxObject.status==200){
                        //声明一个变量接收响应html模板页面
                        var result=ajaxObject.responseText;
                        document.getElementById("fenyeShow").innerHTML=result;
                    }
                }
            }
        }
    </script>
</head>
<body onload="show()">
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="login.html">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="BillServlet?method=fenyeQuery">账单管理</a></li>
                <li><a href="providerList.html">供应商管理</a></li>
                <li><a href="userList.html">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="UserServlet?method=exit">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>账单管理页面</span>
        </div>
        <div class="search">
            <span>商品名称：</span>
            <input type="text" placeholder="请输入商品的名称"/>

            <span>供应商：</span>
            <select name="tigong" id="tigong" >
                <option value="">--请选择--</option>
            </select>

            <span>是否付款：</span>
            <select name="fukuan">
                <option value="">--请选择--</option>
                <option value="">已付款</option>
                <option value="">未付款</option>
            </select>

            <input type="button" value="查询"/>
            <a href="billAdd.html">添加订单</a>
        </div>

        <!--分页数据展示部分-->
        <div id="fenyeShow">
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
        </div>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<footer class="footer">
</footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>
