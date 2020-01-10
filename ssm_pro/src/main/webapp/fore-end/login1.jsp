<%@ page import="static java.awt.SystemColor.window" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

	<title>数据 - AdminLTE2定制版 | Log in</title>

	<meta
			content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
			name="viewport">

	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
</head>
<%--<style type="text/css">
	#checkCode {
		font-family: Arial;
		font-style: italic;
		font-weight: bold;
		border: 0;
		letter-spacing: 2px;
		color: blue;
	}

</style>--%>
<body>

<div id="wrap">
<div>    </div>
<jsp:include page="header1.jsp"/>

<div class="center_content">

	<div class="left_content">
	
		<div class="title"><span class="title_icon"><img src="../img/bullet1.gif"/></span>用户登录</div>

		<div class="feat_prod_box_details">
			<c:if test="${username1==null}">
			<div class="contact_form">
				<div class="form_subtitle">用户登录</div>
				<form id="form1" action="${pageContext.request.contextPath}/common/login"  method="post" >
					<div class="form-group has-feedback">
						<input type="text" name="username" class="form-control"
							   placeholder="用户名"> <span
							class="glyphicon glyphicon-envelope form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" name="password" class="form-control"
							   placeholder="密码"> <span
							class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>

					<input type="hidden" name="id" value="${username1}">

					<%--<div>
						<input type="text" id="input" name="input" placeholder="请输入验证码" />
						<input type="button" id="checkCode" onclick="createCode()" />
					</div>--%>

					<div class="row">
						<div class="col-xs-8">
							<div class="checkbox icheck">
								<label><input type="checkbox"> 记住 下次自动登录</label>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-xs-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat" <%--onclick="validate()"--%>>登录</button>
						</div>
						<!-- /.col -->
					</div>
				</form>

				<div class="form_row">
					<a href="${pageContext.request.contextPath}/register.jsp" style="float:right;margin:8px">没有账户? 点击注册</a>
				</div>
        	</div>
			</c:if>
			<c:if test="${username1!=null}">
				<div class="contact_form">
					<div class="form_subtitle">用户登录</div>
					<form action="${pageContext.request.contextPath}/common/login"  method="post" >
						<div class="form-group has-feedback">
							<input type="text" name="username" class="form-control" value="${username1}" readonly="readonly"
								   placeholder="用户名"> <span
								class="glyphicon glyphicon-envelope form-control-feedback"></span>
						</div>
						<div class="form-group has-feedback">
							<input type="password" name="password" value="<%=request.getSession().getAttribute("password1")%>" readonly="readonly" class="form-control"
								   placeholder="密码"> <span
								class="glyphicon glyphicon-lock form-control-feedback"></span>
						</div>



						<div class="row">
							<div class="col-xs-8">
								<div class="checkbox icheck">
									<label><input type="checkbox"> 记住 下次自动登录</label>
								</div>
							</div>
							<!-- /.col -->
							<div class="col-xs-4">
								<%--<button href="#" class="btn btn-primary btn-block btn-flat" &lt;%&ndash;onclick="validate()"&ndash;%&gt;>登录</button>--%>
								<a href="#" class="btn btn-primary btn-block btn-flat">登录</a>
							</div>
							<!-- /.col -->
						</div>
					</form>
					<div class="form_row">
						<a href="#" style="float:right;margin:8px">没有账户? 点击注册</a>
					</div>
				</div>
			</c:if>
		</div>

		<div class="clear"></div>
	
	</div>
	<div style="margin-right: 10px">
		<jsp:include page="right1.jsp"/>
	</div>


	<div class="clear"></div>
	
</div>

<jsp:include page="footer1.jsp"/>

</div>
<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>

<script>

	
    var code; //在全局定义验证码
    //产生验证码
    window.onload = function() {
        createCode();
    };

    function createCode() {
        code = "";
        var codeLength = 4; //验证码的长度
        var checkCode = document.getElementById("checkCode");
        var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //随机数
        for (var i = 0; i < codeLength; i++) { //循环操作
            var charIndex = Math.floor(Math.random() * 36); //取得随机数的索引
            code += random[charIndex]; //根据索引取得随机数加到code上
        }
        checkCode.value = code; //把code值赋给验证码
    };



    //校验验证码
    function validate() {
        var inputCode = document.getElementById("input").value.toUpperCase(); //取得输入的验证码并转化为大写
        if (inputCode.length <= 0) { //若输入的验证码长度为0
            alert("请输入验证码！"); //则弹出请输入验证码
            /* window.location.replace("${pageContext.request.contextPath}/login1.jsp");*/
            return false;
        } else if (inputCode != code) { //若输入的验证码与产生的验证码不一致时
            alert("验证码输入错误！"); //则弹出验证码输入错误
            createCode(); //刷新验证码
            return false;
        } else { //输入正确时
            var f=document.forms[0];
            f.action="${pageContext.request.contextPath}/common/login";
            f.submit();
        }
    }
</script>
</body>
</html>