<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>


<title></title>
<style type="text/css">
.searchbox{
	margin:-3
}
</style>

<script type="text/javascript">
	$(function(){
			var win = parent.$("iframe[title='课程管理']").get(0).contentWindow;//返回ifram页面窗体对象（window)
	
			$('#dg').datagrid({    
			    //url:'${proPath}/supplier/selectPage.action', //通过关键字查询
			    //支持多条件查询
			    url:'${proPath}/jsclass/selectPageUseDyc.action', 
			    
			    fitColumns:true,
			    nowrapL:true,
			    idField:'cid',
			    rownumbers:true,
			    singleSelect:true,
			    
			    pagination:true,
			    pageSize:20,
			    pageList:[5,10,20],
			    
			     queryParams: {
					cname: '%%'		
				}, 
						    
			    toolbar: [{
					iconCls: 'icon-ok',
					text:'保存',
					handler: function(){
						var row =  $("#dg").datagrid("getSelected");
						alert(row.cid);
						win.$("#ff").form('load',{
							cid:row.cid,
							cname:row.cname
							
						});
						
						parent.$("#win").window("close");

				
					}
		
				},'-',{
					text:"名称：<input type='text' id='cname' name='cname'/>",					
				}],			       
			    

				columns : [ [{
					checkbox:true,
				}, {
				field : 'cid',
				title : '课程编号'
			}, {
				field : 'cname',
				title : '课程名称',
				width : 100
			}, {
				field : 'ctext',
				title : '授课内容',
				width : 100
			}] ]
		});
		
			$('#cname').searchbox({ 
			searcher:function(value,name){ 
				
				$('#dg').datagrid('load',{				
					cname:'%'+value+'%'		
				});					
			}, 
			prompt:'' 
		});
		

	});
</script>
</head>

<body>

	<table id="dg"></table>
</body>
</html>