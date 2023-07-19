package com.korea.k2.cart;

import java.util.List;

public interface CartService {
	void insert(CartVO vo);
	List<CartVO> selectAll(CartVO vo);
	void delete(CartVO vo);
	void deleteAll(CartVO vo);
	void update(CartVO vo);
	void insertOrderJumon(OrderJumonVO vo);
	void insertOrderMoney(OrderMoneyVO vo);
	
	List<OrderMoneyVO> selectOrderMoney(OrderMoneyVO vo);
	List<OrderOneVO> selectOrderOne(OrderOneVO vo);
	

}
