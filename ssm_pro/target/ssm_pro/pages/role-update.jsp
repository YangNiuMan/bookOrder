<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>修改用户</title>

        <!-- 1. 导入CSS的全局样式 -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
        <script src="../js/jquery-3.3.1.min.js"></script>
        <!-- 3. 导入bootstrap的js文件 -->
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改角色信息</h3>
        <form action="${pageContext.request.contextPath}/role/update.do" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${role.id}">

          <div class="form-group">
            <label for="roleId">角色ID：</label>
            <input type="text" class="form-control" id="roleId" name="roleId"  value="${role.id}" readonly="readonly" placeholder="请输入角色ID" />
          </div>

          <div class="form-group">
            <label for="roleName">角色姓名：</label>
            <input type="text" class="form-control" value="${role.roleName}" id="roleName"  name="roleName" placeholder="请输入角色姓名" />
          </div>

          <div class="form-group">
            <label for="roleDesc">角色描述：</label>
            <input type="text" id="roleDesc" class="form-control" value="${role.roleDesc}" name="roleDesc" placeholder="请输入角色描述"/>
          </div>
             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default" type="button" value="返回"/>
             </div>
        </form>
        </div>
    </body>
</html>