<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				<font>用户个人信息</font>USER MESSAGE
				<form class="form-horizontal" style="margin-top: 5px;" action="${pageContext.request.contextPath}/getmes.action" method="post">
				  
				  	<input type="hidden" id="uid" name="uid" value="${loginUser.uid}"/>
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" name="username" class="form-control" id="username" disabled="disabled"  value="${loginUser.username}">
						</div>
					</div>
				

					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">电话</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" name="telephone" disabled="disabled" value="${loginUser.telephone}">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
						<a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#customerEditDialog" onclick="editMessage()">修改</a>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
		
		
		
		<div class="modal fade" id="customerEditDialog" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改用户个人信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="edit_customer_form">
				
			         	<input type="hidden" id="edit_uid" name="uid" value="${loginUser.uid}"/>
			         	
						<div class="form-group">
							<label for="edit_username" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_username" name="username" >
							</div>
						</div>
						
						<div class="form-group">
							<label for="edit_password" class="col-sm-2 control-label">新密码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_password" name="password" >
							</div>
						</div>
						
	
						
						<div class="form-group">
							<label for="edit_telephone" class="col-sm-2 control-label">移动电话</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_telephone" name="telephone">
							</div>
						</div>											
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="updateMessage()">保存修改</button>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
		function editMessage() {
			$.ajax({
				type:"get",
				url:"<%=basePath%>/editmes.action",
				success:function(data) {
					$("#edit_uid").val(data.uid);
					$("#edit_username").val(data.username);
					$("#edit_password").val(data.password);
					$("#edit_telephone").val(data.telephone)
					
				}
			});
		}
	<%-- 	function updateMessage() {
			$.post("<%=basePath%>/updatemes.action",function(data){
// 				data 返回boolean
				if(data){
					alert("用户信息更新成功！");
					window.location.reload();
				}else{
					alert("用户信息更新失败！");
				}					
			});
		} --%>
		

</script>

</html>




