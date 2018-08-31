<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/common.jspf"%>
<%@ include file="/common/bbscommon.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<base href="http://localhost:8080/WebApp/student/">--><base href=".">

<title>问答中心</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">



<script type="text/javascript">
	function _tanchu() {
		var zt = document.getElementById("zt_u_abs");
		zt.onmouseover = function() {
			document.getElementById("zt_u_bg").style.display = "block";
		};
		zt.onmouseout = function() {
			document.getElementById("zt_u_bg").style.display = "none";
		};
	}
	
	
	function showReplyArea(tieid){
		var id = "last_reply_"+tieid ; 
		var ele = document.getElementById(id);
		if(ele.style.display=="none"){
			ele.style.display="block";
		}else{
			ele.style.display="none";
		}
	}
</script>

<style type="text/css">
#cnameH {
	color: #666666;
}

#cnameH:hover {
	text-decoration: none;
	color: black;
}

</style>



</head>

<body>

	




	<!-- main开始 -->
	<div class="main1118" style="padding:0 40px;background:#fff;">
		<div class="title1118">
			<!-- <a href="" class="fr greenFont">回复我的</a>  -->
			<a href="${proPath}/tie/selectmytie.action?userid=${userid}" class="fr greenFont">我的提问</a> 
			
			<a  href=""><span  class="spanFont fl" style="">搜索</span></a>
			
			<div class="fl search" style="width: 180px;line-height: 47px;margin-top: 12px;">
				<form method="get" action="/bbscircle/grouptopic" onsubmit="return validate_form()">
					<input id="kw" name="keyword" type="text" class="inp fl"
						placeholder="请输入关键词"> 
						
				</form>
			</div>
		</div>


		<!-- 新建 -->
		<form  method="post">
		<input type="hidden" value="${sessionScope.user.userid}" name="userid" id="userid" />
		<input type="hidden" value="${sessionScope.user.truename}" name="tieauthor" id="tieauthor" />
			<input id="tietitle" name="tietitle" type="text" class="listTitle"
				placeholder="新建提问" style="margin-top:20px;width: 100%;"
				onfocus="showArea();">
			<div class="listTop"
				style="height:200px;overflow:hidden;margin-top:0;display: none;"
				id="inputArea" >

				<textarea id="tiecontext" name="tiecontext" class="listText"
					style="width: 100%;"></textarea>

				<div class="listBtn">
					<a href="javascript:;" class="fr cancel"
						style="color:#999;margin-left:10px;line-height: 24px;"
						onclick="hideArea();">取消</a> 
						<input type="submit" id="submit" value="发帖"/>
				</div>
			</div>
		</form>
		
		<script type="text/javascript">
		 	$("#submit").click(function(){
		 		var userid = $("#userid").val();
		 		var tieauthor = $("#tieauthor").val();
		 		var tietitle = $("#tietitle").val();
		 		var tiecontext = $("#tiecontext").val();
		 		
		 		$.ajax({
		 			url:"${proPath}/tie/inserttie.action",
		 			data:{"userid":userid,"tieauthor":tieauthor,"tietitle":tietitle,"tiecontext":tiecontext},
		 			dataType:"json",
		 			success:function(data){
		 				if(data == "success"){
		 					location.reload() 
		 				}
		 			}
		 		})
		 	})

		</script>
		

		<script type="text/javascript">
		function showArea(){
			var ele = document.getElementById("inputArea");
			ele.style.display="block";
		}
		function hideArea(){
			var ele = document.getElementById("inputArea");
			ele.style.display="none";
		}
	</script>







		<!-- 问答列表 -->
		<div id="showTopics">

			<c:forEach items="${tie}" var="t">
			
			<div class="content1118" style="border-bottom: none;">
				<div class="oneDiv">
					<span class="fl photo18"> 
					</span>
					<div class="fr oneRight">
						<div class="oneTop">
							<div class="fr operation"></div>
							<p>
								<span class="name">${t.tieauthor } </span> <span class="danwei" style="float: right;">
									
								</span>
							</p>
							<p class="gray">${t.tiedate }</p>
						</div>
						<h3 class="bt ol">
							<span style="color:#59657d;">${t.tietitle }</span>

						</h3>
						<p class="stuFont ol" style="margin-left: 0px;">
							<span style="color:#59657d;">${t.tiecontext }</span>
						</p>
						
						<!-- 回复按钮 -->
						<p class="clearfix">
							<a href="javascript:showReplyArea(${t.tieid })" class="fr tl1"><font id="count_${t.tieid }">回复</font></a>
						</p>
					</div>

					<div class="clear"></div>

					<!-- 回复表单 -->
					
						<div id="last_reply_${t.tieid }" class="hfpl clearfix" style="display:none; margin-top: 15px;position:relative">
							<form  method="post" action="${proPath}/tie/inserthuifu.action" >
							<input type="hidden" value="${sessionScope.user.userid}" id="huserid" name="userid" />
							<input type="hidden" value="${sessionScope.user.truename}" id="hfauthor" name="hfauthor" />
							<input type="hidden" value="${t.tieid }" name="tieid"  id="htieid"/>
							<textarea id="hfcontext" name="hfcontext" id="hfcontext" class="fl inp02" style="width: 715px;"></textarea>
						<input type="submit" class="fl grenBtn" value="回复" id="back11"> 
							
								</form>
						</div>
					
				</div>

				<!-- 分割线 -->
				<p class="borSolid"></p>

				<!-- 回复列表 -->
				 <div id="replyDiv_${t.tieid}">
				 
				 	<c:forEach items="${huifu}" var="h">
				 	<c:if test="${h.tieid==t.tieid }">
						<div class="listHf clearfix" style="border-bottom: #e2e2e2 solid 1px; padding-left: 25px;">
							<p style="color:#666;padding-left:12px;" class="ol">
								<span class="listTime"  style="padding-right: 0px;">${h.hfdate }</span>
								<c:if test="${a.isuse==true }">
									<span class="listTime" style="float: right;padding-right: 0px;"><img src="../images/star.png" title="提问者采纳" width="18"/></span>
								</c:if>
							</p>
							
							<div style="color:#666;padding-left:12px">${h.hfauthor } ：${h.hfcontext }</div>
						</div>
					</c:if>
					</c:forEach>
					
				
				</div> 
				
			</div>

			</c:forEach>



		</div>
		<a href="javascript:void(0)" id="getMoreTopic" class="moreList"
			onclick="getMoreTopic('9ea2732e797cc84b347919af39330676')">查看更多</a>
	</div>
	<!-- 异步添加一条提问 -->
	<script type="text/javascript">
	 /**
	   * 获取异步的函数
	   */
	  function getXMLHttpRequest() {
		try {
			return new XMLHttpRequest();
		} catch (e) {
			try {
				return new ActiveXObject("Msxml2.XMLHttp");
			} catch (e) {
				try {
					return new ActiveXObject("Microsoft.XMLHttp");
				} catch (e) {
					alert("您当前浏览器不支持异步对象的创建，请更换后再尝试！");
					throw e;
				}
			}
		}
	}
	
	
	
	/**
	 * 回复问题
	 */
	function replyQuestion(qid){
	
		var replyDivid = "replyDiv_" + qid;
		var acontentid = "acontent_" + qid;
		var replyList = document.getElementById(replyDivid);//完这里添加回复
		var acontentText = document.getElementById(acontentid);
		
		
		
		if(acontentText.value.trim()==""){
			alert("回复内容不允许为空");
			return false;
		
		}else{
			//拼接参数
			var params = "ccode="+"${course.ccode}"+"&answerer="+"${student.sid}"+"&acontent="+acontentText.value+"&name="+"${student.sname}"+"&qid="+qid;	
		
			//获取异步对象
			var xmlHttp = getXMLHttpRequest();
			
			//打开与服务器的连接
			xmlHttp.open("POST","<c:url value='/AnswerServlet?method=answerQuestion'/>");
			
			//发送参数
			xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xmlHttp.send(params);
			
			xmlHttp.onreadystatechange = function() {
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					var aj = xmlHttp.responseText;
					aj = eval("("+aj+")");				
				
					var s = "";
					s += "<div class='listHf clearfix' style='border-bottom: #e2e2e2 solid 1px; padding-left: 25px;'>";
					s += "<p style='color:#666;padding-left:12px;' class='ol'>";
					s += "<span class='listTime'  style='padding-right: 0px;'>"+aj.aj.atime+"</span>";
					s += "<span class='listTime' style='float: right;padding-right: 0px;'></span></p>";
					s += "<div style='color:#666;padding-left:12px'>"+aj.aj.name+" ："+aj.aj.acontent+"</div></div>";
					
					replyList.innerHTML = replyList.innerHTML + s;		
					
					//隐藏回复表单
					acontentText.value="";
					document.getElementById("last_reply_"+qid).style.display="none";
					
					//修改回复人数
					document.getElementById("count_"+qid).innerHTML = aj.count;
				}
			};
		return false;
		}
	
	}

</script>

</body>
</html>
