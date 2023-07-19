package com.korea.k2.guestbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestBookServiceImpl implements GuestBookService{

	@Autowired
	GuestBookDao dao;
	
	@Override
	public void insert(GuestBookVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	@Override
	public List<GuestBookVO> list(GuestBookVO vo) {
		// TODO Auto-generated method stub
		return dao.list(vo);
	}

	@Override
	public int count(GuestBookVO vo) {
		// TODO Auto-generated method stub
		return dao.count(vo);
	}

}
