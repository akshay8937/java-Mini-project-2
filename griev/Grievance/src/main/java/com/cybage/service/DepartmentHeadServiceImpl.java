package com.cybage.service;

import java.util.ArrayList;
import java.util.List;

import com.cybage.dao.DepartmentHeadDaoImpl;
import com.cybage.model.Complain;
import com.cybage.model.Department;

public class DepartmentHeadServiceImpl implements iDepartmentHeadService {

//	creating the object of DepartmentDao ,globally so that every method use the same object.
	
	DepartmentHeadDaoImpl dao = new DepartmentHeadDaoImpl();
	
//	DepartmentSevice call the DepartmentDao method for getting the list of reopen Complain list.
	
	public List<Complain> getReopenComplain(String deptId) throws Exception  {
		List<Complain> comp = dao.getReopenComplain(deptId);
		return comp;
	}

//	DepartmentSevice call the DepartmentDao method for getting the list of  Complains list.
	
	public List<Complain> getListOfComplain(String deptId) throws Exception {
		List<Complain> comp = dao.getListOfComplain(deptId);
		return comp;
	}

//	DepartmentSevice call the DepartmentDao method for getting the count of reopen Complain list.
	
	public int getCountOfReopenComplain(String deptId) throws Exception {
		List<Complain> comp = dao.getReopenComplain(deptId);
		int count =0;
		
		for(Complain temp : comp)
		{
			count++;
		}
		
		return count;
	}
//	DepartmentSevice call the DepartmentDao method for updating the remark of Complain given by department Head.

	public int submitRemark(String compId,String remark) throws Exception {
		int temp= dao.submitRemark(compId, remark);
		return temp;
	}
	
//	DepartmentSevice call the DepartmentDao method for transferring the Complain form one department to another department.

	public int transferComplain(String compId, String departmentName) throws Exception {
		
		int transfer = dao.tranferComplain(compId, departmentName);
		
		return transfer;
	}
	
//	DepartmentSevice call the DepartmentDao method for updating the status of Complain .
	
	public int changeStatus(String compId) throws Exception
	{
		int status = dao.changeStatus(compId);
		return status;
	}
	
//	DepartmentSevice call the DepartmentDao method for getting the list of reminder Complain list.

	public List<Complain> getListOfReminder(String deptId) throws Exception {
		List<Complain> list = dao.getListOfReminder(deptId);
		return list;
	}
	
//	DepartmentSevice call the DepartmentDao method for getting the count of reminder Complain list.
	
	public int getCountOfReminderComplain(String deptId) throws Exception {
		List<Complain> comp = dao.getListOfReminder(deptId);
		int count =0;
		
		for(Complain temp : comp)
		{
			count++;
		}
		
		return count;
	}

//	DepartmentSevice call the DepartmentDao method for getting the deptId by using Department Name.
	
	public String getDeptId(String username) throws Exception {
		String deptId = dao.getDeptId(username);
		return deptId;
	}

//	DepartmentSevice call the DepartmentDao method for getting the list of department.
	
	public List<Department> getListOfDepartment() throws Exception {
		List<Department> demp = new ArrayList<Department>();
		demp = dao.getListOfDepartment();
		return demp;
	}

}
