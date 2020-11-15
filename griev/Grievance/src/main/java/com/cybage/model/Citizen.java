package com.cybage.model;

public class Citizen {
	
	private int citizenid;
	private String name;
	private String contact;
	private String address;
	
	
	public Citizen() {
		super();
	}


	public Citizen(int citizenid, String name, String contact, String address) {
		super();
		this.citizenid = citizenid;
		this.name = name;
		this.contact = contact;
		this.address = address;
	}


	public int getCitizenid() {
		return citizenid;
	}


	public void setCitizenid(int citizenid) {
		this.citizenid = citizenid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Citizen [citizenid=" + citizenid + ", name=" + name + ", contact=" + contact + ", address=" + address
				+ "]";
	}
	
	

}
