package com.cybage.service;

import java.util.List;

import com.cybage.model.Complain;
import com.cybage.model.Department;

// Department Head Interface

public interface iDepartmentHeadService  {
	

	public List<Complain> getReopenComplain(String deptId) throws Exception;
	
	public List<Complain> getListOfComplain(String deptId) throws Exception;
	
	public int getCountOfReopenComplain(String deptId) throws Exception;
	
	public int getCountOfReminderComplain(String deptId) throws Exception;
	
	public List<Complain> getListOfReminder(String deptId) throws Exception;
	
	public int submitRemark(String compId,String remark) throws Exception;
	
	public int transferComplain(String compId,String departmentName) throws Exception;
	
	public int changeStatus(String compId) throws Exception;
	
	public String getDeptId(String username) throws Exception;
	
	public List<Department> getListOfDepartment() throws Exception;
	
}



