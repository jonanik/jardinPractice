package com.yohan.test.service.noticeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yohan.test.dao.notice.NoticeDao;
import com.yohan.test.dto.notice.NoticeDto;
import com.yohan.test.dto.pagenation.PageDto;
import com.yohan.test.dto.search.SearchValDto;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao noticeDao;

	// 공지사항 리스트
	@Override
	public List<NoticeDto> noticeList(SearchValDto sv) {
		return noticeDao.noticeList(sv);
	}

	//공지사항 리스트 글 갯수
	@Override
	public PageDto noticeListNum(SearchValDto sv) {
		PageDto pDto = noticeDao.noticeListNum(sv);
		pDto.setPage_cnt(pDto.getListCnt()); // 페이지 수 저장
		pDto.setRange_cnt(pDto.getPage_cnt()); // 블럭 수 저장
		pDto.setCurPage(sv.getCurPage()); // 현재 페이지 위치
		pDto.setCur_range(sv.getCurPage()); // 현재 블럭 위치
		pDto.prevnext(sv.getCurPage()); // 이전 블럭, 다음 블럭 설정
		pDto.setStart_page(pDto.getCur_range(), pDto.getRange_size()); // 현재 블럭 시작 페이지
		pDto.setEnd_page(pDto.getCur_range(), pDto.getRange_cnt()); // 현재 블럭 끝
		return pDto;
	}
	
	// 공지사항 상세페이지
	@Override
	public NoticeDto noticeView(int no) {
		NoticeDto noticeDto=noticeDao.noticeView(no);
		String temp=noticeDto.getContent();
		noticeDto.setContent(temp.replace("\\r\\n","<br><br>"));
		return noticeDto;
	}

	//공지사항 글 삭제
	@Override
	public void noticeDelete(int no) {
		noticeDao.noticeDelete(no);
		
	}

	

}
