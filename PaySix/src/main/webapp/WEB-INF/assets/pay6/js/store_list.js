$(document).ready(function(){

	var store_category = "all";
	update_list(store_category);
	
});

function update_list(store_category){
		
	$("#store_list").empty();
	
	var dataForm = "";
	dataForm += "store_category=" + store_category
	$.ajax({
		url: '/store/list',
		type: 'get',
		data:{
			'store_category': store_category
		}			
	}).done(function(data){
		console.log(data);
		if( data == null ){
			alert("등록된 상점이 없습니다.");
		}else{
			$.each(data, function(index, store){
				
				/**
				 * 	Store Information
				 */
				var url = "../images/storeinfo/" + store.store_etc1 + ".jpg";
				var str = "<article>"
							+ "<span class='image'>"
								+ "<img src='" + url + "' alt=''/>"
							+ "</span>"
							+ "<header class='major'>"
								+ "<h3>"
									+ "<a onclick='product_list(" + store.store_seq + ");' class='link cursor'>" + store.store_name + "</a>"
								+ "</h3>"
								+ "<p><span class='store-name'>" + store.store_province + " " + store.store_city + " " + store.store_village + "</span></p>"								
							+ "</header>"
						+ "</article>";
				$("#store_list").append(str);
				
				/**
				 * 	Store Image
				 */
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

function product_list(store_seq){
	location.href="/page/product?sq=" + store_seq;
}