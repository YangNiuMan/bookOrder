<%@ page import="java.util.Date" %>
<%@ page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<!-- 页面meta -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">




	<title>数据 - AdminLTE2定制版</title>
	<meta name="description" content="AdminLTE2定制版">
	<meta name="keywords" content="AdminLTE2定制版">




	<!-- Tell the browser to be responsive to screen width -->
	<meta
			content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
			name="viewport">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/morris/morris.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/select2/select2.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
<title>精品推荐</title>
	<script>
	window.onload=function(){
	var oUl=document.getElementById("piot");
	var str=oUl.innerHTML;
	oUl.innerHTML=str.substr(0,80)+"...";//先按一定字数缩进
	};
    window.onload=function(){
        var oUl=document.getElementById("piot1");
        var str=oUl.innerHTML;
        oUl.innerHTML=str.substr(0,80)+"...";//先按一定字数缩进
    };
    window.onload=function(){
        var oUl=document.getElementById("piot2");
        var str=oUl.innerHTML;
        oUl.innerHTML=str.substr(0,80)+"...";//先按一定字数缩进
    }
	</script>
</head>
<body>

<div id="wrap">

	<jsp:include page="../fore-end/header1.jsp"/>

<div class="center_content">

	<div class="left_content">
	
		<div class="title"><span class="title_icon"><img src="../img/bullet1.gif"/></span>精选推荐</div>
     
     <c:forEach items="${pageInfo.list}" var="special">
     	
	     	<div class="feat_prod_box">
				<div class="prod_img">
					<a href="${pageContext.request.contextPath}/userBook/findById?id=${special.id}">
						<img src="..${special.cover}" class="thumb_big" border="0"/>
					</a>
				</div>
				<div class="prod_det_box"><span class="special_icon"><img src="../img/special_icon.gif"/></span>
					<div class="box_top"></div>
					<div class="box_center">
						<div class="prod_title"><a href="${pageContext.request.contextPath}/userBook/findById?id=${special.id}">${special.name}</a></div>

						<c:if test="${special.id%3==1}">
						<div><p class="details" id="piot">${special.intro}</p></div>
						</c:if>
						<c:if test="${special.id%3==2}">
							<div><p class="details" id="piot1">${special.intro}</p></div>
						</c:if>
						<c:if test="${special.id%3==0}">
							<div><p class="details" id="piot2">${special.intro}</p></div>
						</c:if>
						<%--<div style="width:300px;height:50px;text-overflow:ellipsis; white-space:nowrap; overflow:hidden;-webkit-line-clamp:4">${special.intro}</div>
						--%>

						<a href="${pageContext.request.contextPath}/userBook/findById?id=${special.id}" class="more">- 图书详情 -</a>
						<div class="clear"></div>
					</div>
					<div class="box_bottom"></div>
				</div>
				<div class="clear"></div>
			</div>

	 </c:forEach>
		<div class="box-footer">
			<div class="pull-left">
				<div class="form-group form-inline">
					总共${pages}页，共${totalCount}条数据。
				</div>
			</div>

			<div class="box-tools pull-right">
				<ul class="pagination">
					<li>
						<a href="${pageContext.request.contextPath}/userBook/SepcialList?page=1&size=${pageInfo.pageSize}" aria-label="Previous">首页</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/userBook/SepcialList?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a></li>
					<c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
						<li><a href="${pageContext.request.contextPath}/userBook/SepcialList?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
					</c:forEach>
					<li><a href="${pageContext.request.contextPath}/userBook/SepcialList?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a></li>
					<li>
						<a href="${pageContext.request.contextPath}/userBook/SepcialList?page=${pageInfo.pages}&size=${pageInfo.pageSize}" aria-label="Next">尾页</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="clear"></div>
	
	</div>

	<jsp:include page="../fore-end/right1.jsp"/>
   
	<div class="clear"></div>
	
</div>
	<jsp:include page="../fore-end/footer1.jsp"/>

</div>

<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    /*	function changePageSize() {
            //获取下拉框的值
            var pageSize1 = $("#changePageSize").val();

            //向服务器发送请求，改变没页显示条数
            location.href = "${pageContext.request.contextPath}/orders/findAllAccount?page=1&size="
					+ pageSize1;
		}*/
    /*  function changeA(id)
      {

              var r=document.getElementById("re1");
              if(r.innerText=="设为推荐"){
                  r.innerText="取消推荐";


              } else{
                  r.innerText="设为推荐";
                  window.location.href='${pageContext.request.contextPath}/book/update?id='+id;
            }
		};
*/
    function findById(id) {
        //用户安全提示
        if(confirm("确认修改")){
            //访问路径
            location.href="${pageContext.request.contextPath}/book/findById?id="+id;
        }
    };
    $(document).ready(function() {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale : 'zh-CN'
        });
    });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document).ready(function() {

        // 激活导航位置
        setSidebarActive("admin-datalist");

        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass : 'icheckbox_square-blue',
            increaseArea : '20%'
        });
        // 全选操作
        $("#selall").click(function() {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
</script>
</body>

</html>