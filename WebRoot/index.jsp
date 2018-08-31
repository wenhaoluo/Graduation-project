<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
</head>
<body>
	<form action="user/insert.action" method="post">

		账号：<input type="text"	name="username"><br> 
		密码：<input type="password"	name="password"><br> 	
		等级：<input type="text"	name="role"><br> 	
		<input type="submit" value="ok">
	</form>
	角色类型：<select id="cc" class="easyui-combobox" name="role" style="width:100px;">   
   		<c:forEach items="${applicationScope.sysParam.role}" var="roleq">
   			<option>${stype.value}</option> 
   		</c:forEach>
</select>  
	供应商类型：<select id="cc" class="easyui-combobox" name="supType" style="width:200px;">   
   		<c:forEach items="${applicationScope.sysParam.supType}" var="stype">
   			<option value='${stype.key}'>${stype.value}</option> 
   		</c:forEach>
</select>  
	<form action="user/insertvip.action" method="post">

		时间：<input type="text"	name="viptime"><br> 

		<input type="submit" value="ok">
	</form>
</body>
</html>
