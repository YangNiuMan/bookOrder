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
        <h3 style="text-align: center;">修改书籍信息</h3>
        <form action="${pageContext.request.contextPath}/book/update.do" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${book.id}">

            <div class="form-group">
                <label for="roleId">ID：</label>
                <input type="text" class="form-control" id="Id" name="id"  value="${book.id}" readonly="readonly" />
            </div>

          <div class="form-group">
            <label for="roleId">封面：</label>
            <input type="text" class="form-control" id="roleId" name="cover"  value="${book.cover}"  />
          </div>

          <div class="form-group">
            <label for="roleName">书名：</label>
            <input type="text" class="form-control" value="${book.name}" id="roleName"  name="name" />
          </div>

          <div class="form-group">
            <label for="roleDesc">价格：</label>
            <input type="text" id="roleDesc" class="form-control" value="${book.price}" name="price"/>
          </div>

            <div class="form-group">
                <label for="roleDesc1">介绍：</label>
                <input type="text" id="roleDesc1" class="form-control" value="${book.intro}" name="intro"/>
            </div>

            <div class="form-group">
                <label for="roleDesc2">作者：</label>
                <input type="text" id="roleDesc2" class="form-control" value="${book.auther}" name="auther" />
            </div>

            <div class="form-group">
                <label for="roleDesc3">出版社：</label>
                <input type="text" id="roleDesc3" class="form-control" value="${book.press}" name="press" />
            </div>

            <div class="form-group">
                <label for="roleDesc4">出版日期：</label>
                <input type="text" id="roleDesc4" class="form-control" value="${book.pubdateStr}" name="pubdate"/>
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