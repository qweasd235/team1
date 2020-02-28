package com.local.team1.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.local.team1.domain.FreeBoardVo;
import com.local.team1.domain.ReplyVo;
import com.local.team1.persistence.FreeBoardDao;
import com.local.team1.persistence.ReplyDao;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDao dao;
	
	@Inject
	private FreeBoardDao fb_dao;

	@Transactional
	@Override
	public void create(ReplyVo r_vo) throws Exception {
		dao.create(r_vo);
		fb_dao.reply_count(1, r_vo.getB_num());
	}

	@Override
	public List<ReplyVo> listAll(int b_num) throws Exception {
		return dao.listAll(b_num);
	}

	@Override
	public void modify(ReplyVo r_vo) throws Exception {
		dao.modify(r_vo);
	}

	@Transactional
	@Override
	public void delete(int r_num, int b_num) throws Exception {
		dao.delete(r_num);
		fb_dao.reply_count(-1, b_num);
	}

}
