var tmp = document.location.search.split("=");
var pid = tmp[1].split("&");

var table_order = 100;
var take_out_order = 101;

$(document).ready(function() {

	$.ajax({
		url: '/product/detail?pid=' + pid
	}).done(function(product){
		
		var url = "../images/productinfo/" + pid + ".jpg";
		var str = "<div class='container'>"
					+ "<h3>" + product.pName + "</h3>"
					+ "<p>product contents</p>"
					+ "<div class='features'>"
					+ "<article>"	
						+ "<a href='/' class='image'><img src='" + url + "' alt='' /></a>"
						+ "<div class='inner'>"	
							+ "<h4>" + numberWithCommas(product.pprice) + "</h4>"
						+ "</div>"
					+ "</article>"
					+ "</div>"
					+ "</div>";
			 $("#product_detail").append(str);
	});
	
	


	$.ajax({
		url: '/review/list?pid=' + pid
	}).done(function(data){
		$.each(data, function(index, review){
			var str = "<div class=''>"
						+ "<div>" + review.editor + "</div>"
						+ "<div><h4>" + review.contents + "</h4><hr></div>"
						+ "</div>";
		 $("#reviews").append(str);
		});
	});

	
	$("#btn_take_out").click(function(){
		order_page(take_out_order);
	});
	
	$("#btn_table").click(function(){
		order_page(table_order);
	});
});

function order_page(position){
	location.href="/page/order?pid=" + pid + "?position=" + position;
}

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + " 원";
}