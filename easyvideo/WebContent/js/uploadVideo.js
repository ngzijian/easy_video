$.ajax({
	type : 'get',
	url : 'category.html?method=findAll',
	data : {},
	dataType : 'json',
	cache : false,
	async : false,
	success : function(data) {
		if (data.success) {

			var html = '';
			for (var i = 0; i < data.data.length; i++) {
				html += '<option value="' + data.data[i].cateId + '">'
						+ data.data[i].cateName + '</option>';
			}
			
			document.getElementById('category').innerHTML = html;
		} else {
			alert(data.msg);
		}
	},
	error : function() {
		alert('出错')

	}
});
var _finish = false;
function showStatus() {
	_finish = false;
	document.getElementById('videoForm').submit();
	document.getElementById('up-btn').disabled=true;
	var pro = document.getElementById('progress');
	pro.style.display = 'block';
	var proBar = document.getElementById('progress-bar');
	proBar.style.width='1%';
	createRequest();
} 

function createRequest() {
	if(_finish == true){
		
		document.getElementById('up-btn').disabled=false;
		document.getElementById('progress-info').innerHTML = '上传已完成。';
		return false;
	}
	$.ajax({
		type : 'get',
		url : 'user.html?method=listenUpVideo',
		data : {},
		dataType : 'json',
		cache : false,
		async : false,
		success : function(data) {
			var proBar = document.getElementById('progress-bar');
			var ss = data.split('||');
			proBar.style.width=''+ss[0]+'%';
			if(ss[1]==ss[2]){
				_finish = true;
			}
			setTimeout(createRequest(),200);

		},
		error : function() {
			alert('出错');
		}
	});
}