package com.entity;

public class UserInfo {
	
	/**
	 * 用户信息表
	 */
	private int id;//用户id
	private int age;//
	private String NikeName;
	private String hobbies;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNikeName() {
		return NikeName;
	}
	public void setNikeName(String nikeName) {
		NikeName = nikeName;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	
	

}
