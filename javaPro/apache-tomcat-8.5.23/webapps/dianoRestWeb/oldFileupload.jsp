<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="api/bootstrap-fileup/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.form.js"></script>
<script src="api/bootstrap-fileup/js/fileinput.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script>

</script>
</head>
<body>
	<div>
		<lable for="title">title</lable>
		<input type="text" class="form-control" id="title" placeholder="please enter your file's name">
	</div>
	<div class="form-group">
		<p>
			Select a file: <input id="fileup" type="file" multiple class="file-loading">
		</p>
	</div>
	<button type="submit" class="btn btn-default" onClick="doUpload()">submit</button>
	<!-- test part 1 -->
	<!--<div id="uploadForm">
    <input id="file" type="file"/>
    <button id="upload" type="button" onClick="test()">upload</button>
	</div>-->
</body>
<script>
/*test part 1
 * action : submit file
function test(){
var formData = new FormData();
formData.append('file', $('#file')[0].files[0]);
$.ajax({
    url: 'rest/fileup/music',
    type: 'POST',
    cache: false,
    data: formData,
    processData: false,
    contentType: false
}).done(function(res) {
}).fail(function(res) {});
}*/
function doUpload(){
	//var formData = new FormData($("uploadForm")[0]);
	var formData = new FormData();
	formData.append('file', $('#fileup')[0].files[0]);
	$.ajax({
		url:"rest/fileup/music",
		type:'POST',
		data:formData,
	    processData: false,
	    contentType: false,
		success:function(returndata){
			alert(returndata);
		},
		error:function(returndata){
			alert(returndata);
		}
	});
}
$("#fileup").fileinput({
	language:'en',
	uploadUrl:'#',
	//allowedFileExtentsions:['mp3','wav'],
	uploadAsync:true,
	showUpload:true,
	showRemove:true,
	showPreview:true,
	showCaption:false,
	browseClass:"btn btn-primary",
	dropZoneEnabled:true,
	maxFileSize:20000,
	maxFileCount:1,
	enctype:'multipart/form-data',
	validateInitialCount:true,
	previewFileIcon:"<iclass='glyphccon glyphicon-king'></i>",
	msgFilesTooMany:"The number of files seleted is more than max!",
}).on("fileuploaded",function(event,data,previewId,index){
	
});
</script>
</html>