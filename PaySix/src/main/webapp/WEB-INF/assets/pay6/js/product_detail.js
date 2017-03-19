var tmp = document.location.search.split("=");
var pid = tmp[1].split("&");

var table_order = 100;
var take_out_order = 101;

var both_order = "0";
var only_take_out = "1";
var only_table = "2";

var seqid = 0;
var sid = "";

var amount = "";
var strPaymethod = "";

$(document).ready(function() {
		
	var strPid = pid + "";
	sid = strPid.substr(0, 4);
	amount = "";
	
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
		url: '/product/detail?pid=' + pid
	}).done(function(data){
		amount = data.product.pprice;
		var url = "../images/productinfo/" + data.product.pid + ".jpg";
		var str = "<a href='#' class='image featured'>"
					+ "<img src=" + url + " alt='' /></a>"
					+ "<header>"
						+ "<span class='product_title'>" + data.product.pName + "</span>"
						+ "<span class='product_price'>&nbsp;&nbsp;[ " + numberWithCommas(data.product.pprice) + " ]</span>"
					+ "</header>"
					+ "<p></p>"
					+ "<footer>"
						+ "<ul class='actions'>";
							if( data.sid.order_method == both_order ){
								str += "<li><a id='btn_table_order' class='button'>Table 주문</a></li>"
								+ "<li><a id='btn_takeout_order' class='button'>Take-out 주문</a></li>"
								+ "<li><a href='#footer-wrapper' class='button alt icon fa-comments'>comments</a></li>"; 
							}else if( data.sid.order_method == only_take_out ){
								str += "<li><a id='btn_takeout_order' class='button'>Take-out 주문</a></li>"
									+ "<li><a href='#footer-wrapper' class='button alt icon fa-comments'>comments</a></li>";								
							}else if( data.sid.order_method == only_table ){
								str += "<li><a id='btn_table_order' class='button'>Table 주문</a></li>"
									+ "<li><a href='#footer-wrapper' class='button alt icon fa-comments'>comments</a></li>";
							}
					str += "</ul>"
						+ "</footer>";
			 $("#product_detail").append(str);
			 $("#btn_table_order").click(function(){ strPaymethod="0"; paymethod("[ Table ]"); });
			 $("#btn_takeout_order").click(function(){ strPaymethod="1"; paymethod("[ Take-Out ]"); });
			 $("#btn_more_review").click(function(){ review_more(); });
	});
	

	$("#credit-order").css('display', 'none');
	$("#nh-order").css('display', 'none');
	$("#bitcoin-order").css('display', 'none');
	$("#coupon-order").css('display', 'none');
	
	$("#credit").click(function(){
		$("#credit_amount").text("결제 금액: " + numberWithCommas(amount));
		$("#credit-order").css('display', 'block');
		$("#nh-order").css('display', 'none');
		$("#bitcoin-order").css('display', 'none');
		$("#coupon-order").css('display', 'none');
	});
	$("#nh-api").click(function(){
		$("#nh_amount").text("결제 금액: " + numberWithCommas(amount));
		$("#credit-order").css('display', 'none');
		$("#nh-order").css('display', 'block');
		$("#bitcoin-order").css('display', 'none');
		$("#coupon-order").css('display', 'none');
	});
	$("#bitcoin").click(function(){
		$("#bitcoin_amount").text("결제 금액: " + numberWithCommas(amount));
		$("#credit-order").css('display', 'none');
		$("#nh-order").css('display', 'none');
		$("#bitcoin-order").css('display', 'block');
		$("#coupon-order").css('display', 'none');
	});
	$("#coupon").click(function(){
		alert("준비중입니다.");
		/*
		$("#coupon_amount").text("결제 금액: " + numberWithCommas(amount));
		$("#pay_amount").text(amount);
		$("#credit-order").css('display', 'none');
		$("#nh-order").css('display', 'none');
		$("#bitcoin-order").css('display', 'none');
		$("#coupon-order").css('display', 'block');
		*/
	});
	
	$("#bitcoin_payment").click(function(){
		bitcoin_payment();
	});
	
	//	내 satoshi 잔액
	$.ajax({
		url: '/bitcoin/getBalance'
	}).done(function(data){
		$("#remain_btc").text(numberWithCommasSatoshi(data));
	});
	
	
	//	리뷰 리스트
	init_review();

});


function init_review(){
	review_more();
}

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
				var currDate = new Date(review.intime); // 현재 날짜 생성
				currDate = dateToYYYYMMDD(currDate);
				var str = "<li>"
							+ "<span class='review-title'>" + review.editor + "</span>" 
							+ "&nbsp;&nbsp;&nbsp;<span class='review-date'>" + dateToYYYYMMDD(review.intime) + "</span>"
							+ "<span class='review-contents'>" + review.contents + "</span>"
							+ "</li><hr class='review-hr'>";
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


function paymethod(method){
	$("#paymethod").text(method);
	$("#header-wrapper").css('display', 'block');
	location.href="#header-wrapper";
}

function order(position){
	//	location.href="/page/order?pid=" + pid + "?position=" + position;
}

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + " won";
}

function numberWithCommasSatoshi(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + " satoshi";
}

function dateToYYYYMMDD(intime){
	var date = new Date(intime);
   function pad(num) {
       num = num + '';
       return num.length < 2 ? '0' + num : num;
   }
   return date.getFullYear() + '-' + pad(date.getMonth()+1) + '-' + pad(date.getDate());
}


function back(){
	location.href = "/page/product_list?sid=" + sid;
}

function bitcoin_payment(){
	
	var tno = "0";
	var userid = "이승호";
	
	$.ajax({
		url: '/log/insert',
		type: 'post',
		data:{
			'tno': tno, 
			'pid': pid,
			'userid': userid,
			'paymethod': strPaymethod,
			'amount': amount
		},
		success: function(data){
			alert("결제가 완료되었습니다.");
			location.reload();
		},
		error: function(xhr, status, error){
			
		}
	});
}