package com.yohan.test.controller.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yohan.test.dto.notice.NoticeDto;
import com.yohan.test.dto.pagenation.PageDto;
import com.yohan.test.dto.search.SearchValDto;
import com.yohan.test.service.noticeService.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	//공지사항 리스트
	@RequestMapping("noticeList")
	public String noticeList(Model model,SearchValDto sv) {
		PageDto pDto = noticeService.noticeListNum(sv); // 게시글 수 저장
		List<NoticeDto> Noticelist = noticeService.noticeList(sv); //게시글 검색하거나,페이징 처리된 게시글 리스트 가져오기
		model.addAttribute("noticeList",Noticelist);
		model.addAttribute("pDto",pDto);
		model.addAttribute("sv",sv);
		return "notice/notice";
	}
	
	//공지사항 상세페이지
	@RequestMapping("noticeView")
	public String noticeView(Model model,int no) {
		model.addAttribute("noticeView",noticeService.noticeView(no));
		return "notice/noticeView";
	}
	
	//공지사항 글 삭제
	@RequestMapping("noticeDelete")
	@ResponseBody
	public void noticeDelete(int no) {
		noticeService.noticeDelete(no);
	}
	
}
