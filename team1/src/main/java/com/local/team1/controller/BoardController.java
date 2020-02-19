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
import com.local.team1.domain.PagingDto;
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
	public String detail(Model model, @RequestParam("s_cate") String s_cate, PagingDto dto) throws Exception {
		System.out.println(dto);
		System.out.println(dto.getStartRow());
		System.out.println(dto.getEndRow());
		List<BoardVo> list = bService.list(s_cate, dto);
		System.out.println("list:"+ list);
		int totalCount = bService.totalCount(s_cate);
		System.out.println(totalCount);
		dto.setTotalCount(totalCount);
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
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
		 String s_pic = dataUpload(req);
	     System.out.println(vo);
	     System.out.println(s_pic);
	     vo.setS_pic(s_pic);
	     System.out.println(vo);
		bService.regist(vo);
		return "redirect:/board/home";
	}
	
	@RequestMapping(value = "/displayFile", method =  RequestMethod.GET)
	@ResponseBody
	public byte[] displayFile(@RequestParam("fileName") String fileName) throws Exception {
		String realPath = uploadPath + File.separator + fileName.replace("/", "\\");
//		System.out.println("realPath:"+ realPath);
		FileInputStream is = new FileInputStream(realPath);
		byte[] bytes = IOUtils.toByteArray(is);
		is.close();
		return bytes;
	}
	
	@RequestMapping(value = "/editPage", method = RequestMethod.GET)
	public String editSpot(Model model) throws Exception {
		List<BoardVo> list = bService.editList();
		model.addAttribute("list", list);
		return "board/editPage";
	}
	
	@RequestMapping(value = "/delSpot", method = RequestMethod.GET)
	public String delete(@RequestParam("s_id") int s_id, 
						 @RequestParam("fileName") String fileName) throws Exception {
		System.out.println("delSpot!");
		System.out.println(s_id);
		bService.delete(s_id);
		boardFileDelete(fileName);
		return "redirect:/board/editPage";
	}
	@RequestMapping(value = "/editSpot", method = RequestMethod.GET)
	public String edit(@RequestParam("s_id") int s_id, Model model) throws Exception {
		System.out.println(s_id);
		BoardVo vo = bService.read(s_id);
		model.addAttribute("vo", vo);
		return "/board/editSpotForm";
	}
	
	@RequestMapping(value = "/editSpotPro", method = RequestMethod.POST)
	public String editPro(BoardVo vo, MultipartHttpServletRequest req) throws Exception {
		System.out.println(vo);
		String file = dataUpload(req);
		vo.setS_pic(file);
		String s_pic = vo.getS_pic();
		System.out.println(s_pic);
		if (s_pic.equals("")) {
			System.out.println("1번");
			System.out.println(s_pic);
			bService.modifyNoData(vo);
		} else {
			vo.setS_pic(s_pic);
			System.out.println("2번번");
			System.out.println(s_pic);
			bService.modify(vo);
		}
		return "redirect:/board/editPage";
	}

	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) throws Exception {
		List<BoardVo> list = bService.editList();
		model.addAttribute("list", list);
		return "board/home";
	}		

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
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        String s_pic = "";
	        	
	        if(!originFileName.equals("")) {
	        	s_pic = safeFile.substring(uploadPath.length());
	        }
	        
	        return s_pic;
	}
	
	@ResponseBody
	public String boardFileDelete(String fileName) {

	String path = uploadPath + fileName;

	File file = new File(path);
	
	if(file.exists() == true){
	   
		file.delete();

	}
	
	return null;
} 
	@RequestMapping(value = "/detailContent", method = RequestMethod.GET)
	public String detailContent(@RequestParam("s_id") int s_id, Model model) throws Exception {
		System.out.println(s_id);
		BoardVo vo = bService.detailContent(s_id);
		model.addAttribute("vo", vo);
		return "/board/detailSpot";
	}
	
	
}
