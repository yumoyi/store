<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 导航侧栏 -->
			<aside class="main-sidebar">
				<!-- sidebar: style can be found in sidebar.less -->
				<section class="sidebar">
					<!-- Sidebar user panel -->
					<div class="user-panel">
						<div class="pull-left image">
							<img src="./img/user2-160x160.jpg" class="img-circle" alt="User Image">
						</div>
						<div class="pull-left info">
							<p>张猿猿</p>
							<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
						</div>
					</div>
					

					<!-- sidebar menu: : style can be found in sidebar.less -->
					<ul class="sidebar-menu">
						<li class="header">菜单</li>

						<li id="admin-index">
							<a href="${pageContext.request.contextPath}/admin.action"><i class="fa fa-dashboard"></i> <span>首页</span></a>
						</li>

						<!-- 菜单 -->

						<li class="treeview">
							<a href="#">
								<i class="fa fa-folder"></i> <span>分类管理</span>
								<span class="pull-right-container">
                     			   <i class="fa fa-angle-left pull-right"></i>
                 	  			 </span>
							</a>
							<ul class="treeview-menu">

								<li id="admin-login">
									<a href="${pageContext.request.contextPath}/adminkind.action?page=1&size=10">
										<i class="fa fa-circle-o"></i> 分类管理
									</a>
								</li>

							</ul>
						</li>
						
						
						<li class="treeview">
							<a href="#">
								<i class="fa fa-folder"></i> <span>商品管理</span>
									<span class="pull-right-container">
                    				    <i class="fa fa-angle-left pull-right"></i>
			                    	</span>
							</a>
							<ul class="treeview-menu">

								<li id="charts-chartjs">
									<a href="all-charts-chartjs.html">
										<i class="fa fa-circle-o"></i> 商品管理
									</a>
								</li>

								<li id="charts-morris">
									<a href="all-charts-morris.html">
										<i class="fa fa-circle-o"></i> 已下架商品管理
									</a>
								</li>
							</ul>
						</li>	
						
						
						<li class="treeview">
							<a href="#">
								<i class="fa fa-folder"></i> <span>订单管理</span>
								<span class="pull-right-container">
                     			   <i class="fa fa-angle-left pull-right"></i>
                 	  			 </span>
							</a>
							<ul class="treeview-menu">

								<li id="admin-login">
									<a href="all-admin-login.html">
										<i class="fa fa-circle-o"></i> 未付款订单管理
									</a>
								</li>
								<li id="admin-login">
									<a href="all-admin-login.html">
										<i class="fa fa-circle-o"></i> 已付款订单管理
									</a>
								</li>

								<li id="admin-login">
									<a href="all-admin-login.html">
										<i class="fa fa-circle-o"></i> 已发货订单管理
									</a>
								</li>

								<li id="admin-login">
									<a href="all-admin-login.html">
										<i class="fa fa-circle-o"></i> 已完成订单管理
									</a>
								</li>
							</ul>
						</li>
						
						<li class="treeview">
							<a href="#">
								<i class="fa fa-folder"></i> <span>用户管理</span>
								<span class="pull-right-container">
                     			   <i class="fa fa-angle-left pull-right"></i>
                 	  			 </span>
							</a>
							<ul class="treeview-menu">

								<li id="admin-login">
									<a href="all-admin-login.html">
										<i class="fa fa-circle-o"></i> 基础信息管理
									</a>
								</li>
								<li id="admin-login">
									<a href="all-admin-login.html">
										<i class="fa fa-circle-o"></i> 订单信息管理
									</a>
								</li>

							</ul>
						</li>
						<!-- 菜单 /-->
					</ul>
				</section>
				<!-- /.sidebar -->
			</aside>
<!-- 导航侧栏 /-->