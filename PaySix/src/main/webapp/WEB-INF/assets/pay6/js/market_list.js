var province = "";
var seoul = "seoul";
var daegu = "daegu";
var jeju = "jeju";
var all = "all";

$(document).ready(function(){

	province = all;
	update_list(province);
	
});

function update_list(obj){
	
	province = obj;
	$("#one").empty();
	
	$.ajax({
		url: '/market/list_province?s_province=' + province
	}).done(function(data){
		if( data == null ){
			alert("등록된 재래시장이 없습니다.");
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

function product_list(sid){
	location.href="/page/store_list?sid=" + sid;
}