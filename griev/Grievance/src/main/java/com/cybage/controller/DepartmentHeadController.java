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
   
//  creating the object of DepartmentHeadService globally, so that every controller use same object.
	
    iDepartmentHeadService ds = new DepartmentHeadServiceImpl();
 
		
//	This Get method handle all GET request coming from the browser.
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path = request.getPathInfo();
		
		
//		This controller is call when department head wants to see the complains which is reopen by User.
		
		if(path.equals("/reopenComplain")) {			
			try {
				System.out.println("reopenComplain controller");
				
				HttpSession session = request.getSession();
				String deptId = (String) session.getAttribute("deptId");
				
				List<Complain> comp =  ds.getReopenComplain(deptId);
				
//				set the list of reopen complain and count of no. of list ,in the session object.
				
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
		
//		This controller is call every time when department head login. 
//		Get the username from request Parameter, by using the username ,get the deptId.
		
		 if(path.equals("/homePage")) {			
			try {
				
				String username= request.getParameter("username");
			
				String deptId = ds.getDeptId(username);
				
				HttpSession session = request.getSession();
				session.setAttribute("deptId", deptId);
				
				List<Complain> comp =  ds.getListOfComplain(deptId);
				request.setAttribute("ListOfComplain", comp);
				
//				get the no.of list of reopen complain and no.of Reminder request and list of department.
				
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
		 
//		 This controller is call when department head wants to see all the complains which is registered by User.
		 
		 if(path.equals("/complains")) {			
				try {
					System.out.println("complain controller");
					
					HttpSession session = request.getSession();	
					String deptId = (String) session.getAttribute("deptId");
					
					List<Complain> comp =  ds.getListOfComplain(deptId);
					request.setAttribute("ListOfComplain", comp);
					
//					get the no.of list of reopen complain and no.of Reminder request and list of department.
					
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
			
//		 This controller is call when department head submit the remark for complain and change the status, active to inactive of complain .
		
		if(path.equals("/submitRemark")) {			
			try {
				 HttpSession session = request.getSession();
				
				String remark= request.getParameter("remark");
				String compId= request.getParameter("compId");
				
				int temp= ds.submitRemark(compId, remark);
				if(temp>0)
				{
//					change the status of complain.
					
					 ds.changeStatus(compId);
					response.sendRedirect("homePage");	
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//		This controller is call when department head submit the remark for reopen complains and change the status , reopen to inactive of complain.
		
		if(path.equals("/reopenRemark")) {			
			try {
				 HttpSession session = request.getSession();
				
				String remark= request.getParameter("remark");
				String compId= request.getParameter("compId");
				
				int temp= ds.submitRemark(compId, remark);
				
//				change the status of reopen complain.
				
				if(temp>0)
				{
					 ds.changeStatus(compId);
					response.sendRedirect("reopenComplain");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//		This controller is call when department head wants to transfer the complain from one department to another department.
		
		if(path.equals("/transferComplain")) {			
			try {
				
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
		
//		This controller is call when department head wants to see the list of complain which is not solved by department head in given time
//		and user sent the reminder to department head for reminding him to solve the problem.

		if(path.equals("/reminderList")) {			
			try {
				HttpSession session = request.getSession();
				
				String deptId = (String) session.getAttribute("deptId");
				
				List<Complain> comp =  ds.getListOfReminder(deptId);
				request.setAttribute("reminder", comp);
				
				int count = ds.getCountOfReopenComplain(deptId);
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
