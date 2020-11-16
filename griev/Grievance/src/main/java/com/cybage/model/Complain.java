package com.cybage.model;

import java.time.LocalDate;

public class Complain {
	private String compId;
	private String citizenId;
	private String deptId;
	private String name;
	private String contactNo;
	private String description;
	private String status;
	private String remark;
	private String file;
	private LocalDate date;
	private String deptName;


	public Complain() {
		super();
		// TODO Auto-generated constructor stub
	}

	//	Parameterized Constructor of Complain Class
	
	public Complain(String compId,String name,String contactNo, String description,
			String file,String status , String deptName) {
		super();
		this.compId = compId;
		this.name = name;
		this.contactNo = contactNo;

		this.description = description;
		this.deptName = deptName;

		this.file = file;
		this.status=status;
	}


// Getter and Setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getCompId() {
		return compId;
	}
	public void setCompId(String compId) {
		this.compId = compId;
	}
	public String getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	@Override
	public String toString() {
		return "Complain [compId=" + compId + ", name=" + name + ", contactNo=" + contactNo + ", description="
				+ description + ",  file=" + file + ",  status=" + status + ",  deptName=" + deptName + "]";
	}




}
