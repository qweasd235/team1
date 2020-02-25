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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String joinPost(MemberVo vo, String mem_id, MultipartHttpServletRequest req) throws Exception {
		
		int result = memberService.CheckId(mem_id);
		
		if(result == 1) {
			return "/mem/join";
		}else if(result == 0) {
			String mem_pic = dataUpload(req);
			vo.setMem_pic(mem_pic);
			memberService.join(vo);
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
	
//	//비밀번호 찾기 - 이메일 발송
//	 @RequestMapping(value = "/pw_find", method = RequestMethod.POST)
//     public ModelAndView pw_find(HttpServletRequest request, String mem_id, String mem_email,
//             HttpServletResponse response_email) throws IOException{
//		 //랜덤한 난수를 이메일로 보내고 그 인증번호 입력하면 비밀번호 변경 페이지로 이동
//		 Random r = new Random();
//         int dice = r.nextInt(157211)+48271;
//         
//         String setfrom = "dlgkstjq623@gmail.com";
//         String tomail = request.getParameter("mem_email");    //받는 사람의 이메일
//         String title = "비밀번호 찾기 인증 이메일 입니다.";    //제목
//         String content =
//         
//                 System.getProperty("line.separator")+
//                 
//                 System.getProperty("line.separator")+
//                         
//                 "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다"
//                 
//                 +System.getProperty("line.separator")+
//                 
//                 System.getProperty("line.separator")+
//         
//                 "비밀번호 찾기 인증번호는 " +dice+ " 입니다. "
//                 
//                 +System.getProperty("line.separator")+
//                 
//                 System.getProperty("line.separator")+
//                 
//                 "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용
//         
//         try {
//
//             MimeMessage message = mailSender.createMimeMessage();
//             MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
//
//             messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
//             messageHelper.setTo(tomail); // 받는사람 이메일
//             messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
//             messageHelper.setText(content); // 메일 내용
//             
//             mailSender.send(message);
//     
//         } catch (Exception e) {
//             System.out.println(e);
//         }
//         
//         
//         ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
//         mv.setViewName("/member/pass_email");     //뷰의이름
//         mv.addObject("dice", dice);
//         mv.addObject("mem_email", mem_email);
//         
//         System.out.println("mv : "+mv);
//
//         response_email.setContentType("text/html; charset=UTF-8");
//         PrintWriter out_email = response_email.getWriter();
//         out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
//         out_email.flush();
//         
//         
//         return mv;
//         
//     }

}
