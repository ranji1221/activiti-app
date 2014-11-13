<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="tag.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>后台管理</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/icon.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
  </head>
  
  <body class="easyui-layout">
    	<div data-options="region:'north'" style="height:100px"></div>
    	<div data-options="region:'west'" title="Navigation" style="width:215px;">
    		<%@include file="left.jsp" %>
    	</div>
    	<div data-options="region:'center',title:'WorkSpace'" class="easyui-tabs" id="tt">
    		<div title="Home"></div>
    		<script>
				function addTab(title, url){
					if($('#tt').tabs('exists',title)){
						$('#tt').tabs('select',title);
					}else{
						var content = '<iframe scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:100%;"></iframe>';
						$('#tt').tabs('add',{
							title:title,
							content:content,
							closable:true
						});
					}
				}
			</script>
    	</div>
  </body>
</html>
