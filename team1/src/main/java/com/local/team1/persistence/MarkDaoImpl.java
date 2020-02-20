package com.local.team1.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public List<MarkVo> markList(int s_id) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".markListAll", s_id);
	}

	@Override
	public void deleteMark(int s_id, int m_id) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("s_id", s_id);
		paramMap.put("m_id", m_id);
		sqlSession.delete(NAMESPACE + ".markDelete", paramMap);
	}

}
