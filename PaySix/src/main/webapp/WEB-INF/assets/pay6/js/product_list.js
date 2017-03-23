var tmp = document.location.search.split("=");
var sid = tmp[1].split("&");

$(document).ready(function(){
	
//	var tmp = document.location.search.split("=");
//	var sid = tmp[1].split("&");
	
	var	$window = $(window),
	$body = $('body');
	
	// Toggle.
	$('<div id="headerToggle">' +
			'<a onclick="back();" class="toggle"></a>' +
		'</div>'
	).appendTo($body);
	
	
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
							+ "<article class='top3-box style2 item'>"
								+ "<a href='#' onclick='product_detail(" + product.pid + ");' class='image fit'><img src='" + url + "' alt=''/></a>"
								+ "<header>"
									+ "<span class='product-pname'>" + product.pName + "</span>"
									+ "<span class='product-price'>&nbsp;&nbsp;&nbsp;[ " + numberWithCommas(product.pprice) + " ]</span>"
								+ "</header>"
								+ "<div class=''>"
									+ "<div class='background-white product-count 4u 12u(mobile)'><i class='fa fa-credit-card'></i> " + product.pCount + "</div>"
									+ "<div class='background-white product-count 4u 12u(mobile)'><i class='fa fa-comments-o'></i> " + product.rCount + "</div>"
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
				var str = "<tr class='item box style2 td-cursor'>" 
								+ "<td><a onclick='product_detail(" + product.pid + ");'><span>" + product.pName + "</span></a></td>"
								+ "<td><a onclick='product_detail(" + product.pid + ");'><span class='price'>" + pprice + "</span></a></td>"
							+ "</a>" 
							+ "</tr>";
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