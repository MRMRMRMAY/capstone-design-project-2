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
<script language="javascript" src="js/jquery.min.js" type="text/javascript" ></script>
<script language="javascript" src="js/jquery.form.js" type="text/javascript" ></script>
<script language="javascript" src="js/comman.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript"
	src="js/login/event.js"></script>
<script type="text/javascript">

</script>
</head>
<div class="wrapper">
	<h1>DIANO</h1>
	<h2>
		Welcome to <span>DIANO</span>
	</h2>
	<div class="content">
		<div id="form_wrapper" class="form_wrapper">
			<form class="register", id="register_body">
				<h3>Register</h3>
				<div class="column">
					<div>
						<label>First Name:</label>
						<input type="text" placeholder="First Name" id='reg_fn' onblur="checkfn()"/> <span class="error" id="reg_fnerror"></span>
					</div>
					<div>
						<label>Last Name:</label>
						<input type="text" placeholder="Last Name" id='reg_ln' onblur="checkln()"/> <span class="error" id="reg_lnerror"></span>
					</div>
					<div>
						<label>Email:</label>
						<input type="text" placeholder="Email" id='reg_email' onblur="checkEmail()"/> <span class="error" id="reg_emailerror"></span>
					</div>
					<!--</div>
						<div class="column">-->
					<div>
						<label>Username:</label>
						<input type="text" placeholder="Username" id='reg_usn' onblur="checkUser()"/> 
						<span class="error" id="reg_usnerror"></span>
					</div>
					<div>
						<label>Password:</label>
						<input type="password" placeholder="Password" id='reg_pw' onblur="checkPwd()"/> <span class="error" id="reg_pwerror"></span>
					</div>
					<div>
						<!--<label>Re-enter password:</label>
								<input type="text" value="http://"/>
								<span class="error">This is an error</span>-->
						<label>Re-enter password:</label>
						<input type="password" placeholder="Re-enter password" id='reg_pwcf' onblur="checkpwd_cf()"/> <span
							class="error" id="reg_pwcferror"></span>
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
						class="error"></span>
				</div>
				<div>
					<label>Password: <a href="forgot_password.jsp"
						rel="forgot_password" class="forgot linkform">Forgot your
							password?</a></label> <input type="password" id="pwInput" /> <span
						class="error"></span>
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
						class="error"></span>
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
			<script type="text/javascript">
				function register(){
					
				}
				function checkstr(str,digit){
					var n = 0;
					for(i = 0; i < str.length; i++){
						var leg = str.charCodeAt(i);
						if(leg > 255){
							n += 2;
						}else{
							n += 1;
						}
					}
					if(n > digit){
						return true;
					}else{
						return false;
					}
				}
				//check repeat
				function checkpwd_cf(){
					var pwd_cfError = document.getElementById("reg_pwcferror");
					var pwd = $('#reg_pw').val();
					var pwd_cf = $('#reg_pwcf').val();
					if(pwd!=pwd_cf){
						pwd_cfError.innerHTML="The passwords you entered do not match.";
					}else{
						pwd_cfError.innerHTML="";
					}
					//The passwords you entered do not match.
				}
				function checkUser(){
					//Username entered already in use. Please choose a different name.
					var user = $('#reg_usn').val();
					var userError = document.getElementById("reg_usnerror");
					if(user.length >= 4 && user.length <= 16){
						userError.innerHTML = ""
						return false;
					}else{
						userError.innerHTML = ""
						userError.innerHTML = "the length: 4 - 16"
						return true;
					}
				}
				function checkPwd(){
					var Expression = /^[A-Za-z]{1}([A-Za-z0-9]|[._]){5,29}$/;
					var objExp = new RegExp(Expression); //Create exp obj
					var pwdError = document.getElementById("reg_pwerror");
					var pwd = $('#reg_pw').val();
					if(pwd.length<6||pwd.length>16){
						pwdError.innerHTML="";
						pwdError.innerHTML="the langth of pw: 6 - 16!";
						return false;
					}
					else if(objExp.test(pwd) == false){//exp ok
						pwdError.innerHTML="";
						pwdError.innerHTML="your password cannot include /'// &*()";
						return false;
					}else{
						pwdError.innerHTML="";
						return true;
					}
				}
				function checkEmail(){
					var str = $('#reg_email');
					var emailError = document.getElementById("reg_emailerror");
					var error = "please entry the correct email address.";
					//exp starting by '/'
					
					var Expression=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
					var objExp=new RegExp(Expression);
					if(objExp.test(str)==true){
						emailError.innerHTML="";
						return true;
					}else{
						emailError.innerHTML="";
						emailError.innerHTML=error;
						return false;
					}
				}
				function checkfn(){
					var fnError = document.getElementById("reg_fnerror");
					var fn = $.trim($("#reg_fn").val());
					if(fn.length > 0){
						fnError.innerHTML="";
						return true;
					}else{
						fnError.innerHTML="";
						fnError.innerHTML="please entry your first name";
						return false;
					}
				}
				function checkln(){
					var lnError = document.getElementById("reg_lnerror");
					var ln = $.trim($("#reg_ln").val());
					if(ln.length > 0){
						lnError.innerHTML="";
						return true;
					}else{
						lnError.innerHTML="";
						lnError.innerHTML="please entry your last name";
						return false;
					}
				}
			</script>
</body>
</html>
