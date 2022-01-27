package com.instakilogram.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.instakilogram.api.dao.ApiDao;
import com.instakilogram.api.dto.Feed;
import com.instakilogram.api.service.FeedService;

@Service
public class FeedServiceImpl implements FeedService{
	@Autowired
	ApiDao apiDao;
	
	@Override
	@Transactional
	public List<Feed> getFeed(){
		return apiDao.getFeed();
	}
}
