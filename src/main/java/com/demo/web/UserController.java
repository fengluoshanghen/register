package com.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.User;
import com.demo.manager.UserManager;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name="userManager")
	private UserManager userManager;

	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
		Integer pageNumber = 1;
		String pn = request.getParameter("pageNumber");
		if(pn != null){
			pageNumber = Integer.valueOf(pn);
		}
		if(pageNumber <= 1){
			pageNumber = 1;
		}
		int count = userManager.getCount();
		Integer pageSize = 10;
		int pageCount = count%pageSize==0?count/pageSize:count/pageSize+1;
		if(pageNumber > pageCount){
			pageNumber	=	pageCount;
		}
		String name  = request.getParameter("sname");
		if(name==null||name.length()<=0) {
			request.setAttribute("userList", userManager.getAllUser(pageSize, pageNumber));
		}else{
			request.setAttribute("userList", userManager.getAllUser(pageSize, pageNumber,name));
		}
		request.setAttribute("count",count);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("pageCount", pageCount);
		return "WEB-INF/demo/index";
	}
	
	@RequestMapping("/getUser")
	public String getUser(Integer id,HttpServletRequest request){
		
		request.setAttribute("user", userManager.getUser(id));
	
		return "WEB-INF/demo/editUser";
	}
	
	@RequestMapping("/toAddUser")
	public String toAddUser(){
		return "WEB-INF/demo/addUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user,HttpServletRequest request){
		userManager.addUser(user);
		
		return "redirect:/user/getAllUser";
	}
	
	@RequestMapping("/delUser")
	public void delUser(Integer id,HttpServletResponse response){
		
		String result = "{\"result\":\"error\"}";
		
		if(userManager.delUser(id)){
			result = "{\"result\":\"success\"}";
		}
		
		response.setContentType("application/json");
		
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(User user,HttpServletRequest request){
		
		if(userManager.updateUser(user)){
			user = userManager.getUser(user.getId());
			request.setAttribute("user", user);
			return "redirect:/user/getAllUser";
		}else{
			return "/error";
		}
	}
}