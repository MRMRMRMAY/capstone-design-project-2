package snippet;

public class Snippet {
	function checkstr(str,digit){ 
	var n=0;
	for(i=0;i<str.length;i++){
	var leg=str.charCodeAt(i);	//?���ݬ��������ݬ��Unicode??
	if(leg>255){
	n+=2;
	}else {
	n+=1;
	}
	}
	if (n>digit){
	return true;
	}else {
	return false;
	} 
	}
}

