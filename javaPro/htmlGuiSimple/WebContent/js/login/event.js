$(function(){
	function getLoginJSONdata(){
		var json = new Object();
		json.id = $("#idInput").val();
		json.pw = $("#pwInput").val();
		return json;
	}
	function getRegJSONdata(){
		var json = new Object();
		json.regID = $("#REG_IDInput").val();
		json.regFN = $("#REG_FNInput").val();
		json.regLN = $("#REG_LNInput").val();
		json.regEADD = $("#REG_EADDInput").val();
		json.regPWD = $("#REG_PWDInput").val();
		json.regREPWD = $("REG_REPWDInput").val();
	}
	$("#subBtn").click(function(){
		var paramter = getLoginJSONdata();
		var data = JSON.stringify(paramter);
		$.ajax({
			url : "/htmlGuiSimple/rest/login/postLogin",
			type:"POST",
			data:data,
			cache : true,
			success:function(resultData){
				window.location.href = "main_accordion.html";
			},
			error:function(resultData){
				alert(resultData);
				//var label=document.getElementById("msg");
				//label.style.color="red";
				//if(paramter.id ==""){
				//	label.innerText="The id cannot be empty"; 
				//}else if(paramter.pw == ""){
				//	label.innerText="The pw cannot be empty";
				//}
				//else{
				//	label.innerText="The id or password are incorrent"; 
				//}
			}
		});
	});
	$("#regBtn").click(function(){
		var paramter = getJSONdata();
		var data = JSON.stringify(paramter);
		$.ajax({
			url : "/htmlGuiSimple/rest/login/postLogin",
			type:"POST",
			data:data,
			cache : true,
			success:function(resultData){
				window.location.href = "main_accordion.html";
			},
		error:function(resultData){
			alert(resultData);
			//var label=document.getElementById("msg");
			//label.style.color="red";
			//if(paramter.id ==""){
			//	label.innerText="The id cannot be empty"; 
			//}else if(paramter.pw == ""){
			//	label.innerText="The pw cannot be empty";
			//}
			//else{
			//	label.innerText="The id or password are incorrent"; 
			//}
		}
		});
	});
});