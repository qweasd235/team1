package com.local.team1.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.local.team1.domain.FreeBoardVo;
import com.local.team1.domain.PagingDto;
import com.local.team1.persistence.FreeBoardDao;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {
	
	@Inject
	private FreeBoardDao dao;

	@Override
	public void create(FreeBoardVo fb_vo) throws Exception {
		dao.create(fb_vo);
	}

	@Override
	public List<FreeBoardVo> listAll(PagingDto pagingDto) throws Exception {
//		List<FreeBoardVo> list = dao.listAll();
		
		return dao.listAll(pagingDto);
	}

	@Override
	public FreeBoardVo read(int b_num) throws Exception {
		dao.read_count(b_num);
		return dao.read(b_num);
	}

	@Override
	public void modify(FreeBoardVo fb_vo) throws Exception {
		dao.modify(fb_vo);		
	}
	
	@Override
	public void modify_b_pic(FreeBoardVo fb_vo) throws Exception {
		dao.modify_b_pic(fb_vo);
	}

	@Override
	public void delete(int b_num) throws Exception {
		dao.delete(b_num);
	}

	@Override
	public int totalCount(PagingDto pagingDto) throws Exception {
		return dao.totalCount(pagingDto);
	}

	

}
