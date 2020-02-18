package com.local.team1.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.local.team1.domain.BoardVo;
import com.local.team1.domain.PagingDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	private static final String NAMESPACE = "com.local.mappers.boardMapper";
	
	@Inject
	private SqlSession sqlsession;
	
	
	@Override
	public void create(BoardVo vo) throws Exception {
		sqlsession.insert(NAMESPACE + ".create", vo);
		
	}

	@Override
	public BoardVo read(Integer s_id) throws Exception {
		return sqlsession.selectOne(NAMESPACE + ".read", s_id);
	}

	@Override
	public void update(BoardVo vo) throws Exception {
		sqlsession.update(NAMESPACE + ".update", vo);
		
	}
	
	@Override
	public void delete(Integer s_id) throws Exception {
		sqlsession.delete(NAMESPACE + ".delete", s_id);

	}

	@Override
	public List<BoardVo> list(String s_cate, PagingDto dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("s_cate", s_cate);
		paramMap.put("dto", dto);
		return sqlsession.selectList(NAMESPACE + ".list", paramMap);
	}

	@Override
	public List<BoardVo> editList() throws Exception {
		return sqlsession.selectList(NAMESPACE + ".editList");
	}

	@Override
	public void updateData(BoardVo vo) throws Exception {
		sqlsession.update(NAMESPACE + ".updateData", vo);
	}

	@Override
	public int totalCount(String s_cate) throws Exception {
		
		return sqlsession.selectOne(NAMESPACE + ".totalCount", s_cate);
	}


}
