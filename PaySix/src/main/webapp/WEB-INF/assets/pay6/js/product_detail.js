var tmp = document.location.search.split("=");
var tmp2 = tmp[1].split("&");
var store_seq = tmp2[0];
var product_seq = tmp[2];

$(document).ready(function() {
		
	  
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
	
	

	$("#btn_registe_review").click(function(){
		
	});
});

 

function payment(){
	
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
}

function order(position){
	//	location.href="/page/order?pid=" + pid + "?position=" + position;
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
   return date.getFullYear() + '-' + pad(date.getMonth()+1) + '-' + pad(date.getDate());
}


function back(){
	location.href = "/page/product?sq=" + store_seq;
}