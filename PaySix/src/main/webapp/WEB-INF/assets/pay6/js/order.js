var credit = 1;
var nh_api = 2;
var bitcoin = 3;
var coupon = 4;

var table_order = 100;
var take_out_order = 101;


var tmp = document.location.search.split("=");
var position = tmp[2].split("&");
var tmp2 = tmp[1].split("&");
var pid = tmp2[0].split("?")[0];


$(document).ready(function() {

	$.ajax({
		url: '/product/detail',
		type: 'get',
		data: {
			'pid': '10010001'
		},
		success: function(product){
			 if( product == null ){
				 console.log('null product');
			 }else{
				 
				 var price = product.price;
				 price = numberWithCommas(price);

				 var url = "../images/productinfo/" + product.pid + ".jpg";
				 var str = "<span class='image fit'><img src='" + url + "' alt=''/></span>"
					 		+ "<div class='content'>"
					 			+ "<header class='major'>"
					 				+ "<h2>" + product.pName + "</h2>"
					 			+ "</header>"
					 			+ "<h2>" + price + "</h2>"
					 			+ "<p>Contents</p>"
				 			+ "</div>";
				 $("#product").append(str);
			 }
		},
		error: function(xhr, status, error){
			console.log('order error: ' + error);s
		}
	});
});

function fun_pay(method) {

	if (method == credit){
		console.log("credit");
		if( position == take_out_order ) console.log("테이크아웃 주문");
		else console.log("테이블 주문");
	}
		
	else if (method == nh_api){
		console.log("nh_api");
		if( position == take_out_order ) console.log("테이크아웃 주문");
		else console.log("테이블 주문");	
	}
	else if (method == bitcoin){
		console.log("bitcoin");
		if( position == take_out_order ) console.log("테이크아웃 주문");
		else console.log("테이블 주문");		
	}
	else{
		console.log("coupon");
		if( position == take_out_order ) console.log("테이크아웃 주문");
		else console.log("테이블 주문");
	}
		
}



function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + " 원";
}