package com.yohan.test.service.noticeService;

import java.util.List;

import com.yohan.test.dto.notice.NoticeDto;
import com.yohan.test.dto.pagenation.PageDto;
import com.yohan.test.dto.search.SearchValDto;

public interface NoticeService {

	//공지사항 리스트
	public List<NoticeDto> noticeList(SearchValDto sv);
	
	//공지사항 리스트 글 갯수
	public PageDto noticeListNum(SearchValDto sv);
	
	//공지사항 상세페이지
	public NoticeDto noticeView(int no);
	
	public void noticeDelete(int no);
	
}
