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
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', 'Edit User');
		$('#fm').form('load', row);
		$('#updateIDHiddenInput').remove();
		$('#fm').append(
				'<input id="updateIDHiddenInput" type="hidden" name="id" value="'
						+ row.id + '">');
		url = 'update';
	}
}
function removeUser() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm',
				'Are you sure you want to remove this user?', function(r) {
					if (r) {
						$.post(
								'delete/'+ row.id, function(result) {
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
	}
}

function search(value,name){
	var json = eval("({" + name+":'"+value+"'})");
	$('#dg').datagrid({queryParams:json});
}

