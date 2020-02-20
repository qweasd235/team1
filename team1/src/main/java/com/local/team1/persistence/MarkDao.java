package com.local.team1.persistence;

import com.local.team1.domain.MarkVo;

public interface MarkDao {
	
	// 데이터 추가
		public void create(MarkVo vo) throws Exception;
}
