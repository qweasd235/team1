package com.local.team1.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.local.team1.domain.FreeBoardVo;
import com.local.team1.domain.MemberVo;
import com.local.team1.domain.PagingDto;
import com.local.team1.service.FreeBoardService;

@Controller
@RequestMapping("/board/*")
public class FreeBoardController {
	
	@Resource
	private String uploadPath;
	
	@Inject
	private FreeBoardService fb_Service;
	
	// 자유게시판 전체목록
	@RequestMapping(value = "/freeBoardList", method = RequestMethod.GET)
	public String freeBoard(Model model, PagingDto pagingDto) throws Exception {		
		List<FreeBoardVo> list = fb_Service.listAll(pagingDto);	 
		int totalCount =  fb_Service.totalCount(pagingDto); // 글 총 갯수 구하기
		pagingDto.setTotalCount(totalCount);		
		model.addAttribute("list", list);		
		model.addAttribute("pagingDto", pagingDto);		
		return "board/freeBoardList";
	}
	
	// 게시판 글쓰기창
	@RequestMapping(value = "/fbRegisterGet", method = RequestMethod.GET)
	public String freeBoardRestierGet() throws Exception {
		
		return "board/freeBoardRegister";
	}
	
	// 게시판 글쓰기처리
	@RequestMapping(value = "/fbRegisterPOST", method = RequestMethod.POST)
	public String freeBoardResterPost(FreeBoardVo fb_vo, HttpSession session, MultipartHttpServletRequest req) throws Exception {
		String b_pic = dataUpload(req);
		MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		System.out.println("memberVo == " + memberVo);
		fb_vo.setB_writer(memberVo.getMem_id());
		fb_vo.setB_pic(b_pic);
		fb_Service.create(fb_vo);
		return "redirect:/board/freeBoardList";
	}
		
	// 게시판 상세보기
	@RequestMapping(value = "/fbRead", method = RequestMethod.GET)
	public String freeBoardRead(@RequestParam("b_num") int b_num, Model model, 
								HttpSession session, @ModelAttribute PagingDto pagingDto) throws Exception {
		FreeBoardVo fb_vo = fb_Service.read(b_num);
		model.addAttribute("fb_vo", fb_vo);
		MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		model.addAttribute("memberVo", memberVo);
		return "board/freeBoardContent";
	}
	
	// 게시판 글 수정하기	
	@RequestMapping(value = "/fbModify", method = RequestMethod.POST)
	public String freeBoardModify(FreeBoardVo fb_vo, Model model, MultipartHttpServletRequest req) throws Exception {
		System.out.println("fb_vo == " + fb_vo);
		String b_pic = dataUpload(req);				
		if (b_pic.equals("")) {			
			fb_Service.modify(fb_vo);
		} else {
			fb_vo.setB_pic(b_pic);			
			fb_Service.modify_b_pic(fb_vo);
		}				
		return "redirect:/board/freeBoardList";
	}
	
	// 게시판 글 삭제하기
	@RequestMapping(value = "/fbDelete", method = RequestMethod.GET)
	public String freeBoardDelete(@RequestParam("b_num") int b_num, 
									@RequestParam("fileName") String fileName) throws Exception {
		fb_Service.delete(b_num);
		if(!fileName.equals("")) {
			boardFileDelete(fileName);
		}
		return "redirect:/board/freeBoardList";
	}
	
	// 게시판 글 답글쓰기 폼
	@RequestMapping(value = "/fbCommentGET", method = RequestMethod.GET)
	public String freeBoardCommentGET(@RequestParam("b_num") int b_num, Model model) throws Exception {
		FreeBoardVo fb_vo = fb_Service.read(b_num);
		model.addAttribute("fb_vo", fb_vo);
		return "board/freeBoard_CommentRegister";
	}
	
	// 답글쓰기 처리
	@RequestMapping(value = "/fbCommentPOST", method = RequestMethod.POST)
	public String freeBoardCommentPost(FreeBoardVo fb_vo, HttpSession session, MultipartHttpServletRequest req) throws Exception {
		String b_pic = dataUpload(req);
		MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		fb_vo.setB_writer(memberVo.getMem_id());
		fb_vo.setB_pic(b_pic);
		System.out.println("ref == " + fb_vo.getB_ref());
		System.out.println("step == " + fb_vo.getB_step());
		System.out.println("level == " + fb_vo.getB_level());
		fb_Service.comment_Create(fb_vo);
		return "redirect:/board/freeBoardList";
	}
	
	//파일첨부 메쏘드
		public String dataUpload(MultipartHttpServletRequest req) {
			    MultipartFile mFile = req.getFile("file");
			
		        String src = req.getParameter("src");	        

		        String originFileName = mFile.getOriginalFilename(); // 원본 파일 명
		        long fileSize = mFile.getSize(); // 파일 사이즈		        		        		        

		        String safeFile = uploadPath + System.currentTimeMillis() + originFileName;

		        try {
		        	mFile.transferTo(new File(safeFile));
		        } catch (IllegalStateException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        
		        String b_pic = "";
		        	
		        if(!originFileName.equals("")) {
		        	b_pic = safeFile.substring(uploadPath.length());
		        }
		        
		        return b_pic;
		}
		
		//서버 파일 삭제
		@ResponseBody
		public String boardFileDelete(String fileName) {
		String path = uploadPath + fileName;
		File file = new File(path);		
		if(file.exists() == true){		   
			file.delete();
		}		
		return null;
	} 
		
}
