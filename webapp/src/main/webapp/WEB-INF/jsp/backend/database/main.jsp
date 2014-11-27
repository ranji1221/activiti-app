<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  
    <title>数据库管理</title>
   	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ztree/zTreeStyle/zTreeStyle.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/ztree/jquery.ztree.core-3.5.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$.messager.progress({
                title:'Please waiting',
                msg:'Loading data...'
            });
           	$.post(
				"getJSONStrDataBases",
				{"nodeNameKey":"name","tablesNameKey":"children","columnsNameKey":"children"},
				function(data){
					$.messager.progress('close');
					var setting = {};
					$.fn.zTree.init($("#dataBaseTree"),setting,data);
					$.messager.show({
		                title:'Success',
		                msg:'Data Loading Success.',
		                showType:'fade',
		                timeout:5000
		            });	
				},
				"json"
			).error(function(e){
				$.messager.alert('Error','Data Loading Error!','error');
            	$.messager.progress('close');
			});
		});
	</script>
  </head>
  
  <body class="easyui-layout">
    	<div data-options="region:'west'" title="DataBases Tree" style="width:215px;">
    		<ul id="dataBaseTree" class="ztree"></ul>
    	</div>
    	<div data-options="region:'center',title:'DataBase'" class="easyui-tabs" id="tt">
    		<div title="DataBase Info"></div>
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