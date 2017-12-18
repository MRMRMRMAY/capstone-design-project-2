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
//	function setcookie(name, value, daysToLive){
//		var exdate = new Date();
//		exdate.setDate(exdate.getDate()+daysToList);
//		document.cookie = name+"="+escape(value)+
//		((daysToLive == null)?"":";expires=" + exdate.toGMTString());
//	}
//	function getCookie(name){
//		if(document.cookie.length>0){
//			c_start = document.cookie.indexOf(name + "=");
//			if(c_start!=-1){
//				c_start = c_start+ name.length +1;
//				c_end = document.cookie.indexOf(";",c_start);
//				if(c_end == -1)
//					c_end = document.cookie.length;
//				return unescape(document.cookie.substring(c_start,s_end));
//			}
//		}
//		return "";
//	}
//	function checkCookie(){
//		username = getCookie('username');
//		if(username != null && username != ""){
//			//have found cookie
//			alert('Welcome again '+username+'!');
//			return true
//		}
//		else{
//			//haven't found cookie
//			return false
//		}
//	}
	function validate_required(){
		var idInput = $("#idInput").val();
		var pwInput = $("#pwInput").val();
		if(idInput==null||idInput==""||idInput.length < 4){
			$("#idInput").focus();
			return false;
		}
		if(pwInput==null||pwInput==""){
			$("#pwInput").focus();
			return false;
		}
		return true;
	}
	$("#subBtn").click(function(){
		if(!validate_required()){
			return null;
		}
		var paramter = getLoginJSONdata();
		var data = JSON.stringify(paramter);
		$.ajax({
			url : "rest/login/postLogin",
			type:"POST",
			data:data,
			cache : true,
			success:function(resultData){
				setcookie('username',paramter.id,null);
				window.location.href = "main.jsp";
			},
			error:function(resultData){
				//var result = JSON.stringify(resultData);
				alert(resultData.responseText);
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
//	$("#regBtn").click(function(){
//		var paramter = getJSONdata();
//		var data = JSON.stringify(paramter);
//		$.ajax({
//			url : "rest/login/postReg",
//			type:"POST",
//			data:data,
//			cache : true,
//			success:function(resultData){
//				window.location.href = "main.jsp";
//			},
//		error:function(resultData){
//			alert(resultData);
//			//var label=document.getElementById("msg");
//			//label.style.color="red";
//			//if(paramter.id ==""){
//			//	label.innerText="The id cannot be empty"; 
//			//}else if(paramter.pw == ""){
//			//	label.innerText="The pw cannot be empty";
//			//}
//			//else{
//			//	label.innerText="The id or password are incorrent"; 
//			//}
//		}
//		});
//	});
});