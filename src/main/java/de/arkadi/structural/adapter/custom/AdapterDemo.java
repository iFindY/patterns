package main.java.de.arkadi.structural.adapter.custom;

import java.util.List;

import main.java.de.arkadi.structural.adapter.custom.client.EmployeeClient;

public class AdapterDemo {

	public static void main(String[] args) {
		EmployeeClient client = new EmployeeClient();
		
		List<Employee> employees = client.getEmployeeList();
		
		System.out.println(employees);
	}
}
