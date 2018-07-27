
layui.use(["form","layer"],function(){
        var form=layui.form;
        var layer=layui.layer;
        $(function () {
            /* 点击添加按钮提出添加员工界面 */
            $("#updatePwd").click(function () {     

                    /* 再弹出添加界面 */
                    layer.open({
                        type:1,
                        title:"修改密码",
                        skin:"",
                        area:["50%"],
                        content:$("#changePwd").html()
                    });
                    /* 渲染表单 */
                    form.render();
            });
        });
    });





function changePwd(){
		
		var password = $("#password").val();
		var newpwd = $("#newpwd").val();
		var newpwdagin = $("#newpwdagin").val();
		alert(password);
		alert(newpwd);
		alert(newpwdagin);
		
		if(password == "" || newpwd == "" || newpwdagin == ""){
			layer.alert('表单数据不可以为空！');
			return false;
		}
		
		if(newpwd != newpwdagin){
			layer.alert('新密码两次输入不一致！');
			return false;
		}
	
        $.ajax({
        //几个参数需要注意一下
            type: "POST",//方法类型
            url: "${request.contextPath}/admin/user/changePassword" ,//url
            data: $('#changePwdform').serialize(),
            success: function (result) {
            	
                if(result == "ADD_SUCCESS"){
                	layer.alert('新增轮播图成功！',function(index){
                		window.location.href="${request.contextPath}/admin/banner/toBanners";
                	});
                	//跳转到列表
                }
                if(result == "ADD_FAIL"){
                	layer.alert('新增轮播图失败！',function(index){
                	window.location.href='${request.contextPath}/admin/banner/toAdd';
                	});
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            	 alert(XMLHttpRequest.status);
            	 alert(XMLHttpRequest.readyState);
            	 alert(XMLHttpRequest.responseText);
            	 alert(textStatus);
            	   }
        });

};


