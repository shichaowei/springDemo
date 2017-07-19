package com.netease.course.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.course.dao.PersonDao;
import com.netease.course.meta.Person;
import com.netease.course.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;

	public Person getPersonInfo(String userName){
		return personDao.getPersonInfo(userName);
	}

	public String getPasswd(String userName) {
		return personDao.getPassword(userName);
	}


}
