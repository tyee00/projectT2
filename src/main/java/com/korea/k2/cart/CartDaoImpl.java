package com.korea.k2.cart;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl implements CartDao{

	@Autowired
	SqlSessionTemplate mybatis;
	
	@Override
	public void insert(CartVO vo) {
		// TODO Auto-generated method stub
		mybatis.insert("CART.INSERT", vo);
	}

	@Override
	public List<CartVO> selectAll(CartVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("CART.SELECTALL", vo);
	}

	@Override
	public void delete(CartVO vo) {
		// TODO Auto-generated method stub
		mybatis.delete("CART.DELETE",vo);
	}

	@Override
	public void deleteAll(CartVO vo) {
		// TODO Auto-generated method stub
		mybatis.delete("CART.DELETEALL", vo);
	}

	@Override
	public void update(CartVO vo) {
		// TODO Auto-generated method stub
		mybatis.update("CART.UPDATE", vo);
	}

	@Override
	public void insertOrderJumon(OrderJumonVO vo) {
		// TODO Auto-generated method stub
		mybatis.insert("CART.ORDERJUMON",vo);
	}

	@Override
	public void insertOrderMoney(OrderMoneyVO vo) {
		// TODO Auto-generated method stub
		mybatis.insert("CART.ORDERMONEY",vo);
	}


	@Override
	public List<OrderMoneyVO> selectOrderMoney(OrderMoneyVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("CART.SELECTORDERMONEY",vo);
	}

	@Override
	public List<OrderOneVO> selectOrderOne(OrderOneVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("CART.SELECTONEORDER",vo);
	}
	

}
