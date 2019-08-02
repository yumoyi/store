<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head></head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
	type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

.container .row div {
	/* position:relative;
	 float:left; */
	
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container" style="width:100%;background:url('${pageContext.request.contextPath}/img/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员注册</font>USER REGISTER
				<form class="form-horizontal" style="margin-top: 5px;" action="${pageContext.request.contextPath}/register.action" method="post">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" name="username" class="form-control"
								id="username" placeholder="请输入用户名">
						</div>
						<span id = "s1"></span>
					</div>
					<div class="form-group">
						<label for="inputpwd" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" name="password" class="form-control"
								id="inputpwd" placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmpwd"
								placeholder="请输入确认密码" onblur="checkRePassword()">
						</div>
						<div class="col-md-4 data" id="remind"></div> 
					</div>

					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">电话</label>
						<div class="col-sm-6">
							<input type="text" class="form-control"  placeholder="请输入电话" name="telephone" id="telephone">
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="inputPassword" class="col-sm-2 control-label">短信验证码：</label>
						<div class="col-sm-6">
							<input type="text" placeholder="短信验证码" class="form-control" name="code">  
						</div>
						<div class="col-sm-4">
							<%-- <a href="${pageContext.request.contextPath}/sendCode.action">获取短信验证码</a> --%>
							 <input type="button" id="sendcode" value="获取短信验证码">
						</div>
					
					</div>
					

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" id = "regist" style="background: url('${pageContext.request.contextPath}/img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);height:35px;width:100px;color:white;">
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
		</div>
</body>
<!-- <script type="text/javascript">
$(function(){	
    $("#username").blur(function(){
    	
    	var val = $(this).val();
    	
    	if(val != ""){
    		var url = "${pageContext.request.contextPath}/UserServlet";
    	    var params = {"method":"checkUsername","username":val};
    	    $.post(url,params,function(data){
    	    	if(data== 1){
    	    		$("#s1").html("用户可使用").css("color","#0f0");
    	    		$("#regist").attr("disabled",false);
    	   
    	    	}else if(data == 2){
    	    		$("#s1").html("用户已注册").css("color","red");
    	    		$("##regist").attr("disabled",true);
    	    	}
    	    });
    	}
    	
    });
 
			
});
</script> -->
<script>
	function checkRePassword(){
		var inputpwd = $("#inputpwd").val();
		var confirmpwd = $("#confirmpwd").val();
		if(inputpwd !=confirmpwd){
			alert("两次密码不一致");
			return ; 
		}
		
	}
	$(document).on("click","#sendcode",function sendCode(){
		var telephone = $("#telephone").val();
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/sendCode.action",
			data:"telephone="+telephone,
			dataType:"json",
			success:function(data){
				if(data==3){
					alert("请输入手机号码");
				}else if(data==1){
					alert("手机号码格式不正确");
				}else if(data==2){
					alert("发送验证码成功");
				}
			}
		})
		
	})
</script>
</html>




