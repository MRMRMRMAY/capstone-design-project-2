function getQueryString(key){
	var reg = new RegExp("(^|&)"+key+"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)
		return unescape(r[2]);
	return null;
}
//$(document).ready(function(){
//	var arg1 = getQueryString("arg1");
//	alert("param is "+arg1);
//	$.ajax({
//		type:"GET",
//		url:"rest/player/music",
//		data:arg1,
//		success:function(){
//			$('audio').audioPlayer({
//				classPrefix:"audioplayer",
//				strPlay:'Play',
//				strPause:'pause',
//				strVolumn:'Volume'
//			});
//		},
//		error:function(){
//			
//		}
//	});
//});