package com.local.team1.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.local.team1.domain.ReplyVo;
import com.local.team1.service.ReplyService;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Inject
	private ReplyService rService;
	
	// 리플 쓰기
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String create(@RequestBody ReplyVo r_vo) throws Exception {
		rService.create(r_vo);
		return "reply_success";
	}
	
}
