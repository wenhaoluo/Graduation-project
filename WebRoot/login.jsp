<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%@ include file="/common/common.jspf"%>
<title>Login page</title>
</head>
<body>

	<div id="loginDiv">
	<center>
		<form id="ff"  method="post" action="${proPath}/user/login.action">
			<div>
				<label for="username">账号:</label>
				<!-- 采用 js验证 -->
				<input type="text" name="username"  />
			</div>
			<div>
				<label for="password">密码:</label>

				<input type="password" name="password" />
			</div>
			
			<div>
			<div>
			请选择您的身份：
			</div>
			<label><input name="role" type="radio" value="教练" />教练</label> 
			<label><input name="role" type="radio" value="员工" />员工 </label> 
			<label><input name="role" type="radio" value="会员" />会员 </label> 
			<label><input name="role" type="radio" value="管理员" />管理员 </label> 
			
			</div>
			
			
		</form>
		
		<div style="color:red">${requestScope.msg}</div>
		<div style="color:red">${requestScope.vip}</div>
			</center>
	</div>

	<script type="text/javascript">

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
		
		//把div的内容作为对话框方式弹出
		$('#loginDiv').dialog({
			title : '健身房信息管理系统',
			width : 500,
			height : 300,
			closed : false,
			cache : false,
			//设置关闭按钮可见
			closable : false,
			//模式化窗口.如果为true将锁屏
			modal : true,
			
			buttons:[{
				text:'登陆',
				handler:function(){
					
					//启用验证
					$("#ff").form("enableValidation");
					//进行验证，通过就提交
					
					if($("#ff").form("validate")){
					//提交
			
							$("#ff").submit();
							
					}
					
				}
			},{
				text:'取消',
				handler:function(){
					$("#ff").form("clear");
			}
			}]
			
		});
		
	</script>
</body>
</html>
