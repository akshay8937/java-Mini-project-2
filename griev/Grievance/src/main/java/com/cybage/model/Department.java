package com.cybage.model;

public class Department {
	
	private String deptId;
	private String deptName;
	
	
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}


	public String getDeptId() {
		return deptId;
	}


	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public Department(String deptName) {
		super();
	
		this.deptName = deptName;
	}


	public Department() {
		super();
	}
	

}
