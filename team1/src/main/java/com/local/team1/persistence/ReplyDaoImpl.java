package com.local.team1.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.local.team1.domain.FreeBoardVo;
import com.local.team1.domain.ReplyVo;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	
	private static final String NAMESPACE = "com.local.mappers.replyMapper";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void create(ReplyVo r_vo) throws Exception {
		sqlSession.insert(NAMESPACE + ".replyCreate", r_vo);
	}

	@Override
	public List<ReplyVo> listAll(int b_num) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".replyListAll", b_num);
	}

	@Override
	public void modify(ReplyVo r_vo) throws Exception {
		sqlSession.update(NAMESPACE + ".replyModify", r_vo);
	}

	@Override
	public void delete(int r_num) throws Exception {
		sqlSession.delete(NAMESPACE + ".replyDelete", r_num);
	}

	@Override
	public void deleteByb_num(int b_num) throws Exception {
		sqlSession.delete(NAMESPACE + ".replyDeleteByb_num", b_num);
	}

}
