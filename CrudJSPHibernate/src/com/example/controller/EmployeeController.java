package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.DaoInterface;
import com.example.daoImpl.EmployeeDaoImpl;
import com.example.pojo.EmployeeDetails;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

	private EmployeeDetails employeeDetails = new EmployeeDetails();
    private DaoInterface employeeDao;
    private EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	if(request.getParameter("addEmployee") != null){
    		String ename = request.getParameter("ename");
    		String enumber = request.getParameter("enumber");
    		employeeDetails.setEname(ename);
    		employeeDetails.setEnumber(enumber);
    		
    		employeeDaoImpl.saveEmployee(employeeDetails);
    		RequestDispatcher rd = request.getRequestDispatcher("addEmployee.jsp");
    		rd.forward(request, response); 
    	}
    	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("showEmployee") != null){
			
			List<EmployeeDetails> employeeList = new ArrayList<>();
			employeeList = employeeDaoImpl.showAllEmployees();
			request.setAttribute("employeeList", employeeList);
			RequestDispatcher rd = request.getRequestDispatcher("showEmployee.jsp");
    		rd.forward(request, response); 
		}
		
		if(request.getParameter("updateEmployee") != null){
			
			int id = Integer.parseInt(request.getParameter("id"));
			String ename = request.getParameter("ename");
    		String enumber = request.getParameter("enumber");
    		employeeDaoImpl.updateEmployee(id, ename, enumber);
    		
    		RequestDispatcher rd = request.getRequestDispatcher("addEmployee.jsp");
    		rd.forward(request, response); 
		}
		
		if(request.getParameter("deleteEmployee") != null){
			
			int id = Integer.parseInt(request.getParameter("id"));
			employeeDetails.setId(id);
			employeeDaoImpl.deleteEmployee(employeeDetails);
			
			RequestDispatcher rd = request.getRequestDispatcher("showEmployee.jsp");
    		rd.forward(request, response); 
			
		}
	}

}
