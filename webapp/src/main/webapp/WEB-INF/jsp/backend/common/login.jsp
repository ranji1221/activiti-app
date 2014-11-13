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
		<center>
			<h3>后台登陆</h3>
			<hr color="red">
			<form action="${pageContext.request.contextPath}/backend/login" method="post">
				<table>
					<tr>
						<td>用户名</td>
						<td><input type="text" name="userName"></td>
					</tr>
					<tr>
						<td>密&nbsp;&nbsp;码</td>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr align="center">
						<td colspan="2"><input type="submit" value="submit"></td>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>
