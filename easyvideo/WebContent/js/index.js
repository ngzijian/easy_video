/*
        javascript权威指南
        javascript高级编程
 */

$.ajax({
	type : "get",
	async : false,
	cache : false,
	url : "video.html?method=listVideosByCid",
	dataType : "json",
	success : function(data) {
		var cates = data.data;
		console.info(cates);
		var cv = document.getElementById('cate-video');
		for(var i=0;i<cates.length;i++){
			cv.innerHTML+='<div class="col-md-12"><h2 class="cate-name">'+cates[i].cateName+'</h2></div>';
			for(var j=0;j<cates[i].videos.length;j++){
				cv.innerHTML+='<div class="col-md-6">'
					+ '					<div class="thumbnail">'
					+ '						<a href="video.html?method=watch&video='
					+ cates[i].videos[j].videoId
					+ '" target="_blank"> <img class="video_pic"'
					+ '							src="'
					+ cates[i].videos[j].videoPic
					+ '"'
					+ '							alt="'
					+ cates[i].videos[j].videoName
					+ '">'
					+ '						</a>'
					+ '						<div class="caption">'
					+ '							<p>'
					+ '								<a  href="video.html?method=watch&video='
					+ cates[i].videos[j].videoId
					+ '" class="btn btn-default" role="button">'
					+ '									<span class="user-pic"><img class="icons-img"'
					+ '										src="'
					+ cates[i].videos[j].user.userPic
					+ '" /></span> <span>'
					+ cates[i].videos[j].user.userNickname
					+ '</span>'
					+ '								</a> <a href="javaScript:" onclick="fav('
					+ cates[i].videos[j].videoId
					+ ',this)" class="btn btn-default" role="button"><img'
					+ '									class="fav-img" src="imgs/fav.png" /><span>'
					+ cates[i].videos[j].videoFavcount
					+ '</span></a> <a'
					+ '									 href="video.html?method=watch&video='
					+ cates[i].videos[j].videoId
					+ '" target="_blank" class="btn btn-default" role="button"><img'
					+ '									class="fav-img" src="imgs/comm.png" /><span>'
					+ cates[i].videos[j].videoComms
					+ '</span></a>'
					+ '							</p>'
					+ '						</div>'
					+ '					</div>'
					+ '				</div>';
			}
		}
	},
	error : function(data) {
		alert("出错");
	}
});
/*
 * function watch(url) { var ii = '<iframe frameborder="0"
 * scrolling="no"id="fra1" class="fra1" src="' + url + '"></iframe>';
 * $('.video-preview').html(ii); }
 */
/*
 * function jh(cateId, cateName) {
 * 
 * $.ajax({ type : "get", async : false, cache : false, url :
 * "video?method=allVideosByCid&cateId=" + cateId, dataType : "json", success :
 * function(data) { data = data.data; // 遍历分类数组，将数据活之后在页面中显示 var html = ''; html = '<h2>' +
 * cateName + '</h2><div id="category-video" class="category-video"></div>';
 * document.getElementById('category').innerHTML = html; var html1 = ''; for
 * (var j = 0; j < data.length; j++) { html1 += '<div class="video-item">' + '
 * <div class="video-main">' + ' <a href="javaScript:watch(\'' +
 * data[j].videoPath + '\');">' + ' <img src="' + data[j].videoPic + '"
 * class="video-pic" alt="测试视频">' + ' </a>' + ' </div>' + ' ' + ' <div
 * class="video-info">' + ' <p class="item-autor">' + ' <a
 * href="javaScript:void(0);"><i class="icons icon-head"><img src="' +
 * data[j].user.userPic + '" width="100%" height="100%" alt=""></i><span
 * class="nickname">' + data[j].user.userNickname + '</span></a>' + ' </p>' + '
 * <p class="item-fav">' + ' <a href="javaScript:void(0);" onclick =
 * fav('+data[j].videoId+',this)><i class="icons icon-fav"></i>&nbsp' +
 * data[j].videoFavcount + '</a>' + ' </p>' + ' <p class="item-comm">' + ' <a
 * href="javaScript:void(0);"><i class="icons icon-comm"></i>&nbsp;' +
 * data[j].videoComms + '</a>' + ' </p>' + ' </div>' + ' </div>';
 * document.getElementById('category-video').innerHTML = html1; } }, error :
 * function(data) { alert("出错"); } }); }
 */
var lis = menu.getElementsByTagName('li');

lis[0].classList.add('active');
