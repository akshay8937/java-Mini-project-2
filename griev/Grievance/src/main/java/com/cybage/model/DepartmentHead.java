package com.cybage.model;

public class DepartmentHead {
	
	private int deptHeadId;
	private Department deptId;
	private String email;
	private String contact;
	
	
	@Override
	public String toString() {
		return "DepartmentHead [deptHeadId=" + deptHeadId + ", email=" + email + ", contact=" + contact + "]";
	}


	public int getDeptHeadId() {
		return deptHeadId;
	}


	public void setDeptHeadId(int deptHeadId) {
		this.deptHeadId = deptHeadId;
	}


	public Department getDeptId() {
		return deptId;
	}


	public void setDeptId(Department deptId) {
		this.deptId = deptId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public DepartmentHead() {
		super();
	}


	public DepartmentHead(int deptHeadId, Department deptId, String email, String contact) {
		super();
		this.deptHeadId = deptHeadId;
		this.deptId = deptId;
		this.email = email;
		this.contact = contact;
	}
	

}
