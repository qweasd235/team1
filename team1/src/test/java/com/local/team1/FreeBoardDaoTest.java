package com.local.team1;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.local.team1.domain.FreeBoardVo;
import com.local.team1.persistence.FreeBoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class FreeBoardDaoTest {

	@Inject
	private FreeBoardDao dao;
	
	@Test
	public void createTest() throws Exception {
		FreeBoardVo fb_vo = new FreeBoardVo();
		fb_vo.setB_title("testTitle");
		fb_vo.setB_content("testContent");
		fb_vo.setB_writer("user01");
		
		dao.create(fb_vo);
	}
	
	@Test
	public void listAllTest() throws Exception {
		dao.listAll();
	}
	
	@Test
	public void readTest() throws Exception {
		dao.read(25);
	}
}
