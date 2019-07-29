
var pageNow=1;//当前页
var pageSize=10;	//页面大小
var totalPages; //总页数
window.onload = function() {

    //一开始的初始值
    var datas={
        "pageNow":pageNow,
        "limit":pageSize
    }
    //请求路径
    var url = 'customerList';
    getdata(url,datas);
    $("#page").bootstrapPaginator({
            bootstrapMajorVersion: 3, //对应的bootstrap版本
            currentPage: 1, //当前页数
            numberOfPages: 5, //每次显示页数
            totalPages: totalPages, //总页数
            shouldShowPage: true, //是否显示该按钮
            useBootstrapTooltip: true,
            onPageClicked: function(event, originalEvent, type, page) {
                window.pageNow = page;
                var datas1={
                    "pageNow":page,
                    "limit":pageSize
                }
                getdata(url,datas1);
            }
    });
}
//将取到值拼接到页面
function getdata(url,datas){
    $.ajax({
        url:url,
        dataType:"json",
        type:"get",
        async:false,
        data:datas,
        success:function(datas){
            var tab = document.getElementById("customerTab");
            tab.innerHTML=(" ");
            $(datas).each(
                function(i, values){
                        window.totalPages = values.totalPages;
                        $(values.data).each(
                            function(i,value){
                                $("#customerTab").html($("#customerTab").html()
                                    +'<tr id="'+value.customerId+'">'
                                    +'<td><a href="javascript:void(0)" onclick="showUpdateModal(\''+value.firstName+'\', \''+value.lastName+'\',\''+value.address+'\',\''+value.customerId+'\',\''+value.lastUpdate+'\',\''+value.email+'\')">编辑</a>|<a href="javascript:void(0)" onclick="showDeleteModal('+value.customerId+')">删除</a></td>'
                                    +'<td>'
                                    +value.firstName
                                    +'</td>'
                                    +'<td>'
                                    +value.lastName
                                    +'</td>'
                                    +'<td>'
                                    +value.address
                                    +'</td>'
                                    +'<td>'
                                    +value.email
                                    +'</td>'
                                    +'<td>'
                                    +value.customerId
                                    +'</td>'
                                    +'<td>'
                                    + dateChange(value.lastUpdate)
                                    +'</td>'
                                    +'</tr>'
                                )

                            }

                    )
                }
            )
        }
    });
}

//编辑
function showUpdateModal(firstName,lastName,address,customerId,lastUpdate,email){
    $("#FirstName").val(firstName);
    $("#LastName").val(lastName);
    $("#Address").html(address);;
    $("#Email").val(email);
    $("#CustomerId1").val(customerId);
    //完成赋值
    var date = new Date(lastUpdate);
    var now = new Date(date.getTime());
    //格式化日，如果小于9，前面补0
    var day = ("0" + now.getDate()).slice(-2);
    //格式化月，如果小于9，前面补0
    var month = ("0" + (now.getMonth() + 1)).slice(-2);
    //拼装完整日期格式
    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
    //完成赋值
    $("#LastUpdate").val(today);
    $('#myModal').modal();
}

//删除
function showDeleteModal(customerId) {
    $("#customerId").val(customerId);
    $("#delcfmOverhaul").modal({
        backdrop : 'static',
        keyboard : false
    });
}

//点击是发送请求
$(function() {
    // 删除大修模态框的确定按钮的点击事件
    $("#deleteHaulBtn").click(function() {
        $.ajax({
            url:'/customerDeleteByCusId?customerId='+$("#customerId").val(),
            dataType:'json',
            type:"post",
            async:true,
            success:function(data){
                if(data=="1"){
                    $("#"+$("#customerId").val()).remove();
                    $("#delcfmOverhaul").modal('hide');
                }else{
                    alert("删除失败");
                }
            }
        })
    });

    $("#updateCustomer").click(function () {
        // ajax异步修改
        $.ajax({
            url:'/customerUpdateByCusId',
            dataType:'json',
            type:"post",
            data:{
                "firstName":$("#FirstName").val(),
                "lastName": $("#LastName").val(),
                "address":  $("#Address11").val(),
                "email":    $("#Email").val(),
                "customerId": $("#CustomerId1").val(),
                "lastUpdate":$("#LastUpdate").val()
            },
            async:true,
            success:function(msg){
                if(msg==1){
                    $("#myModal").modal('hide');
                    var datas2={
                        "pageNow":window.pageNow,
                        "limit":pageSize
                    }
                    var url = 'customerList';
                    getdata(url,datas2);
                }else{
                    alert("编辑失败");
                }
            }
        });
    });
    $("#newCustomer").click(function() {
        location.href="/newCustomer";
    })
});

//日期格式的转化
function dateChange(ctime){
    var date = new Date(ctime);
    Y = date.getFullYear() + '-';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    D = date.getDate() + ' ';
    h = date.getHours() + ':';
    m = date.getMinutes() + ':';
    s = date.getSeconds();
    return Y+M+D+h+m+s;
}
