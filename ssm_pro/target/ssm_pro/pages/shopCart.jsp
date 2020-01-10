<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/cart.js"></script>
<title>购物车</title>
	<script>
        function fun(){
          var obj= document.getElementsByName("ids");
          var name =document.getElementById('name').value;
            var phone =document.getElementById('phone').value;
            var address =document.getElementById('address').value;
           var userId= <%=request.getSession().getAttribute("userId")%>
            var myDate = new Date();
            var mytime=myDate.toLocaleDateString();
            var idss=[];
            for(var i=0;i<obj.length;i++){
                if(obj[i].checked){
                    idss.push(obj[i].value);
				}
            }
            window.location.href='${pageContext.request.contextPath}/indent/add.do?name='+name+'&phone='+phone+'&address='+address+'&idss='+idss+'&systime='+mytime+'&status='+0+'&userId='+userId;
        }

	</script>
</head>
<body>

<div id="wrap">

<jsp:include page="../fore-end/header1.jsp"/>

<div class="center_content">

	<div class="left_content">
	
		<div class="title"><span class="title_icon"><img src="../img/bullet1.gif"/></span>我的购物车</div>
		
		<div class="feat_prod_box_details">
				<table class="cart_table">

					<c:forEach items="${shopCarts}" var="shopCart">
						<tr class="cart_title">
							<td><input name="ids" type="checkbox" value="${shopCart.id}"></td>
							<td>
								<a href="${pageContext.request.contextPath}/userBook/findById?id=${shopCart.id}">
									<img src="..${shopCart.cover}" class="thumb" border="0"/>
								</a>
							</td>
							<td>${shopCart.name}</td>
							<td>${shopCart.price}</td>
							<td>x ${shopCart.amount}</td>
							<td>${shopCart.total}</td>
							<td>
								<a href="${pageContext.request.contextPath}/shopCart/add.do?id=${shopCart.id}">[添加]</a>
								<a href="${pageContext.request.contextPath}/shopCart/reduce.do?id=${shopCart.id}">[减少]</a>
								<a href="${pageContext.request.contextPath}/shopCart/delete.do?id=${shopCart.id}">[删除]</a>
							</td>
						</tr>
					</c:forEach>
					<input type="button" value="总价" onclick="fun()">
	          		<%--<tr>
			            <td colspan="4" class="cart_total"><span class="red">总价: </span></td>
			            <td><s:property value="#session.indent.total"/></td>
	          		</tr>--%>
	        	</table><br>
	        	

	        		<table class="cart_table">
	        			<tr>
		        			<td><input type="text" id="name"  placeholder="收货人姓名" style="width:100px"/></td>
			        		<td><input type="text" id="phone"  placeholder="收货人电话" style="width:100px"/></td>
			        		<td><input type="text" id="address"  placeholder="收货地址" style="width:180px"/></td>
		        		</tr>
	        		</table>
					<input type="button" value="提交订单" onclick="fun()">
	        		<%--<a href="javascript:void(0)" class="checkout">提交订单</a>--%>


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