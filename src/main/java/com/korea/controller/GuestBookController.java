package com.korea.controller;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korea.k2.guestbook.GuestBookService;
import com.korea.k2.guestbook.GuestBookVO;

@Controller
public class GuestBookController {
	
	@Autowired
	GuestBookService service;
	
	@RequestMapping("/guestBookInsert.do")
	String guestBookInsert(GuestBookVO vo) {
		String [] str1 = {"박","석","김","이","최","강","배", "서","양"};
		String [] str2 = {"한영","기범","대경","상준","성주","주영","진호", "지효","영원"};
		String [] title = {"재구매 할꺼에요","이런 상품 정말 없어요","배송이 빨라요","적극 추천합니다.","찾던 물건이에요","상품 너무 좋았어요","좋아요", "좋은 상품 감사합니다.","정말 좋아요"};
		
		for(int i = 1; i<=555 ; i++) {
			int k1 = (int)(Math.random()* 9);
			int k2 = (int)(Math.random()* 9);
			int k3 = (int)(Math.random()* 9);
			
			vo.setWriter(str1[k1]+str2[k2]);
			vo.setTitle(title[k3]);
			System.out.print(vo);
			service.insert(vo);
		}
		
		return "/guestBookList.do";
	}
	@RequestMapping("/guestBookList.do")
	String guestBookList(Model model, GuestBookVO vo) {
		model.addAttribute("li",service.list(vo));
		return ("/guestBook/guestBookList.jsp");
	}
	
}
