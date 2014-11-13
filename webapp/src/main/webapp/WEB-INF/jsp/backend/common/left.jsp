<div class="leftPanel" style="width:200px;height:auto;background:#7190E0;padding:5px;">
	<div class="easyui-panel" title="Picture Tasks" collapsible="true" style="width:200px;height:auto;padding:10px;">
		<shiro:hasPermission name="user:list">
			<a href="javascript:void(0)" onclick="addTab('Users','${pageContext.request.contextPath}/system/user/list')">User Manager</a><br/>
		</shiro:hasPermission>
		<a href="javascript:void(0)" onclick="addTab('ProcessDesigner','${pageContext.request.contextPath}/process/designer/edit')">Process Designer</a><br/>
		Order prints online<br/>
		Print pictures
	</div>
	<br/>
	<div class="easyui-panel" title="File and Folder Tasks" collapsible="true" style="width:200px;height:auto;padding:10px;">
		Make a new Folder<br/>
		Publish this folder to the Web<br/>
		Share this folder
	</div>
	<br/>
	<div class="easyui-panel" title="Other Places" collapsible="true" style="width:200px;height:auto;padding:10px;">
		New York<br/>
		My Pictures<br/>
		My Computer<br/>
		My Network Places
	</div>
	<br/>
	<div class="easyui-panel" title="Details" collapsible="true" style="width:200px;height:auto;padding:10px;">
		My Documents<br/>
		File folder<br/>
		Date modified: Nov.30rd 2013
	</div>
	<br/>
</div>