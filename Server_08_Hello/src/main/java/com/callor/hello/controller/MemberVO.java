package com.callor.hello.controller;

public class MemberVO {

	private String username;
	private String password;
	private String name;
	private String tel;
	private String addr;
	
	
	// @NoArgs. . .
	public MemberVO() {
		super();
		
	}
	
	// @AllArg. . .
	public MemberVO(String username, String password, String name, String tel, String addr) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	// @ToString
	@Override
	public String toString() {
		return "MemberVO [username=" + username + ", password=" + password + ", name=" + name + ", tel=" + tel
				+ ", addr=" + addr + "]";
	}
	
	
	
}
