package com.jdbc;

public class BeanReg {
	private int id;
	private String name;
	private String city;
	private long pass;
	
	@Override
	public String toString() {
		return "BeanReg [id=" + id + ", name=" + name + ", city=" + city + ", pass=" + pass + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPass() {
		return pass;
	}
	public void setPass(long pass) {
		this.pass = pass;
	}

}
