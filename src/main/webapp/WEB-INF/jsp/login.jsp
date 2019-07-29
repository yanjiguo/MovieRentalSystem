<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
    <p style="font-size: 20px;margin-left:20px;margin-top:10px;color: red">25020颜继国</p>
    <div class="container">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <h3 class="form-title" id="form-title">电影租赁管理系统</h3>
                <hr id="hr"/>
                <form action="customerLogin" method="post">
                    <div class="col-md-9">
                        <div class="form-group">
                            <span style="font-size: 12px;margin-left: -80px">用户名：</span><input  type="text" placeholder="请输入用户名" id="username" name="username" autofocus="autofocus" maxlength="20" style="width: 300px;">
                            <i class="fa fa-user fa-lg" style="margin-left:-20px;color: #ccc"></i>
                        </div>
                        <div class="form-group">
                            <span style="font-size: 12px;margin-left: -68px">密码：</span><input  type="password" placeholder="请输入密码" id="password" name="password" maxlength="8" style="width: 300px" />
                             <i class="fa fa-lock fa-lg" style="margin-left:-20px;color: #ccc"></i>
                        </div>
                        <div id="btn">
                            <input class="btn btn-success pull-right" id="submit" type="submit" value="登录">
                        </div>
                        <p style="color:red;font-size: 14px;margin: 20px;">${str}</p>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div style="width:100%;height: 40px;background-color: #73B2FB;position: absolute;bottom: 0 ;left: 0">
    </div>
</body>
</html>