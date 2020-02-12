package com.local.team1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail() {
		
		return "board/detail";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String regist() {
		
		return "board/regist";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		
		return "board/home";
	}

}
