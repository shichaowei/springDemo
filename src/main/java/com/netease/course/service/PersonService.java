package com.netease.course.service;


import com.netease.course.meta.Person;

public interface PersonService {

	public Person getPersonInfo(String userName);

	public String getPasswd(String userName);


}
