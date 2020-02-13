package com.local.team1.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.local.team1.domain.BoardVo;
import com.local.team1.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Resource
	private String uploadPath;
	
	@Inject
	private BoardService bService;
	
	// 상세보기
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam("s_cate") String s_cate) throws Exception {
		List<BoardVo> list = bService.list(s_cate);
		model.addAttribute("list", list);
		return "board/detail";
	}
	
	// 명소 등록창
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String regist() throws Exception {
		return "board/regist";
	}
	
	// 명소 등록
	@RequestMapping(value = "/registPro", method = RequestMethod.POST)
	public String registPro(BoardVo vo, MultipartHttpServletRequest req) throws Exception {
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
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	     String s_pic = safeFile.substring(uploadPath.length());
	     System.out.println(s_pic);
	     vo.setS_pic(s_pic);
		bService.regist(vo);
		return "board/home";
	}
	
	@RequestMapping(value = "/displayFile", method =  RequestMethod.GET)
	@ResponseBody
	public byte[] displayFile(@RequestParam("fileName") String fileName) throws Exception {
		String realPath = uploadPath + File.separator + fileName.replace("/", "\\");
		System.out.println("realPath:"+ realPath);
		FileInputStream is = new FileInputStream(realPath);
		byte[] bytes = IOUtils.toByteArray(is);
		is.close();
		return bytes;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() throws Exception {
		
		return "board/home";
	}
	
	// 자유게시판
	@RequestMapping(value = "/freeBoard", method = RequestMethod.GET)
	public String freeBoard() throws Exception {
		return "board/freeBoard";
	}

}
