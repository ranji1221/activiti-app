//-- set datagrid
var dg = $('#dg').datagrid({
	title : 'User List',
	iconCls : 'icon-edit', // 图标,
	nowrap : false,
	striped : true,
	border : true,
	collapsible : true, // 是否可折叠
	idField : 'id',
	rownumbers : true,
	fitColumns : true,
	//singleSelect : true,
	pagination : true, // 分页控件
	url : 'getusers',
	frozenColumns : [[
	    {field : 'ck',checkbox : true} 
	]],
	columns:[[
	    {field:'userName',title:'User Name'},
	    {field:'pwd',title:'Password'},
	    {field:'enabled',title:'Enabled'},
	    {field:'description',title:'Description'}
	]],
	queryParams:{},
	loadMsg : 'Data Loading......'
});

// -- set pagination
var p = $('#dg').datagrid('getPager');
$(p).pagination({
	pageSize : 10, // 每页显示的记录条数，默认为10
	pageList : [ 5, 10, 15 ], // 可以设置每页记录条数的列表
	beforePageText : '第', // 页数文本框前显示的汉字
	afterPageText : '页	    共 {pages} 页',
	displayMsg : '当前显示 {from} - {to} 条记录 		共 {total} 条记录'
});