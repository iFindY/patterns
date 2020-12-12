package main.java.de.arkadi.structural.adapter.custom.client;

import java.util.ArrayList;
import java.util.List;

import main.java.de.arkadi.structural.adapter.custom.Employee;
import main.java.de.arkadi.structural.adapter.custom.csv.EmployeeCSV;
import main.java.de.arkadi.structural.adapter.custom.EmployeeDB;
import main.java.de.arkadi.structural.adapter.custom.ldap.EmployeeLdap;
import main.java.de.arkadi.structural.adapter.custom.csv.EmployeeAdapterCSV;
import main.java.de.arkadi.structural.adapter.custom.ldap.EmployeeAdapterLdap;

public class EmployeeClient {

	public List<Employee> getEmployeeList() {
	
		List<Employee> employees = new ArrayList<>();
		
		Employee employeeFromDB = new EmployeeDB("1234", "John", "Wick", "john@wick.com");
		
		employees.add(employeeFromDB);
		
		//Will not work! This is where the csv comes into play!
		
		//Employee employeeFromLdap = new EmployeeLdap("chewie", "Solo", "Han", "han@solo.com");

		// create instance
		EmployeeLdap employeeFromLdap = new EmployeeLdap("chewie", "Solo", "Han", "han@solo.com");

		// use adapter
		employees.add(new EmployeeAdapterLdap(employeeFromLdap));
		
		EmployeeCSV employeeFromCSV = new EmployeeCSV("567,Sherlock,Holmes,sherlock@holmes.com");
		
		employees.add(new EmployeeAdapterCSV(employeeFromCSV));
		
		return employees;
		
	}
	
}
