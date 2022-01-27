package com.instakilogram.api.dao;

public class ApiSqls {
	public static final String ALL_COMMENT = "SELECT * FROM comment WHERE no= :no";
	public static final String ALL_FEED = "SELECT * FROM feed";
	public static final String LOGIN = "SELECT pw FROM user WHERE id= :id";
}