package com.yohan.test.dao.notice;

import java.util.List;

import com.yohan.test.dto.notice.NoticeDto;
import com.yohan.test.dto.pagenation.PageDto;
import com.yohan.test.dto.search.SearchValDto;


public interface NoticeDao {
	//공지사항 리스트
	public List<NoticeDto> noticeList(SearchValDto sv);
	
	//공지사항 리스트 글 갯수
	public PageDto noticeListNum(SearchValDto sv);
	
	//공지사항 상세페이지
	public NoticeDto noticeView(int no);
	
	//공지사항 글 삭제
	public void noticeDelete(int no);
	
	//공지사항 글 쓰기
	public void noticeWrite(NoticeDto noticeDto);
	
	//공지사항 글 수정
	public NoticeDto noticeModifyForm(int no);
}
