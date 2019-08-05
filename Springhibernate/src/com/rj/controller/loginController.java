package com.rj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rj.entity.User;
import com.rj.service.UserService;

@Controller
@RequestMapping("/login")
public class loginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public void  checklogin(@RequestParam String username,@RequestParam String password,
			HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		List<User> users=userService.login(username, password);
		if(users.size()>0){
			HttpSession session=request.getSession();
			session.setAttribute("user", "1");
			out.print("1");
		}else{
			out.print("0");
		}
	}
	@RequestMapping("/getAll")
	public String  getAll(Map<String,Object> map) throws IOException {
		map.put("users", userService.getAllUser());
		
		return "allusers";
	}
	
	
	
}
