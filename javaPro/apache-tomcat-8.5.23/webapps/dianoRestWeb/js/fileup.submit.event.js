function submit(){
	var url = 'rest/fileup/music';
	var formData = new FormData();
	var username = getCookie('username');
	var songname = $("#songnameInput").val();
	var file = $('#file-1')[0].files[0];
//	alert(songname);
//	return false;
	if(username == null || username == ""){
		alert('please login');
		return false;
	}
	if(songname == null || songname == ""){
		alert('please entry the song name.');
		return false;
	}
	if(file == undefined){
		alert('please select at last a file');
		return false;
	}
	formData.append('file',file);
	formData.append('username',getCookie('username'));
	formData.append('songname',songname);
	$.ajax({
		type:'POST',
		url: url,
		data:formData,
		processData:false,
		contentType:false,
		success:function(response){
			//reset();
			alert(response.responseText);
			window.close();
			//var jumpUrl="window.location='fileupMessage.html?result=success'";
			//window.setTimeout(jumpUrl,500);
		},
		error:function(response){
			alert(response);
		}
	});
}
function reset(){
	//var obj = document.getElementById('file-1');
	//obj.attr("value","");
}