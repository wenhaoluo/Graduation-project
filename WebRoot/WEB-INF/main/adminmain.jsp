<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>


<title></title>

<script type="text/javascript">
	$(function() {
		$("a[title]").click(function() {
			var text = this.href;
			alert(text);
			//判断是否存在
			if($('#tt').tabs("exists",this.title)){
			//存在则选中
				alert("存在了");
				$('#tt').tabs("select",this.title);			
			}else{
				$('#tt').tabs('add', {
					title:this.title,
					//面板有关闭按键
				    closable:true, 
				    //href对远程页面js的支持不好 
					//href: text			
					//可以加载内容填充到选项卡，页面有Js时，也可加载
					content:"<iframe src='"+text+"' title='"+this.title+"' height='100%' width='100%' frameborder='0px' ></iframe>"
						   
				
				});
				
			}
			return false;
			
		});
		
		
	});
	
	
</script>
<script type="text/javascript">
function getCurDate()
{
var d = new Date();
var week;
switch (d.getDay()){
case 1: week="星期一"; break;
case 2: week="星期二"; break;
case 3: week="星期三"; break;
case 4: week="星期四"; break;
case 5: week="星期五"; break;
case 6: week="星期六"; break;
default: week="星期天";
}
var years = d.getFullYear();
var month = add_zero(d.getMonth()+1);
var days = add_zero(d.getDate());
var hours = add_zero(d.getHours());
var minutes = add_zero(d.getMinutes());
var seconds=add_zero(d.getSeconds());
var ndate = years+"年"+month+"月"+days+"日 "+hours+":"+minutes+":"+seconds+" "+week;
var divT=document.getElementById("logInfo");
divT.innerHTML= ndate;
}
function add_zero(temp)
{
if(temp<10) return "0"+temp;
else return temp;
}
setInterval("getCurDate()",100);
</script>
</head>


<body class="easyui-layout">
	<!-- 头部 -->
	<%-- <div data-options="region:'north',title:'欢迎使用进销存管理系统',split:true"
		style="height:50px;">欢迎您 ：${user.username}</div> --%>
	<!-- 左边导航 -->
	<div
		data-options="region:'west',title:'<a >导航菜单</a>',split:true,collapsible:false"
		style="width:180px;">

		<div id="aa" class="easyui-accordion"
			style="width:'100%';height:'100%';">

			<div title="会员管理模块">


				<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
				<ul style="list-style: none;padding: 0px;margin:0px;">
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/user/userlist.action" 
						title="会员信息"
						style="text-decoration: none;display: block;font-weight:bold;">显示所有成员</a>
					</li>
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/user/yguserlist.action" 
						title="所有会员"
						style="text-decoration: none;display: block;font-weight:bold;">显示所有会员</a>
					</li>
				</ul>
			</div>


			<div title="留言板">
				<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
				<ul style="list-style: none;padding: 0px;margin:0px;">
					<li style="padding: 6px;"><a
						href="${proPath}/tie/selecttie.action" 
						title="留言板"
						style="text-decoration: none;display: block;font-weight:bold;">留言板</a>
					</li>

					<li style="padding: 6px;"><a
						href="${proPath}/tie/selectmytie.action?userid=${userid}" 
						title="我的留言"
						style="text-decoration: none;display: block;font-weight:bold;">我的留言</a>
					</li>
					<c:if test="${sessionScope.user.role == '员工'  || sessionScope.user.role == '教练'}">
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/bbs/tielist.action" 
						title="管理帖子"
						style="text-decoration: none;display: block;font-weight:bold;">管理帖子</a>
					</li>
					</c:if>
					<c:if test="${sessionScope.user.role == '员工'  || sessionScope.user.role == '教练'}">
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/course/huifulist.action" 
						title="管理回复"
						style="text-decoration: none;display: block;font-weight:bold;">管理回复</a>
					</li>
					</c:if>
				</ul>


			</div>
			<div title="课程信息">
				<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
				<ul style="list-style: none;padding: 0px;margin:0px;">
				<c:if test="${sessionScope.user.role == '员工'  || sessionScope.user.role == '教练'}">
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/jsclass/jsclasslist.action"
						title="课程信息"
						style="text-decoration: none;display: block;font-weight:bold;">显示所有课程</a>
					</li>
				</c:if>
				</ul>


			</div>
			<div title="健身课程">
				<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
				<ul style="list-style: none;padding: 0px;margin:0px;">
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/course/insert.action"
						title="课程管理"
						style="text-decoration: none;display: block;font-weight:bold;">课程管理</a>
					</li>
					<li style="padding: 6px;"><a
						id="mycourse"
						href="${proPath}/base/goURL/course/mycourse.action" 
						title="我的选课"
						style="text-decoration: none;display: block;font-weight:bold;">我的选课</a>
					</li>
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/course/myyycourse.action" 
						title="预约课程"
						style="text-decoration: none;display: block;font-weight:bold;">预约课程</a>
					</li>

				</ul>


			</div>

			<div title="信息导入导出">
				<ul style="list-style: none;padding: 0px;margin:0px;">
					<li style="padding: 6px;"><a
						href="http://localhost:8080/jsfmis/readExcel.jsp"
						title="信息导入"
						style="text-decoration: none;display: block;font-weight:bold;">信息导入</a>
					</li>
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/user/teacherlist.action" 
						title="信息导出"
						style="text-decoration: none;display: block;font-weight:bold;">信息导出</a>
					</li>
					
				</ul>
			</div>
			<div title="营业管理">
				<ul style="list-style: none;padding: 0px;margin:0px;">
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/order/orderlist.action"
						title="营业管理"
						style="text-decoration: none;display: block;font-weight:bold;">收支情况</a>
					</li>
				</ul>
			</div>
			<div title="个人设置">
				<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
				<ul style="list-style: none;padding: 0px;margin:0px;">
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/main/myinformation.action" 
						title="个人信息"
						style="text-decoration: none;display: block;font-weight:bold;">个人信息</a>
					</li>
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/jsclass/jsclasslist.action"
						title="修改密码"
						style="text-decoration: none;display: block;font-weight:bold;">修改密码</a>
					</li>
					<li style="padding: 6px;"><a 
					href="${proPath}/user/logout.action" 
					style="text-decoration: none;display: block;font-weight:bold;">注销</a>
					</li>

				</ul>
			</div>

		</div>
	</div>

	<!-- 主体内容 -->
	<div data-options="region:'center'"
		style="padding:5px;background:#eee;">
		<div id="tt" class="easyui-tabs" data-options="fit:true,"
			style="width:500px;height:250px;">
			
			<div title="系统介绍" style="padding:20px;">
			 现在时间 :<h3> <p id="logInfo"></p></h3>
			

			<table cellpadding="5">
	    	
	    		<tr>
	    			<td>账号:</td>
	    			<td>${sessionScope.user.username}</td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td>${sessionScope.user.sex}</td>
	    		</tr>
	    		<tr>
	    			<td>真实姓名:</td>
	    			<td>
	    				${sessionScope.user.truename}"
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>生日:</td>
	    			<td>
					${sessionScope.user.birth}
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>电话:</td>
	    			<td>
	    				${sessionScope.user.phone}
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>会员到期时间:</td>
	    			<td>${sessionScope.user.vipendtime}"</td>
	    		</tr>
			
	    		
	    	</table>
			
			
			</div>

		</div>

	</div>
	<div id="win"></div>
</body>

</html>