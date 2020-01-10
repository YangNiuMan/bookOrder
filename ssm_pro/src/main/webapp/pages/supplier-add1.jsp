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
        <h3 style="text-align: center;">添加供应商</h3>
        <form action="${pageContext.request.contextPath}/Supplier/add.do" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${book.id}">

          <div class="form-group">
            <label for="roleId">供应商名称：</label>
            <input type="text" class="form-control" id="roleId" name="name" />
          </div>

          <div class="form-group">
            <label for="roleName">供应商邮箱：</label>
            <input type="text" class="form-control" id="roleName"  name="email" />
          </div>

          <div class="form-group">
            <label for="roleDesc">供应商地址：</label>
            <input type="text" id="roleDesc" class="form-control"  name="address"/>
          </div>

            <div class="form-group">
                <label for="roleDesc1">供应商电话：</label>
                <input type="text" id="roleDesc1" class="form-control"  name="phoneNum"/>
            </div>

            <div class="form-group">
                <label for="roleDesc2">供应商状态：</label>
                <select id="roleDesc2" name="status">
                    <option value="0">0</option>
                    <option value="1">1</option>
                </select>
            </div>

        <%--  <div class="form-group">
                <label for="roleDesc5">图书分类：</label>
                &lt;%&ndash;<input type="text" id="roleDesc5" class="form-control" value="${book.category.id}" name="categoryId"/>&ndash;%&gt;
                <select name="categoryId" id="roleDesc5" >
                    <c:forEach items="${book.category}" var="cate">
                        <option value="${cate.id}">${cate.id}</option>
                    </c:forEach>
                </select>--%>
               <%-- <select name="categoryId" id="roleDesc5" class="form-control"  >
                    <c:forEach items="${book.category.id}" var="cate">
                        <option>${cate.id}</option>
                    </c:forEach>
                </select>--%>
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