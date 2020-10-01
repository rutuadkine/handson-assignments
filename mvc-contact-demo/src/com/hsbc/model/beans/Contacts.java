package com.hsbc.model.beans;

public class Contacts {
	private int contact_id;
	private String name;
	private long contact_no;
	private int pid;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Contacts() {
		super();
	}
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	@Override
	public String toString() {
		return "Contacts [contact_id=" + contact_id + ", name=" + name + ", contact_no=" + contact_no + "]";
	}


}
