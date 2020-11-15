package com.cybage.service;

import java.util.ArrayList;
import java.util.List;

import com.cybage.dao.DepartmentHeadDaoImpl;
import com.cybage.model.Complain;
import com.cybage.model.Department;

public class DepartmentHeadServiceImpl implements iDepartmentHeadService {

	DepartmentHeadDaoImpl dao = new DepartmentHeadDaoImpl();
	
	public List<Complain> getReopenComplain(String deptId) throws Exception  {
		List<Complain> comp = dao.getReopenComplain(deptId);
		return comp;
	}

	public List<Complain> getListOfComplain(String deptId) throws Exception {
		List<Complain> comp = dao.getListOfComplain(deptId);
		return comp;
	}

	public int getCountOfReopenComplain(String deptId) throws Exception {
		List<Complain> comp = dao.getReopenComplain(deptId);
		int count =0;
		
		for(Complain temp : comp)
		{
			count++;
		}
		
		return count;
	}

	public int submitRemark(String compId,String remark) throws Exception {
		int temp= dao.submitRemark(compId, remark);
		return temp;
	}

	public int transferComplain(String compId, String departmentName) throws Exception {
		
		int transfer = dao.tranferComplain(compId, departmentName);
		
		return transfer;
	}
	
	public int changeStatus(String compId) throws Exception
	{
		int status = dao.changeStatus(compId);
		return status;
	}

	public List<Complain> getListOfReminder(String deptId) throws Exception {
		List<Complain> list = dao.getListOfReminder(deptId);
		return list;
	}
	
	public int getCountOfReminderComplain(String deptId) throws Exception {
		List<Complain> comp = dao.getListOfReminder(deptId);
		int count =0;
		
		for(Complain temp : comp)
		{
			count++;
		}
		
		return count;
	}


	public String getDeptId(String username) throws Exception {
		String deptId = dao.getDeptId(username);
		return deptId;
	}

	public List<Department> getListOfDepartment() throws Exception {
		List<Department> demp = new ArrayList<Department>();
		demp = dao.getListOfDepartment();
		return demp;
	}

}
