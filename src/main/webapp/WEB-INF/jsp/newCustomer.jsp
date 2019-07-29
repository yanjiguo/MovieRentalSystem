
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="../../js/jquery-1.8.3.js"></script>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../../js/bootstrap-paginator.js"></script>
    <script src="../../js/newCustomer.js"></script>
    <title>新建 Customer</title>
</head>

<body>
<!-- 导航栏 -->
<nav class="navbar navbar-inverse" role="navigation" style="background-color: #3FC2EC;border: none">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <img src="../image/4.png">
            <ul class="nav navbar-nav navbar-right">
                <li><a style="color: #fff">欢迎您,${sessionScope.username}</a>
                </li>
                <li><a href="#" style="color: #fff">安全退出</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- 菜单栏 -->
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-2">
            <a href="customIndex" class="list-group-item">
                    <span class="glyphicon glyphicon-stop" aria-hidden="true">
                    </span>Customer管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;></a>
            <a href="#" class="list-group-item">
                    <span class="glyphicon glyphicon-stop" aria-hidden="true">
                    </span>Film设置&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;></a>
        </div>

        <div class="col-sm-10">
            <p style="font-size: 20px;margin-left: -4px">创建Customer</p>
            <hr style="margin-top:-10px"/>
            <div class="panel-heading">
                <span style="margin-left: -18px">个人信息</span>
            </div>
            <div>
                    <span>FirstName</span><input type="text" class="form-control" name="firstName" id="FirstName" value="" style="width: 300px">
                    <span>LastName</span><input type="text"  class="form-control" name="lastName" id="LastName" value="" style="width: 300px">
                    <span>Email</span><input type="text"  class="form-control" name="email" id="Email" value="" style="width: 300px">
                    <span>Address</span><select class="form-control" id="Address11" name="address" style="width: 300px">
                    <c:forEach var="all"  items="${all}">
                        <option value ="${all.addressId}">${all.address}</option>
                    </c:forEach>
                    </select><br/>
                    <input type="submit" id="btn" value="新建"style="margin-left: 40px;background-color: #73B2FB"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="取消"/>
            </div>
        </div>
    </div>
</div>


<!-- 底部页脚部分 -->
<div class="footer" style="margin-top: 210px">
    <p class="text-center">
        2019 &copy; 颜继国
    </p>
</div>
</body>
</html>
