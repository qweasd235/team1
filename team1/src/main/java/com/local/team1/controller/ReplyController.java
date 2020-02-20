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
	
	// 댓글 수정
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String update(@RequestBody ReplyVo r_vo) throws Exception {
		rService.modify(r_vo);
		return "success";
	}
		
	// 댓글 삭제
	@RequestMapping(value = "/delete/{r_num}/{b_num}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("r_num") int r_num, @PathVariable("b_num") int b_num) throws Exception {
		// b_num 은 해당 게시글의 댓글 한번에 삭제하기위해 지금은 잠시 안씀
		rService.delete(r_num);
		return "success";
	}
	
	
}
