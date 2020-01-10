<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p><security:authentication property="principal.username"></security:authentication></p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<%--<li class="header">菜单</li>--%>
			<li id="admin-index">
				<a href="${pageContext.request.contextPath}/pages/main.jsp"><i class="fa fa-dashboard"></i> <span>首页</span>
				</a>
				<a href="${pageContext.request.contextPath}/fore-end/index1.jsp"><i class="fa fa-dashboard"></i><span>返回前端</span></a>
			</li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>系统管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting">
						<security:authorize access="hasRole('ADMIN')">
						<a
						href="${pageContext.request.contextPath}/user/findAll.do"> <i
							class="fa fa-circle-o"></i> 用户管理</a>
						</security:authorize>
					</li>
					<li id="system-setting">
                        <security:authorize access="hasRole('ADMIN')">
                        <a
						href="${pageContext.request.contextPath}/role/findAll.do"> <i
							class="fa fa-circle-o"></i> 角色管理
					</a></li>
					<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
						href="${pageContext.request.contextPath}/permission/findAll.do">
							<i class="fa fa-circle-o"></i> 资源权限管理
					</a></li>
					<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
						href="${pageContext.request.contextPath}/sysLog/findAll.do"> <i
							class="fa fa-circle-o"></i> 访问日志
					</a></li>
				</ul></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>基础数据</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
						href="${pageContext.request.contextPath}/product/findAllAccount">
							<i class="fa fa-circle-o"></i> 产品管理
					</a></li>
					<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
						href="${pageContext.request.contextPath}/orders/findAllAccount?page=1&pageSize=3"> <i
							class="fa fa-circle-o"></i> 订单管理
					</a></li>

				</ul></li>

				<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>订单管理</span> <span class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
				</span>
				</a>
					<ul class="treeview-menu">

						<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
								href="${pageContext.request.contextPath}/indent/untreated?page=1&pageSize=3">
							<i class="fa fa-circle-o"></i>未处理
						</a></li>
						<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
								href="${pageContext.request.contextPath}/indent/treated?page=1&pageSize=3"> <i
								class="fa fa-circle-o"></i>已处理
						</a></li>

					</ul></li>

				<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>图书管理</span> <span class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
				</span>
				</a>
					<ul class="treeview-menu">

						<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
								href="${pageContext.request.contextPath}/book/findAll.do">
							<i class="fa fa-circle-o"></i>图书列表
						</a></li>
						<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
								href="${pageContext.request.contextPath}/book/SearchRecommend?page=1&pageSize=3"> <i
								class="fa fa-circle-o"></i>推荐列表
						</a></li>
						<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
								href="${pageContext.request.contextPath}/book/SearchNews?page=1&pageSize=3"> <i
								class="fa fa-circle-o"></i>最新列表
						</a></li>
						<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
							href="${pageContext.request.contextPath}/book/SearchSale?page=1&pageSize=3"> <i
							class="fa fa-circle-o"></i>促销列表
					</a></li>
						<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
							href="${pageContext.request.contextPath}/pages/book-add.jsp"> <i
							class="fa fa-circle-o"></i>添加图书
					</a></li>
					</ul></li>
						<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
							<span>类目管理</span> <span class="pull-right-container"> <i
									class="fa fa-angle-left pull-right"></i>
				</span>
						</a>
							<ul class="treeview-menu">

								<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
										href="${pageContext.request.contextPath}/category/findAll.do">
									<i class="fa fa-circle-o"></i>类目列表
								</a></li>
								<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
										href="${pageContext.request.contextPath}/pages/category-add.jsp"> <i
										class="fa fa-circle-o"></i>添加类目
								</a></li>
							</ul></li>

				<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>供应商管理</span> <span class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
				</span>
				</a>
					<ul class="treeview-menu">

						<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
								href="${pageContext.request.contextPath}/Supplier/findAll.do?page=1&pageSize=3">
							<i class="fa fa-circle-o"></i>供应商信息
						</a></li>
						<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
								href="${pageContext.request.contextPath}/pages/supplier-add1.jsp"> <i
								class="fa fa-circle-o"></i>添加供应商
						</a></li>
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>库存管理</span> <span class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
				</span>
				</a>
					<ul class="treeview-menu">

						<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
								href="${pageContext.request.contextPath}/stock/findAll.do">
							<i class="fa fa-circle-o"></i>库存信息
						</a></li>
						<%--<li id="system-setting"><a access="hasRole('ADMIN')"/><a
								href="${pageContext.request.contextPath}/orders/findAllAccount?page=1&pageSize=3"> <i
								class="fa fa-circle-o"></i>添加库存
						</a></li>--%>
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>进货管理</span> <span class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
				</span>
				</a>
					<ul class="treeview-menu">

						<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
								href="${pageContext.request.contextPath}/WholeSale/findByNoSubmit?page=1&pageSize=3">
							<i class="fa fa-circle-o"></i>进货请求
						</a></li>
						<li id="system-setting"><security:authorize access="hasRole('ADMIN')"/><a
								href="${pageContext.request.contextPath}/WholeSale/findBySubmit?page=1&pageSize=3"> <i
								class="fa fa-circle-o"></i>进货记录
						</a></li>
					</ul></li>
		</ul>
	</section>
    </security:authorize></aside>