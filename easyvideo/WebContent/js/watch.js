var page = 1;
var pid = 0;
comms(0)
function comms(option) {
	page = page + option;

	if (page < 1) {
		page = page + 1;
		return false;
	}
	$
			.ajax({
				url : 'comm.html?method=getCommsByPage',
				data : {
					'page' : page,
					'videoId' : videoId
				},
				dataType : 'json',
				type : 'get',
				success : function(data) {
					list = data.data.list;
					/*console.info(list);*/
					if (list.length == 0) {
						page = page - 1;
						return false;
					}
					var html = '';
					for (var i = 0; i < list.length; i++) {
						var to = '';
						if (list[i].pid != 0) {
							to = '<div class="col-md-12 reply">回复@</div><div class="col-md-12 reply1">'
									+ list[i].cmv.user.userNickname + '</div>';
						}
						html += '<div class="col-md-12 div-comm">'
								+ '								<div class="col-md-3">'
								+ '									<div class="col-md-12">'
								+ '										<a href="" class="btn btn-default" role="button"><span'
								+ '											class="user-pic"><img class="icons-img"'
								+ '												src="'
								+ list[i].user.userPic
								+ '" /></span></a>'
								+ '									</div>'
								+ '									<div class="col-md-12">'
								+ '										<span>'
								+ list[i].user.userNickname
								+ '</span>'
								+ '									</div>'
								+ to
								+ '								</div>'
								+ '								<div class="col-md-6">'
								+ '									<div class="col-md-12"></div>'
								+ '									<div class="col-md-12">&nbsp;&nbsp;'
								+ list[i].commContent
								+ '</div>'
								+ '								</div>'
								+ '								<div class="col-md-3">'
								+ '<div class="col-md-12">'
								+ new Date(list[i].commPtime)
										.format('yyyy-MM-dd hh:mm')
								+ '</div>'
								+ '<div class="col-md-12"><h4 onclick="pwid('+list[i].commId+',\''+list[i].user.userNickname+'\')" class="reply">回复</h4></div>'
								+ '</div></div>';
					}
					document.getElementById('comm-info').innerHTML = html;

				},
				error : function() {
					alert('出错');
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
				if(data.code == -2){
					location.href='index.jsp';	
				}
				
			}

			/*
			 * if (data.success) { console.info(data.data.videoFavcount); var i = '<i
			 * class="icons icon-fav"></i>&nbsp;' + data.data.videoFavcount;
			 * obj.innerHTML = i; obj.firstChild.style.backgroundImage =
			 * 'url(imgs/fav-active.png)'; } else { alert(data.msg); }
			 */

		},
		error : function() {
			alert('出错！');
		}
	});
}
function sendinfo() {
	var videoinfo = document.getElementById('input-info').value;

	$
			.ajax({
				url : 'comm.html?method=comm',
				data : {
					'videoId' : videoId,
					'videoinfo' : videoinfo,
					'pid' : pid
				},
				dataType : 'json',
				type : 'post',
				success : function(data) {
					/*console.info(data);*/
					var comm = document.getElementById('comm').innerHTML;
					comm = parseInt(comm) + 1;
					document.getElementById('comm').innerHTML = comm;
					if (data.success == true) {
						var html = '';

						var info = document.getElementById('comm-info');
						var to = '';
						if (data.data.pid != 0) {
							to = '<div class="col-md-12 reply">回复@</div><div class="col-md-12 reply1">'
									+ data.data.cmv.user.userNickname + '</div>';
						}
						html += '<div class="col-md-3">'
								+ '									<div class="col-md-12">'
								+ '										<a href="" class="btn btn-default" role="button"><span'
								+ '											class="user-pic"><img class="icons-img"'
								+ '												src="'
								+ data.data.user.userPic
								+ '" /></span></a>'
								+ '									</div>'
								+ '									<div class="col-md-12">'
								+ '										<span>'
								+ data.data.user.userNickname
								+ '</span>'
								+ '									</div>'+to
								+ '								</div>'
								+ '								<div class="col-md-6">'
								+ '									<div class="col-md-12"></div>'
								+ '									<div class="col-md-12">&nbsp;&nbsp;'
								+ data.data.commContent
								+ '</div>'
								+ '								</div>'
								+ '								<div class="col-md-3">'
								+ '<div class="col-md-12">'
								+ new Date(data.data.commPtime)
										.format('yyyy-MM-dd hh:mm')
								+ '</div>'
								+ '<div class="col-md-12"><h4 onclick="pwid('+data.data.commId+',\''+data.data.user.userNickname+'\')" class="reply">回复</h4></div>'
								+ '</div></div>';
						var first = document.createElement('div');
						first.setAttribute('class', 'col-md-12 div-comm');
						first.innerHTML = html;
						info.insertBefore(first, info.firstChild);

					} else {
						alert(data.msg);
						if(data.code=-2){
							location.href='index.jsp';
						}
					}
				},
				error : function() {
					alert('出错！');
				}
			});
}
Date.prototype.format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
}
function pwid(d,n){
	pid = d;
	n='回复@'+n;
	document.getElementById('input-info').focus();
	document.getElementById('input-info').setAttribute('placeholder',n);
}