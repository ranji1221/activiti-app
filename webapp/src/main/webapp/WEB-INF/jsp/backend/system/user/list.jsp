<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/gray/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/easyui.custom.css">		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
	</head>
	<body>
		<!-- list users start -->
		<table id="dg" title="My Users"  toolbar="#toolbar"></table>
		<div id="toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addUser()">Add User</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeUser()">Remove User</a>
			<!-- search start -->
			<%@include  file="search.jsp"%>
			<!-- search end -->
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/user/datagrid.js" charset="UTF-8"></script>
		<!-- list users end -->
		
		<!-- user form start -->
		<%@include file="form.jsp" %>
		<!-- user form end -->
	</body>
</html>
