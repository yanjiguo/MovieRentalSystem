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
    <script src="../../js/index.js"></script>
    <title>index</title>
</head>

<style type="text/css">
    .table_list {
        border-top-width: 1px;
        border-right-width: 1px;
        border-bottom-width: 1px;
        border-left-width: 1px;
        border-top-style: solid;
        border-top-color: #bfc4ca;
        border-right-color: #bfc4ca;
        border-bottom-color: #bfc4ca;
        border-left-color: #bfc4ca;
        font-size: 12px;
        background-color: #bfc4ca;
    }
    .table_list thead tr{
        background-color:#E9E9E9;
    }
    .table_list tbody tr{
        height:48px;
    }
    .table_list tr {
        text-align:center;
    }
    .table_list tr td,.table_list tr th {
        line-height: 25px;
        padding: 6px 10px 8px;
    }
</style>
<body>
<!-- 导航栏 -->
<nav class="navbar navbar-inverse" role="navigation" style="background-color: #3FC2EC;border: none">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <img src="../image/4.png">
            <ul class="nav navbar-nav navbar-right">
                <li><a style="color: #fff">欢迎您,${sessionScope.username}</a>
                </li>
                <li><a href="exit" style="color: #fff">安全退出</a>
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
            <p style="font-size: 20px;margin-left: -4px">客户管理</p>
            <hr style="margin-top:-10px"/>
            <div class="panel-heading">
                <span style="margin-left: -18px">客户列表</span>
                <input type="button" name=""  id ="newCustomer" value="新建" style="background-color: #73B2FB;border: none;margin-left: 400px">
            </div>
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list">
                <thead>
                <tr>
                    <th style="margin-left: 10px; text-align: center">操作</th>
                    <th style="margin-left: 10px; text-align: center" >FirstName</th>
                    <th style="margin-left: 10px; text-align: center">LastName</th>
                    <th style="margin-left: 10px; text-align: center">Address</th>
                    <th style="margin-left: 10px; text-align: center">Email</th>
                    <th style="margin-left: 10px; text-align: center">CustomerId</th>
                    <th style="margin-left: 10px; text-align: center">LastUpdate</th>
                </tr>
                </thead>
                <tbody id="customerTab"></tbody>
            </table>
            <div class="container">
                <ul id="page"></ul>
            </div>
        </div>
    </div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">编辑 Customer</h4>
            </div>
            <div class="modal-body">
                FirstName<input type="text" class="form-control" name="FirstName" id="FirstName" value="">
                LastName<input type="text"  class="form-control" name="LastName" id="LastName" value="">

                <%--使用列表的方式--%>
                Address<br/><select class="form-control" id="Address11">
                    <option id="Address"  value="3"></option>
                    <c:forEach var="all"  items="${all}">
                        <option value ="${all.addressId}">${all.address}</option>
                    </c:forEach>
                </select><br/>

                Email<input type="text"  class="form-control" name="Email" id="Email" value="">
                CustomerId<input type="text" class="form-control" name="CustomerId"  id="CustomerId1" value="" readonly="readonly">
                LastUpdate<input type="date"  class="form-control" name="LastUpdate" id="LastUpdate">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="updateCustomer">提交更改</button>
            </div>
        </div>
    </div>
</div>

<!-- 模态框信息删除确认 -->
<div class="modal fade" id="delcfmOverhaul">
    <div class="modal-dialog">
        <div class="modal-content message_align">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <!-- 隐藏需要删除的id -->
                <input type="hidden" id="customerId"  value=""/>
                <p>您确认要删除该条客户信息吗？</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary"
                        id="deleteHaulBtn">确认</button>
            </div>
        </div>
</div>
</div>
<!-- 底部页脚部分 -->
<div class="footer">
    <p class="text-center">
        2019 &copy; 颜继国
    </p>
</div>
</body>
</html>