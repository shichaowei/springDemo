package com.netease.course.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.course.dao.ProductDao;
import com.netease.course.meta.Product;
import com.netease.course.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	public List<Product> getAllProductList() {
		return productDao.getAllProductList();
	}

	
}
