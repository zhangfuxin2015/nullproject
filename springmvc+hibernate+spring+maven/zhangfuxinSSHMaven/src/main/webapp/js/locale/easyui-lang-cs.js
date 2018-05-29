﻿if ($.fn.pagination){
	$.fn.pagination.defaults.beforePageText = 'Strana';
	$.fn.pagination.defaults.afterPageText = 'z {pages}';
	$.fn.pagination.defaults.displayMsg = 'Zobrazuji {from} do {to} z {total} polo啪ky';
}
if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = 'Zpracov谩n铆, 膷ekejte pros铆m ...';
}
if ($.fn.treegrid && $.fn.datagrid){
	$.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg;
}
if ($.messager){
	$.messager.defaults.ok = 'Ok';
	$.messager.defaults.cancel = 'Zru拧it';
}
$.map(['validatebox','textbox','filebox','searchbox',
		'combo','combobox','combogrid','combotree',
		'datebox','datetimebox','numberbox',
		'spinner','numberspinner','timespinner','datetimespinner'], function(plugin){
	if ($.fn[plugin]){
		$.fn[plugin].defaults.missingMessage = 'Toto pole je vy啪adov谩no.';
	}
});
if ($.fn.validatebox){
	$.fn.validatebox.defaults.rules.email.message = 'Zadejte pros铆m platnou e-mailovou adresu.';
	$.fn.validatebox.defaults.rules.url.message = 'Zadejte pros铆m platnou adresu URL.';
	$.fn.validatebox.defaults.rules.length.message = 'Pros铆m, zadejte hodnotu mezi {0} a {1}.';
}
if ($.fn.calendar){
	$.fn.calendar.defaults.weeks = ['S','M','T','W','T','F','S'];
	$.fn.calendar.defaults.months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
}
if ($.fn.datebox){
	$.fn.datebox.defaults.currentText = 'Dnes';
	$.fn.datebox.defaults.closeText = 'Zav艡铆t';
	$.fn.datebox.defaults.okText = 'Ok';
}
if ($.fn.datetimebox && $.fn.datebox){
	$.extend($.fn.datetimebox.defaults,{
		currentText: $.fn.datebox.defaults.currentText,
		closeText: $.fn.datebox.defaults.closeText,
		okText: $.fn.datebox.defaults.okText
	});
}
