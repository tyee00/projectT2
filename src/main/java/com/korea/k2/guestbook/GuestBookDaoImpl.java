package com.korea.k2.guestbook;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestBookDaoImpl implements GuestBookDao{

	@Autowired
	SqlSessionTemplate mybatis;
	
	@Override
	public void insert(GuestBookVO vo) {
		// TODO Auto-generated method stub
		mybatis.insert("GUESTBOOK.INSERT",vo);
	}

	@Override
	public List<GuestBookVO> list(GuestBookVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("GUESTBOOK.SELECT",vo);
	}

	@Override
	public int count(GuestBookVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("GUESTBOOK.COUNT", vo);
	}

}
