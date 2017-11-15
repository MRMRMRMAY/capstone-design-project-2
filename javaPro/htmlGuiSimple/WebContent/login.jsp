<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"></script> 
<script language="javascript" type="text/javascript" src="js/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript">
$(function(){
	function getJSONdata(){
		var json = new Object();
		json.id = $("#idInput").val();
		json.pw = $("#pwInput").val();
		return json;
	}
	$("#subBtn").click(function(){
		var paramter = getJSONdata();
		var data = JSON.stringify(paramter);
		document.getElementById("msg").innerText = "";
		$.ajax({
			url : "/htmlGuiSimple/rest/login/postLogin",
			type:"POST",
			data:data,
			dataType : "text",
			cache : true,
			success:function(resultData){
				window.location.href = "main_accordion.html";
			},
			error:function(resultData){
				var label=document.getElementById("msg");
				label.style.color="red";
				if(paramter.id ==""){
					label.innerText="The id cannot be empty"; 
				}else if(paramter.pw == ""){
					label.innerText="The pw cannot be empty";
				}
				else{
					label.innerText="The id or password are incorrent"; 
				}
			}
		});
	});
});
</script>
</head>
<body>
<form>
	id: <input type="text", id="idInput"/>
	<p/>
	pw: <input type="password", id="pwInput"/>
	<p/>
	<label id="msg"></label>
	<p/>
	<input type="button", id="subBtn", value="log in"/>
	
</form>
</body>
</html>
