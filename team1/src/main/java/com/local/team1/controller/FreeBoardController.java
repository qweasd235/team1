package com.local.team1.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.local.team1.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class FreeBoardController {
	
	@Inject
	private BoardService bService;
	
	// 자유게시판
	@RequestMapping(value = "/freeBoardList", method = RequestMethod.GET)
	public String freeBoard() throws Exception {
		return "/board/freeBoardList";
	}
	
	// 게시판 글쓰기창
	@RequestMapping(value = "/fbRegisterGet", method = RequestMethod.GET)
	public String freeBoardRestierGet() throws Exception {
		return "/board/freeBoardRegister";
	}
	
	// 게시판 글쓰기처리
		@RequestMapping(value = "/fbRegisterGet", method = RequestMethod.POST)
		public String freeBoardRestierPost() throws Exception {
			return "redirect:/board/home";
		}
}
