package com.netease.course.dao;

import java.util.List;

import javax.annotation.Resource;

import com.netease.course.meta.Product;
@Resource
public interface ProductDao {

	public Product getPrdouctById(String title);

	public List<Product> getAllProductList();

}
