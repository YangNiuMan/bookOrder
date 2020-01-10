<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019/12/18
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script language="javascript">
        var secs = 3; //倒计时的秒数
        var URL ;
        function Load(url){
            URL = url;
            for(var i=secs;i>=0;i--)
            {
                window.setTimeout('doUpdate(' + i + ')', (secs-i) * 1000);
            }
        }
        function doUpdate(num)
        {
            document.getElementById('ShowDiv').innerHTML = '请先处理之前的订单，将在'+num+'秒后自动跳转到首页' ;
            if(num == 0) { window.location = URL; }
        }
    </script>

</head>
<body style="color: #bf800c" onload="Load('${pageContext.request.contextPath}/pages/main.jsp')">
<div id="ShowDiv" style="size: 20px;margin: auto;color: red"></div>
</body>
</html>
