package com.local.team1.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.local.team1.domain.MarkVo;
import com.local.team1.persistence.MarkDao;

@Service
public class MarkServiceImpl implements MarkService {

	@Inject
	private MarkDao dao;
	
	@Override
	public void create(MarkVo vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public List<MarkVo> markList(int s_id) throws Exception {
		return dao.markList(s_id);
	}

	@Override
	public void markDelete(int s_id, int m_id) throws Exception {
		dao.deleteMark(s_id, m_id);
	}

	@Override
	public int totalMark(int s_id) throws Exception {
		return dao.totalMark(s_id);
	}

	@Override
	public double avgMark(int s_id) throws Exception {
		return dao.avgMark(s_id);
	}

}
