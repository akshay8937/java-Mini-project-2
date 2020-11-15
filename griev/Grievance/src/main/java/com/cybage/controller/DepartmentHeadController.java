package com.cybage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.model.Complain;
import com.cybage.model.Department;
import com.cybage.service.DepartmentHeadServiceImpl;
import com.cybage.service.iDepartmentHeadService;

public class DepartmentHeadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
  
    iDepartmentHeadService ds = new DepartmentHeadServiceImpl();
    Department department = new Department();
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path = request.getPathInfo();
		System.out.println(path);
		
		if(path.equals("/reopenComplain")) {			
			try {
				System.out.println("reopenComplain controller");
				
				//String deptId= department.getDeptId();
				HttpSession session = request.getSession();
				String deptId = (String) session.getAttribute("deptId");
				List<Complain> comp =  ds.getReopenComplain(deptId);
				request.setAttribute("reopen", comp);
				int reminderCount = ds.getCountOfReminderComplain(deptId);
				request.setAttribute("reminderCount", reminderCount);
				
				List<Department> demp = ds.getListOfDepartment();
				request.setAttribute("departmentList", demp);
				
				request.getRequestDispatcher("/departmentHead/reopenComplain.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		 if(path.equals("/homePage")) {			
			try {
				System.out.println("homePage controller");
				String username= request.getParameter("username");
				System.out.println(username);
				String deptId = ds.getDeptId(username);
				HttpSession session = request.getSession();
				session.setAttribute("deptId", deptId);
				String deptId2 = (String) session.getAttribute("deptId");
				System.out.println(deptId2);
				List<Complain> comp =  ds.getListOfComplain(deptId2);
				System.out.println("controller"+comp);
				request.setAttribute("ListOfComplain", comp);
				int count = ds.getCountOfReopenComplain(deptId);
				request.setAttribute("count", count);
				int reminderCount = ds.getCountOfReminderComplain(deptId);
				request.setAttribute("reminderCount", reminderCount);
				
				List<Department> demp = ds.getListOfDepartment();
				request.setAttribute("departmentList", demp);
				
				request.getRequestDispatcher("/departmentHead/departmentHome.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 
		 if(path.equals("/complains")) {			
				try {
					System.out.println("complain controller");
					
					HttpSession session = request.getSession();
					
					String deptId2 = (String) session.getAttribute("deptId");
					System.out.println(deptId2);
					List<Complain> comp =  ds.getListOfComplain(deptId2);
					System.out.println("controller"+comp);
					request.setAttribute("ListOfComplain", comp);
					int count = ds.getCountOfReopenComplain(deptId2);
					request.setAttribute("count", count);
					int reminderCount = ds.getCountOfReminderComplain(deptId2);
					request.setAttribute("reminderCount", reminderCount);
					
					List<Department> demp = ds.getListOfDepartment();
					request.setAttribute("departmentList", demp);
					
					request.getRequestDispatcher("/departmentHead/departmentHome.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		
		if(path.equals("/submitRemark")) {			
			try {
				 HttpSession session = request.getSession();
				System.out.println("submitRemark controller");
				String remark= request.getParameter("remark");
				String compId= request.getParameter("compId");
				
				int temp= ds.submitRemark(compId, remark);
				if(temp>0)
				{
					 ds.changeStatus(compId);
					response.sendRedirect("homePage");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/reopenRemark")) {			
			try {
				 HttpSession session = request.getSession();
				System.out.println("reopenRemark controller");
				String remark= request.getParameter("remark");
				String compId= request.getParameter("compId");
				
				int temp= ds.submitRemark(compId, remark);
				if(temp>0)
				{
					 ds.changeStatus(compId);
					response.sendRedirect("reopenComplain");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/transferComplain")) {			
			try {
				System.out.println("transferComplain controller");
				String compId= request.getParameter("compId");
				String departmentName= request.getParameter("department");
			
				int temp=ds.transferComplain(compId, departmentName);
				if(temp>0)
				{
					response.sendRedirect("homePage");
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		if(path.equals("/reminderList")) {			
			try {
				System.out.println("reminder controller");
				HttpSession session = request.getSession();
				
				String deptId2 = (String) session.getAttribute("deptId");
				
				
				List<Complain> comp =  ds.getListOfReminder(deptId2);
				request.setAttribute("reminder", comp);
				int count = ds.getCountOfReopenComplain(deptId2);
				request.setAttribute("count", count);
				
				List<Department> demp = ds.getListOfDepartment();
				request.setAttribute("departmentList", demp);
				
				request.getRequestDispatcher("/departmentHead/reminder.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
