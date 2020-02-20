package com.local.team1.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.local.team1.domain.MarkVo;



@Repository
public class MarkDaoImpl implements MarkDao {

	private static final String NAMESPACE = "com.local.mappers.markMapper";

	@Inject
	private SqlSession sqlSession;

	@Override
	public void create(MarkVo vo) throws Exception {
		sqlSession.insert(NAMESPACE + ".markCreate", vo);
	}

}
