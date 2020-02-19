package com.local.team1.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.local.team1.domain.BoardVo;
import com.local.team1.domain.PagingDto;
import com.local.team1.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDao dao;

	@Override
	public void regist(BoardVo vo) throws Exception {
		dao.create(vo);

	}

	@Override
	public BoardVo read(Integer s_id) throws Exception {

		return dao.read(s_id);
	}

	@Override
	public void modify(BoardVo vo) throws Exception {
		dao.update(vo);

	}

	@Override
	public void delete(Integer s_id) throws Exception {
		dao.delete(s_id);
	}

	@Override
	public List<BoardVo> list(String s_cate, PagingDto dto) throws Exception {
		return dao.list(s_cate, dto);
	}

	@Override
	public List<BoardVo> editList(PagingDto dto) throws Exception {
		return dao.editList(dto);
	}

	@Override
	public void modifyNoData(BoardVo vo) throws Exception {
		dao.updateData(vo);
		
	}

	@Override
	public int totalCount(String s_cate) throws Exception {
		return dao.totalCount(s_cate);
	}

	@Override
	public BoardVo detailContent(int s_id) throws Exception {
		return dao.detailContent(s_id);
	}

	@Override
	public List<BoardVo> homeList() throws Exception {
		return dao.homeList();
	}

	@Override
	public int totalCountEdit() throws Exception {
		return dao.totalCountEdit();
	}

}
