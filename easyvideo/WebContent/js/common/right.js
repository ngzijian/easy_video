$.ajax({
	url : 'video.html?method=rank',
	data : {},
	dataType : 'json',
	type : 'get',
	cache : false,
	async : false,
	success : function(data) {
		if(data.success == true){
			var html = '';
			for (var i = 0; i < data.data.length; i++) {
				html += '<div class="col-md-12"><h3>top'+(i+1)+'</h3></div>'
						+ '<div class="col-md-12">'
						+ '					<div class="thumbnail ranking">'
						+ '						<a href="video.html?method=watch&video='
						+ data.data[i].videoId
						+ '" target="_blank"> <img class="video_pic"'
						+ '							src="'
						+ data.data[i].videoPic
						+ '"'
						+ '							alt="'
						+ data.data[i].videoName
						+ '">'
						+ '						</a>'
						+ '						<div class="caption">'
						+ '							<p>'
						+ '								<a  href="video.html?method=watch&video='
						+ data.data[i].videoId
						+ '" class="btn btn-default" role="button">'
						+ '									<span class="user-pic"><img class="icons-img"'
						+ '										src="'
						+ data.data[i].user.userPic
						+ '" /></span> <span>'
						+ data.data[i].user.userNickname
						+ '</span>'
						+ '								</a> <a href="javaScript:" onclick="fav('
						+ data.data[i].videoId
						+ ',this)" class="btn btn-default" role="button"><img'
						+ '									class="fav-img" src="imgs/fav.png" /><span>'
						+ data.data[i].videoFavcount
						+ '</span></a> <a'
						+ '									 href="video.html?method=watch&video='
						+ data.data[i].videoId
						+ '" target="_blank" class="btn btn-default" role="button"><img'
						+ '									class="fav-img" src="imgs/comm.png" /><span>'
						+ data.data[i].videoComms
						+ '</span></a>'
						+ '							</p>'
						+ '						</div>'
						+ '					</div>'
						+ '				</div>';
			}
			document.getElementById('right').innerHTML += html;
			
		}else{
			document.getElementById('right').innerHTML += '<h4>暂无更新</h4>';
		}
	},
	error : function() {
		alert('出错');
	}
});