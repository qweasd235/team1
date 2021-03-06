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
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("mem_id", mem_id);
		paramMap.put("mem_pw", mem_pw);
		return sqlSession.selectOne(NAMESPACE + ".readWithPw", paramMap);
	}

	@Override
	public void updateMember(MemberVo vo) throws Exception {
		sqlSession.update(NAMESPACE + ".updateMember", vo);
		
	}

	@Override
	public void updateNopic(MemberVo vo) throws Exception {
		sqlSession.update(NAMESPACE + ".updateNopic", vo);
		
	}

	@Override
	public MemberVo readMemInfo(String mem_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".readMemInfo", mem_id);
	}

	@Override
	public int update_pw(String mem_pw, String mem_id) throws Exception {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("mem_pw", mem_pw);
		paramMap.put("mem_id", mem_id);
		return sqlSession.update(NAMESPACE + ".update_pw", paramMap);
	}

	@Override
	public int readPw(String mem_pw) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".readPw", mem_pw);
	}
	@Override
	public void deletePic(String mem_id) throws Exception {
		sqlSession.update(NAMESPACE + ".updatePic", mem_id);
		

	}

//	@Override
//	public void createAuthKey(String mem_email, String auth_key) throws Exception {
//		MemberVo vo = new MemberVo();
//		vo.setAuth_key(auth_key);
//		vo.setMem_email(mem_email);
//		
//		sqlSession.update(NAMESPACE + ".createAuthKey", vo);
//		
//	}
	
	@Override
	public void verifyMember(MemberVo vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE + ".verifyMember", vo);
	}

}
