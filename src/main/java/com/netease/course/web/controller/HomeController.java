package com.netease.course.web.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netease.course.meta.Person;
import com.netease.course.service.PersonService;
import com.netease.course.service.ProductService;

@Controller
public class HomeController {

	@Resource
	ProductService productServiceImpl;
	@Resource
	PersonService personServiceImpl;
	//type=0 未登录  1已登录
	@RequestMapping({"/"})
	public String getIndex(HttpServletRequest request,HttpServletResponse response, ModelMap map){
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		Person person = personServiceImpl.getPersonInfo(userName);
		map.addAttribute("user",person);
		map.addAttribute("productList",productServiceImpl.getAllProductList());
		return "index";
	}

	@RequestMapping({"login"})
	public String login(HttpServletRequest request,HttpServletResponse response, ModelMap map){
		return "login";
	}

	@RequestMapping({"api/login"})
	@ResponseBody
	public String chekclogin(@RequestParam("userName") String userName, @RequestParam("password") String password
			,HttpServletResponse response,HttpServletRequest request,ModelMap map) throws IOException {

		if(password.equals(personServiceImpl.getPasswd(userName))){
			HttpSession session = request.getSession();
			Cookie userNameCookie = new Cookie("userName", userName);
			Cookie pwdCookie = new Cookie("pwd", password);
			userNameCookie.setMaxAge(10 * 60);
			pwdCookie.setMaxAge(10 * 60);
			session.setAttribute("userName", userName);
			response.addCookie(userNameCookie);
			response.addCookie(pwdCookie);
			JSONObject result = new JSONObject();;
			result.put("code", 200);
			result.put("message", "welcome"+userName);
			result.put("result", "登录成功");
			return result.toString();
		}else{
			JSONObject result = new JSONObject();;
			result.put("code", 304);
			result.put("message", "账号密码错误");
			result.put("result", "登录失败");
			return result.toString();
		}

	}

}
