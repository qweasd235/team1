package com.local.team1.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.local.team1.domain.MemberVo;
import com.local.team1.domain.ReplyVo;
import com.local.team1.service.ReplyService;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Inject
	private ReplyService rService;
	
	// 리플 쓰기
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String create(@RequestBody ReplyVo r_vo, HttpSession session) throws Exception {
		MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		r_vo.setR_writer(memberVo.getMem_id());
		rService.create(r_vo);
		return "reply_success";
	}
	
	// 리플 보기
	@RequestMapping(value = "/listAll/{b_num}", method = RequestMethod.GET)
	public List<ReplyVo> listAll(@PathVariable("b_num") int b_num) throws Exception {		
		return rService.listAll(b_num);
	}
	
}
