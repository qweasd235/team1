package com.local.team1.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
		if(memberVo == null) {
			session.setAttribute("msg", "login_fail");
			return "redirect:/mem/loginGet";
		}
//		else {
//			session.setAttribute("msg", "login_success");
//		}
			model.addAttribute("memberVo", memberVo);
		return "redirect:/board/home" ;
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
	public String joinPost(MemberVo vo, String mem_id, MultipartHttpServletRequest req) throws Exception{
		
		int result = memberService.CheckId(mem_id);
		try {
			if(result == 1) {
				return "/mem/join";
			}else if(result == 0) {
				String mem_pic = dataUpload(req);
				vo.setMem_pic(mem_pic);
				memberService.join(vo);
			}
		}catch(Exception e) {
			throw new RuntimeException();
		}
		
		return "redirect:/";
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
	
}
