<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>个人信息</title>
<script type="text/javascript">
		$(function() {

			$("[name='username']").validatebox({
				required : true,
				missingMessage : '请填写账号！'
			});
			$("[name='password']").validatebox({
				required : true,
				missingMessage : '请填写密码！'
			});

			//禁用验证
			$("#ff").form("disableValidation");

			$("#btn").click(function() {
				//alert("ddddddddddd");
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					alert("------------");
					$('#ff').form('submit', {
						url : '${proPath}/user/update.action',
						onSubmit : function() {
							return true;
						},
						success : function(count) {							
								//可以定义为对应消息框
                        	    alert("成功");
								parent.$("#win").window("close");
								win.$("#dg").datagrid("reload");
								 //根据需要调整
								win.$("#dg").datagrid("clearSelections");							
						}
					});
				}
			});
		});
	</script>
</head>

<body>


		    <form id="ff" class="easyui-form" method="post" action="${proPath}/user/update.action">
	    	<table cellpadding="5">
	    	<div style="display: none">
			<input type="text" value="${sessionScope.user.userid}" name="userid" />
			<input type="text" value="${sessionScope.user.role}" name="role" />
		</div>
	    		<tr>
	    			<td>账号:</td>
	    			<td><input readOnly="true" class="easyui-textbox" type="text"  name="username" value="${sessionScope.user.username}"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input class="easyui-textbox" type="text" name="password" value="${sessionScope.user.password}"></input></td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td><select class="easyui-combobox" name="sex" value="${sessionScope.user.sex}">
	    			<option value="男">男</option>
	    			<option value="女">女</option>
	    			</select></td>
	    		</tr>
	    		<tr>
	    			<td>真实姓名:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" name="truename" value="${sessionScope.user.truename}"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>生日:</td>
	    			<td>
	    				<input  type="text" id="birth"
				class="easyui-datebox" name="birth" required="required" value="${sessionScope.user.birth}"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>电话:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" name="phone" value="${sessionScope.user.phone}"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>会员到期时间:</td>
	    			<td><input readOnly="true" class="easyui-textbox" type="text"  name="vipendtime" value="${sessionScope.user.vipendtime}"></input></td>
	    		</tr>

	    		
	    	</table>
	    </form>
<div>
			<input id="btn" type="button" value="提交" />
		</div>


</body>
</html>
