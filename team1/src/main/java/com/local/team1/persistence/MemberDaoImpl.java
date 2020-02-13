package com.local.team1.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.local.team1.domain.MemberVo;
@Repository
public class MemberDaoImpl implements MemberDao {
	
	private static final String NAMESPACE = "com.local.mappers.memberMapper";
	
	@Inject
	private SqlSession sqlSession;


	@Override
	public void insertMember(MemberVo vo) {
		sqlSession.insert(NAMESPACE + ".insertMember", vo);
	}

	@Override
	public int readMember(String mem_id) {
		return sqlSession.selectOne(NAMESPACE + ".readMember", mem_id);
	}

	@Override
	public MemberVo readWithPw(String mem_id, String mem_pw) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mem_id", mem_id);
		paramMap.put("mem_pw", mem_pw);
		return sqlSession.selectOne(NAMESPACE + ".readWithPw", paramMap);
	}

}
