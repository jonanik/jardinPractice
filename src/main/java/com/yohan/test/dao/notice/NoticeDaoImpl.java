package com.yohan.test.dao.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yohan.test.dto.notice.NoticeDto;
import com.yohan.test.dto.pagenation.PageDto;
import com.yohan.test.dto.search.SearchValDto;
@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	SqlSession sqlsession;
	
	//공지사항 검색 및 페이징된 글 리스트 가져오기
	@Override
	public List<NoticeDto> noticeList(SearchValDto sv) {
		return sqlsession.selectList("notice.noticeList",sv);
	}

	//공지사항 검색 및 페이징된 글 갯수 가져오기
	public PageDto noticeListNum(SearchValDto sv) {
		return sqlsession.selectOne("notice.noticeListNum",sv);
	}
	
	//공지사항 글 상세보기
	@Override
	public NoticeDto noticeView(int no) {
		return sqlsession.selectOne("notice.noticeView",no);
	}

	//공지사항 글 삭제
	@Override
	public void noticeDelete(int no) {
		sqlsession.delete("notice.noticeDelete",no);
		
	}

}
