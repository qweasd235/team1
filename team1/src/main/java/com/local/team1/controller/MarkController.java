package com.local.team1.controller;


import java.util.List;


import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.local.team1.domain.MarkVo;
import com.local.team1.service.MarkService;

@RestController
@RequestMapping("/mark/*")
public class MarkController {

	@Inject
	private MarkService mService;

	// 리플 쓰기
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String create(@RequestBody MarkVo vo) throws Exception {
		System.out.println(vo);
		mService.create(vo);
		return "reply_success";
	}

	// 리플 목록
	@RequestMapping(value = "/listAll/{s_id}", method = RequestMethod.GET)
	public List<MarkVo> listAll(@PathVariable("s_id") int s_id) throws Exception {
		System.out.println(s_id);
		return mService.markList(s_id);
	}

	// 리플 삭제
	@RequestMapping(value = "delete/{m_id}/{s_id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("s_id") int s_id, @PathVariable("m_id") int m_id) throws Exception {
		mService.markDelete(s_id, m_id);
		return "success";
	}
	//리플 수정
	@RequestMapping(value = "/editMark", method = RequestMethod.PUT)
	public String edit(@RequestBody MarkVo vo) throws Exception {
		System.out.println(vo);
		mService.editMark(vo);
		return "success";
	}
}
