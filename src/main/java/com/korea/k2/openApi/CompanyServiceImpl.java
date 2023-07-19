package com.korea.k2.openApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao  dao;
	
	@Override
	public void insert(CompanyVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public void insertEv(EvSearchVO vo) {
		dao.insertEv(vo);
		
	}

	@Override
	public List<CompanyVO> list(CompanyVO vo) {
		// TODO Auto-generated method stub
		return dao.list(vo);
	}

	@Override
	public List<EvSearchVO> listEv(EvSearchVO vo) {
		// TODO Auto-generated method stub
		return dao.listEv(vo);
	}

	@Override
	public CompanyVO selectOne(CompanyVO vo) {
		// TODO Auto-generated method stub
		return dao.selectOne(vo);
	}

	@Override
	public EvSearchVO selectOne(EvSearchVO vo) {
		// TODO Auto-generated method stub
		return dao.selectOne(vo);
	}

}
