
layui.use(["form","layer"],function(){
        var form=layui.form;
        var layer=layui.layer;
        $(function () {
            /* 点击添加按钮提出修改密码 */
            $("#updatePwd").click(function () {     

                    /* 再弹出修改密码界面 */
                    layer.open({
                        type:1,
                        title:"修改密码",
                        shadeClose: true,
                        shade: false,
                        anim: 4,  //动画从左边翻滚进入
                        btn: ['确认修改', '取消操作'],
                        //btnAlign: 'c', //居中对齐
                        area:["50%"],
                        content:$("#changePwd"),   //这里不知道是layer.open的bug还是怎么回事，不可以写成$("#changePwd").html()
                        end: function () {
                        	$("#changePwd").css("display","none");
                            location.reload();
                        },
                        btn1: function (index, layero) {   
                        	console.log(index);
                        	console.log(layero);
                        	changePwd();
                        },
                        cannel: function (index, layero) {
                        	$("#changePwd").css("display","none");
                        }
                    });
                    
                    /* 渲染表单 */
                    //form.render();
            });
        });
 
    });

function changePwd(){
	
	var oldpwd = $("#oldpwd").val();
	var newpwd = $("#newpwd").val();
	var newpwdagin = $("#newpwdagin").val();
	
	console.log(oldpwd);
	console.log(newpwd);
	console.log(newpwdagin);
	
	if(oldpwd == "" || newpwd == "" || newpwdagin == ""){
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
		url: "/admin/user/changePassword" ,//url
		data: $('#changePwdform').serialize(),
		success: function (result) {
			if(result == 'PWD_WRONG'){
				layer.alert('原密码错误！');
			}
			if(result == 'PWD_INCONSISTENT'){
				layer.alert('新密码两次输入不一致！');
			}
			if(result == "SUCCESS"){
				/*layer.msg('修改密码成功！', {time:5000});
				$("#changePwd").css("display","none");
				layer.closeAll();*/
				layer.alert('修改密码成功',function(index){
					$("#changePwd").css("display","none");
					layer.closeAll();
            	});
			}
			if(result == "FAIL"){
				layer.msg('修改密码失败,请联系管理员！' ,{ time: 2000 });
				$("#changePwd").css("display","none");
				layer.closeAll();
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






