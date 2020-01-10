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
        <h3 style="text-align: center;">添加类别信息</h3>
        <form action="${pageContext.request.contextPath}/category/add.do" method="post">

          <div class="form-group">
            <label for="roleName">类别名称：</label>
            <input type="text" class="form-control" id="roleName"  name="name"  />
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />

                <input class="btn btn-default" type="button" value="返回"/>
             </div>
        </form>
        </div>
    </body>
</html>