var type = document.getElementById('type').value;
var page = 1;

$
		.ajax({
			type : 'get',
			dataType : 'json',
			url : 'video.html?method=allVideosByCid',
			data : {
				'type' : type,
				'page' : page
			},

			async : false,
			cache : false,
			success : function(data) {
				/*console.info(data);*/
				var html = '';
				for (var i = 0; i < data.data.list.length; i++) {
					html += '<div class="col-md-6">'
							+ '					<div class="thumbnail">'
							+ '						<a href="video.html?method=watch&video='
							+ data.data.list[i].videoId
							+ '" target="_blank"> <img class="video_pic"'
							+ '							src="'
							+ data.data.list[i].videoPic
							+ '"'
							+ '							alt="'
							+ data.data.list[i].videoName
							+ '">'
							+ '						</a>'
							+ '						<div class="caption">'
							+ '							<p>'
							+ '								<a  href="video.html?method=watch&video='
							+ data.data.list[i].videoId
							+ '" class="btn btn-default" role="button">'
							+ '									<span class="user-pic"><img class="icons-img"'
							+ '										src="'
							+ data.data.list[i].user.userPic
							+ '" /></span> <span>'
							+ data.data.list[i].user.userNickname
							+ '</span>'
							+ '								</a> <a href="javaScript:" onclick="fav('
							+ data.data.list[i].videoId
							+ ',this)" class="btn btn-default" role="button"><img'
							+ '									class="fav-img" src="imgs/fav.png" /><span>'
							+ data.data.list[i].videoFavcount
							+ '</span></a> <a'
							+ '									 href="video.html?method=watch&video='
							+ data.data.list[i].videoId
							+ '" target="_blank" class="btn btn-default" role="button"><img'
							+ '									class="fav-img" src="imgs/comm.png" /><span>'
							+ data.data.list[i].videoComms
							+ '</span></a>'
							+ '							</p>'
							+ '						</div>'
							+ '					</div>'
							+ '				</div>';
				}
				document.getElementById('videos').innerHTML += html;
				if (html != '') {
					document.getElementById('videos').innerHTML += '<h2 onclick = "next(this)">显示更多</h2>'
				}
			},
			error : function(data) {
				alert(data.msg);
			}
		});
function next(obj) {
	obj.style.display = 'none';
	page = page + 1;
	$
			.ajax({
				type : 'get',
				dataType : 'json',
				url : 'video.html?method=allVideosByCid',
				data : {
					'type' : type,
					'page' : page
				},

				async : false,
				cache : false,
				success : function(data) {
					var html = '';
					for (var i = 0; i < data.data.list.length; i++) {
						html += '<div class="col-md-6">'
								+ '					<div class="thumbnail">'
								+ '						<a href="video.html?method=watch&video='
								+ data.data.list[i].videoId
								+ '" target="_blank"> <img class="video_pic"'
								+ '							src="'
								+ data.data.list[i].videoPic
								+ '"'
								+ '							alt="'
								+ data.data.list[i].videoName
								+ '">'
								+ '						</a>'
								+ '						<div class="caption">'
								+ '							<p>'
								+ '								<a  href="video.html?method=watch&video='
								+ data.data.list[i].videoId
								+ '" class="btn btn-default" role="button">'
								+ '									<span class="user-pic"><img class="icons-img"'
								+ '										src="'
								+ data.data.list[i].user.userPic
								+ '" /></span> <span>'
								+ data.data.list[i].user.userNickname
								+ '</span>'
								+ '								</a> <a href="javaScript:" onclick="fav('
								+ data.data.list[i].videoId
								+ ',this)" class="btn btn-default" role="button"><img'
								+ '									class="fav-img" src="imgs/fav.png" /><span>'
								+ data.data.list[i].videoFavcount
								+ '</span></a> <a'
								+ '									 href="video.html?method=watch&video='
								+ data.data.list[i].videoId
								+ '" target="_blank" class="btn btn-default" role="button"><img'
								+ '									class="fav-img" src="imgs/comm.png" /><span>'
								+ data.data.list[i].videoComms
								+ '</span></a>'
								+ '							</p>'
								+ '						</div>'
								+ '					</div>' + '				</div>';
					}
					document.getElementById('videos').innerHTML += html;
					if (html == '') {
						document.getElementById('videos').innerHTML += '<h2 onclick = "next(this)">已全部显示</h2>'
						return false;
					}
					document.getElementById('videos').innerHTML += '<h2 onclick = "next(this)">显示更多</h2>'
				},
				error : function(data) {
					alert(data.msg);
				}
			});

}
function fav(videoId, obj) {

	$.ajax({
		type : 'get',
		dataType : 'json',
		url : 'video.html?method=fav',
		data : {
			'videoId' : videoId
		},
		cache : false,
		async : false,
		success : function(data) {

			if (data.success) {
				var html = '<img'
						+ ' class="fav-img" src="imgs/fav-active.png" /><span>'
						+ data.data.videoFavcount + '</span>';
				obj.innerHTML = html;
			} else {
				alert(data.msg);
			}
			/*
			 * if (data.success) { console.info(data.data.videoFavcount); var i = '<i
			 * class="icons icon-fav"></i>&nbsp;' + data.data.videoFavcount;
			 * obj.innerHTML = i; obj.firstChild.style.backgroundImage =
			 * 'url(imgs/fav-active.png)'; } else { alert(data.msg); }
			 */
		},
		error : function() {
			alert('出错');
		}
	});
}

var type = document.getElementById('type').value;
var menu = document.getElementById('menu');
var lis = menu.getElementsByTagName('li');

for (var i = 0; i < lis.length; i++) {
	if (type == lis[i].value) {
		lis[i].classList.add('active');
	}
}