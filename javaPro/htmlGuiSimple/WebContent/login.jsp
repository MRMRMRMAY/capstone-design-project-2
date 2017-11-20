<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description"
	content="Expand, contract, animate forms with jQuery wihtout leaving the page" />
<meta name="keywords"
	content="expand, form, css3, jquery, animate, width, height, adapt, unobtrusive javascript" />
<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/login/style.css" />
<script src="js/login/cufon-yui.js" type="text/javascript"></script>
<script src="js/login/ChunkFive_400.font.js" type="text/javascript"></script>
<script type="text/javascript">
			Cufon.replace('h1',{ textShadow: '1px 1px #fff'});
			Cufon.replace('h2',{ textShadow: '1px 1px #fff'});
			Cufon.replace('h3',{ textShadow: '1px 1px #000'});
			Cufon.replace('.back');
		</script>
<title>Insert title here</title>
<script language="javascript" type="text/javascript"
	src="js/jquery.min.js"></script>
<script language="javascript" type="text/javascript"
	src="js/jquery.form.js"></script>
<script type="text/javascript">
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
	$(""#regBtn")..click(function(){
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
</script>
</head>
<div class="wrapper">
	<h1>DIANO</h1>
	<h2>
		Welcome to <span>DIANO</span>
	</h2>
	<div class="content">
		<div id="form_wrapper" class="form_wrapper">
			<form class="register">
				<h3>Register</h3>
				<div class="column">
					<div>
						<!-- <label>First Name:</label>-->
						<input type="text" placeholder="First Name" /> <span class="error">This
							is an error</span>
					</div>
					<div>
						<!--<label>Last Name:</label>-->
						<input type="text" placeholder="Last Name" /> <span class="error">This
							is an error</span>
					</div>
					<div>
						<!--<label>Username:</label>-->
						<input type="text" placeholder="Email" /> <span class="error">This
							is an error</span>
					</div>
					<!--</div>
						<div class="column">-->
					<div>
						<!--<label>Email:</label>-->
						<input type="text" placeholder="Username" /> <span class="error">This
							is an error</span>
					</div>
					<div>
						<!--<label>Password:</label>-->
						<input type="password" placeholder="Password" /> <span
							class="error">This is an error</span>
					</div>
					<div>
						<!--<label>Re-enter password:</label>
								<input type="text" value="http://"/>
								<span class="error">This is an error</span>-->

						<input type="password" placeholder="Re-enter password" /> <span
							class="error">This is an error</span>
					</div>
				</div>
				<div class="bottom">
					<div class="remember">
						<input type="checkbox" /> <span>Send me updates</span>
					</div>
					<input type="button" value="Register" id="regBtn" /> <a
						href="index.html" rel="login" class="linkform">You have an
						account already? Log in here</a>
					<div class="clear"></div>
				</div>
			</form>
			<form class="login active">
				<h3>Login</h3>
				<div>
					<label>Username:</label> <input type="text" id="idInput" /> <span
						class="error">This is an error</span>
				</div>
				<div>
					<label>Password: <a href="forgot_password.jsp"
						rel="forgot_password" class="forgot linkform">Forgot your
							password?</a></label> <input type="password" id="pwInput" /> <span
						class="error">This is an error</span>
				</div>
				<div class="bottom">
					<div class="remember">
						<input type="checkbox" id="rememberBox" /><span>Keep me
							logged in</span>
					</div>
					<input type="button" value="Login" id="subBtn"></input> <a
						href="register.jsp" rel="register" class="linkform">You don't
						have an account yet? Register here</a>
					<div class="clear"></div>
				</div>
			</form>
			<form class="forgot_password">
				<h3>Forgot Password</h3>
				<div>
					<label>Username or Email:</label> <input type="text" /> <span
						class="error">This is an error</span>
				</div>
				<div class="bottom">
					<input type="button" value="Send reminder"></input> <a
						href="index.html" rel="login" class="linkform">Suddenly
						remebered? Log in here</a> <a href="register.html" rel="register"
						class="linkform">You don't have an account? Register here</a>
					<div class="clear"></div>
				</div>
			</form>
		</div>
		<div class="clear"></div>
	</div>
	<a class="back" href="#">back to main page</a>
</div>


<!-- The JavaScript -->
<script language="javascript" type="text/javascript"
	src="js/jquery.min.js"></script>
<script type="text/javascript">
			$(function() {
					//the form wrapper (includes all forms)
				var $form_wrapper	= $('#form_wrapper'),
					//the current form is the one with class active
					$currentForm	= $form_wrapper.children('form.active'),
					//the change form links
					$linkform		= $form_wrapper.find('.linkform');
						
				//get width and height of each form and store them for later						
				$form_wrapper.children('form').each(function(i){
					var $theForm	= $(this);
					//solve the inline display none problem when using fadeIn fadeOut
					if(!$theForm.hasClass('active'))
						$theForm.hide();
					$theForm.data({
						width	: $theForm.width(),
						height	: $theForm.height()
					});
				});
				
				//set width and height of wrapper (same of current form)
				setWrapperWidth();
				
				/*
				clicking a link (change form event) in the form
				makes the current form hide.
				The wrapper animates its width and height to the 
				width and height of the new current form.
				After the animation, the new form is shown
				*/
				$linkform.bind('click',function(e){
					var $link	= $(this);
					var target	= $link.attr('rel');
					$currentForm.fadeOut(400,function(){
						//remove class active from current form
						$currentForm.removeClass('active');
						//new current form
						$currentForm= $form_wrapper.children('form.'+target);
						//animate the wrapper
						$form_wrapper.stop()
									 .animate({
										width	: $currentForm.data('width') + 'px',
										height	: $currentForm.data('height') + 'px'
									 },500,function(){
										//new form gets class active
										$currentForm.addClass('active');
										//show the new form
										$currentForm.fadeIn(400);
									 });
					});
					e.preventDefault();
				});
				
				function setWrapperWidth(){
					$form_wrapper.css({
						width	: $currentForm.data('width') + 'px',
						height	: $currentForm.data('height') + 'px'
					});
				}
				
				/*
				for the demo we disabled the submit buttons
				if you submit the form, you need to check the 
				which form was submited, and give the class active 
				to the form you want to show
				*/
				$form_wrapper.find('input[type="submit"]')
							 .click(function(e){
								e.preventDefault();
							 });	
			});
        </script>
</body>
</html>
