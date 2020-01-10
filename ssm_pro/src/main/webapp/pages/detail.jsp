<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/book.js"></script>
<title>图书详情</title>
</head>
<body>

<div id="wrap">

<jsp:include page="../fore-end/header1.jsp"/>

<div class="center_content">

	<div class="left_content">
	
		<div class="title"><span class="title_icon"><img src="../img/bullet1.gif"/></span>${book.name}</div>
		<div class="feat_prod_box_details">
			<div class="prod_img">
				<img src="..${book.cover}" class="thumb_big" border="0" />
			</div>
			<div class="prod_det_box">
				<div class="box_top"></div>
				<div class="box_center">
					<div class="prod_title">${book.name}</div>
					<p class="details">${book.intro}</p>
					<div class="price"><strong>价格:</strong> <span class="red">${book.price}</span></div>
					<div style="text-align: right;margin-right:11px;margin-top:-20px">
						<a href="javascript:void(0);" onclick="buyBook(${book.id},<%=request.getSession().getAttribute("length")%>,<%=request.getSession().getAttribute("userId")%>)">
							<img src="../img/button.png" width="150px"/>
						</a>
					</div>
					<div class="clear"></div>
				</div>
				<div class="box_bottom"></div>
			</div>
			<div class="clear"></div>
		</div>
		
		<div id="demo" class="demolayout">
		
			<ul id="demo-nav" class="demolayout">
				<li><a class="active">详细介绍</a></li>
				<!-- <li><a class="" href="javascript:alert('暂未实现');">相关推荐</a></li> -->
			</ul>
			<div class="tabs-container">
				<div style="display: block;" class="tab" id="tab1">
					<p class="more_details">${book.intro}</p>
					<ul class="list">
						<li><a href="">作者: ${book.auther}</a></li>
						<li><a href="">出版社: ${book.press}</a></li>
						<li><a href="">出版日期: ${book.pubdate}</a></li>
						<li><a href="">图片分类: ${book.category.name}</a></li>
					</ul>
				</div>
				<div style="display: none;" class="tab" id="tab2">
				<!-- 相关推荐 暂时不做
					<div class="new_prod_box"> <a href="details.htm">product name</a>
						<div class="new_prod_bg"> <a href="details.htm"><img src="images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a> </div>
					</div>
					<div class="new_prod_box"> <a href="details.htm">product name</a>
						<div class="new_prod_bg"> <a href="details.htm"><img src="images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a> </div>
					</div>
					<div class="new_prod_box"> <a href="details.htm">product name</a>
						<div class="new_prod_bg"> <a href="details.htm"><img src="images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a> </div>
					</div>
					<div class="new_prod_box"> <a href="details.htm">product name</a>
						<div class="new_prod_bg"> <a href="details.htm"><img src="images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a> </div>
					</div>
					<div class="clear"></div> -->
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
<script>

	function  buyBook(bookId,length,userId) {
		if (length>0){
            alert("请继续操作")
            window.location.href='${pageContext.request.contextPath}/userBook/findByBookId?bookId='+bookId+'&amount='+1+'&userId='+userId;
		}else{
            alert("请登录后操作")
            window.location.href='${pageContext.request.contextPath}/fore-end/login1.jsp';
		}
    }

</script>
</body>
</html>