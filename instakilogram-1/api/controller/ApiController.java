package com.instakilogram.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instakilogram.api.dto.Comment;
import com.instakilogram.api.dto.Feed;
import com.instakilogram.api.dto.User;
import com.instakilogram.api.service.*;

@RestController
@RequestMapping
public class ApiController {
	@Autowired
	CommentService commentService;
	@Autowired
	UserService userService;
	@Autowired
	FeedService feedService;
	
	@GetMapping("/comment/{no}")
	public Map<String, Object> getComment(@PathVariable(name="no")Integer no, HttpServletRequest request) {
		List<Comment> commentList = commentService.getComment(no);
		Map<String, Object> map = new HashMap<>();
		map.put("commentList", commentList);
		return map;
	}
	
	@GetMapping("/feed")
	public Map<String, Object> getFeed(HttpServletRequest request) {
		List<Feed> feedList = feedService.getFeed();
		Map<String, Object> map = new HashMap<>();
		map.put("feed", feedList);
		return map;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Void> login(@RequestBody HashMap<String, String> login) {
		System.out.println(login);
		boolean token = userService.login(login);
		System.out.println(token);
		if(token) {
			return ResponseEntity.ok(null);
		}
		else	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@PostMapping("/signup")
	public boolean signup(@RequestBody User user) {
//		boolean id_chk = userService.idChk(user.getId());
//		if(id_chk) {
//			
//		}
		boolean token = userService.signup(user);
		System.out.println(user);
		return token;
	}
}
