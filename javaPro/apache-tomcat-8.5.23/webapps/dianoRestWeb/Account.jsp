<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script language="javascript" type="text/javascript"
	src="js/jquery.min.js"></script>
<script language="javascript" type="text/javascript"
	src="js/jquery.form.js"></script>
<link rel="stylesheet"
	href="css/table/bootstrap/bootstrap-table.css">
	
<link href="api/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="css/font-awesome.css" rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<link href="css/index-landing-page.css" rel="stylesheet">

<script src="js/table/bootstrap/bootstrap-table.js"></script>
<script src="js/table/bootstrap/bootstrap-table-en-US.min.js"></script>

<link href="css/index-landing-page.css" rel="stylesheet">

<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script language="javascript" src="js/comman.js" type="text/javascript"></script>
<script src="api/bootstrap/js/bootstrap.bundle.js"></script>
<script language="javascript" type="text/javascript"
	src="js/table/mysongTable.js"></script>
<style>
	.panel{width:60%;margin:0 auto;text-align: center;}
	.form-inline{width:60%;margin:0 auto;}
</style>
<style>
.nav-link-mei{color:#868e96;}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" >
		<div class="container">
			<a class="navbar-brand" href="#">★Music Repository★ </a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" >
				<ul class="navbar-nav ml-auto" >
					<li class="nav-item"><a class="nav-link-mei" href="main.jsp"
						id="btn_main">Main</a></li>
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
<div class="panel">

	<table id="tableID" data-show-columns="true" data-sort-order="desc"
		data-single-select="true" data-toolbar=".toolbar">
	</table>
	</div>
</body>
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
function logout(){
	delCookie("username")
	top.location = "main.jsp";
	return false;
}
</script>

</html>