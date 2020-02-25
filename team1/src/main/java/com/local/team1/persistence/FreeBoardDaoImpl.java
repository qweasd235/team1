package com.local.team1.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.local.team1.domain.FreeBoardVo;
import com.local.team1.domain.PagingDto;

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
	public List<FreeBoardVo> listAll(PagingDto pagingDto) throws Exception {
		return sqlsession.selectList(NAMESPACE + ".listAll", pagingDto);
	}

	@Override
	public FreeBoardVo read(int b_num) throws Exception {		
		return sqlsession.selectOne(NAMESPACE + ".read", b_num);
	}

	@Override
	public void modify(FreeBoardVo fb_vo) throws Exception {
		sqlsession.update(NAMESPACE + ".modify", fb_vo);
	}
	
	@Override
	public void modify_b_pic(FreeBoardVo fb_vo) throws Exception {
		sqlsession.update(NAMESPACE + ".modify_b_pic", fb_vo);		
	}

	@Override
	public void delete(int b_num) throws Exception {
		sqlsession.delete(NAMESPACE + ".delete", b_num);
		
	}

	@Override
	public int totalCount(PagingDto pagingDto) throws Exception {		
		return sqlsession.selectOne(NAMESPACE + ".totalCount", pagingDto);
	}

	

}
