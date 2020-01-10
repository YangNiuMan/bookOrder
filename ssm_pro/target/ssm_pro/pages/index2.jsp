<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书店首页</title>
</head>
<body>

<div id="wrap">

<jsp:include page="../fore-end/header1.jsp"/>

<div class="center_content">

	<div class="left_content">
	
		<!-- 精品推荐 -->
		<div class="title"><span class="title_icon"><img src="../img/bullet1.gif"/></span>精品推荐</div>


		
			<div class="feat_prod_box">
				<div class="prod_img">
					<a href="${pageContext.request.contextPath}/userBook/findById?id=1"><img src="../img/p2.jpg" class="thumb_big"/></a>
				</div>
				<div class="prod_det_box">
					<div class="box_top"></div>
					<div class="box_center">
						<span class="special_icon"><img src="../img/special_icon.gif"></span>
						<div class="prod_title">
							<a href="${pageContext.request.contextPath}/userBook/findById?id=1">实战Java程序设计</a>
						</div>
						<p class="details"><span>这是一本既注重实战，同时也注重底层“内功”（内存分析、JVM底层、数据结构）训练的书，
							本书能帮助初学者打通Java编程“任督二脉”。本书集作者11年Java教学之精华，既适合初学者入门，也适合已经工作的开发者复习。
							全书共分18章，
							</span></p>
						<a href="${pageContext.request.contextPath}/userBook/findById?id=1" class="more">- 图书详情 -</a>
						<div class="clear"></div>
					</div>
					<div class="box_bottom"></div>
				</div>
				<div class="clear"></div>
			</div>

		<div class="feat_prod_box">
			<div class="prod_img">
				<a href="${pageContext.request.contextPath}/userBook/findById?id=2"><img src="../img/p1.jpg" class="thumb_big"/></a>
			</div>
			<div class="prod_det_box">
				<div class="box_top"></div>
				<div class="box_center">
					<span class="special_icon"><img src="../img/special_icon.gif"></span>
					<div class="prod_title">
						<a href="${pageContext.request.contextPath}/userBook/findById?id=2">实战Java程序设计</a>
					</div>
					<p class="details"><span>倾尽十二年学习和工作经验的精华，结合北京尚学堂各学院院长和教学总监多年教学经验总结，
						特著此册希望对所有想要进入程序员行列的同学都能起到一定的积极作用。
							</span></p>
					<a href="${pageContext.request.contextPath}/userBook/findById?id=2" class="more">- 图书详情 -</a>
					<div class="clear"></div>
				</div>
				<div class="box_bottom"></div>
			</div>
			<div class="clear"></div>
		</div>
	<%--</c:forEach>--%>
		

		<!-- 最新出版 -->
		<div class="title"><span class="title_icon"><img src="../img/bullet2.gif"/></span>最新出版</div>
		
		<div class="new_products">
		

				<div class="new_prod_box"> 
					<a href="${pageContext.request.contextPath}/userBook/findById?id=9">实战Java程序设计</a>
					<div class="new_prod_bg">
						<span class="new_icon"><img src="../img/new_icon.gif"/></span>
						<a href="${pageContext.request.contextPath}/userBook/findById?id=9"><img src="../img/p2.jpg" class="thumb" border="0" /></a>
					</div>
				</div>

			<div class="new_prod_box">
				<a href="${pageContext.request.contextPath}/userBook/findById?id=9">实战Java程序设计</a>
				<div class="new_prod_bg">
					<span class="new_icon"><img src="../img/new_icon.gif"/></span>
					<a href="${pageContext.request.contextPath}/userBook/findById?id=9"><img src="../img/p2.jpg" class="thumb" border="0" /></a>
				</div>
			</div>

			<div class="new_prod_box">
				<a href="${pageContext.request.contextPath}/userBook/findById?id=10">程序员修炼手册</a>
				<div class="new_prod_bg">
					<span class="new_icon"><img src="../img/new_icon.gif"/></span>
					<a href="${pageContext.request.contextPath}/userBook/findById?id=10"><img src="../img/p1.jpg" class="thumb" border="0" /></a>
				</div>
			</div>
		</div>
		
		<div class="clear"></div>
	
	</div>
	<jsp:include page="../fore-end/right1.jsp"/>
	<div class="clear"></div>
	
</div>

<jsp:include page="../fore-end/footer1.jsp"/>

</div>

</body>
</html>