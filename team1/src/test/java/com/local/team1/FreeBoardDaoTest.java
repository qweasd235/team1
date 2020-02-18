package com.local.team1;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.local.team1.domain.FreeBoardVo;
import com.local.team1.domain.ReplyVo;
import com.local.team1.persistence.FreeBoardDao;
import com.local.team1.persistence.ReplyDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class FreeBoardDaoTest {

	@Inject
	private FreeBoardDao dao;
	@Inject
	private ReplyDao rDao;
	
	@Test
	public void createTest() throws Exception {
		FreeBoardVo fb_vo = new FreeBoardVo();
		fb_vo.setB_title("testTitle");
		fb_vo.setB_content("testContent");
		fb_vo.setB_writer("user01");
		
		dao.create(fb_vo);
	}
	
	
//	public void listAllTest() throws Exception {
//		dao.listAll();
//	}
	
	@Test
	public void readTest() throws Exception {
		dao.read(25);
	}
	
	@Test
	public void modifyTest() throws Exception {
		FreeBoardVo fb_vo = new FreeBoardVo();
		fb_vo.setB_title("수정수정수정1");
		fb_vo.setB_content("수정수정수정1");
		fb_vo.setB_num(24);
		dao.modify(fb_vo);
	}
	
	@Test
	public void deleteTest() throws Exception {
		dao.delete(24);
	}
	
	@Test
	public void reply_createTest() throws Exception {
		ReplyVo vo = new ReplyVo();
		vo.setB_num(203);
		vo.setR_writer("kbs");
		vo.setR_content("리플 테스트");
		
		rDao.create(vo);
		
	}
}
