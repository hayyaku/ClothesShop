package com.clothesshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clothesshop.dto.UserDto;
import com.clothesshop.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("login")
	public String login(Model model) {
		return "/home/login";
	}
	
	@PostMapping(value ="login")
	public String handleLogin(@ModelAttribute UserDto userDto, Model model,HttpServletRequest request) {
		UserDto loginInfor = userService.checkAccount(userDto);
		if(loginInfor != null) {
			request.getSession().setAttribute("loginInfor", loginInfor);
			if(loginInfor.getRole().equals("admin")) {
				return "redirect:/admin/home";
			}
			return "redirect:/home";
		}else {
			model.addAttribute("loginErr", "Tài khoản hoặc mật khẩu không đúng");
			return "/home/login";
		}
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session,HttpServletRequest request) {
		request.getSession().removeAttribute("loginInfor");
		return "redirect:/login";
	}

}
