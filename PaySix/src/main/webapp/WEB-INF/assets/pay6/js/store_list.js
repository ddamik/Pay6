var s_category = "";
var s_province = "";
var all = "all";

var tmp = document.location.search.split("=");
var sid = tmp[1].split("&");

$(document).ready(function(){

	$.ajax({
		url: '/market/get_market_province?sid=' + sid
	}).done(function(data) {
		$("#market_name").text("◀ " + data.sname);
		s_province = data.s_province;
		
		$("#market_name").click(function(){
			location.href = "/page/market_list";
		});
		s_category = all;
		update_list(s_category);
		console.log(s_province);
		console.log(sid);
	});
	

	
});

function update_list(obj){
	
	s_category = obj;
	$("#one").empty();
	
	$.ajax({
		url: '/market/store_list_category?s_province=' + s_province + '&s_category=' + s_category + '&sid=' + sid
	}).done(function(data){
		if( data == null ){
			alert("등록된 상점이 없습니다.");
		}else{
			$.each(data, function(index, store){			

				var url = "../images/storeinfo/" + store.sid + ".jpg";
				console.log(url);
				var str = "<article>"
							+ "<span class='image'>"
								+ "<img src='" + url + "' alt=''/>"
							+ "</span>"
							+ "<header class='major'>"
								+ "<h3>"
									+ "<a onclick='product_list(" + store.sid + ");' class='link cursor'>" + store.sname + "</a>"
								+ "</h3>"
								+ "<p><span class='store-name'></span>&nbsp;&nbsp;현재 위치로부터 00m</p>"
								
							+ "</header>"
						+ "</article>";
				$("#one").append(str);
				
				var $tiles = $('.tiles > article');
				$tiles.each(function() {

					// <span><img>를 사용한다.
					var $this = $(this),
						$image = $this.find('.image'), $img = $image.find('img'),
						$link = $this.find('.link'), x;

						// Set image.
						$this.css('background-image', 'url(' + $img.attr('src') + ')');

						// Set position.
						if (x = $img.data('position')) $image.css('background-position', x);

						// Hide original.
						$image.hide();
				});	// tiles				
			});
		}
	});
}

function product_list(ssid){
	location.href="/page/product_list?sid=" + ssid + "&mid=" + sid;
}