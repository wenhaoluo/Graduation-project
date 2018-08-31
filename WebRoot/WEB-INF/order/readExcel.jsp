<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload  read excel</title>
<link rel="stylesheet" type="text/css" href="/WEB-INF/order/jquery.js">
<link rel="stylesheet" type="text/css" href="/WEB-INF/order/ajaxfileupload.js">
<link rel="stylesheet" type="text/css" href="/WEB-INF/order/jquery.jokeer.js">
<script type="text/javascript">
function ajaxFileUpload() {
	$.ajaxFileUpload({
		url : 'excel/drexcel.action',
		secureuri : false,
		fileElementId : 'fileToUpload',
		dataType : 'json',
		//data : {username : "controller.ExcelAction"},
		success : function(data, status) {
			if(data.picUrl!=1){
				alert("解析成功！")
				$('#downloadExcel').attr('href',data.picUrl);
				setTimeout('haha()', 5000);
			}else{
				alert("错误")
				setTimeout('haha()', 5000);
			}
			
		}
	})

	return false;

}

$("#exportExcel").click(function(){
	alert("s")
	//头的名称
	
	
});

function exportss(){
	valArr=[];
	 $("#lineTable").find("th").each(function(i){
		 valArr.push($.trim($(this).text()));
		 valArr.join(",")
	  });   
	 alert(valArr)
	 location.href="${proPath}/excel/drexcel.action?status=out&valArr="+valArr;
	 setTimeout('haha()', 1000);
}
</script>
</head>

<body>
	<h1>解析EXCEL03</h1>
	<input id="fileToUpload" type="file" size="45" name="fileToUpload"
		class="input">
	<button class="button" onclick="ajaxFileUpload()">上传</button>
	<br>
	
	<a href="javascript:void(0);" style="margin-left: 400px" id="exportExcel"  onclick="exportss()">导出</a> 
	<a href="" style="margin-left: 400px" id="downloadExcel">下载上传的文件</a> 
										
										
		
		<table  id="lineTable">
			<thead>
				<tr>
					<th>姓名</th>
					<th>年龄</th>
					<th>性别</th>
				</tr>
			</thead>
		
		
		</table>							
</body>
</html>