<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/gray/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/easyui.custom.css">		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/locale/easyui-lang-zh_CN.js"></script>
	</head>
	<body>
		<!-- list users start -->
		<table id="dg" title="My Users"  toolbar="#toolbar"></table>
		<div id="toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reFresh()">刷新</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addItem()">添加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editItem()">编辑</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeItems()">删除</a>
			<!-- search start -->
			<%@ include  file="search.jsp" %>
			<!-- search end -->
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/user/datagrid.js" charset="UTF-8"></script>
		<!-- list users end -->
		
		<!-- user form start -->
		<%@include file="form.jsp" %>
		<!-- user form end -->
	</body>
</html>
