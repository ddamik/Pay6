$(document).ready(function(){
	
//	var tmp = document.location.search.split("=");
//	var sid = tmp[1].split("&");
	

	product_init();
});

function product_init(){
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
					alert("hello");
					var str = "<div class='4u 12u(mobile)'>"
									+ "<article class='box style2'>"
									+ "<a href='#' class='image featured'><img src='../images/miniport/pic01.jpg' alt='' /></a>"
										+ "<h3><a href='#'>" + product.pname + "</a></h3>"
										+ "<p>Ornare nulla proin odio consequat.</p>"
										+ "</article>"
										+ "</div>";			
					$("#product_list").append(str);
				});
			}	
		},
		error: function(xhr, status, error){
			console.log("[ Product List Error ]: " + error);
		}
	});
}