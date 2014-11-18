var url;
function addUser() {
	$('#dlg').dialog('open').dialog('setTitle', 'New User');
	$('#updateIDHiddenInput').remove();
	$('#fm').form('clear');
	url = 'add';
}
function saveUser() {
	$('#fm').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.success) {
				$('#dlg').dialog('close'); // close the dialog
				$('#dg').datagrid('reload'); // reload the user data
			} else {
				$.messager.show({
					title : 'Error',
					msg : result.msg
				});
			}
		}
	});
}
function editUser() {
	var rows = $('#dg').datagrid('getSelections');
	if (rows.length == 1) {
		$('#dlg').dialog('open').dialog('setTitle', 'Edit User');
		$('#fm').form('load', rows[0]);
		$('#updateIDHiddenInput').remove();
		$('#fm').append(
				'<input id="updateIDHiddenInput" type="hidden" name="id" value="'
						+ rows[0].id + '">');
		url = 'update';
	}else if(!rows || rows.length == 0) {
		$.messager.alert('提示','请选择要编辑的数据!','info');
	}else {
		$.messager.alert('提示','请只选择一行要编辑的数据!','info');
	}
}
function removeUser() {
	var rows = $('#dg').datagrid('getSelections');
	if (rows && rows.length > 0) {
		$.messager.confirm('Confirm',
				'Are you sure you want to remove users?', function(r) {
					if (r) {
						var idsArr = new Array();
						$.each(rows,function(i,row){
							idsArr.push(row.id);
						});
						$.post(
								'deleteByIDS', {ids:idsArr} ,function(result) {
									if (result.success) {
										$('#dg').datagrid('reload');
										$('#dg').datagrid('clearSelections');
									} else {
										$.messager.show({
											title : 'Error',
											msg : result.msg
										});
									}
								}, 'json');
					}
				});
	}else{
		$.messager.alert('提示','请选择要删除的数据!','info');
	}
}

function search(value,name){
	var json = '{"' + name + '":"'+value+'"}';
	var dg = $('#dg').datagrid({
		queryParams:{
			'params' : json
		}
	});
	var p = $('#dg').datagrid('getPager');
	$(p).pagination({
		pageSize : 10, // 每页显示的记录条数，默认为10
		pageList : [ 5, 10, 15 ], // 可以设置每页记录条数的列表
		beforePageText : '第', // 页数文本框前显示的汉字
		afterPageText : '页	    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录 		共 {total} 条记录'
	});
}

