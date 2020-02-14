package com.local.team1.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.local.team1.domain.FreeBoardVo;
import com.local.team1.domain.MemberVo;
import com.local.team1.service.BoardService;
import com.local.team1.service.FreeBoardService;

@Controller
@RequestMapping("/board/*")
public class FreeBoardController {
	
	@Inject
	private FreeBoardService fb_Service;
	
	// 자유게시판 전체목록
	@RequestMapping(value = "/freeBoardList", method = RequestMethod.GET)
	public String freeBoard(Model model) throws Exception {
		List<FreeBoardVo> list = fb_Service.listAll();		
		model.addAttribute("list", list);		
		return "board/freeBoardList";
	}
	
	// 게시판 글쓰기창
	@RequestMapping(value = "/fbRegisterGet", method = RequestMethod.GET)
	public String freeBoardRestierGet() throws Exception {
		
		return "board/freeBoardRegister";
	}
	
	// 게시판 글쓰기처리
	@RequestMapping(value = "/fbRegisterPOST", method = RequestMethod.POST)
	public String freeBoardResterPost(FreeBoardVo fb_vo, HttpSession session) throws Exception {
		MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		System.out.println("memberVo == " + memberVo);
		fb_vo.setB_writer(memberVo.getMem_id());
		fb_Service.create(fb_vo);
		return "redirect:/board/freeBoardList";
	}
		
	// 게시판 상세보기
	@RequestMapping(value = "/fbRead", method = RequestMethod.GET)
	public String freeBoardRead(@RequestParam("b_num") int b_num, Model model) throws Exception {
		FreeBoardVo fb_vo = fb_Service.read(b_num);
		model.addAttribute("fb_vo", fb_vo);
		return "board/freeBoardContent";
	}
	
}
