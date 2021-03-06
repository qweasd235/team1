package com.local.team1.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.local.team1.domain.BoardVo;
import com.local.team1.domain.PagingDto;
import com.local.team1.service.BoardService;
import com.local.team1.service.MarkService;


@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Resource
	private String uploadPath;
	
	@Inject
	private BoardService bService;
	
	@Inject
	private MarkService mService;
	
	// 상세보기
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam("s_cate") String s_cate, PagingDto dto) throws Exception {
//		System.out.println(dto);
//		System.out.println(dto.getStartRow());
//		System.out.println(dto.getEndRow());
		List<BoardVo> list = bService.list(s_cate, dto);
//		System.out.println(list);
//		System.out.println("list:"+ list);
		int totalCount = bService.totalCount(s_cate);
//		System.out.println(totalCount);
		dto.setTotalCount(totalCount);
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
		model.addAttribute("s_cate", s_cate);
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
//	     System.out.println(vo);
//	     System.out.println(s_pic);
	     vo.setS_pic(s_pic);
	     System.out.println(vo);
		bService.regist(vo);
		return "redirect:/board/home";
	}
	//서버 파일 접속
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
	
	//수정페이지 연결
	@RequestMapping(value = "/editPage", method = RequestMethod.GET)
	public String editSpot(Model model, PagingDto dto) throws Exception {
		List<BoardVo> list = bService.editList(dto);
		int totalCount = bService.totalCountEdit();
		System.out.println(totalCount);
		dto.setTotalCount(totalCount);
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
		return "board/editPage";
	}
	
	//명소 삭제
	@RequestMapping(value = "/delSpot", method = RequestMethod.GET)
	public String delete(@RequestParam("s_id") int s_id, 
						 @RequestParam("fileName") String fileName) throws Exception {
//		System.out.println("delSpot!");
//		System.out.println(s_id);
		bService.delete(s_id);
		if(!fileName.equals("")) {
			boardFileDelete(fileName);
		}
		
		return "redirect:/board/editPage";
	}
	
	//명소 수정 폼
	@RequestMapping(value = "/editSpot", method = RequestMethod.GET)
	public String edit(@RequestParam("s_id") int s_id, Model model, @ModelAttribute PagingDto dto) throws Exception {
//		System.out.println(s_id);
		BoardVo vo = bService.read(s_id);
		model.addAttribute("vo", vo);
		return "/board/editSpotForm";
	}
	//명소 수정 프로
	@RequestMapping(value = "/editSpotPro", method = RequestMethod.POST)
	public String editPro(BoardVo vo, MultipartHttpServletRequest req, @ModelAttribute PagingDto dto) throws Exception {
//		System.out.println(vo);
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
		return "redirect:/board/editPage?page=" + dto.getPage(); 
	}

	// 메인페이지
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) throws Exception {
		List<BoardVo> list = bService.homeList();
		model.addAttribute("list", list);
		return "board/home";
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
	
	//명소 상세보기
	@RequestMapping(value = "/detailContent", method = RequestMethod.GET)
	public String detailContent(@RequestParam("s_id") int s_id, Model model) throws Exception {
//		System.out.println(s_id);
		
		int total = mService.totalMark(s_id);
		
		if(total > 0) {
		
		double avg = mService.avgMark(s_id);
		String str_avg =String.format("%.2f", avg);
		
		
//		System.out.println(avg);
		System.out.println(str_avg);
		System.out.println(total);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("avg", str_avg);
		paramMap.put("total", total);
		model.addAttribute("paramMap", paramMap);
		}
		
		BoardVo vo = bService.detailContent(s_id);
		model.addAttribute("vo", vo);
		
		return "/board/detailSpot";
	}
	
}
