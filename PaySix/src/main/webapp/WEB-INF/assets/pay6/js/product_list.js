var tmp = document.location.search.split("=");
var sid = tmp[1].split("&");

$(document).ready(function(){
	
//	var tmp = document.location.search.split("=");
//	var sid = tmp[1].split("&");
	
	$.ajax({
		url: '/product/popular_list?sid=' + sid
	}).done(function(data){
		if( data == null ){
			var str = "<div class='4u 12u(mobile)'>상품이 없습니다.</div>";		
		}else{
			$.each(data, function(index, product){
				
				console.log(product.pid);
				
				var str = "<div class='4u 12u(mobile)'>"
							
							+ "<article class='box style2'>"

								+ "<a href='#' onclick='product_detail(" + product.pid + ");' class='image featured'><img src='../images/productinfo/" + product.pid + ".jpg' alt='' /></a>"
							
								+ "<h3><a href='#' onclick='product_detail(" + product.pid + ");'>" + product.pName + "</a></h3>"
								+ "<p>" + numberWithCommas(product.pprice) + "</p>"
								
								+ "<div class='custom-height'>"
									+ "<div class='6u float-left'>"
										+ "<span>구매 수: " + product.pCount + "</span>"
									+ "</div>"
									+ "<div class='6u float-left'>"
										+ "<span>리뷰 수: " + product.rCount + "</span>"
									+ "</div>"
								+ "</div>"
								
							+ "</article>"
						+ "</div>";			
				$("#product_list").append(str);
			});
		}	
	});
	
	
	$.ajax({
		url: '/product/all_list?sid=' + sid,
	}).done(function(data){
		if( data == null ){
			var str = "<div class='4u 12u(mobile)'>상품이 없습니다.</div>";		
		}else{
			$.each(data, function(index, product){
				
				var pprice = numberWithCommas(product.pprice);
				
				var str = "<a href='#' onclick='product_detail(" + product.pid + ");'>"
						+ "<section class='box custom-height'>"
						+ "<div class='8u text-left float-left'><span>" + product.pName + "</span></div>"
						+ "<div class='4u text-right float-left'><span>" + pprice + "</span></div>"
						+ "</section>"
						+ "</a>";
				$("#all_list").append(str);
			});
		}	
	});	
});


function product_detail(pid){
	location.href="/page/product_detail?pid=" + pid;
}



function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + " 원";
}