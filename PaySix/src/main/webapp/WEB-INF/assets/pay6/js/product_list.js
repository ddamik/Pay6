var tmp = document.location.search.split("=");
var store_seq = tmp[1].split("&");

$(document).ready(function(){
	
	/**
	 * 	Back Button
	 */
	var	$window = $(window),
	$body = $('body');
	
	// Toggle.
	$('<div id="headerToggle">' +
			'<a onclick="back();" class="toggle"></a>' +
		'</div>'
	).appendTo($body);
	
	
	/**
	 * 	Product List 
	 */
	var dataForm = "";
	dataForm += "store_seq=" + store_seq;
	$.ajax({
		url: '/product/list',
		type: 'get',
		data: dataForm
	}).done(function(data){
		
		$("#store_name").text(data.store.store_name);
		
		$.each(data.productList, function(index, product){
			console.log("[ index ]: " + index + " / " + product.product_name);
			if( index < 3 ){
				var url = "../images/productinfo/" + product.product_etc1 + ".jpg";
	            var str = "<div class='6u 12u(mobile)'>"
	                     + "<article class='top3-box style2 item'>"
	                        + "<a href='#' onclick='product_detail(" + product.product_seq + ");' class='image fit'><img src='" + url + "' alt=''/></a>"
	                        + "<header>"
	                           + "<span class='product-pname'>" + product.product_name + "</span>"
	                           + "<span class='product-price'>&nbsp;&nbsp;&nbsp;[ " + numberWithCommas(product.product_price) + " ]</span>"
	                        + "</header>"
	                        + "<div class=''>"
	                           + "<div class='background-white product-count 4u 12u(mobile)'><i class='fa fa-credit-card'></i> " + product.product_purchase_cnt + "</div>"
	                           + "<div class='background-white product-count 4u 12u(mobile)'><i class='fa fa-comments-o'></i> " + product.product_review_cnt + "</div>"
	                           + "<div class='background-white product-count 4u 12u(mobile)'><i class='fa fa-eye'></i> " + product.product_view_cnt + "</div>"
	                        + "</div>"                        
	                     + "</article>"                     
	                  + "</div>";      
	            $("#product_list").append(str);
			}else{            
	            var str = "<tr class='item box style2 td-cursor'>" 
	                        + "<td><a onclick='product_detail(" + product.product_seq + ");'><span>" + product.product_name + "</span></a></td>"
	                        + "<td><a onclick='product_detail(" + product.product_seq + ");'><span class='price'>" + numberWithCommas(product.product_price) + "</span></a></td>"
	                     + "</a>" 
	                     + "</tr>";
	            $("#all_list").append(str);
			}
		});
	});
	 
});


function back(){
	location.href = "/page/store";
}

function product_detail(product_seq){
	location.href="/page/order?sq=" + store_seq + "&ps=" + product_seq;
}

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + " 원";
}