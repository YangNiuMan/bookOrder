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
        <h3 style="text-align: center;">修改供应商信息</h3>
        <form action="${pageContext.request.contextPath}/Supplier/update.do" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${supplier.id}">

          <div class="form-group">
            <label for="roleId">供应商ID：</label>
            <input type="text" class="form-control" id="roleId" name="id"  value="${supplier.id}" readonly="readonly" />
          </div>

          <div class="form-group">
            <label for="roleName">供应商名称：</label>
            <input type="text" class="form-control" value="${supplier.name}" id="roleName"  name="name" />
          </div>

          <div class="form-group">
            <label for="roleDesc">供应商邮箱：</label>
            <input type="text" id="roleDesc" class="form-control" value="${supplier.email}" name="email"/>
          </div>

            <div class="form-group">
                <label for="roleDesc1">供应商地址：</label>
                <input type="text" id="roleDesc1" class="form-control" value="${supplier.address}" name="address" />
            </div>

            <div class="form-group">
                <label for="roleDesc2">供应商电话：</label>
                <input type="text" id="roleDesc2" class="form-control" value="${supplier.phoneNum}" name="phoneNum"/>
            </div>

            <div class="form-group">
                <label for="roleDesc3">供应商状态：</label>
                <input type="text" id="roleDesc3" class="form-control" value="${supplier.status}" name="status" />
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