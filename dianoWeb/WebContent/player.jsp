<%@ page language="java" import="java.util.*" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="css/player/index.css" media="screen">
<script language="javascript" type="text/javascript"
	src="js/jquery.min.js"></script>
<script language="javascript" type="text/javascript"
	src="js/jquery.form.js"></script>
<script src="js/player/player.js"></script>
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	//alert('${param.arg1}');
</script>
<audio src="${param.arg1}" preload="auto" controls>Your browser does not support the audio tag.</audio>
</body>
</html>