package com.local.team1.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.local.team1.domain.BoardVo;
import com.local.team1.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService bService;
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail() throws Exception {
		
		return "board/detail";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String regist() throws Exception {
		return "board/regist";
	}
	
	@RequestMapping(value = "/registPro", method = RequestMethod.POST)
	public String registPro(BoardVo vo) throws Exception {
		System.out.println(vo);
		bService.regist(vo);
		return "board/home";
	}
	
	@RequestMapping(value = "/registPro", method = RequestMethod.GET)
	public String registPro() throws Exception {
		
		return "board/home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() throws Exception {
		
		return "board/home";
	}

}
