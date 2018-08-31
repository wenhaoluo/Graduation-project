<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf" %>
<!DOCTYPE html>
<html>
<head>

	<title>提交表单</title>

</head>
<body>

	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="New Topic" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>账号:</td>
	    			<td><input class="easyui-textbox" type="text" name="username" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input class="easyui-textbox" type="text" name="password" data-options="required:true,validType:'email'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>角色:</td>
	    			<td><select class="easyui-combobox" name="role">
	    			<option value="1">教练</option>
	    			<option value="2">员工</option>
	    			<option value="2">会员</option>
	    			</select></td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td><select class="easyui-combobox" name="sex">
	    			<option value="1">男</option>
	    			<option value="2">女</option>
	    			</select></td>
	    		</tr>
	    		<tr>
	    			<td>真实姓名:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" name="truename" data-options="required:true"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>生日:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" name="birth" data-options="required:true"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>电话:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" name="phone" data-options="required:true"></input>
	    			</td>
	    		</tr>

	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	    </div>
	    </div>
	</div>
	<script>
		function submitForm(){
			$('#ff').form('submit',{
				onSubmit:function(){
					return $(this).form('enableValidation').form('validate');
				}
			});
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</body>
</html>