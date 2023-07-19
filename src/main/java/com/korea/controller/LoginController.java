package com.korea.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korea.k2.login.LoginService;
import com.korea.k2.shop.MemberVO;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@RequestMapping("/logout.do")
	String logout(HttpSession session) {
		session.removeAttribute("session");
		return "/index.jsp";
	}
	
	
	@RequestMapping("/login.do")
	String login(Model model, MemberVO vo, HttpSession session) {
		MemberVO m = service.loginOne(vo);
		if(m == null || m.equals(null)) {
			System.out.println("아이디가 존재하지 않습니다.");
			return "/login/login.jsp";
		} else {
			if(BCrypt.checkpw(vo.getPassword(), m.getPassword())) {
				System.out.println("로그인 되었습니다.");
				session.setAttribute("session", m);
				return "/productSelectAll.do";
			} else {
				System.out.println("암호가 일치하지 않습니다.");
				return "/login/login.jsp";
			}
		}
	}
	
	
}
