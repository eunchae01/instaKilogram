package com.instakilogram.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.instakilogram.api.dao.ApiDao;
import com.instakilogram.api.dto.Comment;
import com.instakilogram.api.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	ApiDao apiDao;
	
	@Override
	@Transactional
	public List<Comment> getComment(Integer no){
		return apiDao.getComment(no);
	}
}
