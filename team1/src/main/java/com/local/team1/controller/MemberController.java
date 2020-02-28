package com.local.team1.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.local.team1.domain.LoginDto;
import com.local.team1.domain.MemberVo;
import com.local.team1.service.MemberService;

@Controller
@RequestMapping("/mem/*")
public class MemberController {
	
	@Resource
	private String uploadPath;

	@Inject
	private MemberService memberService;
	
	//서버 파일 접속
		@RequestMapping(value = "/displayFile", method =  RequestMethod.GET)
		@ResponseBody
		public byte[] displayFile(@RequestParam("fileName") String fileName) throws Exception {
			String realPath = uploadPath + File.separator + fileName.replace("/", "\\");
//			System.out.println("realPath:"+ realPath);
			FileInputStream is = new FileInputStream(realPath);
			byte[] bytes = IOUtils.toByteArray(is);
			is.close();
			return bytes;
		}
	
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
		String targetLocation = (String)session.getAttribute("targetLocation");
		String redirectPage = "/board/home";
		
		if(memberVo != null) {
			if(memberVo.getAuth_key().equals("y")) {
				System.out.println("y");
				 session.setAttribute("msg", "Y");
			} else if(memberVo.getAuth_key().equals("N")) {
				session.setAttribute("msg", "notVerify");
				return "redirect:/mem/loginGet";
			}
		} else {
			session.setAttribute("msg", "notCorrect");
			return "redirect:/mem/loginGet";
		}
		
		if (targetLocation != null) {
			redirectPage = targetLocation;
		}
		System.out.println("redirectPage:" + redirectPage);
		
			model.addAttribute("memberVo", memberVo);
			return "redirect:" + redirectPage;
	}
	
	
	//아이디 중복체크
	@ResponseBody
	@RequestMapping(value="/checkId", method = RequestMethod.POST)
	public int checkId(MemberVo vo, String mem_id) throws Exception{
		int result = memberService.CheckId(mem_id);
		return result;
	}
	
	//회원가입 get
	@RequestMapping(value="/joinGet", method= RequestMethod.GET)
	public String joinGet() throws Exception{
		return "/member/join";
	}
	
	// 회원가입 post 처리
	@RequestMapping(value="/joinPost", method= RequestMethod.POST)
	public String joinPost(MemberVo vo, MultipartHttpServletRequest req) throws Exception {
		
		System.out.println(vo);
		String mem_id = vo.getMem_id();
		
		int result = memberService.CheckId(mem_id);
		
		if(result == 1) {
			return "/mem/join";
		}else if(result == 0) {
			String mem_pic = dataUpload(req);
			vo.setMem_pic(mem_pic);
			memberService.join(vo);
			
		}
				
		return "/member/auth_confirm";
	}
	
	//파일첨부 메쏘드
		public String dataUpload(MultipartHttpServletRequest req) {
			    MultipartFile mFile = req.getFile("file");
			
		        String src = req.getParameter("src");
		        System.out.println("src value : " + src);

		        String originFileName = mFile.getOriginalFilename(); // 원본 파일 명
		        long fileSize = mFile.getSize(); // 파일 사이즈
		        
		        
		        System.out.println("originFileName : " + originFileName);
		        System.out.println("fileSize : " + fileSize);

		        String safeFile = uploadPath + System.currentTimeMillis() + originFileName;

		        try {
		        	mFile.transferTo(new File(safeFile));
		        } catch (IllegalStateException e) {
		            
		            e.printStackTrace();
		        } catch (IOException e) {
		            
		            e.printStackTrace();
		        }
		        
		        String mem_pic = "";
		        	
		        if(!originFileName.equals("")) {
		        	mem_pic = safeFile.substring(uploadPath.length());
		        }
		        
		        return mem_pic;
		}
	
	
	//로그아웃 처리
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
	// 회원정보 변경 페이지
	@RequestMapping(value="/editmemGet", method=RequestMethod.GET)
	public String memInfo() throws Exception{
		
//		System.out.println(mem_id);
//		model.addAttribute("vo", vo);
		return "member/editmem";
	}
	
	// 회원정보 변경 post
	@RequestMapping(value="/editmemPost", method=RequestMethod.POST)
	public String memInfoPost(MemberVo vo, MultipartHttpServletRequest req) throws Exception{

		System.out.println(vo);
		
	   String file = dataUpload(req);
		vo.setMem_pic(file);
		String mem_pic = vo.getMem_pic();
		System.out.println(mem_pic);
		if(!mem_pic.equals("")) {
			System.out.println("1번");
			System.out.println("mem_pic:" + mem_pic);
			memberService.modifyMember(vo);
		}else {
			System.out.println("2번");
			vo.setMem_pic(mem_pic);
			System.out.println("mem_pic:" + mem_pic);
			memberService.modifyNopic(vo);
		}
		return "redirect:/board/home";
	}
	

	// 비밀번호 변경 페이지 이동
	@RequestMapping(value="/pw_changeGet", method=RequestMethod.GET)
		public String pw_changeGet() throws Exception{
		
			return "member/pw_change";
	}
	
	// 비밀번호 변경 post
	@RequestMapping(value="/pw_changePost", method=RequestMethod.POST)	
	public String pw_changePost(String old_mem_pw, String mem_pw, String mem_pw2, HttpSession session) throws Exception{
		
		MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		
		String cur_mem_pw = memberVo.getMem_pw();
		// 현재 비밀번호가 맞지 않으면
		if (!old_mem_pw.equals(cur_mem_pw)) {
			session.setAttribute("msg", "pw_change_fail");
			return "redirect:/mem/pw_changeGet";
		}else if(!mem_pw.equals(mem_pw2)){
			session.setAttribute("msg", "pw_not_equal");
			return "redirect:/mem/pw_changeGet";
		}else {
		// 비밀번호를 새로운 비밀번호로 변경
		String mem_id = memberVo.getMem_id();
		
//		int result = memberService.CheckPw(old_mem_pw);
		
//		if(result == 1) {
//			session.setAttribute("msg", "pw_change_fail");
//			return "redirect:/mem/pw_changeGet";
//		}
		
		session.setAttribute("msg", "pw_change_success");
		memberService.pw_change(mem_pw, mem_id);
		}
		return "redirect:/board/home";
	}

	@RequestMapping(value = "/deletePic" , method = RequestMethod.GET)
	@ResponseBody
	public String deletePic(HttpSession session) throws Exception {
		MemberVo vo = (MemberVo)session.getAttribute("memberVo");
		String mem_id = vo.getMem_id();
		System.out.println("도달");
		System.out.println(mem_id);
		memberService.deletePic(mem_id);
		return "success";
	}

	//이메일인증
	@RequestMapping(value = "/emailConfirm", method = RequestMethod.GET)
	public String emailConfirm(MemberVo vo, Model model) throws Exception { // 이메일인증
		System.out.println(vo);
		memberService.verifyMember(vo);
		model.addAttribute("mem_id", vo.getMem_id());

		return "member/auth_success";
	}

}
