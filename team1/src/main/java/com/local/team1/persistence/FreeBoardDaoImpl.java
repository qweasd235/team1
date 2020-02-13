package com.local.team1.persistence;

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

}
