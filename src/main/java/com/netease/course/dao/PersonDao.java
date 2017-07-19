package com.netease.course.dao;

import javax.annotation.Resource;

import com.netease.course.meta.Person;

@Resource
public interface PersonDao {

	public Person getPersonInfo(String userName);

	public String getPassword(String userName);

}
