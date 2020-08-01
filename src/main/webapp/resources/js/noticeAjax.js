
//공지사항 글 삭제
function noticeDelete(no){
	if(confirm("정말 삭제하시겠습니까?")==true){
		
		$.ajax({
			type:'post',
			url:'./noticeDelete',
			data:{no:no},
			success:function(){
				alert("삭제되었습니다. 게시글 리스트로 이동합니다.");
				location.href = "noticeList";
			},
			error:function(request,status,error){
				alert("실패")
			}
		});
	}else{
		return;
	}
}