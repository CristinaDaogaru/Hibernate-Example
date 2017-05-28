package com.example.dao;

import com.example.pojo.EmployeeDetails;
import java.util.*;

public interface DaoInterface {
	
	public void saveEmployee(EmployeeDetails employee);

	public List<EmployeeDetails> showAllEmployees();

	public void updateEmployee(int id, String ename, String enumber);

	public void deleteEmployee(EmployeeDetails employee);
}
