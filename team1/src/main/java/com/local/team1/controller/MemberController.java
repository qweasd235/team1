package com.local.team1.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.local.team1.domain.LoginDto;
import com.local.team1.domain.MemberVo;
import com.local.team1.service.MemberService;

@Controller
@RequestMapping("/mem")
public class MemberController {

	@Inject
	private MemberService memberService;
	
	// 로그인 폼
	@RequestMapping(value = "/loginGet", method = RequestMethod.GET)
	public String loginGet() throws Exception{
		return "/member/login";
	}
	
	// 로그인 post
	@RequestMapping(value="/loginPost", method= RequestMethod.POST)
	public String loginPost(HttpSession session, LoginDto loginDto, Model model) throws Exception{
		MemberVo memberVo = memberService.login(loginDto);
				
		System.out.println("loginDto:" + loginDto);
		System.out.println("memberVo:" + memberVo);
		if(memberVo == null) {
			return "redirect:/mem/loginGet";
		}
		
		String targetLocation = (String)session.getAttribute("targetLocation");
		String redirectPage = "/board/home";
		if(targetLocation != null) {
			redirectPage = targetLocation;
		}
		
		model.addAttribute("memberVo", memberVo);
		return "redirect:" + redirectPage;
	}
	
	//회원가입 get
	@RequestMapping(value="/joinGet", method= RequestMethod.GET)
	public String joinGet() throws Exception{
		return "/member/join";
	}
	
	// 회원가입 post 처리
	@RequestMapping(value="/joinPost", method= RequestMethod.POST)
	public String joinPost(MemberVo vo) throws Exception{
		memberService.join(vo);
		
		return "redirect:/board/home";
	}
	
	
	//로그아웃 처리
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/";
	}
}
