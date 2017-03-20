var sid = '1002';
var seqid = "";
var strTakeOut = "Take Out";

$(document).ready(function() {
	
	init_order_list();
	$("#btn_more").click(function(){
		more_order_list();
	});
});

function init_order_list(){
	more_order_list();
}

function more_order_list(){
	$.ajax({
		url: '/log/owner/order_list',
		type: 'get',
		data:{
			'sid': sid,
			'seqid': seqid
		},
		success: function(data){
			if( data == null || data == "" ) {
				var str = "<div class='order-list'>주문처리 완료</div>";
			}
			$.each(data, function(index, log){
				
				seqid = log.seqid + "";
				
				var status = "";
				if( log.status == "1" ) status = "결제완료";
				else status = "상품제공";
				
				var tno = "";
				if( log.tno == "0" ) tno = strTakeOut + "";
				else tno = log.tno + ""; 
				
				var str = "<div class='order-list'>"
							+ "<div class='log-orderno'>" + log.orderno + "</div>"
							+ "<div class='log-tno'>" + tno + "</div>"
							+ "<div class='log-pname'>" + log.pname + "</div>"
							+ "<div class='log-status'>" + status + "</div>"
							+ "<div class='log-button'><a class='button custom-size' onclick='change_status(" + log.seqid + ", " + tno + ");'>접수</a></div>"
						+ "</div>";
				$("#order_list").append(str);
			});	
		},
		error: function(xhr, status, error){
			console.log('error order list');
		}
	});
}


function change_status(seqid, tno){
	
	$.ajax({
		url: '/log/update_status?seqid=' + seqid
	}).done(function(data){
		if( tno == strTakeOut ) alert("Take Out 주문완료");
		else alert(tno + "번 테이블 주문완료");
		location.reload();
	});
	
}