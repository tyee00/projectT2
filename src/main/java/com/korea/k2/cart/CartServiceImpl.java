package com.korea.k2.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDao dao;
	
	@Override
	public void insert(CartVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	@Override
	public List<CartVO> selectAll(CartVO vo) {
		// TODO Auto-generated method stub
		return dao.selectAll(vo);
	}

	@Override
	public void delete(CartVO vo) {
		// TODO Auto-generated method stub
		dao.delete(vo);
	}

	@Override
	public void deleteAll(CartVO vo) {
		// TODO Auto-generated method stub
		dao.deleteAll(vo);
	}

	@Override
	public void update(CartVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void insertOrderJumon(OrderJumonVO vo) {
		// TODO Auto-generated method stub
		dao.insertOrderJumon(vo);
	}

	@Override
	public void insertOrderMoney(OrderMoneyVO vo) {
		// TODO Auto-generated method stub
		dao.insertOrderMoney(vo);
	}



	@Override
	public List<OrderMoneyVO> selectOrderMoney(OrderMoneyVO vo) {
		// TODO Auto-generated method stub
		return dao.selectOrderMoney(vo);
	}

	@Override
	public List<OrderOneVO> selectOrderOne(OrderOneVO vo) {
		// TODO Auto-generated method stub
		return dao.selectOrderOne(vo);
	}

}
