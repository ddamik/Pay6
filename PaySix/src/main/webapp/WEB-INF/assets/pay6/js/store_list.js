var category = "";
var west = "west";
var korean = "korean";
var chinese = "chinese";
var all = "all";

$(document).ready(function(){

	category = all;
	update_list(category);
	
});

function update_list(obj){
	
	category = obj;
	$("#one").empty();
	
	$.ajax({
		url: '/store/list?category=' + category
	}).done(function(data){
		if( data == null ){
			alert("등록된 상점이 없습니다.");
		}else{
			$.each(data, function(index, store){			

				var url = "../images/productinfo/" + store.etc1 + ".jpg";
				console.log(url);
				var str = "<article>"
							+ "<span class='image'>"
								+ "<img src='" + url + "' alt=''/>"
							+ "</span>"
							+ "<header class='major'>"
								+ "<h3>"
									+ "<a onclick='product_list(" + store.sid + ");' class='link cursor'>" + store.etc2 + "</a>"
								+ "</h3>"
								+ "<p><span class='store-name'>" + store.sname + "</span>&nbsp;&nbsp;현재 위치로부터 00m</p>"
								
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
	location.href="/page/product_list?sid=" + sid;
}