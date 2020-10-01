package com.hsbc.model.beans;

public class Profile {
	
	private int profile_id;
	private String name;
	private String password;
	private long phone;
	private String dob;
	
	public Profile() {
		super();
	}
	@Override
	public String toString() {
		return "Profile [profile_id=" + profile_id + ", name=" + name + ", password=" + password + ", phone=" + phone
				+ ", dob=" + dob + "]";
	}
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	

}
