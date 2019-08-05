package com.rj.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rj.entity.User;
import com.rj.service.UserService;

@Controller

public class UserController {

	@Autowired
	private UserService userService;
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,
			Map<String,Object> map){
		if(id!=null){
			map.put("user", userService.getUser(id));
		}
		
	}
	//删除
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id){
		userService.delUser(id);
		return "redirect:/login/getAll";
	}
	//更新
	@RequestMapping(value="/user",method=RequestMethod.PUT)
	public String update(User user){
		userService.updateUser(user);
		return "redirect:/login/getAll";
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id") Integer id,Map<String,Object> map){
		User user=userService.getUser(id);
		map.put("user",user);
		return "input";
	}
	
	
	//添加
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String save(User  user,Map<String,Object> map){
		
		userService.addUser(user);
		return  "redirect:/login/getAll";
				
	}
	//查询
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String input(Map<String,Object> map){
		map.put("user", new User());
	
		return "input";
	}
}
