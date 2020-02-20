package com.local.team1.controller;

import javax.inject.Inject;

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
}
