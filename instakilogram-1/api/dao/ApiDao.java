package com.instakilogram.api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.instakilogram.api.dto.*;

import static com.instakilogram.api.dao.ApiSqls.*;

@Repository
public class ApiDao {
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Comment> commentMapper = BeanPropertyRowMapper.newInstance(Comment.class);
	private RowMapper<Feed> feedMapper = BeanPropertyRowMapper.newInstance(Feed.class);

	public ApiDao(DataSource dataSource) {
	    this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	    this.insertAction = new SimpleJdbcInsert(dataSource)
	            .withTableName("user")
	            .usingGeneratedKeyColumns("no");
	}
	
	
	public List<Comment> getComment(Integer no) {
		Map<String, Integer> params = new HashMap<>();
		params.put("no", no);
		return jdbc.query(ALL_COMMENT, params, commentMapper);
	}
	
	public List<Feed> getFeed() {
		return jdbc.query(ALL_FEED, feedMapper);
	}
	
	public boolean login(Map<String, String> params) {
		try {
			String encryptedPassword = jdbc.queryForObject(LOGIN, params, String.class);
			return encoder.matches(params.get("pw"), encryptedPassword);
		}catch(EmptyResultDataAccessException e) {
			return false;
		}
	}
	public boolean signup(User user) {
		String encryptedPassword = encoder.encode(user.getPw());
		user.setPw(encryptedPassword);
		SqlParameterSource params = new BeanPropertySqlParameterSource(user);
//		if (idChk(user.getId())) {
//			return false;
//		}
		try{
			insertAction.execute(params);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean idChk(String id) {
//		try {
//			
//			String ;
//			if() {
//				return true;
//			}
//		}catch(Exception e) {
//			return false;
//		}
		return true;
	}
}
