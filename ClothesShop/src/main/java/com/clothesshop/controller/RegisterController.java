package com.clothesshop.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clothesshop.entities.User;
import com.clothesshop.service.UserService;

@Controller
@RequestMapping(value ="/register")
public class RegisterController {
	@Autowired
	private UserService userService;

	@GetMapping()
	public String register(Model model) {
		return "/home/register";
	}
	@PostMapping()
	public String createAcc(@RequestParam String fullname,
			 				@RequestParam String email,
			 				@RequestParam String phone,
			 				@RequestParam String username,
			 				@RequestParam String password, Model model) {
		int check = 0;
		if(isValidEmailAddress(email)==false || email.equals("")) {
			model.addAttribute("emailErr", "Email không hợp lệ");
		}else if(checkEmail(email)) {
			model.addAttribute("emailErr", "Email đã tồn tại");

		}else {
			model.addAttribute("emailErr", "");
			check++;
		}
		
		if(fullname.equals("")) {
			model.addAttribute("fullnameErr", "Vui lòng nhập họ và tên");
		}else {
			model.addAttribute("fullnameErr", "");
			check++;
		}
		
		if(isValidphone(phone)==false || phone.equals("")) {
			model.addAttribute("phoneErr", "Số điện thoại không hợp lệ");
		}else if(checkPhone(phone)) {
			model.addAttribute("phoneErr", "Số điện thoại đã tồn tại");
		}else {
			model.addAttribute("phoneErr", "");
			check++;
		}
		
		if(isValidUserName(username)==false || username.equals("")) {
			model.addAttribute("usernameErr", "Tài khoản không hợp lệ");
		}else if(checkAcc(username)) {
			model.addAttribute("usernameErr", "Tài khoản đã tồn tại");
		}else {
			model.addAttribute("usernameErr", "");
			check++;
		}
		
		if(isValidPassWord(password)==false || password.equals("")) {
			model.addAttribute("passwordErr", "Mật khẩu tối thiểu 6 ký tự");
		}else {
			model.addAttribute("passwordErr", "");
			check++;
		}
		if(check==5) {
			User user = userService.save(fullname, email, phone, username, password);
			if(user.getId() != null)
			return "redirect:/login";
		}
		check = 0;
		return "/home/register";

	}
	
	public boolean checkAcc(String username) {
		User user = userService.getByUserName(username);
		if(user == null) {
			return false;
		}
		return true;
	}
	public boolean checkPhone(String phone) {
		User user = userService.getByPhone(phone);
		if(user == null) {
			return false;
		}
		return true;
	}
	public boolean checkEmail(String email) {
		User user = userService.getByEmail(email);
		if(user == null) {
			return false;
		}
		return true;
	}
	
	
	 public boolean isValidEmailAddress(String email) {
         String regex = "^[a-zA-Z0-9._-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
         Pattern p = Pattern.compile(regex);
         Matcher m = p.matcher(email);
         return m.matches();
  }
	 public boolean isValidphone(String phone) {
         String regex = "^[0-9]+$";
         Pattern p = Pattern.compile(regex);
         Matcher m = p.matcher(phone);
         return m.matches();
  }
	 public boolean isValidUserName(String username) {
         String regex = "^[a-zA-z0-9._!@#$%^&*-]+$";
         Pattern p = Pattern.compile(regex);
         Matcher m = p.matcher(username);
         return m.matches();
  }
	 public boolean isValidPassWord(String pass) {
         String regex = "^[a-zA-z0-9._!@#$%^&*-]{6,}$";
         Pattern p = Pattern.compile(regex);
         Matcher m = p.matcher(pass);
         return m.matches();
  }
}
