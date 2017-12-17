function getQueryString(key){
	var reg = new RegExp("(^|&)"+key+"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)
		return unescape(r[2]);
	return null;
}
function setcookie(name, value, daysToLive){
	var exdate = new Date();
	exdate.setDate(exdate.getDate()+daysToLive);
	document.cookie = name+"="+escape(value)+
	((daysToLive == null)?"":";expires=" + exdate.toGMTString());
}
function getCookie(name){
	if(document.cookie.length>0){
		c_start = document.cookie.indexOf(name + "=");
		if(c_start!=-1){
			c_start = c_start+ name.length +1;
			c_end = document.cookie.indexOf(";",c_start);
			if(c_end == -1)
				c_end = document.cookie.length;
			return unescape(document.cookie.substring(c_start,c_end));
		}
	}
	return "";
}
function checkCookie(){
	username = getCookie('username');
	if(username != null && username != ""){
		//have found cookie
		//alert('Welcome to DIANO, '+username+'!');
		return true
	}
	else{
		//haven't found cookie
		return false
	}
}
function delCookie(key) {
    var date = new Date();
    date.setTime(date.getTime() - 1);
    var delValue = getCookie(key);
    if (!!delValue) {
        document.cookie = key+'='+delValue+';expires='+date.toGMTString();
    }
}
function onUploadBtn(){
	window.open("fileup.html","fileup","height=500,width=800,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no")
}