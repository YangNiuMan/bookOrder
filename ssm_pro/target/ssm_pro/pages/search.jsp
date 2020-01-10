<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书搜索</title>
</head>
<script>
    window.onload=function(){
        var oUl=document.getElementById("piot");
        var str=oUl.innerHTML;
        oUl.innerHTML=str.substr(0,80)+"...";//先按一定字数缩进
    };
    window.onload=function(){
        var oUl=document.getElementById("piot1");
        var str=oUl.innerHTML;
        oUl.innerHTML=str.substr(0,80)+"...";//先按一定字数缩进
    };
    window.onload=function(){
        var oUl=document.getElementById("piot2");
        var str=oUl.innerHTML;
        oUl.innerHTML=str.substr(0,80)+"...";//先按一定字数缩进
    }
</script>
<body>

<div id="wrap">

<jsp:include page="../fore-end/header1.jsp"/>

<div class="center_content">

	<div class="left_content">
	
		<div class="title"><span class="title_icon"><img src="../img/bullet1.gif"/></span>图书搜索</div>
     
     	<c:forEach items="${books}" var="book">
     
			<div class="feat_prod_box">
				<div class="prod_img">
					<a href="${pageContext.request.contextPath}/userBook/findById?id=${book.id}">
						<img src="..${book.cover}" class="thumb_big" border="0"/>
					</a>
				</div>
				<div class="prod_det_box">
					<c:if test="special==true"><span class="special_icon"><img src="../img/special_icon.gif"/></span></c:if>
					<c:if test="news==true"><span class="special_icon"><img src="../img/new_icon.gif"/></span></c:if>
					<c:if test="sale==true"><span class="special_icon"><img src="../img/promo_icon.gif"/></span></c:if>
					<div class="box_top"></div>
					<div class="box_center">
						<div class="prod_title"><a href="${pageContext.request.contextPath}/userBook/findById?id=${book.id}">${book.name}</a></div>
						<c:if test="${book.id%3==1}">
							<div><p class="details" id="piot">${book.intro}</p></div>
						</c:if>
						<c:if test="${book.id%3==2}">
							<div><p class="details" id="piot1">${book.intro}</p></div>
						</c:if>
						<c:if test="${book.id%3==0}">
							<div><p class="details" id="piot2">${book.intro}</p></div>
						</c:if>
						<a href="${pageContext.request.contextPath}/userBook/findById?id=${book.id}" class="more">- 图书详情 -</a>
						<div class="clear"></div>
					</div>
					<div class="box_bottom"></div>
				</div>
				<div class="clear"></div>
			</div>
		
		</c:forEach>

		
		<div class="clear"></div>
	
	</div>

	<jsp:include page="../fore-end/right1.jsp"/>
   
	<div class="clear"></div>
	
</div>

<jsp:include page="../fore-end/footer1.jsp"/>

</div>

</body>
</html>