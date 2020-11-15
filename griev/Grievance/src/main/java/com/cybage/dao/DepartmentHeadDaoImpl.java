package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.Complain;
import com.cybage.model.Department;

public class DepartmentHeadDaoImpl {
	
	public List<Complain> getReopenComplain(String deptId) throws Exception
	{
		String sql = "select cm.compId , c.name , c.contact , cm.description , cm.file,cm.status, d.deptName from complain cm inner join citizen c on cm.citizenId = c.citizenId inner join department d on cm.deptId = d.deptId where cm.status=?  and cm.deptId = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1,"reopen");
		ps.setString(2, deptId);
		ResultSet rs = ps.executeQuery();
		List<Complain> comp = new ArrayList<Complain>();
		
		while(rs.next()) {
			comp.add(new Complain(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			System.out.println(comp);
				}
		System.out.println(comp);
		
		return comp;
		
		
	}
	
	public List<Complain> getListOfComplain(String deptId) throws Exception
	{
		
		String sql = "select cm.compId , c.name , c.contact , cm.description , cm.file,cm.status, d.deptName from complain cm inner join citizen c on cm.citizenId = c.citizenId inner join department d on cm.deptId = d.deptId where cm.status=? and cm.deptId = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, "active");
		ps.setString(2, deptId);
		System.out.println(sql);
		ResultSet rs = ps.executeQuery();
		List<Complain> comp = new ArrayList<Complain>();
		
		
		while(rs.next()) {
			comp.add(new Complain(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			System.out.println("dao"+comp);
		}
		
		
		return comp;
	}
	
	
	public int submitRemark(String compId,String remark) throws Exception {
		
		String sql = "update complain set remark = ?  where compId = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, remark);
		ps.setString(2, compId);
		return ps.executeUpdate();
	}
	
	public int tranferComplain(String compId,String departmentName) throws Exception
	{
		String sql ="update complain set deptId = (select deptId from department where deptName = ?) where compId = ?";
		
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, departmentName);
		ps.setString(2, compId);
		return ps.executeUpdate();
		
	}
	
	public int changeStatus(String compId) throws Exception
	{
		String sql = "update complain set status = ? where compId = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1,"inactive");
		ps.setString(2, compId);
		return ps.executeUpdate();
	}
	
	public List<Complain> getListOfReminder(String deptId) throws Exception
	{
		
		String sql = "select cm.compId , c.name , c.contact , cm.description , cm.file,cm.status, d.deptName from complain cm inner join citizen c on cm.citizenId = c.citizenId inner join department d on cm.deptId = d.deptId inner join reminder r on cm.compId = r.compId  where cm.status=? and cm.deptId = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, "active");
		ps.setString(2, deptId);
		System.out.println(sql);
		ResultSet rs = ps.executeQuery();
		List<Complain> comp = new ArrayList<Complain>();
		
		
		while(rs.next()) {
			comp.add(new Complain(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			System.out.println("dao"+comp);
		}
		
		
		return comp;
	}
	
	public String getDeptId(String username) throws Exception
	{
		

		String sql = "select dh.deptId from departmenthead dh inner join user u on dh.userId = u.userId where u.username = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		System.out.println(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		String deptId = rs.getString(1);
		return deptId;
		
		
	}
	
	public List<Department> getListOfDepartment() throws Exception
	{
		
		String sql = "select deptName from department";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
	
		ResultSet rs = ps.executeQuery();
		List<Department> demp = new ArrayList<Department>();
		
		
		while(rs.next()) {
			demp.add(new Department(rs.getString(1)));
		}
		
		
		return demp;
	} 
	
}
		
	
	
	
