<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/cart.js"></script>
<title>我的订单</title>
</head>
<body>

<div id="wrap">

<jsp:include page="../fore-end/header1.jsp"/>

<div class="center_content">

	<div class="left_content">
	
		<div class="title"><span class="title_icon"><img src="../img/bullet1.gif"/></span>我的订单</div>
		
		<div class="feat_prod_box_details">
		
			<c:if test="${indents!=null}">

				<c:forEach items="${indents}" var="indent">
					<table class="cart_table">
							<tr class="cart_title">
								<td>${indent.id}</td>
								<td>${indent.name}</td>
								<td>${indent.phone}</td>
								<td>${indent.address}</td>
								<td>${indent.systimeStr}</td>
								<td>${indent.total}</td>
								<td>${indent.statusStr}</td>
								<td>
									<a href="${pageContext.request.contextPath}/indent/delete?id=${indent.id}">删除</a>
								</td>
							</tr>			

		        	</table><br>
			</c:forEach>
			</c:if>
			

		
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