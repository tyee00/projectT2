package com.korea.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.korea.k2.cart.CartService;
import com.korea.k2.cart.CartVO;
import com.korea.k2.cart.OrderJumonVO;
import com.korea.k2.cart.OrderMoneyVO;
import com.korea.k2.cart.OrderOneVO;
import com.korea.k2.cart.OrderJMVO;
import com.korea.k2.shop.MemberVO;

@Controller
public class CartController {
	@Autowired
	CartService service;
	
	@RequestMapping("/cart.do")
	String cartInsert(CartVO vo) {

		service.insert(vo);
		return "/cartSelectAll.do";
	}
	@RequestMapping("/cartSelectAll.do")
	String cartSelectAll(Model model, HttpSession session) {
		CartVO vo = new CartVO();
		MemberVO m = (MemberVO)session.getAttribute("session");
		vo.setCustNo(m.getCustno());
		model.addAttribute("li",service.selectAll(vo));
		return "/cart/cart_selectAll.jsp";
	}
	
	@RequestMapping("/cartDelete.do")
	String cartDelete(CartVO vo) {

		service.delete(vo);
		return "/cartSelectAll.do";
	}
	@RequestMapping("/cartDeleteAll.do")
	String cartDeleteAll(CartVO vo) {

		service.deleteAll(vo);
		return "/cartSelectAll.do";
	}
	@RequestMapping("/cartUpdate.do")
	public String cartUpdate(@RequestParam("amount") Integer[] amount,
	                         @RequestParam("cartId") Integer[] cartId
	                         ) throws Exception {
		
		for(int i =0; i< cartId.length; i++) {
			CartVO vo = new CartVO();
			vo.setCartId(cartId[i]);
			vo.setAmount(amount[i]);
			service.update(vo);
		}
	    return "/cartSelectAll.do";
	}
	@RequestMapping("/cartOrder.do")
	public String cartOrder(@RequestParam("amount") Integer[] amount,
							@RequestParam("custno") Integer[] custno,
	                         @RequestParam("cartId") Integer[] cartId,
	                         @RequestParam("productId") Integer[] productId,
	                         @RequestParam("productName") String[] productName,
	                         @RequestParam("totalPrice") Integer totalPrice,
	                         @RequestParam("baesongbi") Integer baesongbi,
	                         OrderMoneyVO mvo
	                         ) throws Exception {
		mvo.setCustNo(custno[0]);
		service.insertOrderMoney(mvo);
		for(int i =0; i< cartId.length; i++) {
			OrderJumonVO ovo = new OrderJumonVO();
			ovo.setCustNo(custno[i]);
			ovo.setCartId(cartId[i]);
			ovo.setProductId(productId[i]);
			ovo.setProductName(productName[i]);
			ovo.setAmount(amount[i]);
			service.insertOrderJumon(ovo);
			CartVO c = new CartVO();
			c.setCartId(cartId[i]);
			service.delete(c);
		}
		
	    return "/cartSelectAll.do";
	}
	@RequestMapping("/orderJumon.do")
		String orderJumon(Model model,OrderMoneyVO vo){
		model.addAttribute("li", service.selectOrderMoney(vo));
		return "/cart/cart_orderMoney.jsp";
	}
	@RequestMapping("/orderOne.do")
	String orderOne(Model model, OrderOneVO vo) {
		model.addAttribute("li", service.selectOrderOne(vo));
		return "cart/cart_orderOne.jsp";
	}
}
