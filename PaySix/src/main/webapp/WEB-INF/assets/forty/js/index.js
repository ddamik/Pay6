$(document).ready(function(){
	$.ajax({
		url: '/store/list'
	}).done(function(data){
		if( data == null ){
			alert("등록된 상점이 없습니다.");
		}else{
			$.each(data, function(index, store){
				
				var url = "../images/storeinfo/" + store.sid + ".jpg";				
				var str = "<article>"
						+ "<span class='image' style='display: none;'>"
							+ "<img src='" + url + "' alt>"
						+ "</span>"
						+ "<header class='major'>"
							+ "<h3>"
							+ "<button onclick='product_list(" + store.sid + ");' class='link'>" + store.sname + "</button>"
							+ "</h3>"
						+ "<p>" + store.saddr + "</p>"
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
});

function product_list(sid){
	location.href="/page/product_list?sid=" + sid;
}