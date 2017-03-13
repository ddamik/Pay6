$(document).ready(function(){
	
//	var tmp = document.location.search.split("=");
//	var sid = tmp[1].split("&");
	
	$.ajax({
		url: '/product/all_list',
		type: 'get',
		data: {
			'sid': '1001'
		},
		success: function(data){
			if( data == null ){
				var str = "<div class='4u 12u(mobile)'>상품이 없습니다.</div>";		
			}else{
				$.each(data, function(index, product){					
					var str = "<div class='4u 12u(mobile)'>"
								+ "<article class='box style2'>"
									+ "<a href='#' class='image featured'><img src='../images/productinfo/" + product.pid + ".jpg' alt='' /></a>"
									+ "<h3><a href='#'>" + product.pName + "</a></h3>"
									+ "<p>" + product.price + " 원</p>"
								+ "</article>"
							+ "</div>";			
					$("#product_list").append(str);
				});
			}	
		},
		error: function(xhr, status, error){
			
		}
	});
	
});