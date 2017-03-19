var tmp = document.location.search.split("=");
var sid = tmp[1].split("&");

$(document).ready(function(){
	
//	var tmp = document.location.search.split("=");
//	var sid = tmp[1].split("&");

	$.ajax({
		url: '/store/get_name?sid=' + sid
	}).done(function(store){
		if( store == null ){
			console.log('null store name');		
		}else{
			$("#store_name").text(store.sname);
		}
	});
	
	
	$.ajax({
		url: '/product/popular_list?sid=' + sid
	}).done(function(data){
		if( data == null ){
			var str = "<div class='4u 12u(mobile)'>상품이 없습니다.</div>";		
		}else{
			$.each(data, function(index, product){				
				
				var url = "../images/productinfo/" + product.pid + ".jpg";
				var str = "<div class='6u 12u(mobile)'>"
							+ "<article class='item'>"
								+ "<a href='#' onclick='product_detail(" + product.pid + ");' class='image fit'><img src='" + url + "' alt=''/></a>"
								+ "<header>"
									+ "<span class='product-pname'>" + product.pName + "</span>"
									+ "<span class='product-price'>&nbsp;&nbsp;&nbsp;[ " + numberWithCommas(product.pprice) + " ]</span>"
								+ "</header>"
								+ "<div class=''>"
									+ "<div class='background-white product-count 4u 12u(mobile)'><i class='fa fa-credit-card'></i> " + product.pCount + "</div>"
									+ "<div class='background-white product-count 4u 12u(mobile)'><i class='fa fa-mail-reply-all'></i> " + product.rCount + "</div>"
									+ "<div class='background-white product-count 4u 12u(mobile)'><i class='fa fa-thumbs-o-up'></i> " + product.vCount + "</div>"
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


function back(){
	location.href = "/page/store_list";
}

function product_detail(pid){
	location.href="/page/product_detail?pid=" + pid;
}



function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + " 원";
}