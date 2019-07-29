$(function(){
    $("#btn").click(function(){
        // ajax异步修改
        $.ajax({
            url:'/addCustomer',
            dataType:'json',
            type:"post",
            data:{
                "firstName":$("#FirstName").val(),
                "lastName": $("#LastName").val(),
                "address":  $("#Address11").val(),
                "email":    $("#Email").val()
            },
            async:true,
            success:function(msg){
                if(msg==1){
                    alert("新建成功");
                }else{
                    alert("新建失败");
                }
            }
        });
    })
});