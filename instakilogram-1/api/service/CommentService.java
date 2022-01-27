package com.instakilogram.api.service;

import java.util.List;

import com.instakilogram.api.dto.Comment;

public interface CommentService {
	public List<Comment> getComment(Integer no);
}
