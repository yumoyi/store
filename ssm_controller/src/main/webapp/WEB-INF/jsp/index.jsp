﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>网络商城</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
  		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container-fluid">
			<!-- 引入头部jsp文件 -->
			<%@ include file="header.jsp"%>
			<!--
				描述：商品显示
			-->
		 	<div class="container-fluid">
		 		<!-- 热门商品头图片 -->
				<div class="col-md-12">
					<h2>热门商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg" /></h2>
				</div>
				
		    	<div class="col-md-12">
					<c:forEach items="${hots}" var="p">
						<div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
						<a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}">
							<img src="${pageContext.request.contextPath}/${p.pimage}" width="130" height="130" style="display: inline-block;">
						</a>
						<p>
							<a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}" style='color: #666'>${p.pname}</a>
						</p>
						<p>
							<font color="#E4393C" style="font-size: 16px">&yen;${p.shop_price}</font>
						</p>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
			<!--
            	描述：商品显示
            -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>最新商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg" /></h2>
				</div>

				<div class="col-md-12">
					<c:forEach items="${news}" var="p">
						<div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
						<a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}">
					  		<img src="${pageContext.request.contextPath}/${p.pimage}" width="130" height="130" style="display: inline-block;">
						</a>
						<p>
							<a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}" style='color: #666'>${p.pname}</a>
						</p>
						<p>
							<font color="#E4393C" style="font-size: 16px">&yen;${p.shop_price}</font>
						</p>
						</div>
					</c:forEach>
				</div>
			</div>
	</body>

</html>