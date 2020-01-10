<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../js/style.css"/>
<script type="text/javascript" src="../js/jquery.js"></script>
</head>
<body>
<div style="height:181px;width: 902px;background: url(../img/header.jpg) no-repeat center ">

    <div class="logo">
	    <a href="index.action">
	    	<img src="../img/logo.gif" border="0" /></a>
    </div>
    <div id="menu">
		<ul>
			<li <c:if test="flag==1">class="selected"</c:if>><a href="${pageContext.request.contextPath}/pages/index2.jsp">首页</a></li>
			<%--<li <c:if test="flag==2">class="selected"</c:if>><a href="about.action">书店简介</a></li>--%>
			<li <c:if test="flag==3">class="selected"</c:if>><a href="${pageContext.request.contextPath}/userBook/SepcialList">精品推荐</a></li>
			<li <c:if test="flag==4">class="selected"</c:if>><a href="${pageContext.request.contextPath}/userBook/NewList">最新出版</a></li>
			<li <c:if test="flag==5">class="selected"</c:if>><a href="${pageContext.request.contextPath}/userBook/SaleList">优惠促销</a></li>

			<li <c:if test="flag==6">class="selected"</c:if>><a href="${pageContext.request.contextPath}/fore-end/login1.jsp">用户登陆</a></li>

			<%--<li <c:if test="flag==7">class="selected"</c:if>><a href="${pageContext.request.contextPath}/register.jsp">用户注册</a></li>--%>
			<li><a href="${pageContext.request.contextPath}/pages/main.jsp" target="_blank">后台管理</a></li>

			<li><a href="${pageContext.request.contextPath}/indent/findAll.do?id=${userId}">订单(${username1})</a></li>
			<li><a href="${pageContext.request.contextPath}/common/lyout">注销(${username1})</a></li>
			<li style="float: right; margin-right: 10px;">
				<form action="${pageContext.request.contextPath}/userBook/search" method="post" id="form_search">
					<input type="text" name="searchName"  placeholder="输入图书名称" />
					<button type="submit" style="float: right;margin-left:0">搜索</button>
				</form>
			</li>
		</ul>
    </div>
</div>
</body>
</html>