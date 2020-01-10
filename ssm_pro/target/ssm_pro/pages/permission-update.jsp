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
        <h3 style="text-align: center;">修改权限信息</h3>
        <form action="${pageContext.request.contextPath}/permission/update.do" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${permission.id}">

          <div class="form-group">
            <label for="roleId">权限ID：</label>
            <input type="text" class="form-control" id="roleId" name="id"  value="${permission.id}" readonly="readonly" placeholder="请输入角色ID" />
          </div>

          <div class="form-group">
            <label for="roleName">权限名称：</label>
            <input type="text" class="form-control" value="${permission.permissionName}" id="roleName"  name="permissionName" placeholder="请输入角色姓名" />
          </div>

          <div class="form-group">
            <label for="roleDesc">权限地址：</label>
            <input type="text" id="roleDesc" class="form-control" value="${permission.url}" name="url" placeholder="请输入角色描述"/>
          </div>
             <div class="form-group" style="text-align: center">
                 <input class="btn btn-primary" type="submit" value="提交" />
                 <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
             </div>
        </form>
        </div>
    </body>
</html>