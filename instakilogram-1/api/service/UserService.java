package com.instakilogram.api.service;

import java.util.HashMap;

import com.instakilogram.api.dto.User;

public interface UserService {
	public boolean login(HashMap<String, String> login);
	public boolean signup(User user);
	public boolean idChk(String id);
}
