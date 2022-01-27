package com.instakilogram.api.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.instakilogram.api.dao.ApiDao;
import com.instakilogram.api.dto.User;
import com.instakilogram.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	ApiDao apiDao;
	
	@Override
	@Transactional
	public boolean login(HashMap<String, String> login) {
		return apiDao.login(login);
	}
	
	@Override
	@Transactional
	public boolean signup(User user) {
		return apiDao.signup(user);
	}
	
	@Override
	@Transactional
	public boolean idChk(String id) {
		return apiDao.idChk(id);
	}
}
