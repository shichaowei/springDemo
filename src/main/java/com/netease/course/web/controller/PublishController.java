package com.netease.course.web.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.netease.course.meta.Person;
import com.netease.course.service.PersonService;
import com.netease.course.service.ProductService;

@Controller
public class PublishController {


	@Resource
	ProductService productServiceImpl;
	@Resource
	PersonService personServiceImpl;


	//type=0 未登录  1已登录
	@RequestMapping({"public"})
	public String getIndex(HttpServletRequest request,HttpServletResponse response, ModelMap map){
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		Person person = personServiceImpl.getPersonInfo(userName);
		map.addAttribute("user",person);
		map.addAttribute("productList",productServiceImpl.getAllProductList());
		return "public";
	}

	//type=0 未登录  1已登录
	@RequestMapping({"api/upload"})
	public String uploadFile(@RequestParam(value = "file", required = false) MultipartFile file,HttpServletRequest request,HttpServletResponse response, ModelMap map) throws IllegalStateException, IOException{
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		Person person = personServiceImpl.getPersonInfo(userName);
		map.addAttribute("user",person);
		map.addAttribute("productList",productServiceImpl.getAllProductList());

		String path = request.getSession().getServletContext().getRealPath("image");
		//防止重名的问题
		String fileName = file.getOriginalFilename()+System.currentTimeMillis();
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}

		//保存
		file.transferTo(targetFile);
		JSONObject result = new JSONObject();;
		result.put("code", 200);
		result.put("message", "上传成功");
		result.put("result", request.getContextPath()+"/image/"+fileName);
		return result.toString();

	}










}
