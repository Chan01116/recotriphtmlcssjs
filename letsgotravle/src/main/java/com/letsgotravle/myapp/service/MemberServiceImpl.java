package com.letsgotravle.myapp.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsgotravle.myapp.persistance.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper mm;

	@Autowired
	public MemberServiceImpl(SqlSession sqlSession) {
		this.mm = sqlSession.getMapper(MemberMapper.class);
	}
	
}
