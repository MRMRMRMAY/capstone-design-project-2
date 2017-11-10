<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		$.ajax({
			url : "/htmlGuiSimple/rest/group/login",
			type:"POST",
			data:data,
			dataType : "json",
			success:function(resultData){
				window.location("main_page.jsp");
			},
			error:function(resultData){
				alert(resultData)
			}
		})
	});
});
</script>
</head>
<body>
<form>
	pw: <input type="text", id="idInput"/>
	<p/>
	id: <input type="password", id="pwInput"/>
	<p/>
	<input type="button", id="subBtn", value="log in"/>
</form>
</body>
</html>