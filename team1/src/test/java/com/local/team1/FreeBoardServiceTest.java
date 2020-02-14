package com.local.team1;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.local.team1.service.FreeBoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class FreeBoardServiceTest {

	@Inject
	private FreeBoardService service;
	
	@Test
	public void listAllTest() throws Exception {
		service.listAll();
	}
	
	@Test
	public void readTest() throws Exception {
		service.read(25);
	}
	
}
