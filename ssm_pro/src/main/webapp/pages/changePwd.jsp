<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<title>修改密码</title>

	<!-- 1. 导入CSS的全局样式 -->
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<!-- 2. jQuery导入，建议使用1.9以上的版本 -->
	<script src="../js/jquery-3.3.1.min.js"></script>
	<!-- 3. 导入bootstrap的js文件 -->
	<script src="../js/bootstrap.min.js"></script>
	<style type="text/css">
		#divbox{
			padding:20px;
			font-size:22px;
			color:red;
		}
	</style>
	<script>
        function codefans(){
            var box=document.getElementById("divbox");
            box.style.display="none";
        }
        setTimeout("codefans()",1300);//3秒

        /*显示密码*/
        function checkit(isChecked) {
            if (isChecked) {
                $("#password").prop("type", 'text');
                $("#mm2").prop("type", 'text');
            } else {
                $("#password").prop("type", 'password');
                $("#mm2").prop("type", 'password');
            }
        }

	</script>
</head>
<body>
<div class="container" style="width: 400px;">
	<h3 style="text-align: center;">修改密码</h3>
	<form action="${pageContext.request.contextPath}/change/updatePwd" method="post">

		<div class="form-group">
			<label for="roleName">原密码：</label>
			<input type="password" class="form-control"  id="roleName" name="oldpassword" placeholder="请输入原密码" />
		</div>

		<div class="form-group">
			<label for="roleDesc">新密码：</label>
			<input type="password" id="roleDesc" class="form-control"   name="password1" placeholder="请输入新密码" />
		</div>
		<div class="form-group" style="text-align: center">
			<input class="btn btn-primary" type="submit" value="提交" />
			<button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
		</div>
	</form>
	<div id="divbox">
		<h4 align="center">${login_msg}</h4>
	</div>
</div>
</body>
</html>