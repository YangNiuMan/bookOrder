<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<div class="right_content">
	

		<div class="cart">
			<div class="title">
				<a href="${pageContext.request.contextPath}/shopCart/findAll1.do?id=<%=request.getSession().getAttribute("userId")%>"><img src="../img/cart.gif" alt="购物车" title="购物车"/></a>
			</div>
				<a href="${pageContext.request.contextPath}/shopCart/findAll1.do?id=<%=request.getSession().getAttribute("userId")%>" class="view_cart">查看购物车</a>
		</div>


	
	<div class="title"><span class="title_icon"><img src="../img/bullet3.gif"/></span>书店简介</div>
	<div class="about">
		<p>
			<img src="../img/about.gif" class="right" />
			书店连续三年获得了新闻出版署举办“讲信誉、重服务”单位的光荣称号。 
			2000年12月被辽宁省文化市场办授予首家“全国音像制品正版销售单位”。 
			书店不仅是出版发行部门开拓图书市场，开通货源渠道的驿站， 
			更是广大读者朋友读书、选书、购书的最佳场所，傲然矗立在图书领域， 
			成为东北乃至更广大地域走向知识经济新时代的桥梁和纽带。 
		</p>
	</div>
	
	
	<div class="right_box">
	
		<div class="title"><span class="title_icon"><img src="../img/bullet4.gif"/></span>优惠促销</div>
		

			<div class="new_prod_box"> <a href="${pageContext.request.contextPath}/userBook/findById?id=9">实战Java程序设计</a>
				<div class="new_prod_bg">
					<span class="new_icon"><img src="../img/promo_icon.gif"/></span>
					<a href="${pageContext.request.contextPath}/userBook/findById?id=9"><img src="../img/p2.jpg" class="thumb" border="0" /></a>
				</div>
			</div>

		<div class="new_prod_box"> <a href="${pageContext.request.contextPath}/userBook/findById?id=10">程序员修炼手册</a>
			<div class="new_prod_bg">
				<span class="new_icon"><img src="../img/promo_icon.gif"/></span>
				<a href="${pageContext.request.contextPath}/userBook/findById?id=10"><img src="../img/p1.jpg" class="thumb" border="0" /></a>
			</div>
		</div>
	</div>



	<div class="right_box">
	
		<div class="title"><span class="title_icon"><img src="../img/bullet5.gif"/></span>图书分类</div>
		<ul class="list">
			<li><a href="${pageContext.request.contextPath}/book/findByCategoryId?id=1">经典作品</a></li>
			<li><a href="${pageContext.request.contextPath}/book/findByCategoryId?id=2">社会科学</a></li>
			<li><a href="${pageContext.request.contextPath}/book/findByCategoryId?id=3">自然科学</a></li>
			<li><a href="${pageContext.request.contextPath}/book/findByCategoryId?id=4">历史地理</a></li>
			<li><a href="${pageContext.request.contextPath}/book/findByCategoryId?id=5">中国文学</a></li>
			<li><a href="${pageContext.request.contextPath}/book/findByCategoryId?id=6">美术雕塑</a></li>
			<li><a href="${pageContext.request.contextPath}/book/findByCategoryId?id=7">摄影影视</a></li>
			<li><a href="${pageContext.request.contextPath}/book/findByCategoryId?id=8">书法篆刻</a></li>
			<li><a href="${pageContext.request.contextPath}/book/findByCategoryId?id=9">医药卫生</a></li>
			<li><a href="${pageContext.request.contextPath}/book/findByCategoryId?id=10">建筑科学</a></li>
			<li><a href="${pageContext.request.contextPath}/book/findByCategoryId?id=11">生活休闲</a></li>
			<li><a href="${pageContext.request.contextPath}/book/findByCategoryId?id=12">少儿读物</a></li>
		</ul>
		
	</div>
</div>
    
</body>
</html>