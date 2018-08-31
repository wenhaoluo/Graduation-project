<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>个人信息</title>

</head>

<body>


		    <form id="ff" class="easyui-form" method="post" action="${proPath}/tie/selecttie.action">
	    	<c:forEach items="${list}" var="p">
				
				
		<input value="${p.userid}" type = "button">
		<input value="${p.tietitle}" type = "button">
		<input value="${p.tieauthor}" type = "button">
		Property 'tieDate' not found on type com.jsf.entity.Tie
				

				</c:forEach>
				    <input type="submit" value="dfgfdg"/>
	    </form>



</body>
</html>
