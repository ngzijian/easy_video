$
		.ajax({
			type : "get",
			async : false,
			cache : false,
			url : "category.html?method=findAll",
			dataType : "json",
			success : function(data) {
				var categorys = data.data;
				// 遍历分类数组，将数据活之后在页面中显示
				var html = '';
				for (var i = 0; i < categorys.length; i++) {
					html += '<li role="presentation" value="'+categorys[i].cateId+'"><a href="category.html?method=square&type='
							+ categorys[i].cateId
							+ '">'
							+ categorys[i].cateName + '</a></li>';
				}
				// 将生成的html加入到指定的区域显示
				document.getElementById('menu').innerHTML += html;
			},
			error : function(data) {
				alert("出错");
			}
		});
function login() {
	$.ajax({
		type : 'post',
		url : 'user.html?method=login',
		data : $('#login').serialize(),
		dataType : 'json',
		async : false,
		cache : false,
		success : function(data) {
			if (data.success) {
				location.reload();
			} else {
				alert(data.msg);
			}
		},
		error : function(data) {
			alert('出错');
		}
	});
}
function uploadVideo() {
	location.href='video.html?method=uploadVideo';
}