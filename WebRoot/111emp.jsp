<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>My JSP</title>

	<script type="text/javascript">
		$(function() {
			$('#dg').datagrid({    
			    url:'${proPath}/tie/selecttie.action',    
			    columns:[[    
			        {field:'userid',
			        	title:'用户id',
			        	width:100},    
			        {field:'name',title:'Name',width:100},    
			        {field:'price',title:'Price',width:100,align:'right'}    
			    ]]    
			});  


		});
	</script>
</head>
<body>
<table id="dg"></table>  
</body>
</html>
