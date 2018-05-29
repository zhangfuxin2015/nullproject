if ($.fn.pagination){
	$.fn.pagination.defaults.beforePageText = '苑栈';
	$.fn.pagination.defaults.afterPageText = '斋謥 {pages}';
	$.fn.pagination.defaults.displayMsg = '源斋湛榨宅 {from}-斋謥 {to}-炸 {total} 眨謤铡占崭謧沾斋謥';
}
if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = '谈辗铡寨站崭謧沾 乍, 窄斩栅謤崭謧沾 榨斩謩 战蘸铡战榨宅 ...';
}
if ($.fn.treegrid && $.fn.datagrid){
	$.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg;
}
if ($.messager){
	$.messager.defaults.ok = '员盏崭';
	$.messager.defaults.cancel = '论铡寨榨宅';
}
$.map(['validatebox','textbox','filebox','searchbox',
		'combo','combobox','combogrid','combotree',
		'datebox','datetimebox','numberbox',
		'spinner','numberspinner','timespinner','datetimespinner'], function(plugin){
	if ($.fn[plugin]){
		$.fn[plugin].defaults.missingMessage = '员盏战 栅铡辗湛炸 蘸铡謤湛铡栅斋謤 乍.';
	}
});
if ($.fn.validatebox){
	$.fn.validatebox.defaults.rules.email.message = '越斩栅謤崭謧沾 榨斩謩 沾崭謧湛謩铡眨謤榨宅 眨崭謤债崭詹 e-mail 瞻铡战謥榨.';
	$.fn.validatebox.defaults.rules.url.message = '越斩栅謤崭謧沾 榨斩謩 沾崭謧湛謩铡眨謤榨宅 眨崭謤债崭詹 URL.';
	$.fn.validatebox.defaults.rules.length.message = '越斩栅謤崭謧沾 榨斩謩 沾崭謧湛謩铡眨謤榨宅 铡謤摘榨謩 {0}  {1}.';
	$.fn.validatebox.defaults.rules.remote.message = '越斩栅謤崭謧沾 榨斩謩 崭謧詹詹榨宅 铡盏战 栅铡辗湛炸.';
}
if ($.fn.calendar){
	$.fn.calendar.defaults.firstDay = 1;
	$.fn.calendar.defaults.weeks  = ['钥.','缘.','缘.','諌.','諃.','请謧.','諊.'];
	$.fn.calendar.defaults.months = ['諃崭謧斩站铡謤', '论榨湛謤站铡謤', '谈铡謤湛', '员蘸謤斋宅', '谈铡盏斋战', '諃崭謧斩斋战', '諃崭謧宅斋战', '諘眨崭战湛崭战', '諐榨蘸湛榨沾闸榨謤', '諃崭寨湛榨沾闸榨謤', '诿崭盏榨沾闸榨謤', '源榨寨湛榨沾闸榨謤'];
}
if ($.fn.datebox){
	$.fn.datebox.defaults.currentText = '员盏战謪謤';
	$.fn.datebox.defaults.closeText = '论铡寨榨宅';
	$.fn.datebox.defaults.okText = '员盏崭';
}
if ($.fn.datetimebox && $.fn.datebox){
	$.extend($.fn.datetimebox.defaults,{
		currentText: $.fn.datebox.defaults.currentText,
		closeText: $.fn.datebox.defaults.closeText,
		okText: $.fn.datebox.defaults.okText
	});
}
