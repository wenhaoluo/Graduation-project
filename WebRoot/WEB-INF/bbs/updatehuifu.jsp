<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>供应商详细信息</title>
</head>
<body>


	<form id="ff" method="post">

		<div>
			<label for="username">账号:</label> <input type="text" name="username" />
		</div>
		<div>
			<label for="password">密码:</label> <input type="text" name="password" />
		</div>
		<div>
			<label for="role">角色:</label> <input type="text"
				name="role" />
		</div>

		<div>
			<input id="btn" type="button" value="提交" />
		</div>
	</form>

	<script type="text/javascript">
		$(function() {
			var win = parent.$("iframe[title='会员信息']").get(0).contentWindow;//返回ifram页面文档（window)
		    var array =win.$("#dg").datagrid("getSelections");
		    alert(array[0].userid);
		    $("#ff").form('load',{
		    	userid : array[0].userid,
				username : array[0].username,
				password : array[0].password,
				role : array[0].role,


			});		
		
			$("[name='userid']").validatebox({
				required : true,
				missingMessage : '请填写供应商！'
			});
			$("[name='username']").validatebox({
				required : true,
				missingMessage : '请填写出联系人！'
			});
			$("[name='password']").validatebox({
				required : true,
				missingMessage : '请填写联系电话！'
			});
			//禁用验证
			$("#ff").form("disableValidation");

			$("#btn").click(function() {
				//alert("ddddddddddd");
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					alert("------------");
					$('#ff').form('submit', {
						url : '${proPath}/supplier/updateByPk.action',
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
</body>
</html>
