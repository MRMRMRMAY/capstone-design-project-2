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

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">★종합설계프로젝트2 APPLUS★ </a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" >
				<ul class="navbar-nav ml-auto" >
					<li class="nav-item"><a class="nav-link-mei" href="login.jsp"
						id="btn_login">Log in</a></li>
					<li class="nav-item"><a class="nav-link-mei" href="Account.jsp"
						id="btn_accountInfo"></a></li>
					<li class="nav-item"><a class="nav-link-mei" href="#"
						id="btn_logout">Log out</a></li> 
					<!-- <li class="nav-item"><a class="nav-link" href="accountSignin.jsp"
						id="btn_signin">Sign in</a></li>
					 -->
				</ul>
			</div>
		</div>
	</nav>
	<div class="search-wrapper">
		<form class="bs-example bs-example-form" role="form">
			<div class="row">
				<div class="col-lg-6">
				<div class="input-group">
					<select class="selectpicker">
  <option>Mustard</option>
  <option>Ketchup</option>
  <option>Relish</option>
</select>
					<input type="text" class="form-control">
				</div><!-- /input-group -->
			</div><!-- /.col-lg-6 --><br>
		<a>asd</a>
	</div>
	</form>
	</div>
<script>
$(function(){
	if(checkCookie()){
		document.getElementById("btn_login").style.display="none";
		document.getElementById("btn_accountInfo").style.display="block";
		$("#btn_logout").show();
		document.getElementById("btn_accountInfo").innerHTML = getCookie('username');
	}
	else{
		$("#btn_login").show(100);
		$("#btn_accountInfo").hide(100);
		$("#btn_logout").hide();
	}
});
</script>
</body>
</html>	