package com.local.team1.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.local.team1.domain.BoardVo;

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

}
