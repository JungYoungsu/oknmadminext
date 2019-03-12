package com.kcb.oknmadminext.model;

public class UserVO {
	private String id;
	private String name;
	private String passwd;

	public UserVO(String id, String name, String passwd) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
	}

	public UserVO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", passwd=" + passwd + "]";
	}
}
