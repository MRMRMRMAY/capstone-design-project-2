$(document).ready(function(){
//	var data;
//	$(function(){
//		var columns = [];
//		$.ajax({
//			type:"POST",
//			url:"/htmlGuiSimple/rest/test/data",
//			dataType:"json",
//			contentType: 'application/json',
//			async:false,
//			success:function(response){
//				var arr = JSON.stringify(response.data);
//				alert("return from server:\n\n" + arr);
//				data = response.data
////				$.each(arr.data,function(i, item){
////					columns.push();
////					
////				});
//				
//				
//			},
//			error:function(){
//				alert("error");
//			}
//		});
//	});

	$("#tableID").bootstrapTable({
		method:'GET',
		striped:true,
		cache:false,
		pagination:true,
		sortable:true,
		pageSize:10,
		pageList:[10,20,30],
		url:"rest/test/data",
		sidePagination:"client",
		singleSelect:false,
		search:true,
		columns:[{
			field:'song_title',
			title:'title'},{
			field:'song_uper',
			title:'up'							
		},{
			field:'song_len',
			title:'length',
			sortable:'true'
		},{
			field:'song_up_date',
			title:'up date',
			sortable:'true'
		},{
			field:'song_click_num',
			title:'click',
			sortable:'true'
		},{
			field:"song_id",
			title:"option",
			formatter:function(value,row,index){
				var fd = '<a href="#" mce_href="#" onclick="file_download(\''+row.song_id+'\')">download</a> ';
				var p = '<a href="#" mce_href="#" onclick="file_player(\''+row.song_id+'\')">play</a>';
				return fd + p;
			}
		}],
		pagination:true
	});
});
function file_download(song_id){
	var url = 'http://localhost:1122/htmlGuiSimple/rest/download/piano/'+'test.mp3';
	alert(url);
	window.open(url);
};
function file_player(song_id){
	var param = 'http://localhost:1122/htmlGuiSimple/rest/download/piano/'+'test.mp3';
	var url = 'player.jsp?arg1='+ param;
	window.open(url);
};