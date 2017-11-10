<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
	<div>

		<div>
			<input id="getParamVal" type="text" /> <input id="getBtn"
				type="button" value="submit" />
			<div id="getText"></div>
		</div>
		<div>
			<input id="postParamVal" type="text" /> <input id="postBtn"
				type="button" value="submit" />
			<div id="postText"></div>
		</div>
		<div>
			<input id="putParamVal" type="text" /> <input id="putBtn"
				type="button" value="submit" />
			<div id="putText"></div>
		</div>
	</div>
</body>
</html>
<script language="javascript" type="text/javascript"src="js/jquery.min.js"></script>
<script language="javascript" type="text/javascript"src="js/jquery.form.js"></script>
<script type="text/javascript"></script>
<script>
	$(function() {
		$("#getBtn").click(function() {
			$.ajax({
				type : "GET",
				url : "http://localhost:8080/htmlGuiSimple/rest/hello/getSayHello",
				success : function(result) {
					$("#getText").val(result);
				},
				error : function() {
					alert("add category failed!");
				}
			});
		});
		$("#postBtn").click(function() {
			var paramter = new Object();
			var name = $("#postParamVal").val()
			paramter.name = name;
			var data = JSON.stringify(paramter);
			$.ajax({
				type : "POST",
				url : "http://localhost:8080/htmlGuiSimple/rest/hello/postSayHello",
				data : data,
				cache : true,
				contentType : "application/json;charset=utf-8",
				success : function(resultData, textStatus) {
					$("#postText").val(resultData);
				}
			});
		});
		$("#putBtn").click(function() {
			var paramter = {};
			paramter = '{"name":"' + $("#putParamVal").val() + '"}';
			$.ajax({
				url : "/htmlGuiSimple/rest/hello/putSayHello",
				type : "PUT",
				data : paramter,
				dataType : "json",
				contentType : "application/json;charset=utf-8",
				success : function(resultData, textStatus) {
					$("#putText").val(resultData);
				}
			});
		});
	});
</script>