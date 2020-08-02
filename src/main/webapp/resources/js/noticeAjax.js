
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

//공지사항 글 작성
function noticeWrite(){
	
	var formDate=$("#noticeWriteForm").serialize();
	
	$.ajax({
		
		type:'post',
		url:'./noticeWrite',
		data:formDate,
		success:function(data){
			if(confirm("작성되었습니다. 더 작성하시겠습니까?")==true){
			location.reload();
			}else{
				alert("공지사항 리스트로 돌아갑니다.");
				location.href="noticeList";
			}
		},
		error:function(request,status,error){
			alert("실패")
		}
		
	})
}

function noticeModifyForm(no){
	$.ajax({
		type:'post',
		url:'./noticeModifyForm',
		data:{no:no},
		success:function(data){
			alert("수정 정보를 가져옵니다.");
			$("title").html(data.title);
			$("content").html(data.content);
		},
		error:function(request,status,error){
			alert("실패");
		}
	})
}