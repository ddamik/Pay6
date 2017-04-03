var tmp = document.location.search.split("=");
var tmp2 = tmp[1].split("&");
var store_seq = tmp2[0];
var product_seq = tmp[2];

var amount = 0;
var user_seq = 0;
var user_name = "";
var current_review_seq = 0;
$(document).ready(function() {
		
	initUser();	
	
	var IMP = window.IMP;
	IMP.init('imp96588755')
 	
	var dataForm = "";
	dataForm += "store_seq=" + store_seq;
	dataForm += "&product_seq=" + product_seq;
	
	$.ajax({
		url: '/product/detail',
		type: 'get',
		data: dataForm
	}).done(function(data){
		$("#store_name").text(data.store.store_name);
		
		amount = data.product.product_price;
		var url = "../images/productinfo/" + data.product.product_etc1 + ".jpg";
		var str = "<a class='image featured'>"
					+ "<img src=" + url + " alt='' /></a>"
					+ "<header>"
						+ "<span class='product_title'>" + data.product.product_name + "</span>"
						+ "<span class='product_price'>&nbsp;&nbsp;[ " + numberWithCommas(data.product.product_price) + " ]</span>"
					+ "</header>"
					+ "<p></p>"
					+ "<footer>"
						+ "<ul class='actions'>"
							+ "<li><a id='btn_payment' class='button'>결제하기</a></li>"
							+ "<li><a href='#footer-wrapper' class='button alt icon fa-comments'>comments</a></li>"
						+ "</ul>"
					+ "</footer>";
		$("#product_detail").append(str);
		$("#btn_payment").click(function(){
			payment();
		});
	});
	
	update_reviews();

	$("#btn_registe_review").click(function(){
		insert_review();
	});
});

function initUser(){
	user_name = "이재익";
}
 

function payment(){
	
	var order_no = 0;
	var order_store_fk = store_seq;
	
	var orderForm = "";
	orderForm += "order_no=" + order_no;
	orderForm += "&order_store_fk=" + order_store_fk;
	orderForm += "&order_product_fk=" + product_seq;
	orderForm += "&order_product_price=" + amount;
	orderForm += "&order_user_fk=" + user_seq;
	
	
	console.log("[ OrderForm ]: " + orderForm);
	$.ajax({
		url: '/order/payment',
		type: 'post',
		data: orderForm		
	}).done(function(result){
		if( result > 0 ){
			alert("결제완료");
		}else{
			alert("결제실패");
		}
	});
	/*
	IMP.request_pay({
	    pg : 'kakao',
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : '주문명:결제테스트',
	    amount : 1100,
//	    buyer_email : 'iamport@siot.do',
//	    buyer_name : '구매자이름',
	    buyer_tel : '010-3329-7859',
//	    buyer_addr : '서울특별시 강남구 삼성동',
//	    buyer_postcode : '123-456',
	    kakaoOpenApp : true
	}, function(rsp) {
	    if ( rsp.success ) {
	    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
	    	jQuery.ajax({
	    		url: "/order/complete", //cross-domain error가 발생하지 않도록 주의해주세요
	    		type: 'POST',
	    		dataType: 'json',
	    		data: {
		    		imp_uid : rsp.imp_uid
		    		//기타 필요한 데이터가 있으면 추가 전달
	    		}
	    	}).done(function(data) {
	    		//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
	    		if ( everythings_fine ) {
	    			var msg = '결제가 완료되었습니다.';
	    			msg += '\n고유ID : ' + rsp.imp_uid;
	    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	    			msg += '\결제 금액 : ' + rsp.paid_amount;
	    			msg += '카드 승인번호 : ' + rsp.apply_num;
	    			
	    			alert(msg);
	    		} else {
	    			//[3] 아직 제대로 결제가 되지 않았습니다.
	    			//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
	    		}
	    	});
	    } else {
	        var msg = '결제에 실패하였습니다.';
	        msg += '에러내용 : ' + rsp.error_msg;
	        
	        alert(msg);
	    }
	});
	*/
}
 

function update_reviews(){
	
	var review_seq = 0;
	var reviewForm = "";
	reviewForm = "review_seq=" + review_seq;
	reviewForm += "&review_product_fk=" + product_seq;
	
	$.ajax({
		url: '/review/list',
		type: 'get',
		data: reviewForm
	}).done(function(data){
		$.each(data, function(index, review){
			var str = "<tr><td class='review-user'>" + review.review_user_fk + "</td><td class='review-user'>" + dateToYYYYMMDD(review.review_savetime) + "</tr>"
			+ "<tr><td colspan='2' class='review_contents'>" + review.review_contents + "</td></tr>"
			+ "<tr><td colspan='2'><hr></td></tr>";			
			$("#reviews").append(str);
		});
	});
}


function insert_review(){
	
	var review_contents = $("#review_contents").val();
	
	var reviewForm = "";
	reviewForm = "review_product_fk=" + product_seq;
	reviewForm += "&review_user_fk=" + user_seq;
	reviewForm += "&review_contents=" + review_contents;
	reviewForm += "&store_seq=" + store_seq;
	
	$.ajax({
		url: '/review/insert',
		type: 'post',
		data: reviewForm
	}).done(function(result){		
		if(result > 0){
			var str = "<tr><td class='review-user'>" + user_name + "</td><td class='review-user'>" + dateToYYYYMMDD(new Date()) + "</tr>"
				+ "<tr><td colspan='2' class='review_contents'>" + review_contents + "</td></tr>"
				+ "<tr><td colspan='2'><hr></td></tr>";			
			$("#reviews").prepend(str);
		}else{
			alert("댓글등록 실패!!");
		}
		$("#review_contents").val("");
	});
}

 


function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + " 원";
}
 

function dateToYYYYMMDD(intime){
	var date = new Date(intime);
   function pad(num) {
       num = num + '';
       return num.length < 2 ? '0' + num : num;
   }
   return date.getFullYear() + '-' + pad(date.getMonth()+1) + '-' + pad(date.getDate()) + " " + pad(date.getHours()) + ":" + pad(date.getMinutes()) + ":" + pad(date.getSeconds()) ;
}


function back(){
	location.href = "/page/product?sq=" + store_seq;
}