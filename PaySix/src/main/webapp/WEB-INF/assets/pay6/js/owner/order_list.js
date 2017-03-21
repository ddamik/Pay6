var sid = '1002';
var seqid = "0";
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
		url: '/log/owner/order_list/ordertime',
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
				
				var str = "<tr>"
							+ "<th>" + log.orderno + "</th>"
							+ "<th>" + log.tno + "</th>"
							+ "<th>" + log.pname + "</th>"
							+ "<th>" + dateToYYYYMMDD(log.ordertime) + "</th>"
							+ "<th><a class='button custom-size' onclick='change_status(" + log.seqid + ", " + log.tno + ");'>완료</a></th>"
						+ "</tr>";
				$("#order_list").append(str);
			});	
		},
		error: function(xhr, status, error){
			console.log('error order list');
		}
	});
	
	$.ajax({
		url: '/log/owner/order_list/endtime',
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
								
				var str = "<tr>"
							+ "<td>" + log.orderno + "</td>"
							+ "<td>" + log.tno + "</td>"
							+ "<td>" + log.pname + "</td>"
							+ "<td>" + dateToYYYYMMDD(log.endtime) + "</td>"
						+ "</tr>";
				$("#order_end_list").append(str);
			});	
		},
		error: function(xhr, status, error){
			console.log('error order list');
		}
	});	
}


function change_status(seqid, tno){
	alert(tno);
	
	$.ajax({
		url: '/log/update_status?seqid=' + seqid
	}).done(function(data){
		
		alert(tno + "번 테이블 주문완료");
		location.reload();
	});
	
}


function dateToYYYYMMDD(intime){
	var date = new Date(intime);
   function pad(num) {
       num = num + '';
       return num.length < 2 ? '0' + num : num;
   }
   return pad(date.getDate()) + '일 ' + date.getHours() + ':' + pad(date.getMinutes()); 
}