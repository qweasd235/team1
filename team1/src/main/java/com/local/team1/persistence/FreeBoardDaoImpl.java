package com.local.team1.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.local.team1.domain.FreeBoardVo;

@Repository
public class FreeBoardDaoImpl implements FreeBoardDao {

	private static final String NAMESPACE = "com.local.mappers.freeBoardMapper";
	
	@Inject
	private SqlSession sqlsession;
	
	@Override
	public void create(FreeBoardVo fb_vo) throws Exception {
		sqlsession.insert(NAMESPACE + ".create", fb_vo);
	}

	@Override
	public List<FreeBoardVo> listAll() throws Exception {
		return sqlsession.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public FreeBoardVo read(int b_num) throws Exception {		
		return sqlsession.selectOne(NAMESPACE + ".read", b_num);
	}

}
