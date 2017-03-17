var tmp = document.location.search.split("=");
var pid = tmp[1].split("&");

var table_order = 100;
var take_out_order = 101;

var both_order = "0";
var only_take_out = "1";
var only_table = "2";

var seqid = 0;

$(document).ready(function() {

	var strPid = pid + "";
	var sid = strPid.substr(0, 4);
	
	$.ajax({
		url: '/product/detail?pid=' + pid
	}).done(function(product){
		var url = "../images/productinfo/" + pid + ".jpg";
		var str = "<div class='container'>"
					+ "<h3>" + product.pName + "</h3>"
					+ "<p>product contents</p>"
					+ "<div class='features'>"
					+ "<article>"	
						+ "<a href='#' class='image'><img src='" + url + "' alt='' /></a>"
						+ "<div class='inner'>"	
							+ "<h4>" + numberWithCommas(product.pprice) + "</h4>"
						+ "</div>"
					+ "</article>"
					+ "</div>"
					+ "</div>";
			 $("#product_detail").append(str);
	});
	
		
	//	주문방법
	$.ajax({
		url: '/store/order_info',
		type: 'get',
		data: {
			'sid': sid
		},
		success: function(store){
			var data = store.order_method;
			if( data == both_order ){
				var str = "<li class='custom-margin'><input id='btn_table' type='button' class='special' value='테이블 주문'/></li>"
					+ "<li class='custom-margin'><input id='btn_take_out' type='button' value='테이크아웃 주문' /></li>";
				$("#order_method").append(str);
				$("#btn_take_out").click(function(){ order_page(take_out_order); });
				$("#btn_table").click(function(){ order_page(table_order); });	
			}else if( data == only_take_out ){
				var str = "<li class='custom-margin'><input id='btn_take_out' type='button' value='테이크아웃 주문' /></li>";
				$("#order_method").append(str);
				$("#btn_take_out").click(function(){ order_page(take_out_order); });
			}else if( data == only_table ){
				var str = "<li class='custom-margin'><input id='btn_table' type='button' class='special' value='테이블 주문'/></li>";
				$("#order_method").append(str);
				$("#btn_table").click(function(){ order_page(table_order); });	
			}
		},
		error: function(xhr, status, error){
			console.log("Product Detail StoreVO Error");
		}
	});
	

	//	리뷰 리스트
	review_more(pid, seqid);
	/*$.ajax({
		url: '/review/list?pid=' + pid
	}).done(function(data){
		$.each(data, function(index, review){
			var currDate = new Date(review.intime); // 현재 날짜 생성
			currDate = dateToYYYYMMDD(currDate);
			var str = "<div class=''>"
							+ "<h5 class='tag-inline'>" + review.editor + "</h5>"
							+ "<div class='tag-inline date-margin editor'><span>" + currDate + "</span></div>"
							+ "<div><span>" + review.contents + "</span></div>"
							+ "<hr>"
							+ "</div>";
			seqid = review.seqid;
		 $("#reviews").append(str);
		});
	});*/

	
	
	$("#btn_more_review").click(function(){
		review_more();
	});
});

function review_more(){
	pid = pid + "";
	$.ajax({
		url: '/review/more',
		type: 'post',
		data:{
			'seqid': seqid,
			'pid': pid
		},
		success: function(data){
			$.each(data, function(index, review){
				console.log(review.editor);
				var currDate = new Date(review.intime); // 현재 날짜 생성
				currDate = dateToYYYYMMDD(currDate);
				var str = "<div class=''>"
								+ "<h5 class='tag-inline'>" + review.editor + "</h5>"
								+ "<div class='tag-inline date-margin editor'><span>" + currDate + "</span></div>"
								+ "<div><span>" + review.contents + "</span></div>"
								+ "<hr>"
								+ "</div>";
				seqid = review.seqid;
				$("#reviews").append(str);
			});
		},
		error: function(xhr, status, error){
			console.log("Review More Error: " + error);
			console.log("Status: " + status);
		}
	});
}






function order_page(position){
	location.href="/page/order?pid=" + pid + "?position=" + position;
}

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + " 원";
}

function dateToYYYYMMDD(date){
   function pad(num) {
       num = num + '';
       return num.length < 2 ? '0' + num : num;
   }
   return date.getFullYear() + '-' + pad(date.getMonth()+1) + '-' + pad(date.getDate());
}