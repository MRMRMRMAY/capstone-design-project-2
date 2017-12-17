<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<title>Insert title here</title>
<link href="api/bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="css/font-awesome.css" rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="css/index-landing-page.css" rel="stylesheet">
<link href="css/mainpage.css" rel="stylesheet" type="text/css">
<link href="css/searchbar.css" rel="stylesheet" type="text/css">

<script language="javascript" src="js/jquery.min.js" type="text/javascript"></script>
<script language="javascript" src="js/jquery.form.js" type="text/javascript"></script>
<script language="javascript" src="js/comman.js" type="text/javascript"></script>
<script src="api/bootstrap/js/bootstrap.bundle.js"></script>
<!-- js -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<style>
.nav-link-mei{color:#868e96;}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" >
		<div class="container">
			<a class="navbar-brand" href="#">�����ռ���������Ʈ2 APPLUS�� </a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" >
				<ul class="navbar-nav ml-auto" >
					<li class="nav-item"><a class="nav-link-mei" href="index.html"
						id="btn_aboutus">About us</a></li>
					<li class="nav-item"><a class="nav-link-mei" href="login.jsp"
						id="btn_login">Log in</a></li>
					<li class="nav-item"><a class="nav-link-mei" href="Account.jsp"
						id="btn_accountInfo"></a></li>
					<li class="nav-item"><a class="nav-link-mei" href="javascript:;" onclick="onUploadBtn()"
						id="btn_fileup">upload</a></li> 
					<li class="nav-item"><a class="nav-link-mei" href="javascript:;" onclick="logout()"
						id="btn_logout">Log out</a></li> 
					<!-- <li class="nav-item"><a class="nav-link" href="accountSignin.jsp"
						id="btn_signin">Sign in</a></li>
					 -->
				</ul>
			</div>
		</div>
	</nav>
	<div class="search-wrapper">
	<div id="search" class="cd-main-search">
		<form onsubmit="submitFn(this, event);">
			<div class="search-wrapper">
				<div class="input-holder">
					<input type="text" class="search-input" placeholder="Type to search" />
					<button class="search-icon" onclick="searchToggle(this, event);"><span></span></button>
			</div>
			<span class="close" onclick="searchToggle(this, event);"></span>
			<div class="result-container">

			</div>
		</div>
	</form>
		<a>asd</a>
	</div>
</div>
<script>
$(function(){
	if(checkCookie()){
		document.getElementById("btn_login").style.display="none";
		document.getElementById("btn_accountInfo").style.display="block";
		$("#btn_logout").show();
		$("#btn_fileup").show();
		document.getElementById("btn_accountInfo").innerHTML = getCookie('username');
	}
	else{
		$("#btn_login").show(100);
		$("#btn_accountInfo").hide(100);
		$("#btn_logout").hide();
		$("#btn_fileup").hide();
	}
});
</script>
<script type="text/javascript">
	function searchToggle(obj, evt){
		var container = $(obj).closest('.search-wrapper');

		if(!container.hasClass('active')){
			  container.addClass('active');
			  evt.preventDefault();
		}
		else if(container.hasClass('active') && $(obj).closest('.input-holder').length == 0){
			  container.removeClass('active');
			  // clear input
			  container.find('.search-input').val('');
			  // clear and hide result container when we press close
			  container.find('.result-container').fadeOut(100, function(){$(this).empty();});
		}
	}

	function submitFn(obj, evt){
		value = $(obj).find('.search-input').val().trim();

		_html = "Yup yup! Your search text sounds like this: ";
		if(!value.length){
			_html = "Yup yup! Add some text friend :D";
		}
		else{
			_html += "<b>" + value + "</b>";
			var url = "tabletest.jsp?keyword="+ value;
			window.location.href=url;
		}

		$(obj).find('.result-container').html('<span>' + _html + '</span>');
		$(obj).find('.result-container').fadeIn(100);

		evt.preventDefault();
	}
	
	function logout(){
		delCookie("username");
		top.location = "main.jsp";
		return false;
	}
</script>
</body>
</html>	