package com.newbalance.rickie.vo;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class UserVO {
	
	private int user_id;//                 int not null auto_increment,
    private String user_avator;//          varchar(1024),
    private String user_name;//            varchar(50) not null,
    private String user_nickname;//        varchar(50),
    private String user_password;//        varchar(50),
    private int user_sex;//                int,
    private String user_birthday;//        varchar(50),
    private int user_city_id;//            int,
    private String user_secu_question;//   varchar(50),
    private String user_secu_answer;//     varchar(50),
    private Date timestamp;//              timestamp,
    
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_avator() {
		return user_avator;
	}
	public void setUser_avator(String user_avator) {
		this.user_avator = user_avator;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public int getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(int user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
	public int getUser_city_id() {
		return user_city_id;
	}
	public void setUser_city_id(int user_city_id) {
		this.user_city_id = user_city_id;
	}
	public String getUser_secu_question() {
		return user_secu_question;
	}
	public void setUser_secu_question(String user_secu_question) {
		this.user_secu_question = user_secu_question;
	}
	public String getUser_secu_answer() {
		return user_secu_answer;
	}
	public void setUser_secu_answer(String user_secu_answer) {
		this.user_secu_answer = user_secu_answer;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	/**
	 * 把当前对象转为为一个Json格式的字符串
	 * @return
	 */
	public JSONObject toJsonObject(){
		JSONObject jsonObject=new JSONObject();
		
		jsonObject.put("user_id", user_id);
		jsonObject.put("user_avator", user_avator);
		jsonObject.put("user_name", user_name);
		jsonObject.put("user_nickname", user_nickname);
		jsonObject.put("user_password", user_password);
		jsonObject.put("user_sex", user_sex);
		jsonObject.put("user_birthday", user_birthday);
		jsonObject.put("user_city_id", user_city_id);
		jsonObject.put("user_secu_question", user_secu_question);
		jsonObject.put("user_secu_answer", user_secu_answer);
		jsonObject.put("timestamp", timestamp.toString());
			
		return jsonObject;
	}
    
    
}
